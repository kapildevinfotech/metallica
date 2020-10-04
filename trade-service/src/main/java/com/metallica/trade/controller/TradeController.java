package com.metallica.trade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.metallica.trade.domain.Trade;
import com.metallica.trade.service.TradeService;

@RestController
public class TradeController {
	@Autowired
	private TradeService tradeService;
	
	@GetMapping(path="/")
	public List<Trade> getAllTrades(){
		return tradeService.getAllTrades();
	}
	
	@GetMapping(path="/trade/{id}")
	public Trade getTradeById(@PathVariable long id){
		return tradeService.getTradesById(id);
	}
	
	@PutMapping(path="/trade/")
	public Trade getTradeById(@RequestBody Trade trade) throws Exception{
		return tradeService.updateTrade(trade);
	}
	
	@DeleteMapping(path="/trade/{id}")
	public List<Trade> deleteTradeById(@PathVariable long id) throws Exception{
		return tradeService.deleteTradeById(id);
	}
	
	@PostMapping(path="/trade")
	public Trade createTrade(@RequestBody Trade trade) throws Exception{
		return tradeService.createTrade(trade);
	}
	
	@PutMapping(path="/trade")
	public Trade editTrade(@RequestBody Trade trade) throws Exception{
		return tradeService.updateTrade(trade);
	}
	
	@GetMapping(path="/search")
    public @ResponseBody List<Trade> search(@RequestParam(value = "search") String search) {
       return tradeService.serachTrade(search);
    }
}
