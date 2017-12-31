package com.metallica.trade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping(path="/trade/{id}")
	public Trade getTradeById(@PathVariable long id){
		return tradeService.getTradesById(id);
	}
	
	@PostMapping(path="/trade")
	void createTrade(@RequestBody Trade trade) throws Exception{
		System.out.println("Trade creating  :" +trade);
		tradeService.createTrade(trade);
		messageProducer.sendMesage(NotificationType.TRADE_CREATED, trade.toJson());
	}
}
