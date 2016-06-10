package vn.com.nguacon.springcore.beans;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserManagerTest {
	private UserManager manager;
	
	@Before
	public void setUp() {
		manager = new UserManager();
		manager.setValidator(new AgeValidator());
	}
	
	@Test
	public void validateUserWithAgeSmaller18ShouldThrowException() {
		try {
			manager.checkUser(new User());
			fail("must throw exception");
		} catch (RuntimeException e) {
			assertEquals("Not enough age", e.getMessage());
		}
	}
	
	@Test
	public void validateUserWithAgeLargerThan18ShouldValid() {
		User user = new User();
		user.setAge(19);
		manager.checkUser(user);
	}
}
