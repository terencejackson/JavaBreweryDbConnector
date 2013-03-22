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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abv == null) ? 0 : abv.hashCode());
		result = prime * result
				+ ((available == null) ? 0 : available.hashCode());
		result = prime * result
				+ ((glassware == null) ? 0 : glassware.hashCode());
		result = prime * result + ((ibu == null) ? 0 : ibu.hashCode());
		result = prime * result + ((srmId == null) ? 0 : srmId.hashCode());
		result = prime * result + ((style == null) ? 0 : style.hashCode());
		result = prime * result
				+ ((withBreweries == null) ? 0 : withBreweries.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BeersFilter other = (BeersFilter) obj;
		if (abv == null) {
			if (other.abv != null)
				return false;
		} else if (!abv.equals(other.abv))
			return false;
		if (available == null) {
			if (other.available != null)
				return false;
		} else if (!available.equals(other.available))
			return false;
		if (glassware == null) {
			if (other.glassware != null)
				return false;
		} else if (!glassware.equals(other.glassware))
			return false;
		if (ibu == null) {
			if (other.ibu != null)
				return false;
		} else if (!ibu.equals(other.ibu))
			return false;
		if (srmId == null) {
			if (other.srmId != null)
				return false;
		} else if (!srmId.equals(other.srmId))
			return false;
		if (style == null) {
			if (other.style != null)
				return false;
		} else if (!style.equals(other.style))
			return false;
		if (withBreweries == null) {
			if (other.withBreweries != null)
				return false;
		} else if (!withBreweries.equals(other.withBreweries))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}

}
