package vn.com.nguacon.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import vn.com.nguacon.model.Order;

@Service
public class OrderServiceImpl implements OrderService {
	private List<Order> orders = new ArrayList<Order>();
	
	public List<Order> saveOrder(Order order) {
		
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
		//Loc cho toi nhung order thoa man 1 dkien nao 
		//TODO
		return orders;
	}

}
