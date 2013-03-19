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

import com.sosv.breweryDB.connector.entity.Beer;
import com.sosv.breweryDB.connector.entity.BeerResultPage;
import com.sosv.breweryDB.connector.service.exceptions.ApiKeyNotFoundExeption;
import com.sosv.breweryDB.connector.service.resource.filter.beer.IBeerFilter;

/**
 * Interface for the beer resource
 * @author Sven
 *
 */
public interface IBeerResource {

	/**
	 * Get beers for a page
	 * @param currentPage The current page => If null no page is requested
	 * @param filter The filter to apply => if null no filter is applied
	 * @return The response as {@link BeerResultPage}
	 * @throws ApiKeyNotFoundExeption 
	 */
	BeerResultPage getBeers(Number currentPage, IBeerFilter filter) throws ApiKeyNotFoundExeption;
	
	/**
	 * Get a beer by its id
	 * @param id
	 * @return The found {@link Beer}
	 * @throws ApiKeyNotFoundExeption If the provided api key was not found by brewery db
	 */
	Beer getBeerById(String id) throws ApiKeyNotFoundExeption;
	
}
