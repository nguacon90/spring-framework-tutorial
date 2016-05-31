package vn.com.nguacon.springcore.beans.annotation.inheritance;

public class Animal {
	protected String name;
	protected String color;

	public Animal(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void say() {
		System.out.println("My name is " + name + " and my color is " + color);
	}
}
