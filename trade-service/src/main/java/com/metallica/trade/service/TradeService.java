package com.metallica.trade.service;

import java.util.List;

import com.metallica.trade.domain.Trade;

public interface TradeService {
	Trade getTradesById(long id);
	List<Trade> getAllTrades();
	Trade createTrade(Trade trade) throws Exception;
	List<Trade> deleteTradeById(long id) throws Exception;
	List<Trade> serachTrade(String search);
	Trade updateTrade(Trade trade) throws Exception;
}
