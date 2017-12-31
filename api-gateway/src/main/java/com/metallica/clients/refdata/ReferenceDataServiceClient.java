package com.metallica.clients.refdata;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("reference-data-service")
public interface ReferenceDataServiceClient {
	
	@GetMapping(path="/commodity")
	public Commodity getAllCommodity();
	
	@GetMapping(path="/location")
	public Location getAllLocation();
	
	@GetMapping(path="/counterparty")
	public Counterparty getAllCounterparty();
	
}
