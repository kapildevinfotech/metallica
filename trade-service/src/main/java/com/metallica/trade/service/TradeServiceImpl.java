package com.metallica.trade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metallica.trade.domain.Trade;
import com.metallica.trade.repository.TradeRepository;

@Service
public class TradeServiceImpl implements TradeService {

	@Autowired
	private TradeRepository tradeRepository;
	
	@Override
	public Trade getTradesById(long id) {
		return tradeRepository.getOne(id);
	}

	@Override
	public List<Trade> getAllTrades() {
		return tradeRepository.findAll();
	}

	@Override
	public void createTrade(Trade trade) {
		tradeRepository.save(trade);
	}

}
