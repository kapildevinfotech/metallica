package com.metallica.trade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metallica.trade.domain.Trade;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long>{

}
