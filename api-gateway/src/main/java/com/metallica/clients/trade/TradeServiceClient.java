package com.metallica.clients.trade;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("trade-service")
public interface TradeServiceClient {
	
	@GetMapping(path="/")
	public List<Trade> getAllTrades();
	
	@GetMapping(path="/trade/{id}")
	public Trade getTradeById(@PathVariable long id);
	
	@PostMapping(path="/trade")
	public Trade createTrade(@RequestBody Trade trade);
	
	@PutMapping(path="/trade")
	public Trade updateTrade(@RequestBody Trade trade);
	
	@GetMapping(path="/search")
	public List<Trade> search(@RequestParam(value = "search") String search); 
}
