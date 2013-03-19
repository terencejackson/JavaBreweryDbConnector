package com.sosv.breweryDB.connector.service.resource.filter.brewery;

import java.util.Collection;

import com.sosv.breweryDB.connector.service.resource.filter.Sorting;

public class BreweriesFilter extends BreweryFilter implements IBreweriesFilter {
	
	/**
	 * Create a filter with only withLocations set to the given value
	 * @param withLocations True if with locations, false if without
	 * @return A {@link IBreweriesFilter} with withLocations set
	 */
	public static IBreweriesFilter createWithLocationsFilter(boolean withLocations){
		BreweriesFilter bf = new BreweriesFilter();
		bf.setWithLocations(withLocations);
		return bf;
	}

	private Sorting sort;
	private String name;
	private Collection<String> ids;

	@Override
	public Collection<String> getIds() {
		return ids;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Sorting getSort() {
		return sort;
	}
}
