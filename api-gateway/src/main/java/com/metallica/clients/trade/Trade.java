package com.metallica.clients.trade;

import java.util.Date;

import com.metallica.clients.refdata.Commodity;
import com.metallica.clients.refdata.Counterparty;
import com.metallica.clients.refdata.Location;

public class Trade {
	private long id;
	private Side side;
	private int quantity;
	private  double price;
	private Date tradeDate;
	private TradeStatus status;
	private Commodity commodity;
	private Location location;
	private Counterparty counterparty;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Trade() {
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
}
