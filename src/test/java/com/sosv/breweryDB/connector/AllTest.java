package com.sosv.breweryDB.connector;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.sosv.breweryDB.connector.service.resource.beer.BeerFilterMultivalueMapBuilderTests;
import com.sosv.breweryDB.connector.service.resource.beer.BeerResourceTests;
import com.sosv.breweryDB.connector.service.resource.brewery.BreweryResourceTests;

@RunWith(Suite.class)
@SuiteClasses({ BeerFilterMultivalueMapBuilderTests.class,
		BeerResourceTests.class, BreweryResourceTests.class })
public class AllTest {

}
