package vn.com.nguacon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.com.nguacon.model.Order;
import vn.com.nguacon.service.OrderService;
import vn.com.nguacon.validator.OrderFormValidator;

@Controller
public class OrderController {
	private OrderService service;
	private OrderFormValidator orderFormValidator;

	@Autowired
	public OrderController(OrderService service, OrderFormValidator orderFormValidator) {
		this.service = service;
		this.orderFormValidator = orderFormValidator;
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(orderFormValidator);
	}

	@RequestMapping("/orders")
	public ModelAndView viewOrderPage() {
		List<Order> orders = service.getOrders();
		ModelAndView model = new ModelAndView("orders");
		model.addObject("orders", orders);
		model.addObject("order", new Order());
		return model;
	}

	@RequestMapping(value="/placeOrder", method=RequestMethod.POST)
	public String placeOrder(Model model, @ModelAttribute("order") @Validated Order order, 
			BindingResult result, final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			List<Order> orders = service.getOrders();
			model.addAttribute("orders", orders);
			return "orders";
		}
		
		service.saveOrder(order);
		
		return "redirect: orders";
	}
}
