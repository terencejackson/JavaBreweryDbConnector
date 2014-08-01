package com.sosv.breweryDB.connector.guice;

import com.google.inject.AbstractModule;
import com.sosv.breweryDB.connector.service.BreweryDBService;
import com.sosv.breweryDB.connector.service.IBreweryDBService;
import com.sosv.breweryDB.connector.service.beer.BeerService;
import com.sosv.breweryDB.connector.service.beer.IBeerService;
import com.sosv.breweryDB.connector.service.brewery.BreweryService;
import com.sosv.breweryDB.connector.service.brewery.IBreweryService;
import com.sosv.breweryDB.connector.service.search.ISearchService;
import com.sosv.breweryDB.connector.service.search.SearchService;

public class BreweryDBSyncModule extends AbstractModule {

	@Override
	protected void configure() {
		install(new BreweryDBBaseModule());
		
		bindServices();		
	}
	
	/**
	 * Bind the services
	 */
	protected void bindServices() {
		bind(IBeerService.class).to(BeerService.class);
		bind(IBreweryService.class).to(BreweryService.class);
		bind(ISearchService.class).to(SearchService.class);
		
		// bind facade
		bind(IBreweryDBService.class).to(BreweryDBService.class);
	}


}
