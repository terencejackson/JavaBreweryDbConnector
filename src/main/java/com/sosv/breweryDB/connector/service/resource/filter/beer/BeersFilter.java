package com.sosv.breweryDB.connector.service.resource.filter.beer;


import com.sosv.breweryDB.connector.entity.Available;
import com.sosv.breweryDB.connector.entity.Glass;
import com.sosv.breweryDB.connector.entity.Style;
import com.sosv.breweryDB.connector.service.resource.filter.AbstractBaseFilter;
import com.sosv.breweryDB.connector.service.resource.filter.Sorting;

/**
 * Implementation of the {@link IBeersFilter} interface with some comfort
 * functions to easily create a simple filter like
 * {@link BeersFilter#createNameFilter(String)} or
 * {@link BeersFilter#createSortFilter(Sorting)}
 * 
 * @author ssommerf
 * 
 */
public class BeersFilter extends AbstractBaseFilter implements IBeersFilter {

	private String abv;
	private String ibu;
	private Glass glassware;
	private String srmId;
	private Available available;
	private Style style;
	private Integer year;
	private Boolean withBreweries;
	@Override
	public String getABV() {
		return abv;
	}

	@Override
	public String getIBU() {
		return ibu;
	}

	@Override
	public Glass getGlassware() {
		return glassware;
	}

	@Override
	public String getSRMID() {
		return srmId;
	}

	@Override
	public Available getAvailable() {
		return available;
	}

	@Override
	public Style getStyle() {
		return style;
	}

	@Override
	public Boolean isOrganic() {
		return organic;
	}

	@Override
	public Integer getYear() {
		return year;
	}

	public String getAbv() {
		return abv;
	}

	public void setAbv(String abv) {
		this.abv = abv;
	}

	public String getIbu() {
		return ibu;
	}

	public void setIbu(String ibu) {
		this.ibu = ibu;
	}

	public String getSrmId() {
		return srmId;
	}

	public void setSrmId(String srmId) {
		this.srmId = srmId;
	}

	public void setGlassware(Glass glassware) {
		this.glassware = glassware;
	}

	public void setAvailable(Available available) {
		this.available = available;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	/**
	 * Create a beer filter for a name
	 * 
	 * @param name
	 *            The name to filter
	 * @return A new {@link BeersFilter}
	 */
	public static IBeersFilter createNameFilter(String name) {
		BeersFilter bf = new BeersFilter();
		bf.setName(name);
		return bf;
	}

	/**
	 * Create a beer filter for the sorting
	 * 
	 * @param sorting
	 * @return A new {@link BeersFilter}
	 */
	public static IBeersFilter createSortFilter(Sorting sorting) {
		BeersFilter bf = new BeersFilter();
		bf.setSort(sorting);
		return bf;
	}

	/**
	 * Create a with breweries filter
	 * 
	 * @param withBreweries
	 * @return
	 */
	public static IBeersFilter createWithBreweriesFilter(boolean withBreweries) {
		BeersFilter bf = new BeersFilter();
		bf.setWithBreweries(withBreweries);
		return bf;
	}

	public void setWithBreweries(boolean withBreweries) {
		this.withBreweries = withBreweries;
	}

	@Override
	public Boolean withBreweries() {
		return withBreweries;
	}

}
