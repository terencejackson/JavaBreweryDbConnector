package com.sosv.breweryDB.connector.service.resource.filter.brewery;

import com.sosv.breweryDB.connector.service.resource.filter.IBaseFilter;

/**
 * Interface for the filter for a breweries request
 * @author ssommerf
 *
 */
public interface IBreweriesFilter extends IBreweryFilter, IBaseFilter{

	/**
	 * Year a brewery was established. Format YYYY
	 * @return The Year a brewery was established. Format YYYY
	 */
	Integer getEstablished();
	
	
	
}
