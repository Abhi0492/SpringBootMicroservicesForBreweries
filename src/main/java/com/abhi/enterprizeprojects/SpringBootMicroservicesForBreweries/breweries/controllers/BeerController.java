package com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.controllers;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.models.BeerDto;
import com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.services.BeerService;

@Deprecated
@ComponentScan({"com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.services"})
@Validated
@RequestMapping("/beerServiceApi/v1/beer")
@RestController
public class BeerController {
	
	
	private final BeerService beerService;
	
	

	public BeerController(BeerService beerService) {
		super();
		this.beerService = beerService;
	}



	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDto> getBeer(@PathVariable @NotNull UUID beerId) {
		
		return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
		
	}
	
	@PostMapping //POST - creates New Beer
	public ResponseEntity<BeerDto> handlePost(@Valid @NotNull @RequestBody BeerDto beerDto) {
		
		
		BeerDto saveDto = beerService.saveNewBeer(beerDto);
		
		System.out.println(beerDto.getBeerName());
		System.out.println(beerDto.getBeerStyle());
		System.out.println(beerDto.getId());
		System.out.println(beerDto.getUpc());
		
		HttpHeaders httpHeaders = new HttpHeaders();
		//TODO: Add Hostname to URL
		httpHeaders.add("Location", "/beerServiceApi/v1/beer"+saveDto.getId().toString());
		
		return new ResponseEntity<BeerDto>(httpHeaders, HttpStatus.CREATED);
		
	}
	
	
	@PutMapping("/{beerId}")
	public ResponseEntity<BeerDto> handleUpdate(@PathVariable UUID beerId, @Valid @RequestBody BeerDto beerDto) {
		
		beerService.updateBeer(beerId, beerDto);
		
		System.out.println(beerDto.getBeerName());
		System.out.println(beerDto.getBeerStyle());
		System.out.println(beerDto.getId());
		System.out.println(beerDto.getUpc());
		
		return new ResponseEntity<BeerDto>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{beerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable("beerId") UUID beerId) {
		
		beerService.deleteByBeerId(beerId);
		
	}
	
}