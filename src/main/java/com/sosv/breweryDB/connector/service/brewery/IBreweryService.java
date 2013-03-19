package com.sosv.breweryDB.connector.service.brewery;

import java.util.List;

import com.sosv.breweryDB.connector.entity.Brewery;
import com.sosv.breweryDB.connector.service.exceptions.ApiKeyNotFoundExeption;
import com.sosv.breweryDB.connector.service.resource.filter.brewery.IBreweryFilter;

public interface IBreweryService {

	List<Brewery> getAll() throws ApiKeyNotFoundExeption;

	List<Brewery> getAll(IBreweryFilter breweryFilter)
			throws ApiKeyNotFoundExeption;
}
