package com.metallica.trade.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Trade {
	@Id @GeneratedValue
	private long id;
	
	private Side side;
	private int quantity;
	private  double price;
	private Date tradeDate;
	private TradeStatus status;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Trade() {
	}
	
	public Trade(Side side,int quantity,double price,Date tradeDate,TradeStatus status) {
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
	public Date getTradeDate() {
		return tradeDate;
	}
	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}
	public TradeStatus getStatus() {
		return status;
	}
	public void setStatus(TradeStatus status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return String.join(",", side.toString(),String.valueOf(quantity),
				String.valueOf(price),tradeDate.toString(),status.toString());
	}
	
	public String toJson() throws JsonProcessingException{
		return new ObjectMapper().writeValueAsString(this);
	}
}
