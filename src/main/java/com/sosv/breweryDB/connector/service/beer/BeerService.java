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
import java.util.Collection;
import java.util.List;

import com.sosv.breweryDB.connector.entity.beer.Beer;
import com.sosv.breweryDB.connector.entity.beer.Page;
import com.sosv.breweryDB.connector.service.resource.beer.IBeerResource;

/**
 * Implementation of the beer service
 * 
 * @author Sven
 * 
 */
public class BeerService implements IBeerService {

	private IBeerResource beerResource;

	public BeerService(IBeerResource beerResource) {
		this.beerResource = beerResource;
	}
	
	@Override
	public Page getPagesBeers(Number pageNumber){
		Page page = this.beerResource.getBeers(pageNumber);
		return page;
	}

	@Override
	public Collection<Beer> getAll() {
		// A set would be faster but we take a list here because of sorting
		// functionality in future releases
		List<Beer> beers = new ArrayList<Beer>();
		Page firstPage = this.beerResource.getBeers(null);

		beers.addAll(handlePage(firstPage));

		return beers;
	}

	private List<? extends Beer> handlePage(Page page) {
		List<Beer> beers = page.getData();
		if (beers == null || beers.isEmpty()) {
			beers = new ArrayList<Beer>();
		}
		Number currentPage = page.getCurrentPage();
		if (currentPage != page.getNumberOfPages()) {
			beers.addAll(handlePage(this.beerResource.getBeers(currentPage.intValue() + 1)));
		}

		return beers;
	}

}
