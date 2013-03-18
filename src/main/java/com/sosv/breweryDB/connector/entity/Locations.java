
package com.sosv.breweryDB.connector.entity;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Locations{
   	private Country country;
   	private String countryIsoCode;
   	private String createDate;
   	private String id;
   	private String inPlanning;
   	private String isClosed;
   	private String isPrimary;
   	private Number latitude;
   	private String locality;
   	private String locationType;
   	private String locationTypeDisplay;
   	private Number longitude;
   	private String name;
   	private String openToPublic;
   	private String postalCode;
   	private String region;
   	private String status;
   	private String statusDisplay;
   	private String updateDate;
   	private String website;
   	private String yearOpened;

 	public Country getCountry(){
		return this.country;
	}
	public void setCountry(Country country){
		this.country = country;
	}
 	public String getCountryIsoCode(){
		return this.countryIsoCode;
	}
	public void setCountryIsoCode(String countryIsoCode){
		this.countryIsoCode = countryIsoCode;
	}
 	public String getCreateDate(){
		return this.createDate;
	}
	public void setCreateDate(String createDate){
		this.createDate = createDate;
	}
 	public String getId(){
		return this.id;
	}
	public void setId(String id){
		this.id = id;
	}
 	public String getInPlanning(){
		return this.inPlanning;
	}
	public void setInPlanning(String inPlanning){
		this.inPlanning = inPlanning;
	}
 	public String getIsClosed(){
		return this.isClosed;
	}
	public void setIsClosed(String isClosed){
		this.isClosed = isClosed;
	}
 	public String getIsPrimary(){
		return this.isPrimary;
	}
	public void setIsPrimary(String isPrimary){
		this.isPrimary = isPrimary;
	}
 	public Number getLatitude(){
		return this.latitude;
	}
	public void setLatitude(Number latitude){
		this.latitude = latitude;
	}
 	public String getLocality(){
		return this.locality;
	}
	public void setLocality(String locality){
		this.locality = locality;
	}
 	public String getLocationType(){
		return this.locationType;
	}
	public void setLocationType(String locationType){
		this.locationType = locationType;
	}
 	public String getLocationTypeDisplay(){
		return this.locationTypeDisplay;
	}
	public void setLocationTypeDisplay(String locationTypeDisplay){
		this.locationTypeDisplay = locationTypeDisplay;
	}
 	public Number getLongitude(){
		return this.longitude;
	}
	public void setLongitude(Number longitude){
		this.longitude = longitude;
	}
 	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
 	public String getOpenToPublic(){
		return this.openToPublic;
	}
	public void setOpenToPublic(String openToPublic){
		this.openToPublic = openToPublic;
	}
 	public String getPostalCode(){
		return this.postalCode;
	}
	public void setPostalCode(String postalCode){
		this.postalCode = postalCode;
	}
 	public String getRegion(){
		return this.region;
	}
	public void setRegion(String region){
		this.region = region;
	}
 	public String getStatus(){
		return this.status;
	}
	public void setStatus(String status){
		this.status = status;
	}
 	public String getStatusDisplay(){
		return this.statusDisplay;
	}
	public void setStatusDisplay(String statusDisplay){
		this.statusDisplay = statusDisplay;
	}
 	public String getUpdateDate(){
		return this.updateDate;
	}
	public void setUpdateDate(String updateDate){
		this.updateDate = updateDate;
	}
 	public String getWebsite(){
		return this.website;
	}
	public void setWebsite(String website){
		this.website = website;
	}
 	public String getYearOpened(){
		return this.yearOpened;
	}
	public void setYearOpened(String yearOpened){
		this.yearOpened = yearOpened;
	}
}
