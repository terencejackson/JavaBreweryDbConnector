package com.sosv.breweryDB.connector.mockery;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.ws.rs.core.MultivaluedMap;

import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.map.ObjectMapper;

import com.sosv.breweryDB.connector.configuration.IBreweryDBConnectorConfiguration;
import com.sosv.breweryDB.connector.entity.BeerResult;
import com.sosv.breweryDB.connector.entity.BeerResultPage;
import com.sosv.breweryDB.connector.entity.BreweryResultPage;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

/**
 * Factory to create the different mock object for the tests
 * 
 * @author ssommerf
 * 
 */
public class Mockery {

	public static Client createBeerClientMock() throws IOException {
		Client client = mock(Client.class);
		WebResource webResource = mock(WebResource.class);
		when(client.resource("http://api.brewerydb.com/v2/")).thenReturn(
				webResource);

		IBreweryDBConnectorConfiguration fakeConfig = createConfigMock();
		when(webResource.path(anyString())).thenReturn(webResource);

		createPageMock(webResource, 1, fakeConfig);
		createPageMock(webResource, 2, fakeConfig);
		createPageMock(webResource, 3, fakeConfig);

		createWithBreweriesMock(webResource, 1, fakeConfig);
		createWithBreweriesMock(webResource, 2, fakeConfig);

		createBreweriesMock(webResource, 1, fakeConfig);
		createBreweriesMock(webResource, 2, fakeConfig);
		createBreweriesMock(webResource, 3, fakeConfig);

		createGetByIdMock(client, "cBLTUw", webResource, fakeConfig);
		return client;
	}

	private static void createBreweriesMock(WebResource webResource, int page,
			IBreweryDBConnectorConfiguration fakeConfig)
			throws UniformInterfaceException, ClientHandlerException,
			IOException {
		WebResource resource1 = mock(WebResource.class);
		MultivaluedMap<String, String> withBreweriesMap = new MultivaluedMapImpl();
		withBreweriesMap.add("key", fakeConfig.getApiKey());
		withBreweriesMap.add("withLocations", "Y");
		if (page > 1) {
			withBreweriesMap.add("p", page + "");
		}
		when(webResource.queryParams(withBreweriesMap)).thenReturn(resource1);

		when(resource1.get(BreweryResultPage.class)).thenReturn(
				createBreweriesWithLocations(page));

		WebResource resource2 = mock(WebResource.class);
		MultivaluedMap<String, String> withoutBreweriesMap = new MultivaluedMapImpl();
		withoutBreweriesMap.add("key", fakeConfig.getApiKey());
		if (page > 1) {
			withoutBreweriesMap.add("p", page + "");
		}
		when(webResource.queryParams(withoutBreweriesMap))
				.thenReturn(resource2);
		when(resource2.get(BreweryResultPage.class)).thenReturn(
				createBreweries(page));
	}

	private static BreweryResultPage createBreweries(int page) throws IOException {
		InputStream stream = Mockery.class
				.getResourceAsStream("/breweries/breweryPage" + page
						+ ".json");
		StringWriter writer = new StringWriter();
		IOUtils.copy(stream, writer, "UTF-8");
		String theString = writer.toString();

		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(theString, BreweryResultPage.class);
	}

	private static BreweryResultPage createBreweriesWithLocations(int page)
			throws IOException {
		InputStream stream = Mockery.class
				.getResourceAsStream("/breweries/breweryPage" + page
						+ "WithLocations.json");
		StringWriter writer = new StringWriter();
		IOUtils.copy(stream, writer, "UTF-8");
		String theString = writer.toString();

		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(theString, BreweryResultPage.class);
	}

