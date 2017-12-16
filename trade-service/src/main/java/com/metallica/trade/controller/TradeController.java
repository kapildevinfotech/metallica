package com.metallica.trade.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.metallica.trade.domain.Side;
import com.metallica.trade.domain.Trade;
import com.metallica.trade.domain.TradeStatus;
import com.metallica.trade.service.TradeService;

@RestController
public class TradeController {
	@Autowired
	private TradeService tradeService;
	
	@RestResource
	@RequestMapping(path="/dummyTrade",method=RequestMethod.GET)
	public Trade getDummyTrade(){
		return new Trade(Side.BUY, 100, 25, LocalDate.now() , TradeStatus.OPEN);
	}
	
	@RequestMapping(path="/{id}",method=RequestMethod.GET)
	public Trade getTradeById(@PathVariable long id){
		return tradeService.getTradesById(id);
		
	}
	
}
