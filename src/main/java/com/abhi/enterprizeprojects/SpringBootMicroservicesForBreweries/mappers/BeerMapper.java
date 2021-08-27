package com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.mappers;

import org.mapstruct.Mapper;

import com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.models.BeerDto;
import com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.persistenceDomain.Beer;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
	
	BeerDto beerToBeerDto(Beer beer);
	
	Beer beerDtoToBeer(BeerDto beer);

}
