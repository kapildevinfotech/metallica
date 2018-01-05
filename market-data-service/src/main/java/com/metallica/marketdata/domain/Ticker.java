package com.metallica.marketdata.domain;

import java.util.function.Function;

import com.sun.jersey.core.header.AcceptableLanguageTag;

public class Ticker {
	private Commodity commodity;
	private double price;
	private double changeInPrice;
	
	public Ticker(Commodity commodity,double  price,double changeinPrice) {
		this.commodity=commodity;
		this.price=price;
		this.changeInPrice=changeinPrice;
	}
	
	public void createTicker(Commodity commodity,double  price,double changeinPrice){
		this.commodity=commodity;
		this.price=price;
		this.changeInPrice=changeinPrice;
	}
	
	public Commodity getCommodity() {
		return commodity;
	}
	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getChangeInPrice() {
		return changeInPrice;
	}
	public void setChangeInPrice(double changeInPrice) {
		this.changeInPrice = changeInPrice;
	}
	
	@Override
	public String toString() {
		return "[Ticker :: commodity : "+commodity +" | price :"+price +" | changeInPrice :" +changeInPrice +"]";
	}
}