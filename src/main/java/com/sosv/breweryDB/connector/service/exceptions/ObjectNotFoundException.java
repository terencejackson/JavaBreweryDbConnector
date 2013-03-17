package com.sosv.breweryDB.connector.service.exceptions;

import com.sosv.breweryDB.connector.service.ErrorCodes;

/**
 * The object was not found by the request
 * @author ssommerf
 *
 */
public class ObjectNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5731585328610625864L;
	
	private int errorCode = ErrorCodes.OBJECT_NOT_FOUND.getErrorCode();

	public int getErrorCode() {
		return errorCode;
	}
}
