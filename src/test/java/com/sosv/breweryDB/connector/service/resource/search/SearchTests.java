package com.sosv.breweryDB.connector.service.resource.search;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.junit.Test;

import com.sosv.breweryDB.connector.configuration.IBreweryDBConnectorConfiguration;
import com.sosv.breweryDB.connector.entity.beer.Beer;
import com.sosv.breweryDB.connector.mockery.Mockery;
import com.sosv.breweryDB.connector.service.exceptions.ApiKeyNotFoundExeption;
import com.sosv.breweryDB.connector.service.search.ISearchService;
import com.sosv.breweryDB.connector.service.search.SearchService;
import com.sun.jersey.api.client.Client;

public class SearchTests {

	private Client client;
	private IBreweryDBConnectorConfiguration configuration;
	private IBreweryDBConnectorConfiguration fakeConfig;

	public SearchTests() throws IOException {
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
	public void testWithoutFilter() throws ApiKeyNotFoundExeption {
		ISearchResource searchResource = new SearchResource(fakeConfig, client);
		ISearchService service = new SearchService(searchResource);
		List<Beer> result = service.searchBeers("Haus");
		assertNotNull(result);
		assertEquals(150, result.size());
	}

}
