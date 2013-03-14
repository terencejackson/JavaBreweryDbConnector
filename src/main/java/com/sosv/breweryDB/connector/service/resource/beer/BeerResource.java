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

import com.google.inject.Inject;
import com.sosv.breweryDB.connector.configuration.IBreweryDBConnectorConfiguration;
import com.sosv.breweryDB.connector.entity.beer.Page;
import com.sosv.breweryDB.connector.service.resource.AbstractResource;

/**
 * Implementation for the beer resource services
 * @author Sven
 *
 */
public class BeerResource extends AbstractResource implements IBeerResource {

	@Inject
	public BeerResource(IBreweryDBConnectorConfiguration configuration) {
		super(configuration, "beers/");
	}

	/*
	 * (non-Javadoc)
	 * @see com.sosv.breweryDB.connector.service.resource.beer.IBeerResource#getBeers(java.lang.Integer)
	 */
	public Page getBeers(Integer currentPage) {
		return get(new Page());
	}

}
