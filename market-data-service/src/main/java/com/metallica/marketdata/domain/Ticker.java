package com.metallica.marketdata.domain;

import java.text.DecimalFormat;
import java.util.Random;

public class Ticker {
	transient DecimalFormat df = new DecimalFormat("#.###");
	
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
	
	public void mockPrice(){
		changeInPrice=new Random().nextInt(20)-5;
		price+=changeInPrice;
	}
	
	@Override
	public String toString() {
		return "[Ticker :: commodity : "+commodity +" | price :"+price +" | changeInPrice :" +changeInPrice +"]";
	}
}