package vn.com.nguacon.springcore.beans;

import org.springframework.stereotype.Component;

@Component
public class AgeValidator implements Validator {

	public void validate(User user) {
		if(user.getAge() < 18) {
			throw new RuntimeException("Not enough age");
		}
	}
	
}
