package com.sosv.breweryDB.connector.service.resource.filter.beer;


import com.sosv.breweryDB.connector.entity.Available;
import com.sosv.breweryDB.connector.entity.Glass;
import com.sosv.breweryDB.connector.entity.Style;
import com.sosv.breweryDB.connector.service.resource.filter.IBaseFilter;

/**
 * Filter criterias for a beer request
 * 
 * @author ssommerf
 * 
 */
public interface IBeersFilter extends IBaseFilter, IBeerFilter {

	/**
	 * ABV for a beer. Premium users may use advanced filtering. "+10" will
	 * return everything above 10%, "-10" will return everything under 10%,
	 * "8,10" will return everything between 8% and 10%.
	 * 
	 * @return
	 */
	String getABV();

	/**
	 * IBUs for a beer. Premium users may use advanced filtering. "+50" will
	 * return everything above 50 IBUs, "-50" will return everything less than
	 * 50 IBUs, "30,50" will return everything between 30 and 50 IBUs.
	 * 
	 * @return
	 */
	String getIBU();

	/**
	 * The glassware
	 * 
	 * @return
	 */
	Glass getGlassware();

	/**
	 * ID for SRM
	 * 
	 * @return
	 */
	String getSRMID();

	/**
	 * The availability to filter
	 * 
	 * @return
	 */
	Available getAvailable();

	/**
	 * The style to filter
	 * 
	 * @return
	 */
	Style getStyle();

	/**
	 * Defines the filter if the beer should be organic
	 * 
	 * @return
	 */
	Boolean isOrganic();

	/**
	 * The year to filter
	 * 
	 * @return
	 */
	Integer getYear();

	/**
	 * Returns everything that has been updated since that date. Max 30 days. In
	 * UNIX timestamp format.
	 * 
	 * @return
	 */
	Long getSince();
}
