package com.sosv.breweryDB.connector.service.provider;

import com.google.inject.Provider;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

/**
 * Provider for the jersey {@link Client}
 * @author ssommerf
 *
 */
public class JerseyClientProvider implements Provider<Client> {

	/**
	 * Creates a {@link DefaultClientConfig} and set POJO_MAPPING 
	 */
	public Client get() {
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
				Boolean.TRUE);
		return Client.create(clientConfig);
	}

}