	private static void createWithBreweriesMock(WebResource webResource,
			int page, IBreweryDBConnectorConfiguration fakeConfig)
			throws UniformInterfaceException, ClientHandlerException,
			IOException {
		WebResource resource1 = mock(WebResource.class);
		MultivaluedMap<String, String> mapPage1 = new MultivaluedMapImpl();
		mapPage1.add("key", fakeConfig.getApiKey());
		mapPage1.add("withBreweries", "Y");
		if (page > 1) {
			mapPage1.add("p", page + "");
		}
		when(webResource.queryParams(mapPage1)).thenReturn(resource1);

		when(resource1.get(BeerResultPage.class)).thenReturn(
				createPageWithBreweries(page));

	}

	private static BeerResultPage createPageWithBreweries(int page)
			throws IOException {
		InputStream stream = Mockery.class
				.getResourceAsStream("/beers/beersPage" + page
						+ "WithBreweries.json");
		StringWriter writer = new StringWriter();
		IOUtils.copy(stream, writer, "UTF-8");
		String theString = writer.toString();

		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(theString, BeerResultPage.class);
	}

	public static IBreweryDBConnectorConfiguration createConfigMock() {
		IBreweryDBConnectorConfiguration fakeConfig = mock(IBreweryDBConnectorConfiguration.class);
		when(fakeConfig.getApiKey()).thenReturn("jjjjkkkkjjjkkkk");
		return fakeConfig;
	}

	private static void createGetByIdMock(Client client, String string,
			WebResource resource, IBreweryDBConnectorConfiguration fakeConfig)
			throws UniformInterfaceException, ClientHandlerException,
			IOException {
		MultivaluedMap<String, String> map = new MultivaluedMapImpl();
		map.add("key", fakeConfig.getApiKey());

		WebResource r1 = mock(WebResource.class);
		when(resource.path("beer/" + string + "/")).thenReturn(r1);
		when(r1.queryParams(map)).thenReturn(r1);
		when(r1.get(BeerResult.class)).thenReturn(createBeerResult(string));

		WebResource r2 = mock(WebResource.class);
		when(resource.path("beer/" + string + "x/")).thenReturn(r2);
		when(r2.queryParams(map)).thenReturn(r2);
		ClientResponse response = mock(ClientResponse.class);
		when(response.getStatus()).thenReturn(404);
		Throwable ex2 = new UniformInterfaceException(response);
		when(r2.get(BeerResult.class)).thenThrow(ex2);

		WebResource r3 = mock(WebResource.class);
		MultivaluedMap<String, String> map2 = new MultivaluedMapImpl();
		map2.add("key", fakeConfig.getApiKey() + "x");
		when(r1.queryParams(map2)).thenReturn(r3);

		ClientResponse r = mock(ClientResponse.class);
		when(r.getStatus()).thenReturn(401);
		Throwable ex = new UniformInterfaceException(r);
		when(r3.get(BeerResult.class)).thenThrow(ex);

	}

	private static void createPageMock(WebResource webResource, int page,
			IBreweryDBConnectorConfiguration fakeConfig) throws IOException {
		WebResource resource1 = mock(WebResource.class);
		MultivaluedMap<String, String> mapPage1 = new MultivaluedMapImpl();
		mapPage1.add("key", fakeConfig.getApiKey());
		if (page > 1) {
			mapPage1.add("p", page + "");
		}
		when(webResource.queryParams(mapPage1)).thenReturn(resource1);

		when(resource1.get(BeerResultPage.class)).thenReturn(createPage(page));
	}

	private static BeerResult createBeerResult(String beerId)
			throws IOException {
		InputStream stream = Mockery.class.getResourceAsStream("/beers/beer"
				+ beerId + ".json");
		StringWriter writer = new StringWriter();
		IOUtils.copy(stream, writer, "UTF-8");
		String theString = writer.toString();

		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(theString, BeerResult.class);
	}

	private static BeerResultPage createPage(int i) throws IOException {
		InputStream stream = Mockery.class
				.getResourceAsStream("/beers/beersPage" + i + ".json");
		StringWriter writer = new StringWriter();
		IOUtils.copy(stream, writer, "UTF-8");
		String theString = writer.toString();

		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(theString, BeerResultPage.class);
	}
}
