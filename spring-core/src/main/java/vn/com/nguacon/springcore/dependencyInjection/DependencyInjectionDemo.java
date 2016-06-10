package vn.com.nguacon.springcore.dependencyInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DependencyInjectionDemo {
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("spring-bean-dependency-injection.xml");
		
		UserLoginController controller = (UserLoginController) context.getBean("controller");
		UserLoginController controller2 = (UserLoginController) context.getBean("controller2");
		
		boolean isLogined = controller.login("", "");
		System.out.println(isLogined);
		
		System.out.println(controller2.login("", ""));
	}
}
