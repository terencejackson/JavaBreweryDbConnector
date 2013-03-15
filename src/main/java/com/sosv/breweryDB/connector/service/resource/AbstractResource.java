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
package com.sosv.breweryDB.connector.service.resource;

import javax.ws.rs.core.MultivaluedMap;

import com.google.inject.Inject;
import com.sosv.breweryDB.connector.configuration.IBreweryDBConnectorConfiguration;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.core.util.MultivaluedMapImpl;
/**
 * Base class for all resources
 * 
 * @author Sven
 * 
 */
public abstract class AbstractResource {

	private String apiKey;
	private WebResource webResource;

	/**
	 * Getter for the api key
	 * @return
	 */
	protected String getApiKey() {
		return apiKey;
	}

	/**
	 * Getter for the {@link WebResource}
	 * @return
	 */
	protected WebResource getWebResource() {
		return webResource;
	}

	@Inject
	public AbstractResource(IBreweryDBConnectorConfiguration configuration, String endpoint) {
		super();
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);

		webResource = client
				.resource("http://api.brewerydb.com/v2/" + endpoint);
		this.apiKey = configuration.getApiKey();
	}
	
	/**
	 * Do a get operation to the resource with the given T as result
	 * @param type
	 * @return
	 */
	public <T> T get(T type){
		MultivaluedMap<String, String> map = new MultivaluedMapImpl();
		map.add("key", apiKey);
		
		/**
		 * Possible risk if T is not the response object. If not it is thrown a not deserializable exception
		 */
		@SuppressWarnings("unchecked")
		T result = (T) webResource.queryParams(map).get(type.getClass());
		return result;
	}
	
	/**
	 * Do a get operation with query params to the resource with the given T as result
	 * @param map
	 * @param type
	 * @return
	 */
	public <T> T get(MultivaluedMap<String, String> map, T type){
		map.add("key", apiKey);
		
		/**
		 * Possible risk if T is not the response object. If not it is thrown a not deserializable exception
		 */
		@SuppressWarnings("unchecked")
		T result = (T) webResource.queryParams(map).get(type.getClass());
		return result;
	}

}
