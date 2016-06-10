package vn.com.nguacon.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import vn.com.nguacon.springcore.beans.HelloWorld;
import vn.com.nguacon.springcore.beans.Student;

public class AppDemoBeans {
	
	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("spring-beans.xml");
		HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
		helloWorld.sayHello();
	
		Student studentA = (Student) context.getBean("studentA");
		System.out.println(studentA);

		
		Student studentB = (Student) context.getBean("studentB");
		System.out.println(studentB);
		
		//scope = singleton (default)
		Student studentB1 = (Student) context.getBean("studentB");
		System.out.println(String.format("%s is Singleton: %s", studentB, studentB.equals(studentB1)));
		
		//scope = prototype
		Student studentC = (Student) context.getBean("studentC");
		System.out.println(studentB);

		Student studentC1 = (Student) context.getBean("studentC");
		System.out.println(String.format("%s is Prototype: %s", studentC, !studentC.equals(studentC1)));
	}
}
