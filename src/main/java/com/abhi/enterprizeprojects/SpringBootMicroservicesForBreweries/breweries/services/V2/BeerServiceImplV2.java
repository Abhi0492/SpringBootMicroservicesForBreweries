package com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.services.V2;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.models.V2.BeerDtoV2;
import com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.services.V2.BeerServiceV2;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@Service
public class BeerServiceImplV2 implements BeerServiceV2{

	@Override
	public BeerDtoV2 getBeerById(UUID beerId) {
		
		return null;
		
	}

	@Override
	public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto) {
		
		return null;
	}

	@Override
	public void updateBeer(UUID beerId, BeerDtoV2 beerDto) {
		// TODO : Adding impl to update a beer 
		
	}

	@Override
	public void deleteByBeerId(UUID beerId) {
		// TODO Auto-generated method stub
		
	}

	
	
}
