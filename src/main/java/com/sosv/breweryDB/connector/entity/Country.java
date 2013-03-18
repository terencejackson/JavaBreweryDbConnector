
package com.sosv.breweryDB.connector.entity;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country{
   	private String createDate;
   	private String displayName;
   	private String isoCode;
   	private String isoThree;
   	private String name;
   	private Number numberCode;
   	private String urlTitle;

 	public String getCreateDate(){
		return this.createDate;
	}
	public void setCreateDate(String createDate){
		this.createDate = createDate;
	}
 	public String getDisplayName(){
		return this.displayName;
	}
	public void setDisplayName(String displayName){
		this.displayName = displayName;
	}
 	public String getIsoCode(){
		return this.isoCode;
	}
	public void setIsoCode(String isoCode){
		this.isoCode = isoCode;
	}
 	public String getIsoThree(){
		return this.isoThree;
	}
	public void setIsoThree(String isoThree){
		this.isoThree = isoThree;
	}
 	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
 	public Number getNumberCode(){
		return this.numberCode;
	}
	public void setNumberCode(Number numberCode){
		this.numberCode = numberCode;
	}
 	public String getUrlTitle(){
		return this.urlTitle;
	}
	public void setUrlTitle(String urlTitle){
		this.urlTitle = urlTitle;
	}
}
