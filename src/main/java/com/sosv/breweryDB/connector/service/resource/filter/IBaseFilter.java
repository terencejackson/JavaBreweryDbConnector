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
	public abstract Collection<String> getIds();

	/**
	 * The name to lookup. BreweryDB documentation: Name of a beer.
	 * 
	 * @return
	 */
	public abstract String getName();

	/**
	 * How the results should be sorted.
	 * @return
	 */
	public abstract Sorting getSort();

}