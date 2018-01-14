package com.metallica.mq;

import java.sql.Time;
import java.util.List;
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

@SpringBootApplication
public class MarketDataServiceApplication {
	
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
			System.out.println("List of commodity fetched form ref data service : "+commodityList);
			
			//fetch last open, close price from mongoDb
			TickerFactory<Commodity, Double, Double, Ticker> tickerFactory= Ticker::new;
			List<Ticker> tickerList=commodityList.stream().map(commodity -> tickerFactory.apply(commodity, 100.00, 1.00)).collect(Collectors.toList());
			System.out.println("Ticker List : " + tickerList);
			
			//push to Rabbit MQ Dummy Data at initialization / Now initialization id done at React App only
			//messageProducer.sendMesage(NotificationType.TICKER, new ObjectMapper().writeValueAsString(tickerList));
			
			//Mock Feed of Change in Price
			Runnable mockPriceChange = () -> {
				for (;;) {
					try {
						for (Ticker ticker : tickerList) {
							ticker.mockPrice();
							messageProducer.sendMesage(NotificationType.TICKER_UPDATED,
											new ObjectMapper().writeValueAsString(ticker));
							TimeUnit.SECONDS.sleep(5);
						}
						TimeUnit.SECONDS.sleep(15);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			new Thread(mockPriceChange).start();
			
		};
	}
}
