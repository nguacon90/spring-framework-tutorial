package vn.com.nguacon.springcore.beans.annotation.inheritance;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean
	public Animal animal() {
		Animal animal = new Animal("Animal");
		animal.setColor("Yellow");
		return animal;
	}
	
	@Bean
	public Cat cat(Animal animal) {
		Cat cat = new Cat("Cat");
		cat.setColor(animal.color);
		return cat;
	}
}
