package com.sosv.breweryDB.connector.service.beer.async.callables;

import java.util.concurrent.Callable;

import org.apache.log4j.Logger;

import com.sosv.breweryDB.connector.entity.beer.Beer;
import com.sosv.breweryDB.connector.service.beer.IBeerService;
import com.sosv.breweryDB.connector.service.resource.filter.beer.IBeerFilter;

public class GetBeerByIdCallable implements Callable<Beer> {

	private IBeerService beerService;
	private IBeerFilter filter;
	private String id;

	private static Logger logger = Logger.getLogger(GetBeerByIdCallable.class);

	public GetBeerByIdCallable(IBeerService beerService, String id,
			IBeerFilter filter) {
		this(beerService, id);
		this.filter = filter;
	}

	public GetBeerByIdCallable(IBeerService beerService, String id) {
		super();
		this.beerService = beerService;
		this.id = id;
	}

	@Override
	public Beer call() throws Exception {
		logger.debug("Get beer by id callable. Current thread: "
				+ Thread.currentThread().getId());
		return beerService.getBeerById(id, filter);
	}

}
