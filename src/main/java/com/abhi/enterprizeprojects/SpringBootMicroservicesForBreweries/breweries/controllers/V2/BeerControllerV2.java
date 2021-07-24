package com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.controllers.V2;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.models.V2.BeerDtoV2;
import com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.services.V2.BeerServiceV2;

import lombok.RequiredArgsConstructor;
import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/beerServiceApi/v2/beer")
@RestController
public class BeerControllerV2 {
	
	private final BeerServiceV2 beerServicev2;

	
	//-----------Using Lombok's @RequireeArgsConstructor annotation which takes final declared variables as parameters to constructor-------------//
	/*
	 * public BeerControllerV2(BeerServiceV2 beerServicev2) { super();
	 * this.beerServicev2 = beerServicev2; }
	 */



	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDtoV2> getBeer(@PathVariable UUID beerId) {
		
		//--------Using Lombok's @Slf4j annotation for logging---------//
		log.debug("in getBeer method...");
		
		return new ResponseEntity<BeerDtoV2>(beerServicev2.getBeerById(beerId), HttpStatus.OK);
		
	}
	
	@PostMapping //POST - creates New Beer
	public ResponseEntity<BeerDtoV2> handlePost(@Valid @RequestBody BeerDtoV2 beerDtov2) {
		
		//--------Using Lombok's @Slf4j annotation for logging---------//
		log.debug("in handlePost method...");
		
		//BeerDtoV2 saveDto = beerServicev2.saveNewBeer(beerDtov2);
		
		//-----Using Lombok's val class--------//
		val saveDto = beerServicev2.saveNewBeer(beerDtov2);
		
		System.out.println(beerDtov2.getBeerName());
		System.out.println(beerDtov2.getBeerStyle());
		System.out.println(beerDtov2.getId());
		System.out.println(beerDtov2.getUpc());
		
		//HttpHeaders httpHeaders = new HttpHeaders();
		
		//-----Using Lombok's val class--------//
		val httpHeaders = new HttpHeaders();
		
		//TODO: Add Hostname to URL
		httpHeaders.add("Location", "/beerServiceApi/v1/beer"+saveDto.getId().toString());
		
		return new ResponseEntity<BeerDtoV2>(httpHeaders, HttpStatus.CREATED);
		
	}
	
	
	@PutMapping("/{beerId}")
	public ResponseEntity<BeerDtoV2> handleUpdate(@PathVariable UUID beerId, @Valid @RequestBody BeerDtoV2 beerDtov2) {
		
		//--------Using Lombok's @Slf4j annotation for logging---------//
		log.debug("in handleUpdate method...");
		
		beerServicev2.updateBeer(beerId, beerDtov2);
		
		System.out.println(beerDtov2.getBeerName());
		System.out.println(beerDtov2.getBeerStyle());
		System.out.println(beerDtov2.getId());
		System.out.println(beerDtov2.getUpc());
		
		return new ResponseEntity<BeerDtoV2>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{beerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable("beerId") UUID beerId) {
		
		//--------Using Lombok's @Slf4j annotation for logging---------//
		log.debug("in deleteBeer method...");
		
		beerServicev2.deleteByBeerId(beerId);
		
	}
	
}