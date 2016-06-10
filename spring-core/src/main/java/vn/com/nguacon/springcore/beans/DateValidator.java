package vn.com.nguacon.springcore.beans;

import org.springframework.stereotype.Component;

@Component
public class DateValidator implements Validator {

	public void validate(User user) {
		//TODO validate Date of user
		System.out.println("validate date of birth");
	}

}
