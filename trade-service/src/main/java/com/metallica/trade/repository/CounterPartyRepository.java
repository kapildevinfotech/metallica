package com.metallica.trade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metallica.refdata.domain.Counterparty;

public interface CounterPartyRepository extends JpaRepository<Counterparty, Long>{
	Counterparty findByCode(String code);
}
