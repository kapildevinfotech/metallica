package com.metallica.trade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.metallica.mq.NotificationType;
import com.metallica.mq.Producer;
import com.metallica.trade.domain.Trade;
import com.metallica.trade.service.TradeService;

@RestController
public class TradeController {
	@Autowired
	private TradeService tradeService;
	
	@Autowired
	private Producer messageProducer;
	
	@GetMapping(path="/")
	public List<Trade> getAllTrades(){
		return tradeService.getAllTrades();
	}
	
	@GetMapping(path="/trade/{id}")
	public Trade getTradeById(@PathVariable long id){
		return tradeService.getTradesById(id);
	}
	
	@DeleteMapping(path="/trade/{id}")
	public List<Trade> deleteTradeById(@PathVariable long id){
		return tradeService.deleteTradeById(id);
	}
	
	@PostMapping(path="/trade")
	public Trade createTrade(@RequestBody Trade trade) throws Exception{
		messageProducer.sendMesage(NotificationType.TRADE_CREATED,trade.toJson());
		return tradeService.createTrade(trade);
	}
	
	@GetMapping(path="/search")
    public @ResponseBody List<Trade> search(@RequestParam(value = "search") String search) {
       return tradeService.serachTrade(search);
    }
}
