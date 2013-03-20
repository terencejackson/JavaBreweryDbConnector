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
package com.sosv.breweryDB.connector.guice;

import com.google.inject.AbstractModule;
import com.sosv.breweryDB.connector.service.BreweryDBService;
import com.sosv.breweryDB.connector.service.IBreweryDBService;
import com.sosv.breweryDB.connector.service.brewery.BreweryService;
import com.sosv.breweryDB.connector.service.brewery.IBreweryService;
import com.sosv.breweryDB.connector.service.beer.BeerService;
import com.sosv.breweryDB.connector.service.beer.IBeerService;
import com.sosv.breweryDB.connector.service.provider.JerseyClientProvider;
import com.sosv.breweryDB.connector.service.resource.beer.BeerResource;
import com.sosv.breweryDB.connector.service.resource.beer.IBeerResource;
import com.sosv.breweryDB.connector.service.resource.brewery.BreweryResource;
import com.sosv.breweryDB.connector.service.resource.brewery.IBreweryResource;
import com.sun.jersey.api.client.Client;

/**
 * Guice module to use in the application Binds all necessary services to use
 * them if you install this module.
 * 
 * @author Sven
 * 
 */
public class BreweryDBConnectorModule extends AbstractModule {

	@Override
	protected void configure() {
		// Bind the client provider
		bind(Client.class).toProvider(JerseyClientProvider.class);

		// Bind resources
		bind(IBeerResource.class).to(BeerResource.class);
		bind(IBreweryResource.class).to(BreweryResource.class);

		// Bind services
		bind(IBeerService.class).to(BeerService.class);
		bind(IBreweryService.class).to(BreweryService.class);

		// bind facade
		bind(IBreweryDBService.class).to(BreweryDBService.class);
	}

}
