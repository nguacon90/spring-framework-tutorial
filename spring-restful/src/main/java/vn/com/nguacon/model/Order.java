package vn.com.nguacon.model;

import java.util.Date;

public class Order {
	private String id;
	private String symbol;
	private Date placedTime;
	private int quantity;
	private int price;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Date getPlacedTime() {
		return placedTime;
	}

	public void setPlacedTime(Date placedTime) {
		this.placedTime = placedTime;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
