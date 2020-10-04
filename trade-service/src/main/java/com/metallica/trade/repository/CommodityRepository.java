package com.metallica.trade.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metallica.refdata.domain.Commodity;

@Repository
public interface CommodityRepository extends JpaRepository<Commodity, Long> {
	Commodity findByCode(String code);
}
