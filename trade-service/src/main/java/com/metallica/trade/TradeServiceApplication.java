package com.metallica.trade;

import java.util.Date;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;

import com.metallica.refdata.domain.Commodity;
import com.metallica.refdata.domain.Counterparty;
import com.metallica.refdata.domain.Location;
import com.metallica.trade.domain.Side;
import com.metallica.trade.domain.Trade;
import com.metallica.trade.domain.TradeStatus;
import com.metallica.trade.repository.CommodityRepository;
import com.metallica.trade.repository.CounterPartyRepository;
import com.metallica.trade.repository.LocationRepository;
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
	@Transactional
	public InitializingBean seedDatabase(TradeRepository repository,CommodityRepository commodityRepo
						,CounterPartyRepository counterPartyRepo,LocationRepository locationRepo) {
		return () -> {
			
			Commodity aluminium=new Commodity("AL","Aluminium");
			commodityRepo.save(aluminium);
			Commodity zinc=new Commodity("ZN","Zinc");
			commodityRepo.save(zinc);
			Commodity copper=new Commodity("CU","Copper");
			commodityRepo.save(copper);

			Location newYork=new Location("NY","NewYork");
			locationRepo.save(newYork);
			Location london=new Location("LN","London");
			locationRepo.save(london);
			Location denver=new Location("DN","Denver");
			locationRepo.save(denver);
			
			Counterparty ipsum=new Counterparty("Ipsum","Ipsum");
			counterPartyRepo.save(ipsum);
			Counterparty lorem=new Counterparty("Lorem","Lorem");
			counterPartyRepo.save(lorem);
			
			Trade trade1=new Trade(Side.SELL,34,98,new Date(),TradeStatus.OPEN,
					commodityRepo.findByCode("AL"),
					locationRepo.findByCode("LN"),
					counterPartyRepo.findByCode("Ipsum")
					);
			
			Trade trade2=new Trade(Side.BUY,144,13,new Date(),TradeStatus.NOMINATED,
					commodityRepo.findByCode("AL"),
					locationRepo.findByCode("NY"),
					counterPartyRepo.findByCode("Ipsum")
					);
			
			Trade trade3=new Trade(Side.BUY,126,15,new Date(),TradeStatus.NOMINATED,
					commodityRepo.findByCode("ZN"),
					locationRepo.findByCode("LN"),
					counterPartyRepo.findByCode("Lorem")
					);
			
			repository.save(trade1);
			repository.save(trade2);
			repository.save(trade3);
		};
	}

}
