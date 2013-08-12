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
package com.sosv.breweryDB.connector.service.async;

import java.util.List;
import java.util.concurrent.Callable;

import com.sosv.breweryDB.connector.entity.beer.Beer;
import com.sosv.breweryDB.connector.entity.beer.BeerResultPage;
import com.sosv.breweryDB.connector.service.resource.filter.beer.IBeerFilter;
import com.sosv.breweryDB.connector.service.resource.filter.beer.IBeersFilter;

/**
 * Interface for the factory to create the callables
 * @author Sven
 *
 */
public interface ICallableFactory {

	Callable<List<Beer>> getAllBeersCallable();

	Callable<BeerResultPage> getPagesBeersCallable(Number pageNumber);

	Callable<List<Beer>> getAllBeersCallable(IBeersFilter beerFilter);

	Callable<BeerResultPage> getPagesBeersCallable(Number pageNumber, IBeersFilter beerFilter);

	Callable<Beer> getBeerByIdCallable(String id, IBeerFilter filter);

	Callable<Beer> getBeerByIdCallable(String id);
}
