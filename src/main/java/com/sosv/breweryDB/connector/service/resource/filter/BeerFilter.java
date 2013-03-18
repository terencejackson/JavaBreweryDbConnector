package com.sosv.breweryDB.connector.service.resource.filter;

import java.util.Collection;

import com.sosv.breweryDB.connector.entity.Available;
import com.sosv.breweryDB.connector.entity.Glass;
import com.sosv.breweryDB.connector.entity.Style;

/**
 * Implementation of the {@link IBeerFilter} interface with some comfort
 * functions to easily create a simple filter like
 * {@link BeerFilter#createNameFilter(String)} or
 * {@link BeerFilter#createSortFilter(Sorting)}
 * 
 * @author ssommerf
 * 
 */
public class BeerFilter implements IBeerFilter {

	private Collection<String> ids;
	private String name;
	private String abv;
	private String ibu;
	private Glass glassware;
	private String srmId;
	private Available available;
	private Style style;
	private Boolean organic;
	private Integer year;
	private Long since;
	private Sorting sort;
	private Boolean withBreweries;

	@Override
	public Collection<String> getIds() {
		return ids;
	}

	@Override
	public String getName() {
		return name;
	}

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

	@Override
	public Long getSince() {
		return since;
	}

	@Override
	public Sorting getSort() {
		return sort;
	}

	@Override
	public Boolean withBreweries() {
		return withBreweries;
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

	public Boolean getOrganic() {
		return organic;
	}

	public void setOrganic(Boolean organic) {
		this.organic = organic;
	}

	public Boolean getWithBreweries() {
		return withBreweries;
	}

	public void setWithBreweries(Boolean withBreweries) {
		this.withBreweries = withBreweries;
	}

	public void setIds(Collection<String> ids) {
		this.ids = ids;
	}

	public void setName(String name) {
		this.name = name;
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

	public void setSince(Long since) {
		this.since = since;
	}

	public void setSort(Sorting sort) {
		this.sort = sort;
	}

	/**
	 * Create a beer filter for a name
	 * 
	 * @param name
	 *            The name to filter
	 * @return A new {@link BeerFilter}
	 */
	public static BeerFilter createNameFilter(String name) {
		BeerFilter bf = new BeerFilter();
		bf.setName(name);
		return bf;
	}

	/**
	 * Create a beer filter for the sorting
	 * 
	 * @param sorting
	 * @return A new {@link BeerFilter}
	 */
	public static BeerFilter createSortFilter(Sorting sorting) {
		BeerFilter bf = new BeerFilter();
		bf.setSort(sorting);
		return bf;
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
