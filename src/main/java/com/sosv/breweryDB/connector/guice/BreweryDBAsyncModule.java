package com.sosv.breweryDB.connector.guice;

import com.sosv.breweryDB.connector.service.async.BreweryDBServiceAsync;
import com.sosv.breweryDB.connector.service.async.CallableFactory;
import com.sosv.breweryDB.connector.service.async.IBreweryDBServiceAsync;
import com.sosv.breweryDB.connector.service.async.ICallableFactory;
import com.sosv.breweryDB.connector.service.beer.BeerService;
import com.sosv.breweryDB.connector.service.beer.IBeerService;
import com.sosv.breweryDB.connector.service.beer.async.BeerServiceAsync;
import com.sosv.breweryDB.connector.service.beer.async.IBeerServiceAsync;
import com.sosv.breweryDB.connector.service.brewery.BreweryService;
import com.sosv.breweryDB.connector.service.brewery.IBreweryService;

public class BreweryDBAsyncModule extends BreweryDBSyncModule {

	@Override
	protected void configure() {
		super.configure();
		
		bindAsyncServices();
	}

	private void bindAsyncServices() {
		bind(ICallableFactory.class).to(CallableFactory.class);
		bind(IBeerServiceAsync.class).to(BeerServiceAsync.class);

		bind(IBreweryDBServiceAsync.class).to(BreweryDBServiceAsync.class);
	}
	

}
