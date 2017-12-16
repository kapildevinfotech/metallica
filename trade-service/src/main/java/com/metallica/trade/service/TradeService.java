package com.metallica.trade.service;

import java.util.List;

import com.metallica.trade.domain.Trade;

public interface TradeService {
	Trade getTradesById(long id);
	List<Trade> getAllTrades();
	void createTrade(Trade trade);
}
