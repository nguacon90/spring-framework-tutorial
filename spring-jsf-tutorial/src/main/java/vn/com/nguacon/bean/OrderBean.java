package vn.com.nguacon.bean;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vn.com.nguacon.model.Order;
import vn.com.nguacon.service.OrderService;

@Component
@ManagedBean(name="orderBean")
@SessionScoped
public class OrderBean {
	private Order order = new Order();
	private OrderService orderService;
	
	@Autowired
	public OrderBean(OrderService orderService) {
		this.orderService = orderService;
	}
	
	public void addOrder() {
		order.setId(UUID.randomUUID().toString());
		order.setTimePlaced(new Date());
		orderService.saveOrder(order);
		order = new Order();
	}
	
	public void validateOrder(ComponentSystemEvent event) {
		FacesContext fc = FacesContext.getCurrentInstance();
		UIComponent components = event.getComponent();
		// get symbol
		UIInput uiInputSymbol = (UIInput) components.findComponent("symbol");
		String symbol = (String) uiInputSymbol.getLocalValue();
		String symbolId = uiInputSymbol.getClientId();
		
		// get price
		UIInput uiInputPrice = (UIInput) components.findComponent("price");
		Integer price = (Integer) uiInputPrice.getLocalValue();
		String priceId = uiInputPrice.getClientId();
		
		// get symbol
		UIInput uiInputQuantity = (UIInput) components.findComponent("quantity");
		Integer quantity = (Integer) uiInputQuantity.getLocalValue();
		String quantityId = uiInputQuantity.getClientId();

		if (symbol == null || symbol.equals("")) {
			FacesMessage msg = new FacesMessage("Bạn cần điền mã chứng khoán.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			fc.addMessage(symbolId, msg);
			fc.renderResponse();
		}

		if (price == null || price == 0) {
			FacesMessage msg = new FacesMessage("Giá chứng khoán không đúng");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			fc.addMessage(priceId, msg);
			fc.renderResponse();
		}

		if (quantity == null || quantity == 0) {
			FacesMessage msg = new FacesMessage("Số lượng chứng khoán không đúng");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			fc.addMessage(quantityId, msg);
			fc.renderResponse();
		}
		
	}
	
	public List<Order> getOrders(){
		return orderService.getOrders();
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}
