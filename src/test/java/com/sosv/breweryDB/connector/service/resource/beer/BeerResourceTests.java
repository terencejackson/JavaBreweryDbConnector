/*
Copyright 2013 Sven Sommerfeld (svensommerfeld1982@gmail.com)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package com.sosv.breweryDB.connector.service.resource.beer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Properties;

import javax.ws.rs.core.MultivaluedMap;

import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import com.sosv.breweryDB.connector.configuration.IBreweryDBConnectorConfiguration;
import com.sosv.breweryDB.connector.entity.beer.Beer;
import com.sosv.breweryDB.connector.entity.beer.BeerResult;
import com.sosv.breweryDB.connector.entity.beer.Page;
import com.sosv.breweryDB.connector.service.beer.BeerService;
import com.sosv.breweryDB.connector.service.beer.IBeerService;
import com.sosv.breweryDB.connector.service.exceptions.ApiKeyNotFoundExeption;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class BeerResourceTests {

	private Client client;
	private IBreweryDBConnectorConfiguration configuration;
	private IBreweryDBConnectorConfiguration fakeConfig;

	public BeerResourceTests() throws IOException {
		super();

		Properties prop = new Properties();
		InputStream stream = getClass().getResourceAsStream(
				"/configuration.properties");
		prop.load(stream);
		configuration = mock(IBreweryDBConnectorConfiguration.class);
		when(configuration.getApiKey()).thenReturn((String) prop.get("apiKey"));

		this.client = mock(Client.class);
		WebResource webResource = mock(WebResource.class);
		when(client.resource("http://api.brewerydb.com/v2/")).thenReturn(
				webResource);

		fakeConfig = mock(IBreweryDBConnectorConfiguration.class);
		when(fakeConfig.getApiKey()).thenReturn("jjjjkkkkjjjkkkk");
		when(webResource.path(anyString())).thenReturn(webResource);

		createPageMock(webResource, 1);
		createPageMock(webResource, 2);
		createPageMock(webResource, 3);

		createGetByIdMock(client, "cBLTUw", webResource);
	}

	private void createGetByIdMock(Client client, String string,
			WebResource resource) throws UniformInterfaceException,
			ClientHandlerException, IOException {
		MultivaluedMap<String, String> map = new MultivaluedMapImpl();
		map.add("key", fakeConfig.getApiKey());

		WebResource r1 = mock(WebResource.class);
		when(resource.path("beer/" + string + "/")).thenReturn(r1);
		when(r1.queryParams(map)).thenReturn(r1);
		when(r1.get(BeerResult.class)).thenReturn(createBeerResult(string));

		WebResource r2 = mock(WebResource.class);
		when(resource.path("beer/" + string + "x/")).thenReturn(r2);
		when(r2.queryParams(map)).thenReturn(r2);
		when(r2.get(BeerResult.class)).thenReturn(
				createBeerResult(string + "x"));

		WebResource r3 = mock(WebResource.class);
		MultivaluedMap<String, String> map2 = new MultivaluedMapImpl();
		map2.add("key", fakeConfig.getApiKey() + "x");
		when(r1.queryParams(map2)).thenReturn(r3);
		when(r3.get(BeerResult.class)).thenReturn(
				createBeerResult("ApiKeyNotFound"));

	}

	private void createPageMock(WebResource webResource, int page)
			throws IOException {
		WebResource resource1 = mock(WebResource.class);
		MultivaluedMap<String, String> mapPage1 = new MultivaluedMapImpl();
		mapPage1.add("key", fakeConfig.getApiKey());
		if (page > 1) {
			mapPage1.add("p", page + "");
		}
		when(webResource.queryParams(mapPage1)).thenReturn(resource1);

		when(resource1.get(Page.class)).thenReturn(createPage(page));
	}

	private BeerResult createBeerResult(String beerId) throws IOException {
		InputStream stream = getClass().getResourceAsStream(
				"/beers/beer" + beerId + ".json");
		StringWriter writer = new StringWriter();
		IOUtils.copy(stream, writer, "UTF-8");
		String theString = writer.toString();

		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(theString, BeerResult.class);
	}

	private Page createPage(int i) throws IOException {
		InputStream stream = getClass().getResourceAsStream(
				"/beers/beersPage" + i + ".json");
		StringWriter writer = new StringWriter();
		IOUtils.copy(stream, writer, "UTF-8");
		String theString = writer.toString();

		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(theString, Page.class);
	}

	@Test
	public void testGetAll() throws IOException {
		IBeerResource br = new BeerResource(fakeConfig, client);
		IBeerService bs = new BeerService(br);
		Collection<Beer> result = bs.getAll();
		assertNotNull(result);
		assertEquals(150, result.size());
	}

	@Test
	public void testGetPage1() throws IOException {
		IBeerResource br = new BeerResource(fakeConfig, client);
		Page result = br.getBeers(null);
		assertEquals(1, result.getCurrentPage());
		assertNotNull(result.getData());
		assertEquals(50, result.getData().size());
	}

	@Test
	public void testGetPage2() throws IOException {

		IBeerResource br = new BeerResource(fakeConfig, client);
		Page result = br.getBeers(2);
		assertEquals(2, result.getCurrentPage());
		assertNotNull(result.getData());
		assertEquals(50, result.getData().size());
	}

	@Test
	public void testGetPage3() throws IOException {

		IBeerResource br = new BeerResource(fakeConfig, client);
		Page result = br.getBeers(3);
		assertEquals(3, result.getCurrentPage());
		assertNotNull(result.getData());
		assertEquals(50, result.getData().size());
	}

	@Test
	public void testGetById() throws ApiKeyNotFoundExeption {
		IBeerResource br = new BeerResource(fakeConfig, client);
		Beer result = br.getBeerById("cBLTUw");
		assertNotNull(result);
	}

	@Test
	public void testGetByIdNull() throws ApiKeyNotFoundExeption {
		IBeerResource br = new BeerResource(fakeConfig, client);
		Beer result = br.getBeerById("cBLTUwx");
		assertNull(result);
	}

	@Test(expected = ApiKeyNotFoundExeption.class)
	public void testApiKeyNotFoundException() throws ApiKeyNotFoundExeption {
		IBreweryDBConnectorConfiguration fakeConfig2 = mock(IBreweryDBConnectorConfiguration.class);
		String apiKey = fakeConfig.getApiKey();
		when(fakeConfig2.getApiKey()).thenReturn(apiKey + "x");
		IBeerResource br = new BeerResource(fakeConfig2, client);
		br.getBeerById("cBLTUw");
	}

}
