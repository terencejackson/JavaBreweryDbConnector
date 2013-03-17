package com.sosv.breweryDB.connector.service.exceptions;

import com.sosv.breweryDB.connector.service.ErrorCodes;

/**
 * Exception if an api key is not found. If this exception occurs, provide the correct api key!
 * @author ssommerf
 *
 */
public class ApiKeyNotFoundExeption extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6742037618385272951L;
	
	private int errorCode = ErrorCodes.API_KEY_NOT_FOUND.getErrorCode();

	public int getErrorCode() {
		return errorCode;
	}
	
}
