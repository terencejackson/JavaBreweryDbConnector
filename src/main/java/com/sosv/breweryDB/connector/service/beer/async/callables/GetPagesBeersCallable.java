package com.sosv.breweryDB.connector.service.beer.async.callables;

import java.util.concurrent.Callable;

import com.sosv.breweryDB.connector.entity.beer.BeerResultPage;
import com.sosv.breweryDB.connector.service.async.IResultCallback;
import com.sosv.breweryDB.connector.service.beer.IBeerService;
import com.sosv.breweryDB.connector.service.resource.filter.beer.IBeersFilter;

public class GetPagesBeersCallable implements Callable<BeerResultPage> {

	private IBeerService beerService;
	private Number pageNumber;
	private IBeersFilter beerFilter;
	private IResultCallback<BeerResultPage> callback;

	public GetPagesBeersCallable(IBeerService beerService, Number pageNumber, IResultCallback<BeerResultPage> callback) {
		super();
		this.beerService = beerService;
		this.pageNumber = pageNumber;
		this.callback = callback;
	}

	public GetPagesBeersCallable(IBeerService beerService,
			IBeersFilter beerFilter, Number pageNumber, IResultCallback<BeerResultPage> callback) {
		this(beerService, pageNumber, callback);
		this.beerFilter = beerFilter;
	}

	@Override
	public BeerResultPage call() throws Exception {
		BeerResultPage result = beerService.getPagesBeers(pageNumber, beerFilter);
		callback.onSuccess(result);
		return result;
	}

}
