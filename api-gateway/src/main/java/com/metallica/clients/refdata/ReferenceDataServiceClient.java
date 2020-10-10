package com.metallica.clients.refdata;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("reference-data-service")
public interface ReferenceDataServiceClient {
	
	@GetMapping(path="/commodity")
	public List<Commodity> getAllCommodity();
	
	@GetMapping(path="/location")
	public List<Location> getAllLocation();
	
	@GetMapping(path="/counterparty")
	public List<Counterparty> getAllCounterparty();
	
}
