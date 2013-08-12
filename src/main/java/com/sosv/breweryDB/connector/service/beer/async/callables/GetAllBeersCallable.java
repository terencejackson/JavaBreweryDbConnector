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
package com.sosv.breweryDB.connector.service.beer.async.callables;

import java.util.List;
import java.util.concurrent.Callable;

import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.sosv.breweryDB.connector.entity.beer.Beer;
import com.sosv.breweryDB.connector.service.async.IResultCallback;
import com.sosv.breweryDB.connector.service.beer.IBeerService;
import com.sosv.breweryDB.connector.service.exceptions.ApiKeyNotFoundExeption;
import com.sosv.breweryDB.connector.service.resource.filter.beer.IBeersFilter;

public class GetAllBeersCallable implements Callable<List<Beer>> {

	private IBeerService beerService;
	private IBeersFilter beerFilter;
	private IResultCallback<List<Beer>> callback;

	private static Logger logger = Logger.getLogger(GetAllBeersCallable.class);

	@Inject
	public GetAllBeersCallable(IBeerService beerService,
			IResultCallback<List<Beer>> callback) {
		super();
		this.beerService = beerService;
		this.callback = callback;
	}

	public GetAllBeersCallable(IBeerService beerService,
			IBeersFilter beerFilter, IResultCallback<List<Beer>> callback) {
		this(beerService, callback);
		this.beerFilter = beerFilter;
	}

	/**
	 * @throws ApiKeyNotFoundExeption
	 *             If the api key is not available or invalid
	 */
	@Override
	public List<Beer> call() throws Exception {
		logger.debug("Call on thread: " + Thread.currentThread().getId());
		List<Beer> result = null;
		if (beerFilter == null) {
			result = this.beerService.getAllBeers();
		} else {
			result = this.beerService.getAllBeers(beerFilter);
		}
		callback.onSuccess(result);
		return result;
	}

}
