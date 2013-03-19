package com.sosv.breweryDB.connector.service.resource.brewery;

import javax.ws.rs.core.MultivaluedMap;

import com.google.inject.Inject;
import com.sosv.breweryDB.connector.configuration.IBreweryDBConnectorConfiguration;
import com.sosv.breweryDB.connector.entity.Brewery;
import com.sosv.breweryDB.connector.entity.BreweryResultPage;
import com.sosv.breweryDB.connector.service.exceptions.ApiKeyNotFoundExeption;
import com.sosv.breweryDB.connector.service.exceptions.ObjectNotFoundException;
import com.sosv.breweryDB.connector.service.resource.AbstractResource;
import com.sosv.breweryDB.connector.service.resource.filter.FilterMultivalueMapBuilder;
import com.sosv.breweryDB.connector.service.resource.filter.brewery.IBreweryFilter;
import com.sun.jersey.api.client.Client;

public class BreweryResource extends AbstractResource implements
		IBreweryResource {

	@Inject
	public BreweryResource(IBreweryDBConnectorConfiguration configuration,
			Client client) {
		super(configuration, client);
	}

	@Override
	public BreweryResultPage getBreweries(Number currentPage,
			IBreweryFilter filter) throws ApiKeyNotFoundExeption {
		MultivaluedMap<String, String> map = new FilterMultivalueMapBuilder()
				.convert(filter);
		BreweryResultPage result = null;
		if (currentPage != null) {
			map.add("p", currentPage.toString());
		}
		try {
			result = get("breweries/", map, new BreweryResultPage());
		} catch (ObjectNotFoundException e) {
			//Silently catched
		}
		return result;
	}

	@Override
	public Brewery getBreweryById(String id) throws ApiKeyNotFoundExeption {
		// TODO Auto-generated method stub
		return null;
	}

}
