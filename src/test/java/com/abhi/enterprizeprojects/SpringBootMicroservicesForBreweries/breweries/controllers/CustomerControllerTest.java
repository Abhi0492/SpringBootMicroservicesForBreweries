package com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.controllers;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.BDDMockito.*;
import static org.hamcrest.Matchers.is;

import com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.models.CustomerDto;
import com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.services.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {
	
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
	MockMvc mockmvc;
	
	CustomerDto validCustomer;
	
	
	@BeforeEach
	public void setUp() {
		validCustomer = CustomerDto.builder().id(UUID.randomUUID())
										.customerName("Abhishek S. Iyer")
										.build();
										
	}
	
	
	@Test
	public void getCustomerById() throws Exception {
		
		given(customerService.getCustomerById(any(UUID.class))).willReturn(validCustomer);
		
		mockmvc.perform(MockMvcRequestBuilders.get("/customerServiceApi/v1/customer/" + validCustomer.getId().toString())
											.accept(MediaType.APPLICATION_JSON))
										.andExpect(MockMvcResultMatchers.status().isOk())
										.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
										.andExpect(MockMvcResultMatchers.jsonPath("$.id", is(validCustomer.getId().toString())))
										.andExpect(MockMvcResultMatchers.jsonPath("$.customerName", is("Abhishek S. Iyer")));
										
	}
	
	@Test
	public void createCustomer() {
		
	}
	
	@Test
	public void updateCustomer() {
		
	}
	
	@Test
	public void deleteCustomer() {
		
	}
	

}
