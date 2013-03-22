package com.sosv.breweryDB.connector.service.resource.search;

import javax.ws.rs.core.MultivaluedMap;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.sosv.breweryDB.connector.configuration.IBreweryDBConnectorConfiguration;
import com.sosv.breweryDB.connector.entity.search.BeerSearchResultPage;
import com.sosv.breweryDB.connector.service.exceptions.ApiKeyNotFoundExeption;
import com.sosv.breweryDB.connector.service.exceptions.ObjectNotFoundException;
import com.sosv.breweryDB.connector.service.resource.AbstractResource;
import com.sosv.breweryDB.connector.service.resource.filter.FilterMultivalueMapBuilder;
import com.sosv.breweryDB.connector.service.resource.filter.search.ISearchFilter;
import com.sun.jersey.api.client.Client;

public class SearchResource extends AbstractResource implements ISearchResource {

	@Inject
	public SearchResource(IBreweryDBConnectorConfiguration configuration,
			Client client) {
		super(configuration, client);
	}

	@Override
	public BeerSearchResultPage searchBeers(String query, Number currentPage,
			ISearchFilter filter) throws ApiKeyNotFoundExeption {
		Preconditions.checkArgument(query != null, "query must not be null");
		
		BeerSearchResultPage result = null;
		
		MultivaluedMap<String, String> map = new FilterMultivalueMapBuilder().convert(filter);
		map.add("q", query);
		map.add("type", "beer");
		
		if (currentPage != null) {
			map.add("p", currentPage.toString());
		}
		
		try {
			result = get("search/", map , new BeerSearchResultPage());
		} catch (ObjectNotFoundException e) {
		}
		
		return  result;
	}

}
