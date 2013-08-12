package com.sosv.breweryDB.connector.service.beer.async.callables;

import java.util.concurrent.Callable;

import com.sosv.breweryDB.connector.entity.beer.BeerResultPage;
import com.sosv.breweryDB.connector.service.beer.IBeerService;
import com.sosv.breweryDB.connector.service.resource.filter.beer.IBeersFilter;

public class GetPagesBeersCallable implements Callable<BeerResultPage> {

	private IBeerService beerService;
	private Number pageNumber;
	private IBeersFilter beerFilter;

	public GetPagesBeersCallable(IBeerService beerService, Number pageNumber) {
		super();
		this.beerService = beerService;
		this.pageNumber = pageNumber;
	}

	public GetPagesBeersCallable(IBeerService beerService,
			IBeersFilter beerFilter, Number pageNumber) {
		this(beerService, pageNumber);
		this.beerFilter = beerFilter;
	}

	@Override
	public BeerResultPage call() throws Exception {
		return beerService.getPagesBeers(pageNumber, beerFilter);
	}

}
