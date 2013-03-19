package com.sosv.breweryDB.connector.service.brewery;

import java.util.List;

import com.sosv.breweryDB.connector.entity.brewery.Brewery;
import com.sosv.breweryDB.connector.service.exceptions.ApiKeyNotFoundExeption;
import com.sosv.breweryDB.connector.service.resource.filter.brewery.IBreweriesFilter;

public interface IBreweryService {

	/**
	 * Get all breweries
	 * @return 
	 * @throws ApiKeyNotFoundExeption
	 */
	List<Brewery> getAllBreweries() throws ApiKeyNotFoundExeption;

	/**
	 * Get all breweries with a filter
	 * @param breweryFilter
	 * @return
	 * @throws ApiKeyNotFoundExeption
	 */
	List<Brewery> getAllBreweries(IBreweriesFilter breweryFilter)
			throws ApiKeyNotFoundExeption;
	
	/**
	 * Get a brewery by its id
	 * @param id
	 * @return The found object or null
	 * @throws ApiKeyNotFoundExeption
	 */
	Brewery getBreweryById(String id) throws ApiKeyNotFoundExeption;

	/**
	 * Get a brewery by its id and apply a filter
	 * @param id
	 * @param createWithLocationsFilter
	 * @return he found object or null
	 * @throws ApiKeyNotFoundExeption
	 */
	Brewery getBreweryById(String id,
			IBreweriesFilter createWithLocationsFilter) throws ApiKeyNotFoundExeption;
}
