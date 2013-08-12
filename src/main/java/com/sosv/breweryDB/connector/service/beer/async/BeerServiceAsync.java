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
package com.sosv.breweryDB.connector.service.beer.async;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.sosv.breweryDB.connector.entity.beer.Beer;
import com.sosv.breweryDB.connector.entity.beer.BeerResultPage;
import com.sosv.breweryDB.connector.service.async.ICallableFactory;
import com.sosv.breweryDB.connector.service.async.IResultCallback;
import com.sosv.breweryDB.connector.service.resource.filter.beer.IBeerFilter;
import com.sosv.breweryDB.connector.service.resource.filter.beer.IBeersFilter;

/**
 * Asnychronous beer service
 * 
 * @author Sven
 * 
 */
public class BeerServiceAsync implements IBeerServiceAsync {

	private static Logger logger = Logger.getLogger(BeerServiceAsync.class);

	private ICallableFactory factory;

	@Inject
	public BeerServiceAsync(ICallableFactory factory) {
		super();
		this.factory = factory;
	}

	@Override
	public void getAllBeers(IResultCallback<List<Beer>> callback) {
		logger.debug("Get all beers asnyc. Current thread: "
				+ Thread.currentThread().getId());
		ExecutorService executor = Executors.newSingleThreadExecutor();
		try {
			executor.submit(this.factory
					.getAllBeersCallable(callback));
		} catch (Exception e) {
			logger.error("Error occured calling get all beers asnyc", e);
			callback.onError(e);
		} finally {
			executor.shutdown();
		}
	}

	@Override
	public void getPagesBeers(Number pageNumber,
			IResultCallback<BeerResultPage> callback) {
		logger.debug("Get pages beers. Current thread: "
				+ Thread.currentThread().getId());
		ExecutorService executor = Executors.newSingleThreadExecutor();
		try {
			executor.submit(this.factory
					.getPagesBeersCallable(pageNumber, callback));
			logger.debug("Successfully called get all beers asnyc");
		} catch (Exception e) {
			logger.error("Error occured calling get all beers asnyc", e);
			callback.onError(e);
		} finally {
			executor.shutdown();
		}
	}

	@Override
	public void getAllBeers(IBeersFilter beerFilter,
			IResultCallback<List<Beer>> callback) {
		logger.debug("Get all beers with filer asnyc. Current thread: "
				+ Thread.currentThread().getId());
		ExecutorService executor = Executors.newSingleThreadExecutor();
		try {
			executor.submit(this.factory
					.getAllBeersCallable(beerFilter, callback));
		} catch (Exception e) {
			logger.error("Error occured calling get all beers asnyc", e);
			callback.onError(e);
		}finally{
			executor.shutdown();
		}
	}

	@Override
	public void getPagesBeers(Number pageNumber, IBeersFilter beerFilter,
			IResultCallback<BeerResultPage> callback) {
		logger.debug("Get pages beers. Current thread: "
				+ Thread.currentThread().getId());
		ExecutorService executor = Executors.newSingleThreadExecutor();
		try {
			Future<BeerResultPage> future = executor.submit(this.factory
					.getPagesBeersCallable(pageNumber, beerFilter, callback));
			logger.debug("Successfully called get all beers asnyc");
			callback.onSuccess(future.get());
		} catch (Exception e) {
			logger.error("Error occured calling get all beers asnyc", e);
			callback.onError(e);
		} finally {
			executor.shutdown();
		}
	}

	@Override
	public void getBeerById(String id, IResultCallback<Beer> callback) {
		logger.debug("Get beer by id. Current thread: "
				+ Thread.currentThread().getId());
		ExecutorService executor = Executors.newSingleThreadExecutor();
		try {
			executor.submit(this.factory
					.getBeerByIdCallable(id, callback));
		} catch (Exception e) {
			logger.error("Error occured calling get all beers asnyc", e);
			callback.onError(e);
		} finally {
			executor.shutdown();
		}
	}

	@Override
	public void getBeerById(String id, IBeerFilter filter,
			IResultCallback<Beer> callback) {
		logger.debug("Get beer by id with filer. Current thread: "
				+ Thread.currentThread().getId());
		ExecutorService executor = Executors.newSingleThreadExecutor();
		try {
			executor.submit(this.factory
					.getBeerByIdCallable(id, filter, callback));
		} catch (Exception e) {
			logger.error("Error occured calling get all beers asnyc", e);
			callback.onError(e);
		} finally {
			executor.shutdown();
		}
	}

}
