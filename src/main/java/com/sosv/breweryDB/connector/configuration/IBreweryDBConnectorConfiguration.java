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
package com.sosv.breweryDB.connector.configuration;

/**
 * Interface which provides the breweryDB base configuration
 * @author Sven
 *
 */
public interface IBreweryDBConnectorConfiguration {

	/**
	 * Getter for the API Key
	 * You'll find your API Key in "My Apps" at breweryDB
	 * @return The API Key
	 */
	String getApiKey();
}
