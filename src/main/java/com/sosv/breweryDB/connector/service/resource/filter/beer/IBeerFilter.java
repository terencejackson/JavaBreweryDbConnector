package com.sosv.breweryDB.connector.service.resource.filter.beer;

public interface IBeerFilter {

	/**
	 * Get beer results with brewery information included.
	 * @return
	 */
	public abstract Boolean withBreweries();

}