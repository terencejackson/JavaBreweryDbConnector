package com.sosv.breweryDB.connector.service;

public enum ErrorCodes {

	OBJECT_NOT_FOUND(100, "The object you requested was not found."),
	API_KEY_NOT_FOUND(200, "API key could not be found");
	
	private String message;
	private int errorCode;
	
	public String getMessage() {
		return message;
	}

	public int getErrorCode() {
		return errorCode;
	}

	private ErrorCodes(int errorCode, String message){
		this.errorCode = errorCode;
		this.message = message;
	}
}
