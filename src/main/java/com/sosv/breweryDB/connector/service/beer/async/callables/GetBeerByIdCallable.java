package com.sosv.breweryDB.connector.service.beer.async.callables;

import java.util.concurrent.Callable;

import org.apache.log4j.Logger;

import com.sosv.breweryDB.connector.entity.beer.Beer;
import com.sosv.breweryDB.connector.service.async.IResultCallback;
import com.sosv.breweryDB.connector.service.beer.IBeerService;
import com.sosv.breweryDB.connector.service.resource.filter.beer.IBeerFilter;

public class GetBeerByIdCallable implements Callable<Beer> {

	private IBeerService beerService;
	private IBeerFilter filter;
	private String id;
	private IResultCallback<Beer> callback;

	private static Logger logger = Logger.getLogger(GetBeerByIdCallable.class);

	public GetBeerByIdCallable(IBeerService beerService, String id,
			IBeerFilter filter, IResultCallback<Beer> callback) {
		this(beerService, id, callback);
		this.filter = filter;
	}

	public GetBeerByIdCallable(IBeerService beerService, String id, IResultCallback<Beer> callback) {
		super();
		this.beerService = beerService;
		this.id = id;
		this.callback = callback;
	}

	@Override
	public Beer call() throws Exception {
		logger.debug("Get beer by id callable. Current thread: "
				+ Thread.currentThread().getId());
		Beer result = beerService.getBeerById(id, filter);
		callback.onSuccess(result);
		return result;
	}

}
