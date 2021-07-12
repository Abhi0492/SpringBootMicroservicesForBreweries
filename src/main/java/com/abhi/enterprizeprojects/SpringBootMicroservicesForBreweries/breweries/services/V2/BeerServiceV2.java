package com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.services.V2;

import java.util.UUID;

import com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.models.V2.BeerDtoV2;

public interface BeerServiceV2 {

	BeerDtoV2 getBeerById(UUID beerId);

	BeerDtoV2 saveNewBeer(BeerDtoV2 beerDtov2);

	void updateBeer(UUID beerId, BeerDtoV2 beerDtov2);

	void deleteByBeerId(UUID beerId);

	
}
