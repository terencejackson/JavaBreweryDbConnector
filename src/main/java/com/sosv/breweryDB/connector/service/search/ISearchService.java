package com.sosv.breweryDB.connector.service.search;

import java.util.List;

import com.sosv.breweryDB.connector.entity.beer.Beer;
import com.sosv.breweryDB.connector.service.exceptions.ApiKeyNotFoundExeption;
import com.sosv.breweryDB.connector.service.resource.filter.search.ISearchFilter;

/**
 * Interface for the search service
 * 
 * @author ssommerf
 * 
 */
public interface ISearchService {

	/**
	 * Search for beers without additional filter
	 * 
	 * @param query
	 *            The query string like Red or Stripe. Must not be null!
	 * @return The found beers or null
	 * @throws ApiKeyNotFoundExeption
	 */
	List<Beer> searchBeers(String query) throws ApiKeyNotFoundExeption;

	/**
	 * Search for beers.
	 * 
	 * @param query
	 *            The query string like Red or Stripe. Must not be null!
	 * @param filter
	 *            The additional filter to apply. If null no additional filter
	 *            is applied
	 * @return The found beers or null
	 * @throws ApiKeyNotFoundExeption
	 */
	List<Beer> searchBeers(String query, ISearchFilter filter)
			throws ApiKeyNotFoundExeption;

	/**
	 * Search for beers by UPC. Will return one or more beers.
	 * 
	 * @param upc
	 *            The UPC code to lookup. Since a UPC can start with a 0 this is
	 *            a String. The input must match the regular expression
	 *            ^[0-9]{12}$ (BreweryDBConnectorConstants.UPC_REGEX), if not a {@link IllegalArgumentException} is
	 *            thrown
	 * @return The found beers or null
	 * @throws ApiKeyNotFoundExeption
	 */
	List<Beer> searchBeersByUpc(String upc) throws ApiKeyNotFoundExeption;

	/**
	 * Search for beers by UPC. Will return one or more beers.
	 * 
	 * @param upc
	 *            The UPC code to lookup. Since a UPC can start with a 0 this is
	 *            a String. The input must match the regular expression
	 *            ^[0-9]{12}$ (BreweryDBConnectorConstants.UPC_REGEX), if not a {@link IllegalArgumentException} is
	 *            thrown
	 * @param filter
	 *            The additional filter to apply
	 * @return The found beers or null
	 * @throws ApiKeyNotFoundExeption
	 */
	List<Beer> searchBeersByUpc(String upc, ISearchFilter filter)
			throws ApiKeyNotFoundExeption;
}
