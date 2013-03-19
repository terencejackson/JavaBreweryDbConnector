package com.sosv.breweryDB.connector.service.brewery;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;
import com.sosv.breweryDB.connector.entity.Brewery;
import com.sosv.breweryDB.connector.entity.BreweryResultPage;
import com.sosv.breweryDB.connector.service.exceptions.ApiKeyNotFoundExeption;
import com.sosv.breweryDB.connector.service.resource.brewery.IBreweryResource;
import com.sosv.breweryDB.connector.service.resource.filter.brewery.IBreweryFilter;

public class BreweryService implements IBreweryService {

	private IBreweryResource breweryResource;

	@Inject
	public BreweryService(IBreweryResource breweryResource) {
		this.breweryResource = breweryResource;
	}

	@Override
	public List<Brewery> getAll() throws ApiKeyNotFoundExeption {
		return getAll(null);
	}

	@Override
	public List<Brewery> getAll(IBreweryFilter breweryFilter)
			throws ApiKeyNotFoundExeption {
		// A set would be faster but we take a list here because of sorting
		// functionality in future releases
		List<Brewery> breweries = new ArrayList<Brewery>();
		BreweryResultPage firstPage = this.breweryResource.getBreweries(null,
				breweryFilter);

		breweries.addAll(handlePage(firstPage, breweryFilter));

		return breweries;
	}

	private List<? extends Brewery> handlePage(BreweryResultPage page,
			IBreweryFilter filter) throws ApiKeyNotFoundExeption {
		List<Brewery> beers = page.getData();
		if (beers == null || beers.isEmpty()) {
			beers = new ArrayList<Brewery>();
		}
		Number currentPage = page.getCurrentPage();
		if (currentPage != page.getNumberOfPages()) {
			beers.addAll(handlePage(this.breweryResource.getBreweries(
					currentPage.intValue() + 1, filter), filter));
		}

		return beers;
	}
}
