
package com.sosv.breweryDB.connector.entity.brewery;


public class BreweryResult{
   	private Brewery data;
   	private String message;
   	private String status;

 	public Brewery getData(){
		return this.data;
	}
	public void setData(Brewery data){
		this.data = data;
	}
 	public String getMessage(){
		return this.message;
	}
	public void setMessage(String message){
		this.message = message;
	}
 	public String getStatus(){
		return this.status;
	}
	public void setStatus(String status){
		this.status = status;
	}
}
