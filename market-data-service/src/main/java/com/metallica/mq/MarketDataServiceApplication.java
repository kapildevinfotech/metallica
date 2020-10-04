package com.metallica.mq;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.metallica.marketdata.domain.Commodity;
import com.metallica.marketdata.domain.Ticker;
import com.metallica.marketdata.domain.TickerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class MarketDataServiceApplication {
	private static final Logger logger = LoggerFactory.getLogger(MarketDataServiceApplication.class);
	
	@Autowired
	private Producer messageProducer;
	
	public static void main(String[] args) {
		SpringApplication.run(MarketDataServiceApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			//Get Set of commodity available in ref data service via API Gateway
			String commodityJson= restTemplate.getForObject(
					"http://localhost:9023/reference-data-service/commodity",String.class);
			List<Commodity> commodityList= new ObjectMapper().readValue(commodityJson, new TypeReference<List<Commodity>>(){});
			logger.info("List of commodity fetched form ref data service : "+commodityList);
			
			//fetch last open, close price from mongoDb
			TickerFactory<Commodity, Double, Double, Ticker> tickerFactory= Ticker::new;
			List<Ticker> tickerList=commodityList.stream().map(commodity -> tickerFactory.apply(commodity, 100.00, 1.00)).collect(Collectors.toList());
			logger.info("Ticker List : " + tickerList);
			
			//Mock Feed of Change in Price
			final Runnable mockPriceChange = () -> {
				for (Ticker ticker : tickerList) {
					ticker.mockPrice();
					try {
						messageProducer.sendMesage(NotificationType.TICKER_UPDATED,
										new ObjectMapper().writeValueAsString(ticker));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
	
			ScheduledExecutorService scheduledExecutorService= Executors.newScheduledThreadPool(1);
			scheduledExecutorService.scheduleWithFixedDelay(mockPriceChange, 0,10,TimeUnit.SECONDS);
			//scheduledExecutorService.shutdown();
		};
	}
}
