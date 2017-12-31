package com.metallica.clients.trade;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("trade-service")
public interface TradeServiceClient {

	@GetMapping(path="/trade/{id}")
	public Trade getTradeById(@PathVariable long id);
	
	@PostMapping(path="/trade")
	public void createTrade(@RequestBody Trade trade);
}
