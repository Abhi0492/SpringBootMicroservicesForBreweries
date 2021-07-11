package com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.controllers;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	
	@PostMapping
	public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
		
		CustomerDto saveCustomer = customerService.saveNewCustomer(customerDto);
		
		System.out.println(customerDto.getCustomerName());
		System.out.println(customerDto.getId());
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Location", "/customerServiceApi/v1/customer/"+saveCustomer.getId().toString());
		
		return new ResponseEntity<CustomerDto>(httpHeaders, HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/{customerId}")
	public ResponseEntity<CustomerDto> updateCustomer(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDto customerDto) {
		
		customerService.updateExistingCustomer(customerId, customerDto);
		
		System.out.println(customerDto.getCustomerName());
		System.out.println(customerDto.getId());
		
		return new ResponseEntity<CustomerDto>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCustomer(@PathVariable("/{customerId}") UUID customerId) {
		
		customerService.deleteCustomerById(customerId);
		
	}

}
