package com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.services;

import java.util.UUID;
import com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.models.CustomerDto;


public interface CustomerService {

	public CustomerDto getCustomerById(UUID id);
}
