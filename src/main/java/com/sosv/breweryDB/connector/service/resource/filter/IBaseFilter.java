package com.sosv.breweryDB.connector.service.resource.filter;

import java.util.Collection;

/**
 * Base interface for a filter
 * @author ssommerf
 *
 */
public interface IBaseFilter {

	/**
	 * All id's to lookup. BreweryDB documentation: ID's of the beers to return
	 * => Max 10.
	 * 
	 * @return
	 */
	Collection<String> getIds();

	/**
	 * The name to lookup. BreweryDB documentation: Name of a beer.
	 * 
	 * @return
	 */
	String getName();

	/**
	 * How the results should be sorted.
	 * @return
	 */
	Sorting getSort();
	
	/**
	 * Returns everything that has been updated since that date. Max 30 days. In
	 * UNIX timestamp format.
	 * 
	 * @return
	 */
	Long getSince();
	
	/**
	 * Defines the filter if the beer should be organic
	 * 
	 * @return
	 */
	Boolean isOrganic();

}