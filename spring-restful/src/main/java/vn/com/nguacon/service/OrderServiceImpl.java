package vn.com.nguacon.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import vn.com.nguacon.model.Order;

@Service
public class OrderServiceImpl implements OrderService {
	private List<Order> orders = new ArrayList<Order>();
	
	public List<Order> saveOrder(Order order) {
		order.setId(UUID.randomUUID().toString());
		order.setPlacedTime(new Date());
		orders.add(order);
		return orders;
	}

	public void removeOrder(String orderId) {
		Iterator<Order> iterator = orders.iterator();
		while(iterator.hasNext()) {
			Order o = iterator.next();
			if(o.getId().equals(orderId)) {
				iterator.remove();
				break;
			}
		}
	}

	public Order updateOrder(Order order) {
		for (int i =0 ; i<orders.size(); i++) {
			if(order.getId().equals(orders.get(i).getId())) {
				orders.set(i, order);
				break;
			}
			
		}
		
		return order;
	}

	public List<Order> getOrders() {
		return orders;
	}
	
	@PostConstruct
	public void initMockOrder() {
		Order o = new Order();
		o.setId(UUID.randomUUID().toString());
		o.setPlacedTime(new Date());
		o.setPrice(2000);
		o.setQuantity(100000);
		o.setSymbol("AAA");
		
		orders.add(o);
	}

	@Override
	public Order getOrderBy(String orderId) {
		for (Order order : orders) {
			if(order.getId().equals(orderId)) {
				return order;
			}
		}
		
		return new Order();
	}

}
