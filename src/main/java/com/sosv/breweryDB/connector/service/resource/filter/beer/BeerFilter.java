package com.sosv.breweryDB.connector.service.resource.filter.beer;

public class BeerFilter implements IBeerFilter {

	private Boolean withBreweries;

	@Override
	public Boolean withBreweries() {
		return withBreweries;
	}
	
	public void setWithBreweries(Boolean withBreweries) {
		this.withBreweries = withBreweries;
	}

	/**
	 * Create a with breweries filter
	 * @param withBreweries
	 * @return
	 */
	public static IBeerFilter createWithBreweriesFilter(boolean withBreweries) {
		BeerFilter bf = new BeerFilter();
		bf.setWithBreweries(withBreweries);
		return bf;
	}

}
