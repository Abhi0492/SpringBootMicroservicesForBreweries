package com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.models.CustomerDto;
import com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.services.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService{

	@Override
	public CustomerDto getCustomerById(UUID id) {
		
		return CustomerDto.builder().id(UUID.randomUUID())
								.customerName("Abhishek Seshadri Iyer")
								.build();
	}

	@Override
	public CustomerDto saveNewCustomer(CustomerDto customerDto) {
		// TODO Auto-generated method stub
		return CustomerDto.builder()
						.id(UUID.randomUUID())
						.build();
	}

	@Override
	public void updateExistingCustomer(UUID customerId, CustomerDto customerDto) {
		// TODO : Adding impl to update an existing customer
		
	}

	@Override
	public void deleteCustomerById(UUID customerId) {
		log.debug("Deleting an existing customer...");
		
	}
	
}
