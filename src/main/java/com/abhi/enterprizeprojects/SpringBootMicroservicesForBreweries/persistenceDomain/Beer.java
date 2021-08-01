package com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.persistenceDomain;

import java.util.UUID;

import com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.models.V2.BeerStyleEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Beer {
	
	private UUID id;
	private String beerName;
	private BeerStyleEnum beerStyle;
	private Long upc;

}