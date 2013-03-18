/*
Copyright 2013 Sven Sommerfeld (svensommerfeld1982@gmail.com)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package com.sosv.breweryDB.connector.service.resource.beer;

import java.util.List;

import com.sosv.breweryDB.connector.entity.beer.Beer;
import com.sosv.breweryDB.connector.entity.beer.Page;
import com.sosv.breweryDB.connector.service.exceptions.ApiKeyNotFoundExeption;
import com.sosv.breweryDB.connector.service.resource.filter.IBeerFilter;

/**
 * Interface for the beer resource
 * @author Sven
 *
 */
public interface IBeerResource {

	/**
	 * Get beers for a page
	 * @param currentPage The current page => If null no page is requested
	 * @return The response as {@link Page}
	 */
	Page getBeers(Number currentPage);
	
	/**
	 * Get a beer by its id
	 * @param id
	 * @return The found {@link Beer}
	 * @throws ApiKeyNotFoundExeption If the provided api key was not found by brewery db
	 */
	Beer getBeerById(String id) throws ApiKeyNotFoundExeption;
	
	/**
	 * Get beers with a custom filter
	 * @param filter The filter to apply
	 * @return The result list of beers or null
	 * @throws ApiKeyNotFoundExeption If the provided api key was not found by brewery db
	 */
	List<Beer> getBeersByFilter(IBeerFilter filter) throws ApiKeyNotFoundExeption;
}
