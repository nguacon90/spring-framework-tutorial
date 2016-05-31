package vn.com.nguacon.springcore.beans;

public class BeanLifeCircle {
	
	public void init() {
		System.out.println("Init class: " + BeanLifeCircle.class.getSimpleName());
	}
	
	public void destroy() {
		System.out.println("Run destroy method.");
	}
}
