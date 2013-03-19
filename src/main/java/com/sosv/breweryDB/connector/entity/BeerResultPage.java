
package com.sosv.breweryDB.connector.entity;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BeerResultPage implements IErrorResult {
   	private Number currentPage;
   	private List<Beer> data;
   	private Number numberOfPages;
   	private String status;
   	private Number totalResults;
	private String errorMessage;

 	public Number getCurrentPage(){
		return this.currentPage;
	}
	public void setCurrentPage(Number currentPage){
		this.currentPage = currentPage;
	}
 	public List<Beer> getData(){
		return this.data;
	}
	public void setData(List<Beer> data){
		this.data = data;
	}
 	public Number getNumberOfPages(){
		return this.numberOfPages;
	}
	public void setNumberOfPages(Number numberOfPages){
		this.numberOfPages = numberOfPages;
	}
 	public String getStatus(){
		return this.status;
	}
	public void setStatus(String status){
		this.status = status;
	}
 	public Number getTotalResults(){
		return this.totalResults;
	}
	public void setTotalResults(Number totalResults){
		this.totalResults = totalResults;
	}
	
	@Override
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
