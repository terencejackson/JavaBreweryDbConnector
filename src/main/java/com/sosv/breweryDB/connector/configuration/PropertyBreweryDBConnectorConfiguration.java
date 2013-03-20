package com.sosv.breweryDB.connector.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Implementation of {@link IBreweryDBConnectorConfiguration} to load the api key out of a property file located at classpath.
 * Key which is read is apiKey
 * @author ssommerf
 *
 */
public class PropertyBreweryDBConnectorConfiguration implements
		IBreweryDBConnectorConfiguration {

	private String apiKey;

	public PropertyBreweryDBConnectorConfiguration() throws IOException {
		super();
		Properties prop = new Properties();
		InputStream stream = getClass().getResourceAsStream(
				"/configuration.properties");
		prop.load(stream);
		this.apiKey = (String) prop.get("apiKey");
	}

	@Override
	public String getApiKey() {
		return apiKey;
	}

}
