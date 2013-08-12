
package com.sosv.breweryDB.connector.entity.beer;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.sosv.breweryDB.connector.entity.Available;
import com.sosv.breweryDB.connector.entity.Glass;
import com.sosv.breweryDB.connector.entity.Style;
import com.sosv.breweryDB.connector.entity.brewery.Brewery;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Beer{
	
	@XmlElement
   	private String abv;
	
	@XmlElement
   	private Available available;
	
	@XmlElement
   	private Number availableId;
	
	@XmlElement
   	private String createDate;
	
	@XmlElement
   	private String description;
	
	@XmlElement
   	private Glass glass;
	
	@XmlElement
   	private Number glasswareId;
	
	@XmlElement
   	private String id;
	
	@XmlElement
   	private String isOrganic;
	
	@XmlElement
   	private String name;
	
	@XmlElement
   	private String status;
	
	@XmlElement
   	private String statusDisplay;
	
	@XmlElement
   	private Style style;
	
	@XmlElement
   	private Number styleId;
	
	@XmlElement
   	private String updateDate;
	
	@XmlElement
	private List<Brewery> breweries;

 	public List<Brewery> getBreweries() {
		return breweries;
	}
 	
	public void setBreweries(List<Brewery> breweries) {
		this.breweries = breweries;
	}
	
	public String getAbv(){
		return this.abv;
	}
	public void setAbv(String abv){
		this.abv = abv;
	}
 	public Available getAvailable(){
		return this.available;
	}
	public void setAvailable(Available available){
		this.available = available;
	}
 	public Number getAvailableId(){
		return this.availableId;
	}
	public void setAvailableId(Number availableId){
		this.availableId = availableId;
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
 	public Glass getGlass(){
		return this.glass;
	}
	public void setGlass(Glass glass){
		this.glass = glass;
	}
 	public Number getGlasswareId(){
		return this.glasswareId;
	}
	public void setGlasswareId(Number glasswareId){
		this.glasswareId = glasswareId;
	}
 	public String getId(){
		return this.id;
	}
	public void setId(String id){
		this.id = id;
	}
 	public String getIsOrganic(){
		return this.isOrganic;
	}
	public void setIsOrganic(String isOrganic){
		this.isOrganic = isOrganic;
	}
 	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
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
 	public Style getStyle(){
		return this.style;
	}
	public void setStyle(Style style){
		this.style = style;
	}
 	public Number getStyleId(){
		return this.styleId;
	}
	public void setStyleId(Number styleId){
		this.styleId = styleId;
	}
 	public String getUpdateDate(){
		return this.updateDate;
	}
	public void setUpdateDate(String updateDate){
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "Beer [abv=" + abv + ", available=" + available
				+ ", availableId=" + availableId + ", createDate=" + createDate
				+ ", description=" + description + ", glass=" + glass
				+ ", glasswareId=" + glasswareId + ", id=" + id
				+ ", isOrganic=" + isOrganic + ", name=" + name + ", status="
				+ status + ", statusDisplay=" + statusDisplay + ", style="
				+ style + ", styleId=" + styleId + ", updateDate=" + updateDate
				+ ", breweries=" + breweries + "]";
	}
}
