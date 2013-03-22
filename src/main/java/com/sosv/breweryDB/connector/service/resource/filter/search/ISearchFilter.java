package com.sosv.breweryDB.connector.service.resource.filter.search;

/**
 * Interface for the search filter
 * @author ssommerf
 *
 */
public interface ISearchFilter {

	/**
	 * Get results with brewery information included.
	 * @return
	 */
	Boolean withBreweries();
	
	/**
	 * Get brewery results with social account information included. 
	 * PREMIUM FEATURE!
	 * @return
	 */
	Boolean withSocialAccounts();
	
	/**
	 * Get brewery results with location information included. 
	 * PREMIUM FEATURE!
	 * @return
	 */
	Boolean withLocations();
	
	/**
	 * Get brewery results with alternate name information included.
	 * PREMIUM FEATURE!
	 * @return
	 */
	Boolean withAlternateNames();
	
	/**
	 * Get beer results with ingredient information included.
	 * PREMIUM FEATURE!
	 * @return
	 */
	Boolean withIngredients();
}
