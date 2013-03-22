package com.sosv.breweryDB.connector;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.sosv.breweryDB.connector.service.resource.beer.BeerResourceTests;
import com.sosv.breweryDB.connector.service.resource.brewery.BreweryResourceTests;
import com.sosv.breweryDB.connector.service.resource.filter.FilterMultivalueMapBuilderTests;
import com.sosv.breweryDB.connector.service.resource.search.SearchTests;

@RunWith(Suite.class)
@SuiteClasses({ FilterMultivalueMapBuilderTests.class,
		BeerResourceTests.class, BreweryResourceTests.class, SearchTests.class })
public class AllTest {

}
