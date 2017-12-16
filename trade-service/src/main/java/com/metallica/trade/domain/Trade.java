package com.metallica.trade.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Trade {
	@Id @GeneratedValue
	private long id;
	
	private Side side;
	private int quantity;
	private  double price;
	private LocalDate tradeDate;
	private TradeStatus status;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Trade() {
	}
	
	public Trade(Side side,int quantity,double price,LocalDate tradeDate,TradeStatus status) {
		this.side=side;
		this.quantity=quantity;
		this.price=price;
		this.tradeDate=tradeDate;
		this.status=status;
	}
	
	public Side getSide() {
		return side;
	}
	public void setSide(Side side) {
		this.side = side;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDate getTradeDate() {
		return tradeDate;
	}
	public void setTradeDate(LocalDate tradeDate) {
		this.tradeDate = tradeDate;
	}
	public TradeStatus getStatus() {
		return status;
	}
	public void setStatus(TradeStatus status) {
		this.status = status;
	}
}
