package com.sosv.breweryDB.connector.service.resource.filter;

/**
 * Defines the possible sortig directons
 * @author ssommerf
 *
 */
public enum Sorting {

	/**
	 * Ascending
	 */
	ASC("ASC"),
	/**
	 * Descending
	 */
	DESC("DESC");
	
	private String name;

	public String getName() {
		return name;
	}

	private Sorting(String name){
		this.name = name;
	}
}
