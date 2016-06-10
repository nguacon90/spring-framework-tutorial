package vn.com.nguacon.springcore;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import vn.com.nguacon.springcore.collections.Address;
import vn.com.nguacon.springcore.collections.Customer;
import vn.com.nguacon.springcore.collections.Person;

public class SpringCollectionsDemo {
private static AbstractApplicationContext context;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("spring-collections.xml");
		Address address = (Address) context.getBean("address");
		Customer customer = (Customer) context.getBean("customer");
		Person p = (Person) context.getBean("person1");
		
		System.out.println(address.getProvinces());
		System.out.println(address.getProvincesMap());
		
		System.out.println(customer.getPersons());
		System.out.println(customer.getPersonsMap());
	}
}
