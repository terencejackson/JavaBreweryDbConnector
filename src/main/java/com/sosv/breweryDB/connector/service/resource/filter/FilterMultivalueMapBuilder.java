package com.sosv.breweryDB.connector.service.resource.filter;

import javax.ws.rs.core.MultivaluedMap;

import com.google.common.base.Joiner;
import com.sosv.breweryDB.connector.service.resource.filter.beer.IBeerFilter;
import com.sosv.breweryDB.connector.service.resource.filter.brewery.IBreweryFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;

/**
 * Class provides the functionality to convert a filter to a
 * {@link MultivaluedMap}
 * 
 * @author ssommerf
 * 
 */
public class FilterMultivalueMapBuilder {

	/**
	 * Converts an {@link IBeerFilter} to a {@link MultivaluedMap}. Null values
	 * are ignored
	 * 
	 * @param filter
	 *            The filter to convert => if null an empty map is returned
	 * @return The {@link MultivaluedMap} to use for a service request
	 */
	public MultivaluedMap<String, String> convert(IBeerFilter filter) {
		MultivaluedMap<String, String> map = new MultivaluedMapImpl();
		if (filter == null) {
			return map;
		}

		if (filter.getABV() != null) {
			map.add("abv", filter.getABV());
		}
		if (filter.getAvailable() != null) {
			map.add("availableId", filter.getAvailable().getId());
		}
		if (filter.getGlassware() != null) {
			map.add("glasswareId", filter.getGlassware().getId().toString());
		}
		if (filter.getIBU() != null) {
			map.add("ibu", filter.getIBU());
		}
		if (filter.getIds() != null && !filter.getIds().isEmpty()) {
			if (filter.getIds().size() > 10) {
				throw new UnsupportedOperationException(
						"Maximum of 10 ids allowed");
			}
			map.add("ids", Joiner.on(",").join(filter.getIds()));
		}
		if (filter.getName() != null) {
			map.add("name", filter.getName());
		}
		if (filter.getSince() != null) {
			map.add("since", filter.getSince().toString());
		}
		if (filter.getSort() != null) {
			map.add("sort", filter.getSort().getName());
		}
		if (filter.getSRMID() != null) {
			map.add("srmId", filter.getSRMID());
		}
		if (filter.getStyle() != null) {
			map.add("styleId", filter.getStyle().getId().toString());
		}
		if (filter.getYear() != null) {
			map.add("year", filter.getYear().toString());
		}
		if (filter.withBreweries() != null) {
			map.add("withBreweries", filter.withBreweries() ? "Y" : "N");
		}
		if (filter.isOrganic() != null) {
			map.add("isOrganic", filter.isOrganic() ? "Y" : "N");
		}
		return map;
	}

	public MultivaluedMap<String, String> convert(IBreweryFilter filter) {
		MultivaluedMap<String, String> map = new MultivaluedMapImpl();
		if (filter == null) {
			return map;
		}
		
		if (filter.withLocations() != null) {
			map.add("withLocations", filter.withLocations() ? "Y" : "N");
		}
		return map;
	}
}
