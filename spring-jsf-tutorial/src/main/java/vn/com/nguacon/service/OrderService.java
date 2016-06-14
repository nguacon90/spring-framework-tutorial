package vn.com.nguacon.service;

import java.util.List;

import vn.com.nguacon.model.Order;


public interface OrderService {
	List<Order> saveOrder(Order order);
	
	void removeOrder(String orderId);
	
	Order updateOrder(Order order);

	List<Order> getOrders();
}
