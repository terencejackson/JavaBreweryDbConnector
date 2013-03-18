
package com.sosv.breweryDB.connector.entity;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Style{
   	private String abvMax;
   	private String abvMin;
   	private Category category;
   	private Number categoryId;
   	private String createDate;
   	private String description;
   	private String fgMax;
   	private String fgMin;
   	private String ibuMax;
   	private String ibuMin;
   	private Number id;
   	private String name;
   	private String ogMin;
   	private String srmMax;
   	private String srmMin;

 	public String getAbvMax(){
		return this.abvMax;
	}
	public void setAbvMax(String abvMax){
		this.abvMax = abvMax;
	}
 	public String getAbvMin(){
		return this.abvMin;
	}
	public void setAbvMin(String abvMin){
		this.abvMin = abvMin;
	}
 	public Category getCategory(){
		return this.category;
	}
	public void setCategory(Category category){
		this.category = category;
	}
 	public Number getCategoryId(){
		return this.categoryId;
	}
	public void setCategoryId(Number categoryId){
		this.categoryId = categoryId;
	}
 	public String getCreateDate(){
		return this.createDate;
	}
	public void setCreateDate(String createDate){
		this.createDate = createDate;
	}
 	public String getDescription(){
		return this.description;
	}
	public void setDescription(String description){
		this.description = description;
	}
 	public String getFgMax(){
		return this.fgMax;
	}
	public void setFgMax(String fgMax){
		this.fgMax = fgMax;
	}
 	public String getFgMin(){
		return this.fgMin;
	}
	public void setFgMin(String fgMin){
		this.fgMin = fgMin;
	}
 	public String getIbuMax(){
		return this.ibuMax;
	}
	public void setIbuMax(String ibuMax){
		this.ibuMax = ibuMax;
	}
 	public String getIbuMin(){
		return this.ibuMin;
	}
	public void setIbuMin(String ibuMin){
		this.ibuMin = ibuMin;
	}
 	public Number getId(){
		return this.id;
	}
	public void setId(Number id){
		this.id = id;
	}
 	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
 	public String getOgMin(){
		return this.ogMin;
	}
	public void setOgMin(String ogMin){
		this.ogMin = ogMin;
	}
 	public String getSrmMax(){
		return this.srmMax;
	}
	public void setSrmMax(String srmMax){
		this.srmMax = srmMax;
	}
 	public String getSrmMin(){
		return this.srmMin;
	}
	public void setSrmMin(String srmMin){
		this.srmMin = srmMin;
	}
}
