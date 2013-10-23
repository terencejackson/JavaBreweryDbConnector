package com.sosv.breweryDB.connector.service.resource.search;

import java.util.List;

import com.sosv.breweryDB.connector.entity.beer.Beer;
import com.sosv.breweryDB.connector.entity.search.BeerSearchResultPage;
import com.sosv.breweryDB.connector.service.exceptions.ApiKeyNotFoundExeption;
import com.sosv.breweryDB.connector.service.resource.filter.search.ISearchFilter;

/**
 * Interface for the serch resource
 * 
 * @author ssommerf
 * 
 */
public interface ISearchResource {

	/**
	 * Search for beers
	 * 
	 * @param query
	 * @param currentPage
	 * @param filter
	 * @return
	 * @throws ApiKeyNotFoundExeption 
	 */
	BeerSearchResultPage searchBeers(String query, Number currentPage,
			ISearchFilter filter) throws ApiKeyNotFoundExeption;
	
	/**
	 * Search for beers by a upc
	 * @param upc
	 * @param filter
	 * @return
	 * @throws ApiKeyNotFoundExeption 
	 */
	List<Beer> searchByUPC(String upc, ISearchFilter filter) throws ApiKeyNotFoundExeption;
}
