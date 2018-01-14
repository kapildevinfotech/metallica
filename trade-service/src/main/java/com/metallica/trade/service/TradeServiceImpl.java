package com.metallica.trade.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metallica.trade.domain.Side;
import com.metallica.trade.domain.Trade;
import com.metallica.trade.repository.CommodityRepository;
import com.metallica.trade.repository.CounterPartyRepository;
import com.metallica.trade.repository.LocationRepository;
import com.metallica.trade.repository.TradeRepository;
import com.metallica.trade.search.TardeSpecificationsBuilder;

@Service
@Transactional
public class TradeServiceImpl implements TradeService {

	@Autowired
	private TradeRepository tradeRepository;
	
	@Autowired
	private CommodityRepository commodityRepository;
	
	@Autowired
	private LocationRepository locationRepository;
	
	@Autowired
	private CounterPartyRepository counterPartyRepository;
	
	@Override
	public Trade getTradesById(long id) {
		return tradeRepository.getOne(id);
	}

	@Override
	public List<Trade> getAllTrades() {
		return tradeRepository.findAll();
	}

	@Override
	public Trade createTrade(Trade trade) {
		trade.setCommodity(commodityRepository.findByCode(trade.getCommodity().getCode()));
		trade.setCounterparty(counterPartyRepository.findByCode(trade.getCounterparty().getCode()));
		trade.setLocation(locationRepository.findByCode(trade.getLocation().getCode()));
		return tradeRepository.save(trade);
	}

	@Override
	public List<Trade> deleteTradeById(long id) {
		return tradeRepository.removeById(id);
	}

	@Override
	public List<Trade> serachTrade(String search) {
		TardeSpecificationsBuilder builder = new TardeSpecificationsBuilder();
		Pattern pattern = Pattern.compile("(\\w+?)([:<>])(\\w+?|\\d{4}-\\d{2}-\\d{2}),");
		Matcher matcher = pattern.matcher(search + ",");
		while (matcher.find()) {
			if(matcher.group(1).contains("trade")){
				builder.with("tradeDate", matcher.group(2), matcher.group(3));
			}else if(matcher.group(1).contains("commodity")){
				builder.with(matcher.group(1), matcher.group(2), commodityRepository.findByCode(matcher.group(3)));
			}
			else if(matcher.group(1).contains("counterparty")){
				builder.with(matcher.group(1), matcher.group(2), counterPartyRepository.findByCode(matcher.group(3)));
			}
			else if(matcher.group(1).contains("location")){
				builder.with(matcher.group(1), matcher.group(2), locationRepository.findByCode(matcher.group(3)));
			}
			else if(matcher.group(1).contains("side")){
				builder.with(matcher.group(1), matcher.group(2), Side.valueOf(matcher.group(3)));
			}else{
				builder.with(matcher.group(1), matcher.group(2),matcher.group(3));
			}
		}

		Specification<Trade> spec = builder.build();
		return tradeRepository.findAll(spec);
	}
}