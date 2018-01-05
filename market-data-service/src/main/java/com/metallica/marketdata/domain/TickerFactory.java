package com.metallica.marketdata.domain;

@FunctionalInterface
public interface TickerFactory<T,U,V,R>{
	R apply(T commodity,U price,V changeInPrice);
}
