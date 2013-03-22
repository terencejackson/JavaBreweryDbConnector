package com.sosv.breweryDB.connector.service.search;

import java.util.List;

import com.sosv.breweryDB.connector.entity.beer.Beer;
import com.sosv.breweryDB.connector.service.exceptions.ApiKeyNotFoundExeption;
import com.sosv.breweryDB.connector.service.resource.filter.search.ISearchFilter;

/**
 * Interface for the search service
 * @author ssommerf
 *
 */
public interface ISearchService {

	/**
	 * Search for beers without additional filter
	 * @param query The query string like Red or Stripe. Must not be null!
	 * @return The found beers or null
	 * @throws ApiKeyNotFoundExeption 
	 */
	List<Beer> searchBeers(String query) throws ApiKeyNotFoundExeption;
	
	/**
	 * Search for beers.
	 * @param query The query string like Red or Stripe. Must not be null!
	 * @param filter The additional filter to apply. If null no additional filter is applied 
	 * @return The found beers or null
	 * @throws ApiKeyNotFoundExeption 
	 */
	List<Beer> searchBeers(String query, ISearchFilter filter) throws ApiKeyNotFoundExeption;
}
