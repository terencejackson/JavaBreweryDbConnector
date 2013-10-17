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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import org.junit.Test;

import com.sosv.breweryDB.connector.configuration.IBreweryDBConnectorConfiguration;
import com.sosv.breweryDB.connector.entity.beer.Beer;
import com.sosv.breweryDB.connector.entity.beer.BeerResultPage;
import com.sosv.breweryDB.connector.mockery.Mockery;
import com.sosv.breweryDB.connector.service.beer.BeerService;
import com.sosv.breweryDB.connector.service.beer.IBeerService;
import com.sosv.breweryDB.connector.service.exceptions.ApiKeyNotFoundExeption;
import com.sosv.breweryDB.connector.service.provider.JerseyClientProvider;
import com.sosv.breweryDB.connector.service.resource.filter.beer.BeersFilter;
import com.sun.jersey.api.client.Client;

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

		this.client = Mockery.createBeerClientMock();
		this.fakeConfig = Mockery.createConfigMock();
	}

	@Test
	public void testGetAllWithBreweries() throws ApiKeyNotFoundExeption{
		IBeerResource br = new BeerResource(fakeConfig, client);
		IBeerService bs = new BeerService(br);
		List<Beer> result = bs.getAllBeers(BeersFilter.createWithBreweriesFilter(true));
		assertEquals(100, result.size());
		assertNotNull(result.get(0).getBreweries());
	}
	
	@Test
	public void testGetWithBreweriesPage2() throws ApiKeyNotFoundExeption{
		IBeerResource br = new BeerResource(fakeConfig, client);
		IBeerService bs = new BeerService(br);
		BeerResultPage result = bs.getPagesBeers(2, BeersFilter.createWithBreweriesFilter(true));
		assertEquals(2, result.getCurrentPage());
		assertNotNull(result.getData().get(0).getBreweries());
	}

	@Test
	public void testGetAll() throws IOException, ApiKeyNotFoundExeption {
		IBeerResource br = new BeerResource(fakeConfig, client);
		IBeerService bs = new BeerService(br);
		Collection<Beer> result = bs.getAllBeers();
		assertNotNull(result);
		assertEquals(150, result.size());
	}

	@Test
	public void testGetPage1() throws IOException, ApiKeyNotFoundExeption {
		IBeerResource br = new BeerResource(fakeConfig, client);
		BeerResultPage result = br.getBeers(null, null);
		assertEquals(1, result.getCurrentPage());
		assertNotNull(result.getData());
		assertEquals(50, result.getData().size());
	}

	@Test
	public void testGetPage2() throws IOException, ApiKeyNotFoundExeption {

		IBeerResource br = new BeerResource(fakeConfig, client);
		BeerResultPage result = br.getBeers(2, null);
		assertEquals(2, result.getCurrentPage());
		assertNotNull(result.getData());
		assertEquals(50, result.getData().size());
	}

	@Test
	public void testGetPage3() throws IOException, ApiKeyNotFoundExeption {

		IBeerResource br = new BeerResource(fakeConfig, client);
		BeerResultPage result = br.getBeers(3, null);
		assertEquals(3, result.getCurrentPage());
		assertNotNull(result.getData());
		assertEquals(50, result.getData().size());
	}

	@Test
	public void testGetById() throws ApiKeyNotFoundExeption {
		IBeerResource br = new BeerResource(fakeConfig, client);
		Beer result = br.getBeerById("cBLTUw", null);
		assertNotNull(result);
	}

//	@Test
//	public void testGetByIdReal() throws ApiKeyNotFoundExeption {
//		IBeerResource br = new BeerResource(configuration, new JerseyClientProvider().get());
//		Beer result = br.getBeerById("FoPVhW", null);
//		assertNotNull(result);
//	}

	@Test
	public void testGetByIdNull() throws ApiKeyNotFoundExeption {
		IBeerResource br = new BeerResource(fakeConfig, client);
		Beer result = br.getBeerById("cBLTUwx", null);
		assertNull(result);
	}

	@Test(expected = ApiKeyNotFoundExeption.class)
	public void testApiKeyNotFoundException() throws ApiKeyNotFoundExeption {
		IBreweryDBConnectorConfiguration fakeConfig2 = mock(IBreweryDBConnectorConfiguration.class);
		String apiKey = fakeConfig.getApiKey();
		when(fakeConfig2.getApiKey()).thenReturn(apiKey + "x");
		IBeerResource br = new BeerResource(fakeConfig2, client);
		br.getBeerById("cBLTUw", null);
	}

}
