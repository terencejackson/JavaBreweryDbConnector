package com.sosv.breweryDB.connector.service.search;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.sosv.breweryDB.connector.configuration.BreweryDBConnectorConstants;
import com.sosv.breweryDB.connector.entity.beer.Beer;
import com.sosv.breweryDB.connector.entity.search.BeerSearchResultPage;
import com.sosv.breweryDB.connector.service.exceptions.ApiKeyNotFoundExeption;
import com.sosv.breweryDB.connector.service.resource.filter.search.ISearchFilter;
import com.sosv.breweryDB.connector.service.resource.search.ISearchResource;

/**
 * Implementation of the {@link ISearchService} interface
 * 
 * @author ssommerf
 * 
 */
public class SearchService implements ISearchService {

	private static final Logger logger = Logger.getLogger(SearchService.class);

	private ISearchResource searchResource;

	@Inject
	public SearchService(ISearchResource searchResource) {
		this.searchResource = searchResource;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sosv.breweryDB.connector.service.search.ISearchService#searchBeers
	 * (java.lang.String,
	 * com.sosv.breweryDB.connector.service.resource.filter.search
	 * .ISearchFilter)
	 */
	@Override
	public List<Beer> searchBeers(String query, ISearchFilter filter)
			throws ApiKeyNotFoundExeption {
		Preconditions.checkArgument(query != null, "query must not be null!");

		BeerSearchResultPage page = searchResource.searchBeers(query, null,
				filter);
		List<Beer> result = new ArrayList<Beer>();
		result.addAll(handlePage(query, page, filter));
		return result;
	}

	private List<? extends Beer> handlePage(String query,
			BeerSearchResultPage page, ISearchFilter filter)
			throws ApiKeyNotFoundExeption {
		List<Beer> beers = page.getData();
		if (beers == null || beers.isEmpty()) {
			beers = new ArrayList<Beer>();
		}

		int currentPage = page.getCurrentPage().intValue();
		int numberOfPages = page.getNumberOfPages().intValue();

		logger.debug("Current page is " + currentPage
				+ ". Number of pages is: " + numberOfPages);

		if (currentPage < numberOfPages) {
			beers.addAll(handlePage(query, this.searchResource.searchBeers(
					query, currentPage + 1, filter), filter));
		}

		return beers;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sosv.breweryDB.connector.service.search.ISearchService#searchBeers
	 * (java.lang.String)
	 */
	@Override
	public List<Beer> searchBeers(String query) throws ApiKeyNotFoundExeption {
		return searchBeers(query, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sosv.breweryDB.connector.service.search.ISearchService#searchBeersByUpc
	 * (java.lang.String)
	 */
	@Override
	public List<Beer> searchBeersByUpc(String upc)
			throws ApiKeyNotFoundExeption {
		return searchBeersByUpc(upc, null);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.sosv.breweryDB.connector.service.search.ISearchService#searchBeersByUpc(java.lang.String, com.sosv.breweryDB.connector.service.resource.filter.search.ISearchFilter)
	 */
	@Override
	public List<Beer> searchBeersByUpc(String upc, ISearchFilter filter)
			throws ApiKeyNotFoundExeption {
		logger.debug("Search for a upc: " + upc);
		Pattern p = Pattern.compile(BreweryDBConnectorConstants.UPC_REGEX);
		if (!p.matcher(upc).matches()) {
			logger.debug("UPC is not valid");
			throw new IllegalArgumentException(
					"UPC is not valid. It must be well formed: " + BreweryDBConnectorConstants.UPC_REGEX);
		}
		logger.debug("UPC is valid");
		return this.searchResource.searchByUPC(upc, filter);
	}
}
