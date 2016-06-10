package vn.com.nguacon.springcore.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UserManager {
	@Autowired
	@Qualifier("ageValidator") 
	private Validator validator;
	
	public void checkUser(User user) {
		validator.validate(user);
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}
}
