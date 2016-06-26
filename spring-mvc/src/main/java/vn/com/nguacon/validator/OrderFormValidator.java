package vn.com.nguacon.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import vn.com.nguacon.model.Order;

@Component
public class OrderFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Order.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Order order = (Order) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "symbol", "order.form.empty.symbol");
		if (order.getPrice() <= 0) {
			errors.rejectValue("price", "order.form.invalid.price");
		}

		if (order.getQuantity() <= 0) {
			errors.rejectValue("quantity", "order.form.invalid.price");
		}
	}

}
