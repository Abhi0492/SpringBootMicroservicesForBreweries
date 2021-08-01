package com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.mappers;

import org.mapstruct.Mapper;

import com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.models.CustomerDto;
import com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.persistenceDomain.Customer;

@Mapper
public interface CustomerMapper {

	CustomerDto customerToCustomerDto(Customer customer);
	
	Customer customerdtoToCustomer(CustomerDto customerdto);
	
}
