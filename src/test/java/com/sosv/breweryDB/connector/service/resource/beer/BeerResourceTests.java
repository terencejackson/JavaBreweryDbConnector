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

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

import com.sosv.breweryDB.connector.configuration.IBreweryDBConnectorConfiguration;
import com.sosv.breweryDB.connector.entity.beer.Page;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

public class BeerResourceTests {

	@Test
	public void testGetPage1() throws IOException {
		Properties prop = new Properties();
		InputStream stream = getClass().getResourceAsStream("/configuration.properties");
		prop.load(stream);
		IBreweryDBConnectorConfiguration configuration = mock(IBreweryDBConnectorConfiguration.class);
		when(configuration.getApiKey()).thenReturn((String) prop.get("apiKey"));
		IBeerResource br = new BeerResource(configuration);
		Page result = br.getBeers(null);
		assertEquals(1, result.getCurrentPage());
		assertNotNull(result.getData());
	}

}
