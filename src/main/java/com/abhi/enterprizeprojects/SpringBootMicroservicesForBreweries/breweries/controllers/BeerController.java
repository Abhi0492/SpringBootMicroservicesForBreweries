package com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.controllers;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.models.BeerDto;
import com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.services.BeerService;

@RequestMapping("/beerServiceApi/v1/beer")
@RestController
public class BeerController {
	
	
	private final BeerService beerService;

	public BeerController(BeerService beerService) {
		super();
		this.beerService = beerService;
	}



	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDto> getBeer(@PathVariable UUID beerId) {
		
		return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
		
	}
	
	@PostMapping //POST - creates New Beer
	public ResponseEntity<BeerDto> handlePost(BeerDto beerDto) {
		
		
		BeerDto saveDto = beerService.saveNewBeer(beerDto);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		//TODO: Add Hostname to URL
		httpHeaders.add("Location", "/beerServiceApi/v1/beer"+saveDto.getId().toString());
		
		return new ResponseEntity<BeerDto>(httpHeaders, HttpStatus.CREATED);
		
	}
	
}
