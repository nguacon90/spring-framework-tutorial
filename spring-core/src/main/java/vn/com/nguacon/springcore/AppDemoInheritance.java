package vn.com.nguacon.springcore;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import vn.com.nguacon.springcore.beans.inheritance.Animal;
import vn.com.nguacon.springcore.beans.inheritance.Cat;

public class AppDemoInheritance {
	private static AbstractApplicationContext context;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("spring-beans-inheritance.xml");
		
		Animal animal = (Animal) context.getBean("animal");
		animal.say();
		Cat cat = (Cat) context.getBean("cat");
		cat.say();
		context.registerShutdownHook(); 
	}
}
