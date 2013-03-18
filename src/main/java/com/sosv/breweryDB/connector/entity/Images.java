
package com.sosv.breweryDB.connector.entity;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Images{
   	private String icon;
   	private String large;
   	private String medium;

 	public String getIcon(){
		return this.icon;
	}
	public void setIcon(String icon){
		this.icon = icon;
	}
 	public String getLarge(){
		return this.large;
	}
	public void setLarge(String large){
		this.large = large;
	}
 	public String getMedium(){
		return this.medium;
	}
	public void setMedium(String medium){
		this.medium = medium;
	}
}
