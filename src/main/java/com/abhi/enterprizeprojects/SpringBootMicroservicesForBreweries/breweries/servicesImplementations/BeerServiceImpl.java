package com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.servicesImplementations;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.models.BeerDto;
import com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.services.BeerService;

@Service
public class BeerServiceImpl implements BeerService{

	@Override
	public BeerDto getBeerById(UUID beerId) {
		
		return BeerDto.builder().id(UUID.randomUUID())
								.beerName("Budweiser")
								.beerStyle("Magnum")
								.build();
		
	}

	
	
}
