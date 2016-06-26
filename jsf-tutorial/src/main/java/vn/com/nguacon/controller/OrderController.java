package vn.com.nguacon.controller;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import vn.com.nguacon.model.Order;

@ManagedBean(name = "orderBean")
@SessionScoped
public class OrderController implements Serializable {
	private Order order = new Order();
	private static final long serialVersionUID = 1L;
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static List<Order> orders;
	
	static {
		orders = new ArrayList<>();
		orders.add(new Order("VND", 12000, 100000, format("22/12/2016 05:00:00")));
		orders.add(new Order("AAA", 13400, 10000, format("22/12/2016 15:10:00")));
		orders.add(new Order("KLS", 1100000, 22200, format("22/12/2016 15:20:00")));
	}
	
	public List<Order> getOrders() {
		//Select tu DB set to orders.
		return orders;
	}

	public void addOrder() {
		order.setTimePlaced(new Date());
		orders.add(order);
		order = new Order();
	}
	
	public void deleteOrder(Order order) {
		orders.remove(order);
	}
	
	public void saveOrder(Order order) {
		//UPDATE TO DB
		order.setEditable(false);
	}
	
	public void editOrder(Order order) {
		for (Order o : orders) {
			o.setEditable(false);
		}
		
		order.setEditable(true);
	}
	
	public void cancelEditOrder(Order order) {
		order.setEditable(false);
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

	private static Date format(String dateTime) {
		try {
			return simpleDateFormat.parse(dateTime);
		} catch (ParseException e) {
			return new Date();
		}
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}
