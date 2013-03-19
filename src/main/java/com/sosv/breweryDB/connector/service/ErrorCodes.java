package com.sosv.breweryDB.connector.service;


public enum ErrorCodes {

	OBJECT_NOT_FOUND(404, "The object you requested was not found."),
	API_KEY_NOT_FOUND(401, "API key could not be found");	
	
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
	
	public static ErrorCodes parseErrorCodes(int errorCode){
		for (ErrorCodes ec : values()) {
			if(ec.getErrorCode() == errorCode){
				return ec;
			}
		}
		throw new UnsupportedOperationException("Error code " + errorCode + " not found");
	}
}
