package com.sosv.breweryDB.connector.service.resource.filter.search;

import com.google.common.base.Preconditions;

/**
 * Implementation of the {@link ISearchFilter}
 * @author ssommerf
 *
 */
public class SearchFilter implements ISearchFilter {

	private Boolean withIngredients;
	private Boolean withAlternateNames;
	private Boolean withLocations;
	private Boolean withSocialAccounts;
	private Boolean withBreweries;
	
	public void setWithIngredients(Boolean withIngredients) {
		this.withIngredients = withIngredients;
	}

	public void setWithAlternateNames(Boolean withAlternateNames) {
		this.withAlternateNames = withAlternateNames;
	}

	public void setWithLocations(Boolean withLocations) {
		this.withLocations = withLocations;
	}

	public void setWithSocialAccounts(Boolean withSocialAccounts) {
		this.withSocialAccounts = withSocialAccounts;
	}

	public void setWithBreweries(Boolean withBreweries) {
		this.withBreweries = withBreweries;
	}

	@Override
	public Boolean withBreweries() {
		return withBreweries;
	}

	@Override
	public Boolean withSocialAccounts() {
		return withSocialAccounts;
	}

	@Override
	public Boolean withLocations() {
		return withLocations;
	}

	@Override
	public Boolean withAlternateNames() {
		return withAlternateNames;
	}

	@Override
	public Boolean withIngredients() {
		return withIngredients;
	}
}
