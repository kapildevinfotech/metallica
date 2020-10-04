package com.metallica.trade.search;

import com.metallica.trade.domain.Trade;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class TardeSpecificationsBuilder {
    
    private final List<SearchCriteria> params;
 
    public TardeSpecificationsBuilder() {
        params = new ArrayList<SearchCriteria>();
    }
 
    public TardeSpecificationsBuilder with(String key, String operation, Object value) {
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }
 
    public Specification<Trade> build() {
        if (params.size() == 0) {
            return null;
        }
 
        List<Specification<Trade>> specs = new ArrayList<Specification<Trade>>();
        for (SearchCriteria param : params) {
            specs.add(new TradeSpecification(param));
        }
 
        Specification<Trade> result = specs.get(0);
        for (int i = 1; i < specs.size(); i++) {
            result = Specification.where(result).and(specs.get(i));
        }
        return result;
    }
}