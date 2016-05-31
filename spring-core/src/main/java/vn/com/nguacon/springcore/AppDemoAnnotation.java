package vn.com.nguacon.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import vn.com.nguacon.springcore.beans.annotation.inheritance.Animal;
import vn.com.nguacon.springcore.beans.annotation.inheritance.Cat;

public class AppDemoAnnotation {
	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new AnnotationConfigApplicationContext("vn.com.nguacon.springcore.beans.annotation.inheritance");
		Animal animal = (Animal) context.getBean("animal");
		animal.say();
		Cat cat = (Cat) context.getBean("cat");
		cat.say();
	}
}
