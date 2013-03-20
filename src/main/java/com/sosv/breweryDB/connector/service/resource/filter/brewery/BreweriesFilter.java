package com.sosv.breweryDB.connector.service.resource.filter.brewery;

import com.sosv.breweryDB.connector.service.resource.filter.AbstractBaseFilter;

/**
 * Implementation of the {@link IBreweriesFilter} to provide a filter for breweries requests
 * @author ssommerf
 *
 */
public class BreweriesFilter extends AbstractBaseFilter implements IBreweriesFilter {

	private Boolean withLocations;
	private Integer established;

	@Override
	public Boolean withLocations() {
		return withLocations;
	}
	
	public void setWithLocations(boolean withLocations) {
		this.withLocations = withLocations;
	}
	
	@Override
	public Integer getEstablished() {
		return established;
	}

	public void setEstablished(Integer established) {
		this.established = established;
	}
	
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

}
