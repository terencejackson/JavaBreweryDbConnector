package com.sosv.breweryDB.connector.service.beer.async;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

import com.sosv.breweryDB.connector.configuration.IBreweryDBConnectorConfiguration;
import com.sosv.breweryDB.connector.entity.beer.Beer;
import com.sosv.breweryDB.connector.entity.beer.BeerResultPage;
import com.sosv.breweryDB.connector.mockery.Mockery;
import com.sosv.breweryDB.connector.service.async.CallableFactory;
import com.sosv.breweryDB.connector.service.async.IResultCallback;
import com.sosv.breweryDB.connector.service.beer.BeerService;
import com.sosv.breweryDB.connector.service.exceptions.ApiKeyNotFoundExeption;
import com.sosv.breweryDB.connector.service.resource.beer.BeerResource;
import com.sosv.breweryDB.connector.service.resource.filter.beer.BeersFilter;
import com.sun.jersey.api.client.Client;

/**
 * Async service tests
 * 
 * @author Sven
 * 
 */
public class BeerServiceAsyncTests {

	private CountDownLatch lock = new CountDownLatch(1);
	private Client client;
	private IBreweryDBConnectorConfiguration fakeConfig;
	private IBreweryDBConnectorConfiguration configuration;
	private BeerServiceAsync beerServiceAsync;

	@Before
	public void setUp() throws IOException {
		Properties prop = new Properties();
		InputStream stream = getClass().getResourceAsStream(
				"/configuration.properties");
		prop.load(stream);
		configuration = mock(IBreweryDBConnectorConfiguration.class);
		when(configuration.getApiKey()).thenReturn((String) prop.get("apiKey"));

		this.client = Mockery.createBeerClientMock();
		this.fakeConfig = Mockery.createConfigMock();

		beerServiceAsync = new BeerServiceAsync(new CallableFactory(
				new BeerService(new BeerResource(fakeConfig, client))));
	}

	private class GetAllBeersCallback implements IResultCallback<List<Beer>> {
		private List<Beer> result;
		private Throwable error;

		public List<Beer> getResult() {
			return result;
		}

		public Throwable getError() {
			return error;
		}

		@Override
		public void onSuccess(List<Beer> result) {
			this.result = result;
			lock.countDown();
		}

		@Override
		public void onError(Throwable throwable) {
			this.error = throwable;
			lock.countDown();

		}
	}

	@Test
	public void testGetAllBeersAsync() throws InterruptedException {
		GetAllBeersCallback callback = new GetAllBeersCallback();

		beerServiceAsync.getAllBeers(callback);

		lock.await(2000, TimeUnit.MILLISECONDS);

		assertNotNull(callback.getResult());
		assertEquals(150, callback.getResult().size());
		assertNull(callback.getError());
	}

	@Test
	public void testGetAllBeersWithBreweriesAsync() throws InterruptedException {
		GetAllBeersCallback callback = new GetAllBeersCallback();

		beerServiceAsync.getAllBeers(
				BeersFilter.createWithBreweriesFilter(true), callback);

		lock.await(2000, TimeUnit.MILLISECONDS);

		List<Beer> result = callback.getResult();
		assertNotNull(result);
		assertEquals(100, result.size());
		assertNotNull(result.iterator().next().getBreweries());
		assertNull(callback.getError());
	}

	private class BeerResultPageCallback implements
			IResultCallback<BeerResultPage> {

		private Throwable error;
		private BeerResultPage result;

		public Throwable getError() {
			return error;
		}

		public BeerResultPage getResult() {
			return result;
		}

		@Override
		public void onSuccess(BeerResultPage result) {
			this.result = result;
			lock.countDown();
		}

		@Override
		public void onError(Throwable throwable) {
			this.error = throwable;
			lock.countDown();
		}

	}

	@Test
	public void testGetPage1() throws InterruptedException {
		BeerResultPageCallback callback = new BeerResultPageCallback();
		beerServiceAsync.getPagesBeers(null, callback);
		
		lock.await(2000, TimeUnit.MILLISECONDS);
		
		BeerResultPage result = callback.getResult();
		assertEquals(1, result.getCurrentPage());
		assertNotNull(result.getData());
		assertEquals(50, result.getData().size());
		assertNull(callback.getError());
	}

	@Test
	public void testGetPage1WithBreweries() throws InterruptedException {
		BeerResultPageCallback callback = new BeerResultPageCallback();
		beerServiceAsync.getPagesBeers(null,
				BeersFilter.createWithBreweriesFilter(true), callback);
		
		lock.await(2000, TimeUnit.MILLISECONDS);
		
		BeerResultPage result = callback.getResult();
		assertEquals(1, result.getCurrentPage());
		assertNotNull(result.getData());
		assertEquals(50, result.getData().size());
		assertNull(callback.getError());
		assertNotNull(result.getData().get(0).getBreweries());
	}

	@Test
	public void testGetPage2() throws InterruptedException {
		BeerResultPageCallback callback = new BeerResultPageCallback();
		beerServiceAsync.getPagesBeers(2, callback);
		
		lock.await(2000, TimeUnit.MILLISECONDS);
		
		BeerResultPage result = callback.getResult();
		assertEquals(2, result.getCurrentPage());
		assertNotNull(result.getData());
		assertEquals(50, result.getData().size());
		assertNull(callback.getError());
	}
	
	private class BeerResultCallback implements IResultCallback<Beer>{

		private Beer result;
		private Throwable error;

		public Beer getResult() {
			return result;
		}

		public Throwable getError() {
			return error;
		}

		@Override
		public void onSuccess(Beer result) {
			this.result = result;
		}

		@Override
		public void onError(Throwable throwable) {
			this.error = throwable;
		}
		
	}
	
	@Test
	public void testGetById() throws ApiKeyNotFoundExeption, InterruptedException {
		BeerResultCallback callback = new BeerResultCallback();;
		beerServiceAsync.getBeerById("cBLTUw", callback);
		
		lock.await(2000, TimeUnit.MILLISECONDS);
		
		assertNotNull(callback.getResult());
		assertNull(callback.getError());
	}

	@Test
	public void testGetByIdNull() throws ApiKeyNotFoundExeption, InterruptedException {
		BeerResultCallback callback = new BeerResultCallback();	
		beerServiceAsync.getBeerById("cBLTUwx", callback);
		
		lock.await(2000, TimeUnit.MILLISECONDS);
		
		assertNull(callback.getResult());
		assertNull(callback.getError());
	}
}
