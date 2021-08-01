package com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.persistenceDomain;

import java.util.UUID;

import com.abhi.enterprizeprojects.SpringBootMicroservicesForBreweries.breweries.models.CustomerDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

	private UUID id;
	private String customerName;
	
}
