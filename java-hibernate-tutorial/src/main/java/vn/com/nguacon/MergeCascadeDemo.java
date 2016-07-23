package vn.com.nguacon;

import java.util.ArrayList;
import java.util.List;

import vn.com.nguacon.model.mergecascade.Country;
import vn.com.nguacon.model.mergecascade.State;
import vn.com.nguacon.repository.HibernateDaoSupport;

public class MergeCascadeDemo {
	public static void main(String[] args) {
		HibernateDaoSupport dao = new HibernateDaoSupport();
		// Save State with multiple countries
		// countries
		Country a = new Country("Country A");
		Country b = new Country("Country B");
		List<Country> countries = new ArrayList<>();
		countries.add(a);
		countries.add(b);
		State s = new State("Viet Nam", countries);
		dao.save(s);
		System.out.println("-----Result of saving state------");
		System.out.println(dao.findAll(Country.class));
		System.out.println(dao.findAll(State.class));

		// save country has a state -- unsuccess: báo lỗi save State
		State s2 = new State("Thai Lan");
		Country c = new Country("ABC", s2);
		try {
			System.out.println("-----Result of saving country with state not in database------");
			dao.save(c);
			System.out.println(dao.findAll(Country.class));
			System.out.println(dao.findAll(State.class));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		dao.save(s2);
		dao.save(c);
		System.out.println("-----Result of saving country with state in database------");
		System.out.println(dao.findAll(Country.class));
		System.out.println(dao.findAll(State.class));

		try {
			System.out.println("-----Result after delete state-----------");
			dao.delete(s);
			System.out.println(dao.findAll(Country.class));
			System.out.println(dao.findAll(State.class));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		System.out.println("-----Result after delete country-----------");
		dao.delete(c);
		System.out.println(dao.findAll(Country.class));
		System.out.println(dao.findAll(State.class));
		
		/*
		 * Cascade.MERGE: tuong tu PERSIST
		 */
	}
}
