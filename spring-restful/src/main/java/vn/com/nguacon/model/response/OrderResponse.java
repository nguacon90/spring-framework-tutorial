package vn.com.nguacon.model.response;

import java.util.List;

import vn.com.nguacon.model.Order;


public class OrderResponse {
	private List<Order> orders;

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}
