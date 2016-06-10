package vn.com.nguacon.springcore.collections;

import java.util.List;
import java.util.Map;

public class Customer {
	private List<Person> persons;
	private Map<String, Person> personsMap;

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public Map<String, Person> getPersonsMap() {
		return personsMap;
	}

	public void setPersonsMap(Map<String, Person> personsMap) {
		this.personsMap = personsMap;
	}
}
