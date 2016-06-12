package vn.com.nguacon.model;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	private Date timePlaced;
	private String symbol;
	private int price;
	private int quantity;
	private boolean editable = false;
	public Order() {
		
	}
	
	public Order(String symbol, int price, int quantity, Date timePlaced) {
		this.symbol = symbol;
		this.price = price;
		this.quantity = quantity;
		this.timePlaced = timePlaced;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		if(symbol != null) {
			symbol = symbol.toUpperCase();
		}
		this.symbol = symbol;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getTimePlaced() {
		return timePlaced;
	}

	public void setTimePlaced(Date timePlaced) {
		this.timePlaced = timePlaced;
	}

	@Override
	public String toString() {
		return "Order [timePlaced=" + timePlaced + ", symbol=" + symbol + ", price=" + price + ", quantity=" + quantity
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + price;
		result = prime * result + quantity;
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
		result = prime * result + ((timePlaced == null) ? 0 : timePlaced.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (price != other.price)
			return false;
		if (quantity != other.quantity)
			return false;
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		if (timePlaced == null) {
			if (other.timePlaced != null)
				return false;
		} else if (!timePlaced.equals(other.timePlaced))
			return false;
		return true;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}
}
