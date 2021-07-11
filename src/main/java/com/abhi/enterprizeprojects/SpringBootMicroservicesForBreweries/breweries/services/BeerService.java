package com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.services;

import java.util.UUID;

import com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.models.BeerDto;

public interface BeerService {
	
	BeerDto getBeerById(UUID beerId);

	BeerDto saveNewBeer(BeerDto beerDto);

}
