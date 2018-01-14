package com.metallica.trade;

import java.util.Date;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.metallica.refdata.domain.Commodity;
import com.metallica.refdata.domain.Counterparty;
import com.metallica.refdata.domain.Location;
import com.metallica.trade.domain.Side;
import com.metallica.trade.domain.Trade;
import com.metallica.trade.domain.TradeStatus;
import com.metallica.trade.repository.TradeRepository;

@ComponentScan({"com.metallica.trade","com.metallica.mq"})
@EntityScan("com.metallica")
@SpringBootApplication
@EnableEurekaClient
public class TradeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradeServiceApplication.class, args);
	}
	
	@Bean
	public InitializingBean seedDatabase(TradeRepository repository) {
		return () -> {
			repository.save(new Trade(Side.BUY,34,98,new Date(),TradeStatus.OPEN,
					new Commodity("Al","Aluminium"),new Location("NY","NewYork"),new Counterparty("Ipsum","Ipsum")));
			repository.save(new Trade(Side.BUY,15,360,new Date(),TradeStatus.NOMINATED,
					new Commodity("CU","Copper"),new Location("LN","London"),new Counterparty("Lorem","Lorem")));
			repository.save(new Trade(Side.BUY,89,189,new Date(),TradeStatus.OPEN,
					new Commodity("Al","Aluminium"),new Location("NY","NewYork"),new Counterparty("Ipsum","Ipsum")));
			repository.save(new Trade(Side.BUY,47,187,new Date(),TradeStatus.OPEN,
					new Commodity("ZN","Zinc"),new Location("NY","NewYork"),new Counterparty("Ipsum","Ipsum")));
			repository.save(new Trade(Side.BUY,23,90,new Date(),TradeStatus.NOMINATED,
					new Commodity("Al","Aluminium"),new Location("LN","London"),new Counterparty("Lorem","Lorem")));
			repository.save(new Trade(Side.BUY,57,180,new Date(),TradeStatus.OPEN,
					new Commodity("ZN","Zinc"),new Location("DN","Denver"),new Counterparty("Ipsum","Ipsum")));
			repository.save(new Trade(Side.BUY,98,150,new Date(),TradeStatus.NOMINATED,
					new Commodity("Al","Aluminium"),new Location("NY","NewYork"),new Counterparty("Lorem","Lorem")));
			
		};
	}

}
