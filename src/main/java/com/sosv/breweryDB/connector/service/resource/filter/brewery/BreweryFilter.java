package com.sosv.breweryDB.connector.service.resource.filter.brewery;

public class BreweryFilter implements IBreweryFilter {

	private Boolean withLocations;

	@Override
	public Boolean withLocations() {
		return withLocations;
	}

	public void setWithLocations(Boolean withLocations) {
		this.withLocations = withLocations;
	}

	/**
	 * Create a filter with only withLocations set to the given value
	 * 
	 * @param withLocations
	 *            True if with locations, false if without
	 * @return A {@link IBreweryFilter} with withLocations set
	 */
	public static IBreweryFilter createWithLocationsFilter(boolean withLocations) {
		BreweryFilter bf = new BreweryFilter();
		bf.setWithLocations(withLocations);
		return bf;
	}

}
