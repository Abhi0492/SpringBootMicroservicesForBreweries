package com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.servicesImplementations;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.models.CustomerDto;
import com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Override
	public CustomerDto getCustomerById(UUID id) {
		
		return CustomerDto.builder().id(UUID.randomUUID())
								.customerName("Abhishek Seshadri Iyer")
								.build();
	}

	
}
