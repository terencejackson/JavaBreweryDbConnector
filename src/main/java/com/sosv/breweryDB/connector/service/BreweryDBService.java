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
package com.sosv.breweryDB.connector.service;

import java.util.List;

import com.google.inject.Inject;
import com.sosv.breweryDB.connector.entity.beer.Beer;
import com.sosv.breweryDB.connector.entity.beer.BeerResultPage;
import com.sosv.breweryDB.connector.entity.brewery.Brewery;
import com.sosv.breweryDB.connector.service.beer.IBeerService;
import com.sosv.breweryDB.connector.service.brewery.IBreweryService;
import com.sosv.breweryDB.connector.service.exceptions.ApiKeyNotFoundExeption;
import com.sosv.breweryDB.connector.service.resource.filter.beer.IBeerFilter;
import com.sosv.breweryDB.connector.service.resource.filter.beer.IBeersFilter;
import com.sosv.breweryDB.connector.service.resource.filter.brewery.IBreweriesFilter;
import com.sosv.breweryDB.connector.service.resource.filter.search.ISearchFilter;
import com.sosv.breweryDB.connector.service.search.ISearchService;

/**
 * The service to get the data of the breweryDB service
 * 
 * @author Sven
 * 
 */
public class BreweryDBService implements IBeerService, IBreweryDBService, ISearchService {

	private IBeerService beerService;
	private IBreweryService breweryService;
    private ISearchService searchService;

	/**
	 * C'tor
	 * 
	 * @param beerService
	 *            The beer service which is used to retrieve the beer data
	 */
	@Inject
	public BreweryDBService(IBeerService beerService,
			IBreweryService breweryService,
            ISearchService searchService) {
		super();
		this.beerService = beerService;
		this.breweryService = breweryService;
        this.searchService = searchService;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sosv.breweryDB.connector.service.beer.IBeerService#getPagesBeers(
	 * java.lang.Number)
	 */
	@Override
	public BeerResultPage getPagesBeers(Number pageNumber)
			throws ApiKeyNotFoundExeption {
		return beerService.getPagesBeers(pageNumber);
	}

	@Override
	public List<Beer> getAllBeers(IBeersFilter beerFilter)
			throws ApiKeyNotFoundExeption {
		return beerService.getAllBeers(beerFilter);
	}

	@Override
	public BeerResultPage getPagesBeers(Number pageNumber,
			IBeersFilter beerFilter) throws ApiKeyNotFoundExeption {
		return beerService.getPagesBeers(pageNumber, beerFilter);
	}

	@Override
	public List<Beer> getAllBeers() throws ApiKeyNotFoundExeption {
		return beerService.getAllBeers();
	}

	@Override
	public Beer getBeerById(String id) throws ApiKeyNotFoundExeption {
		return beerService.getBeerById(id);
	}

	@Override
	public Beer getBeerById(String id, IBeerFilter filter)
			throws ApiKeyNotFoundExeption {
		return beerService.getBeerById(id, filter);
	}

	@Override
	public List<Brewery> getAllBreweries() throws ApiKeyNotFoundExeption {
		return breweryService.getAllBreweries();
	}

	@Override
	public List<Brewery> getAllBreweries(IBreweriesFilter breweryFilter)
			throws ApiKeyNotFoundExeption {
		return breweryService.getAllBreweries(breweryFilter);
	}

	@Override
	public Brewery getBreweryById(String id) throws ApiKeyNotFoundExeption {
		return breweryService.getBreweryById(id);
	}

	@Override
	public Brewery getBreweryById(String id,
			IBreweriesFilter filter)
			throws ApiKeyNotFoundExeption {
		return breweryService.getBreweryById(id, filter);
	}

    @Override
    public List<Beer> searchBeers(String query)
        throws ApiKeyNotFoundExeption {
        return searchService.searchBeers(query);
    }

    @Override
    public List<Beer> searchBeers(String query,
                                  ISearchFilter filter)
        throws ApiKeyNotFoundExeption {
        return searchService.searchBeers(query, filter);
    }

    @Override
    public List<Beer> searchBeersByUpc(String upc)
        throws ApiKeyNotFoundExeption {
        return searchService.searchBeersByUpc(upc);
    }

    @Override
    public List<Beer> searchBeersByUpc(String upc,
                                       ISearchFilter filter)
        throws ApiKeyNotFoundExeption {
        return searchService.searchBeersByUpc(upc, filter);
    }
}
