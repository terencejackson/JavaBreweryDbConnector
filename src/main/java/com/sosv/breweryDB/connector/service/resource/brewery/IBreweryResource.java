package com.sosv.breweryDB.connector.service.resource.brewery;

import com.sosv.breweryDB.connector.entity.brewery.Brewery;
import com.sosv.breweryDB.connector.entity.brewery.BreweryResultPage;
import com.sosv.breweryDB.connector.service.exceptions.ApiKeyNotFoundExeption;
import com.sosv.breweryDB.connector.service.resource.filter.brewery.IBreweriesFilter;
import com.sosv.breweryDB.connector.service.resource.filter.brewery.IBreweryFilter;

/**
 * Interface for the brewery resource services
 * 
 * @author ssommerf
 * 
 */
public interface IBreweryResource {
	/**
	 * Get breweries for a page
	 * 
	 * @param currentPage
	 *            The current page => If null no page is requested
	 * @param filter
	 *            The filter to apply => if null no filter is applied
	 * @return The response as {@link BreweryResultPage}
	 * @throws ApiKeyNotFoundExeption
	 */
	BreweryResultPage getBreweries(Number currentPage, IBreweriesFilter filter)
			throws ApiKeyNotFoundExeption;

	/**
	 * Get a brewery by its id
	 * 
	 * @param id
	 * @return The found {@link Brewery}
	 * @throws ApiKeyNotFoundExeption
	 *             If the provided api key was not found by brewery db
	 */
	Brewery getBreweryById(String id, IBreweryFilter filter)
			throws ApiKeyNotFoundExeption;

}
