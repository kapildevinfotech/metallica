package com.metallica.trade.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.metallica.refdata.domain.Commodity;
import com.metallica.refdata.domain.Counterparty;
import com.metallica.refdata.domain.Location;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Trade {
	@Id @GeneratedValue
	private long id;
	
	@Enumerated(EnumType.STRING)
	private Side side;
	
	private int quantity;
	private  double price;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date tradeDate;
	
	@Enumerated(EnumType.STRING)
	private TradeStatus status;
	
	@ManyToOne
	private Commodity commodity;
	
	@ManyToOne
	private Location location;
	
	@ManyToOne
	private Counterparty counterparty;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Trade() {
	}
	
	public Trade(Side side,int quantity,double price,Date tradeDate,TradeStatus status,
			Commodity commodity,Location location,Counterparty counterparty) {
		this.side=side;
		this.quantity=quantity;
		this.price=price;
		this.tradeDate=tradeDate;
		this.status=status;
		this.commodity=commodity;
		this.counterparty=counterparty;
		this.location=location;
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
	
	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Counterparty getCounterparty() {
		return counterparty;
	}

	public void setCounterparty(Counterparty counterparty) {
		this.counterparty = counterparty;
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
