package com.sosv.breweryDB.connector;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.sosv.breweryDB.connector.service.resource.beer.BeerFilterMultivalueMapBuilderTests;
import com.sosv.breweryDB.connector.service.resource.beer.BeerResourceTests;

@RunWith(Suite.class)
@SuiteClasses({ BeerFilterMultivalueMapBuilderTests.class,
		BeerResourceTests.class })
public class AllTest {

}
