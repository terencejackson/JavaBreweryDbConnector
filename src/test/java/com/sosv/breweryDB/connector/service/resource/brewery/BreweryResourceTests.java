package com.sosv.breweryDB.connector.service.resource.brewery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.junit.Test;

import com.sosv.breweryDB.connector.configuration.IBreweryDBConnectorConfiguration;
import com.sosv.breweryDB.connector.entity.brewery.Brewery;
import com.sosv.breweryDB.connector.mockery.Mockery;
import com.sosv.breweryDB.connector.service.brewery.BreweryService;
import com.sosv.breweryDB.connector.service.exceptions.ApiKeyNotFoundExeption;
import com.sosv.breweryDB.connector.service.resource.filter.brewery.BreweriesFilter;
import com.sun.jersey.api.client.Client;

public class BreweryResourceTests {

	private IBreweryDBConnectorConfiguration configuration;
	private IBreweryDBConnectorConfiguration fakeConfig;
	private Client client;

	public BreweryResourceTests() throws IOException {
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
	public void testGetWithLocations() throws ApiKeyNotFoundExeption {
		IBreweryResource breweryResource = new BreweryResource(fakeConfig,
				client);
		BreweryService bs = new BreweryService(breweryResource);
		List<Brewery> result = bs.getAllBreweries(BreweriesFilter
				.createWithLocationsFilter(true));
		assertNotNull(result);
		assertEquals(150, result.size());
		assertNotNull(result.get(0).getLocations());
	}

	@Test
	public void testGetAllWithoutLocations() throws ApiKeyNotFoundExeption {
		IBreweryResource breweryResource = new BreweryResource(fakeConfig,
				client);
		BreweryService bs = new BreweryService(breweryResource);
		List<Brewery> result = bs.getAllBreweries();
		assertNotNull(result);
		assertEquals(150, result.size());
		assertNull(result.get(0).getLocations());
	}

	@Test
	public void testGetByIdWithoutLocations() throws ApiKeyNotFoundExeption {
		IBreweryResource breweryResource = new BreweryResource(fakeConfig,
				client);
		BreweryService bs = new BreweryService(breweryResource);
		Brewery result = bs.getBreweryById("Klgom2");
		assertNotNull(result);
		assertEquals("Klgom2", result.getId());
	}

	@Test
	public void testGetByIdWithLocations() throws ApiKeyNotFoundExeption {
		IBreweryResource breweryResource = new BreweryResource(fakeConfig,
				client);
		BreweryService bs = new BreweryService(breweryResource);
		Brewery result = bs.getBreweryById("Klgom2",
				BreweriesFilter.createWithLocationsFilter(true));
		assertNotNull(result);
		assertEquals("Klgom2", result.getId());		
		assertNotNull(result.getLocations());
	}

}
