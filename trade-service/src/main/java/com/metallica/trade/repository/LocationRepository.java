package com.metallica.trade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metallica.refdata.domain.Location;

public interface LocationRepository extends JpaRepository<Location, Long>{
	Location findByCode(String code);
}
