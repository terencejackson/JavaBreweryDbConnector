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
package com.sosv.breweryDB.connector.service.async;

import java.util.List;
import java.util.concurrent.Callable;

import com.google.inject.Inject;
import com.sosv.breweryDB.connector.entity.beer.Beer;
import com.sosv.breweryDB.connector.entity.beer.BeerResultPage;
import com.sosv.breweryDB.connector.service.beer.IBeerService;
import com.sosv.breweryDB.connector.service.beer.async.callables.GetAllBeersCallable;
import com.sosv.breweryDB.connector.service.beer.async.callables.GetBeerByIdCallable;
import com.sosv.breweryDB.connector.service.beer.async.callables.GetPagesBeersCallable;
import com.sosv.breweryDB.connector.service.resource.filter.beer.IBeerFilter;
import com.sosv.breweryDB.connector.service.resource.filter.beer.IBeersFilter;

/**
 * Implementation of {@link ICallableFactory} to create all callables for async service calls
 * @author Sven
 *
 */
public class CallableFactory implements ICallableFactory {
	
	private IBeerService beerService;

	@Inject
	public CallableFactory(IBeerService beerService) {
		super();
		this.beerService = beerService;
	}

	@Override
	public Callable<List<Beer>> getAllBeersCallable(IResultCallback<List<Beer>> callback) {
		return new GetAllBeersCallable(beerService, callback);
	}

	@Override
	public Callable<BeerResultPage> getPagesBeersCallable(Number pageNumber, IResultCallback<BeerResultPage> callback) {
		return new GetPagesBeersCallable(beerService, pageNumber, callback);
	}

	@Override
	public Callable<List<Beer>> getAllBeersCallable(IBeersFilter beerFilter, IResultCallback<List<Beer>> callback) {
		return new GetAllBeersCallable(beerService, beerFilter, callback);
	}

	@Override
	public Callable<BeerResultPage> getPagesBeersCallable(Number pageNumber,
			IBeersFilter beerFilter, IResultCallback<BeerResultPage> callback) {
		 return new GetPagesBeersCallable(beerService, beerFilter, pageNumber, callback);
	}

	@Override
	public Callable<Beer> getBeerByIdCallable(String id, IBeerFilter filter, IResultCallback<Beer> callback) {
		return new GetBeerByIdCallable(beerService, id, filter, callback);
	}

	@Override
	public Callable<Beer> getBeerByIdCallable(String id, IResultCallback<Beer> callback) {
		return new GetBeerByIdCallable(beerService, id, callback);
	}

}
