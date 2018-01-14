package com.metallica.trade.service;

import java.util.List;

import com.metallica.trade.domain.Trade;

public interface TradeService {
	Trade getTradesById(long id);
	List<Trade> getAllTrades();
	Trade createTrade(Trade trade);
	List<Trade> deleteTradeById(long id);
	List<Trade> serachTrade(String search);
	
}
