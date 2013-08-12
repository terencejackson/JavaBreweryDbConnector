package com.sosv.breweryDB.connector.service.async;

import java.util.List;

import com.google.inject.Inject;
import com.sosv.breweryDB.connector.entity.beer.Beer;
import com.sosv.breweryDB.connector.entity.beer.BeerResultPage;
import com.sosv.breweryDB.connector.service.beer.async.IBeerServiceAsync;
import com.sosv.breweryDB.connector.service.resource.filter.beer.IBeerFilter;
import com.sosv.breweryDB.connector.service.resource.filter.beer.IBeersFilter;

/**
 * Asynch brewery db service
 * 
 * @author Sven
 * 
 */
public class BreweryDBServiceAsync implements IBreweryDBServiceAsync {

	private IBeerServiceAsync beerService;

	@Inject
	public BreweryDBServiceAsync(IBeerServiceAsync beerService) {
		super();
		this.beerService = beerService;
	}

	@Override
	public void getAllBeers(IResultCallback<List<Beer>> callback) {
		beerService.getAllBeers(callback);
	}

	@Override
	public void getPagesBeers(Number pageNumber,
			IResultCallback<BeerResultPage> callback) {
		beerService.getPagesBeers(pageNumber, callback);
	}

	@Override
	public void getAllBeers(IBeersFilter beerFilter,
			IResultCallback<List<Beer>> callback) {
		beerService.getAllBeers(beerFilter, callback);
	}

	@Override
	public void getPagesBeers(Number pageNumber, IBeersFilter beerFilter,
			IResultCallback<BeerResultPage> callback) {
		beerService.getPagesBeers(pageNumber, beerFilter, callback);
	}

	@Override
	public void getBeerById(String id, IResultCallback<Beer> callback) {
		beerService.getBeerById(id, callback);
	}

	@Override
	public void getBeerById(String id, IBeerFilter filter,
			IResultCallback<Beer> callback) {
		beerService.getBeerById(id, filter, callback);
	}

}
