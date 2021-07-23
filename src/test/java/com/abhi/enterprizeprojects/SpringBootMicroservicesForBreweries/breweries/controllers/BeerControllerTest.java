package com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.controllers;

import java.util.UUID;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.mockito.BDDMockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.hamcrest.Matchers.is;

import com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.controllers.V2.BeerControllerV2;
import com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.models.BeerDto;
import com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.services.BeerService;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest(BeerController.class)
public class BeerControllerTest {
	
	
	@Autowired
	BeerService beerService;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
	MockMvc mockmvc;
	
	BeerDto validBeer;
	
	@BeforeEach
	public void setUp() {
		validBeer = BeerDto.builder().id(UUID.randomUUID())
								.beerName("Carlsburg")
								.beerStyle("Pale Ale")
								.upc(123400000123L)
								.build();
	}
	
	@Test
	void getBeer() throws Exception {
		
		given(beerService.getBeerById(any(UUID.class))).willReturn(validBeer);
		
		mockmvc.perform(MockMvcRequestBuilders.get("/beerServiceApi/v1/beer/" + validBeer.getId().toString())
											.accept(MediaType.APPLICATION_JSON))
										.andExpect(MockMvcResultMatchers.status().isOk())
										.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
										.andExpect(MockMvcResultMatchers.jsonPath("$.id", is(validBeer.getId().toString())))
										.andExpect(MockMvcResultMatchers.jsonPath("$.beerName", is("Carlsburg")));
										
										
		
	}
	
	@Test
	public void handlePost() throws Exception {
		
		//given
		BeerDto beerDto = validBeer;
		beerDto.setId(null);
		BeerDto savedDto = BeerDto.builder().id(UUID.randomUUID()).beerName("New Beer").build();
		String beerDtoJson = objectMapper.writeValueAsString(beerDto);
			
		given(beerService.saveNewBeer(any())).willReturn(savedDto);
				
		mockmvc.perform(MockMvcRequestBuilders.post("/beerServiceApi/v1/beer/")
												.contentType(MediaType.APPLICATION_JSON)
												.content(beerDtoJson))
											.andExpect(MockMvcResultMatchers.status().isCreated());
		
	}
	
	@Test
	public void handleUpdate() throws Exception  {
		
		//given
		BeerDto beerDto = validBeer;
		beerDto.setId(null);
		String beerDtoJson = objectMapper.writeValueAsString(beerDto);
				
		//when
		mockmvc.perform(MockMvcRequestBuilders.put("/beerServiceApi/v1/beer/" + beerDto.getId())
												.contentType(MediaType.APPLICATION_JSON)
												.content(beerDtoJson))
											.andExpect(MockMvcResultMatchers.status().isNoContent());
				
		then(beerService).should().updateBeer(any(), any());
		
	}
	
	@Test
	public void deleteBeer() throws Exception {
		
		
	}

}
