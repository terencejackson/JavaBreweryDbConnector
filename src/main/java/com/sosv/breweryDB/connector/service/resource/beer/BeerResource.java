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
import com.sosv.breweryDB.connector.entity.Beer;
import com.sosv.breweryDB.connector.entity.BeerResult;
import com.sosv.breweryDB.connector.entity.IErrorResult;
import com.sosv.breweryDB.connector.entity.Page;
import com.sosv.breweryDB.connector.service.ErrorCodes;
import com.sosv.breweryDB.connector.service.Status;
import com.sosv.breweryDB.connector.service.exceptions.ApiKeyNotFoundExeption;
import com.sosv.breweryDB.connector.service.exceptions.ObjectNotFoundException;
import com.sosv.breweryDB.connector.service.resource.AbstractResource;
import com.sosv.breweryDB.connector.service.resource.filter.IBeerFilter;
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
	public Page getBeers(Number currentPage, IBeerFilter filter) throws ApiKeyNotFoundExeption {
		MultivaluedMap<String, String> map = new BeerFilterMultivalueMapBuilder()
				.convert(filter);
		Page result = null;
		if (currentPage != null) {
			map.add("p", currentPage.toString());
		}
		result = get("beers/", map, new Page());
		
		if (Status.SUCCESS.asString().equals(result.getStatus())) {
			return result;
		}
		try {
			handleErrorResult(result);
		} catch (ObjectNotFoundException e) {
			// Object not found => return null
			return null;
		}
		throw new UnsupportedOperationException("Result "
				+ result.getErrorMessage() + " unknown");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sosv.breweryDB.connector.service.resource.beer.IBeerResource#getBeerById
	 * (java.lang.String)
	 */
	@Override
	public Beer getBeerById(String id) throws ApiKeyNotFoundExeption {
		BeerResult result = get(String.format("beer/%s/", id), new BeerResult());
		if (Status.SUCCESS.asString().equals(result.getStatus())) {
			return result.getData();
		}
		try {
			handleErrorResult(result);
		} catch (ObjectNotFoundException e) {
			// Object not found => return null
			return null;
		}
		throw new UnsupportedOperationException("Result " + result.getMessage()
				+ " unknown");
	}

	/**
	 * Handle the result and determine the error of the result
	 * 
	 * @param result
	 * @throws ApiKeyNotFoundExeption
	 *             If the api key is not found by the service
	 * @throws ObjectNotFoundException
	 *             If the object was not found
	 */
	private void handleErrorResult(IErrorResult result)
			throws ApiKeyNotFoundExeption, ObjectNotFoundException {
		if (ErrorCodes.API_KEY_NOT_FOUND.getMessage().equals(
				result.getErrorMessage())) {
			throw new ApiKeyNotFoundExeption();
		} else if (ErrorCodes.OBJECT_NOT_FOUND.getMessage().equals(
				result.getErrorMessage())) {
			throw new ObjectNotFoundException();
		}
	}
}
