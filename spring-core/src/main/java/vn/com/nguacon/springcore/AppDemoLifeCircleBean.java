package vn.com.nguacon.springcore;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppDemoLifeCircleBean {
	private static AbstractApplicationContext context;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("spring-beans.xml");
		
		context.registerShutdownHook(); //Close context on JVM
	}
}
