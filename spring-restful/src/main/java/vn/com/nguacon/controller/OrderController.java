package vn.com.nguacon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vn.com.nguacon.model.Order;
import vn.com.nguacon.model.response.OrderResponse;
import vn.com.nguacon.service.OrderService;

@RestController
public class OrderController {
	private OrderService orderService;

	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@RequestMapping(value="/orders", method=RequestMethod.GET)
	public ResponseEntity<OrderResponse> get(){
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setOrders(orderService.getOrders());
		return new ResponseEntity<>(orderResponse, HttpStatus.OK);
	}
	
	@RequestMapping(value="/orders/{id}", method=RequestMethod.GET)
	public ResponseEntity<Order> getOrderBy(@PathVariable("id") String orderId){
		Order order = orderService.getOrderBy(orderId);
		return new ResponseEntity<>(order, HttpStatus.OK);
	}
}
