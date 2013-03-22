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
package com.sosv.breweryDB.connector.service.beer;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sosv.breweryDB.connector.entity.beer.Beer;
import com.sosv.breweryDB.connector.entity.beer.BeerResultPage;
import com.sosv.breweryDB.connector.service.exceptions.ApiKeyNotFoundExeption;
import com.sosv.breweryDB.connector.service.resource.beer.IBeerResource;
import com.sosv.breweryDB.connector.service.resource.filter.beer.IBeerFilter;
import com.sosv.breweryDB.connector.service.resource.filter.beer.IBeersFilter;
import com.google.inject.Inject;

/**
 * Implementation of the beer service
 * 
 * @author Sven
 * 
 */
public class BeerService implements IBeerService {

	private static Logger logger = Logger.getLogger(BeerService.class);
	
	private IBeerResource beerResource;

	@Inject
	public BeerService(IBeerResource beerResource) {
		this.beerResource = beerResource;
	}

	@Override
	public BeerResultPage getPagesBeers(Number pageNumber)
			throws ApiKeyNotFoundExeption {
		BeerResultPage page = this.beerResource.getBeers(pageNumber, null);
		return page;
	}

	@Override
	public List<Beer> getAllBeers() throws ApiKeyNotFoundExeption {
		return getAllBeers(null);
	}

	private List<? extends Beer> handlePage(BeerResultPage page,
			IBeersFilter filter) throws ApiKeyNotFoundExeption {	
		List<Beer> beers = page.getData();
		if (beers == null || beers.isEmpty()) {
			beers = new ArrayList<Beer>();
		}
		
		int currentPage = page.getCurrentPage().intValue();
		int numberOfPages = page.getNumberOfPages().intValue();
		
		logger.debug("Current page is " + currentPage + ". Number of pages is: " + numberOfPages);
		
		if (currentPage < numberOfPages) {
			beers.addAll(handlePage(this.beerResource.getBeers(
					currentPage + 1, filter), filter));
		}

		return beers;
	}

	@Override
	public List<Beer> getAllBeers(IBeersFilter beerFilter)
			throws ApiKeyNotFoundExeption {
		// A set would be faster but we take a list here because of sorting
		// functionality in future releases
		List<Beer> beers = new ArrayList<Beer>();
		BeerResultPage firstPage = this.beerResource.getBeers(null, beerFilter);

		beers.addAll(handlePage(firstPage, beerFilter));

		return beers;
	}

	@Override
	public BeerResultPage getPagesBeers(Number pageNumber,
			IBeersFilter beerFilter) throws ApiKeyNotFoundExeption {
		return beerResource.getBeers(pageNumber, beerFilter);
	}

	@Override
	public Beer getBeerById(String id) throws ApiKeyNotFoundExeption {
		return getBeerById(id, null);
	}

	@Override
	public Beer getBeerById(String id, IBeerFilter filter) throws ApiKeyNotFoundExeption {
		return beerResource.getBeerById(id, filter);
	}

}
