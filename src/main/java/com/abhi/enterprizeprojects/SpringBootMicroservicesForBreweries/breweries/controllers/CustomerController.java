package com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.controllers;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.models.CustomerDto;
import com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.services.CustomerService;

@RequestMapping("/customerServiceApi/v1/customer")
@RestController
public class CustomerController {
	
	
	private final CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	
	@GetMapping("/{customerId}")
	public ResponseEntity<CustomerDto> getCustomerById(@PathVariable UUID customerId) {
		
		return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
	}

}
