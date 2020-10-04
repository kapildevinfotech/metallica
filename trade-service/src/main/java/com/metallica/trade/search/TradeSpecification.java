package com.metallica.trade.search;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.metallica.trade.domain.Trade;

public class TradeSpecification implements Specification<Trade> {
	 
    private SearchCriteria criteria;
 
    public TradeSpecification(SearchCriteria param) {
    	this.criteria=param;
    }

	@Override
    public Predicate toPredicate
      (Root<Trade> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        if (criteria.getOperation().equalsIgnoreCase(">")) {
            try {
				return builder.greaterThanOrEqualTo(
				  root.<Date> get(criteria.getKey()),sdf.parse(criteria.getValue().toString()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
        } 
        else if (criteria.getOperation().equalsIgnoreCase("<")) {
            try {
				return builder.lessThanOrEqualTo(
						 root.<Date> get(criteria.getKey()),sdf.parse(criteria.getValue().toString()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
        } 
        else if (criteria.getOperation().equalsIgnoreCase(":")) {
                return builder.equal(root.get(criteria.getKey()), criteria.getValue());
        }
        return null;
    }
}