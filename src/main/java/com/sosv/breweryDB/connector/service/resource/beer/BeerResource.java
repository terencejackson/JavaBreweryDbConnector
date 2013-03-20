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

import javax.ws.rs.core.MultivaluedMap;

import com.google.inject.Inject;
import com.sosv.breweryDB.connector.configuration.IBreweryDBConnectorConfiguration;
import com.sosv.breweryDB.connector.entity.beer.Beer;
import com.sosv.breweryDB.connector.entity.beer.BeerResult;
import com.sosv.breweryDB.connector.entity.beer.BeerResultPage;
import com.sosv.breweryDB.connector.service.exceptions.ApiKeyNotFoundExeption;
import com.sosv.breweryDB.connector.service.exceptions.ObjectNotFoundException;
import com.sosv.breweryDB.connector.service.resource.AbstractResource;
import com.sosv.breweryDB.connector.service.resource.filter.FilterMultivalueMapBuilder;
import com.sosv.breweryDB.connector.service.resource.filter.beer.IBeerFilter;
import com.sosv.breweryDB.connector.service.resource.filter.beer.IBeersFilter;
import com.sun.jersey.api.client.Client;

/**
 * Implementation for the beer resource services
 * 
 * @author Sven
 * 
 */
public class BeerResource extends AbstractResource implements IBeerResource {

	@Inject
	public BeerResource(IBreweryDBConnectorConfiguration configuration,
			Client client) {
		super(configuration, client);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sosv.breweryDB.connector.service.resource.beer.IBeerResource#getBeers
	 * (java.lang.Integer)
	 */
	public BeerResultPage getBeers(Number currentPage, IBeersFilter filter)
			throws ApiKeyNotFoundExeption {
		MultivaluedMap<String, String> map = new FilterMultivalueMapBuilder()
				.convert(filter);
		BeerResultPage result = null;
		if (currentPage != null) {
			map.add("p", currentPage.toString());
		}
		try {
			result = get("beers/", map, new BeerResultPage());
		} catch (ObjectNotFoundException e) {
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sosv.breweryDB.connector.service.resource.beer.IBeerResource#getBeerById
	 * (java.lang.String)
	 */
	@Override
	public Beer getBeerById(String id, IBeerFilter filter)
			throws ApiKeyNotFoundExeption {
		Beer result = null;
		MultivaluedMap<String, String> map = new FilterMultivalueMapBuilder()
				.convert(filter);

		try {
			result = get(String.format("beer/%s/", id), map, new BeerResult())
					.getData();
		} catch (ObjectNotFoundException e) {
			// Silently catched is ok => return null;
		}
		return result;
	}

}
