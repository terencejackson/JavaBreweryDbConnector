package com.sosv.breweryDB.connector.service;

public enum Status {

	SUCCESS("success"),
	FAILURE("failure");
	
	private String status;

	public String asString(){
		return status;
	}
	
	private Status(String status){
		this.status = status;
	}
}
