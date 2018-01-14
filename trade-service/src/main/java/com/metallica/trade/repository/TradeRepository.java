package com.metallica.trade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.metallica.trade.domain.Trade;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long>,JpaSpecificationExecutor<Trade> {
	 List<Trade> removeById(long id);
}
