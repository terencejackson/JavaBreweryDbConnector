
package com.sosv.breweryDB.connector.entity.beer;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class BeerResult{
   	private Beer data;
   	private String message;
   	private String status;
   	
	public Beer getData(){
		return this.data;
	}
	public void setData(Beer data){
		this.data = data;
	}
 	/* (non-Javadoc)
	 * @see com.sosv.breweryDB.connector.entity.beer.IMessageStatusResult#getMessage()
	 */
	public String getMessage(){
		return this.message;
	}
	public void setMessage(String message){
		this.message = message;
	}
 	/* (non-Javadoc)
	 * @see com.sosv.breweryDB.connector.entity.beer.IMessageStatusResult#getStatus()
	 */
	public String getStatus(){
		return this.status;
	}
	public void setStatus(String status){
		this.status = status;
	}
}
