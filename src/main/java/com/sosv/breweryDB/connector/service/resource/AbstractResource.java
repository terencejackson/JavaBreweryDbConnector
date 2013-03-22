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

import org.apache.log4j.Logger;

import com.sosv.breweryDB.connector.configuration.IBreweryDBConnectorConfiguration;
import com.sosv.breweryDB.connector.service.ErrorCodes;
import com.sosv.breweryDB.connector.service.exceptions.ApiKeyNotFoundExeption;
import com.sosv.breweryDB.connector.service.exceptions.ObjectNotFoundException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

/**
 * Base class for all resources
 * 
 * @author Sven
 * 
 */
public abstract class AbstractResource {

	private WebResource webResource;
	private IBreweryDBConnectorConfiguration configuration;
	
	private static Logger logger = Logger.getLogger(AbstractResource.class);

	/**
	 * Getter for the {@link WebResource}
	 * 
	 * @return
	 */
	protected WebResource getWebResource() {
		return webResource;
	}

	public AbstractResource(IBreweryDBConnectorConfiguration configuration,
			Client client) {
		super();

		webResource = client.resource("http://api.brewerydb.com/v2/");
		this.configuration = configuration;
	}

	/**
	 * Do a get operation to the resource with the given T as result
	 * 
	 * @param type
	 * @return
	 * @throws ApiKeyNotFoundExeption
	 * @throws ObjectNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public <T> T get(String path, T type) throws ApiKeyNotFoundExeption,
			ObjectNotFoundException {
		logger.debug("Calling get for path " + path + " and type " + type.toString());
		MultivaluedMap<String, String> map = new MultivaluedMapImpl();
		map.add("key", configuration.getApiKey());

		/**
		 * Possible risk if T is not the response object. If not it is thrown a
		 * not deserializable exception
		 */
		T result = null;
		try {
			result = (T) webResource.path(path).queryParams(map)
					.get(type.getClass());
		} catch (UniformInterfaceException e) {
			handleException(e);
		}
		return result;
	}

	private void handleException(UniformInterfaceException e)
			throws ApiKeyNotFoundExeption, ObjectNotFoundException {
		int statusCode = e.getResponse().getStatus();
		if (ErrorCodes.parseErrorCodes(statusCode) == ErrorCodes.API_KEY_NOT_FOUND) {
			throw new ApiKeyNotFoundExeption();
		}
		if (ErrorCodes.parseErrorCodes(statusCode) == ErrorCodes.OBJECT_NOT_FOUND) {
			throw new ObjectNotFoundException();
		}
	}

	@SuppressWarnings("unchecked")
	public <T> T get(T type) throws ApiKeyNotFoundExeption,
			ObjectNotFoundException {
		MultivaluedMap<String, String> map = new MultivaluedMapImpl();
		map.add("key", configuration.getApiKey());
		
		/**
		 * Possible risk if T is not the response object. If not it is thrown a
		 * not deserializable exception
		 */
		T result = null;
		try {
			result = (T) webResource.queryParams(map).get(type.getClass());
		} catch (UniformInterfaceException e) {
			handleException(e);
		}
		return result;
	}

	/**
	 * Do a get operation with query params to the resource with the given T as
	 * result
	 * 
	 * @param map
	 * @param type
	 * @return
	 * @throws ApiKeyNotFoundExeption
	 * @throws ObjectNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public <T> T get(String path, MultivaluedMap<String, String> map, T type)
			throws ApiKeyNotFoundExeption, ObjectNotFoundException {
		logger.debug("Calling get for path " + path + " and type " + type.toString() + " and map values " + map.values());

		map.add("key", configuration.getApiKey());

		/**
		 * Possible risk if T is not the response object. If not it is thrown a
		 * not deserializable exception
		 */
		T result = null;
		try {
			result = (T) webResource.path(path).queryParams(map)
					.get(type.getClass());
		} catch (UniformInterfaceException e) {
			handleException(e);
		}
		return result;
	}

}
