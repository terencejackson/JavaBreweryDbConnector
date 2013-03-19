package com.sosv.breweryDB.connector.service.resource.filter.brewery;

/**
 * Interface for the filter for a brewery request
 * @author ssommerf
 *
 */
public interface IBreweryFilter {

	/**
	 * Get brewery results with location information included.
	 * PREMIUM feature!
	 * @return True if locations should be loaded, null or False if not
	 */
	Boolean withLocations();
}
