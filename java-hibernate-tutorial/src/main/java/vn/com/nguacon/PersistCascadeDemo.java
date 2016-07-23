package vn.com.nguacon;

import java.util.ArrayList;
import java.util.List;

import vn.com.nguacon.model.persistcascade.Country;
import vn.com.nguacon.model.persistcascade.State;
import vn.com.nguacon.repository.HibernateDaoSupport;

public class PersistCascadeDemo {
	public static void main(String[] args) {
		HibernateDaoSupport dao = new HibernateDaoSupport();
		// Save State with multiple countries -- success: save state not save
		// countries
		Country a = new Country("Country A");
		Country b = new Country("Country B");
		List<Country> countries = new ArrayList<>();
		countries.add(a);
		countries.add(b);
		State s = new State("Viet Nam", countries);

		System.out.println("-----Result of saving state------");
		dao.save(s);
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

		System.out.println("-----Result of saving country with state in database------");
		dao.save(s2);
		dao.save(c);
		System.out.println(dao.findAll(Country.class));
		System.out.println(dao.findAll(State.class));

		System.out.println("-----Result after delete state-----------");
		try {
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
		 * Cascade.PERSIST: câu lệnh insert lớp có khoá ngoại thì lớp là khoá
		 * ngoại phải được insert vào database từ trước 
		 * Delete country -- state EXISTED
		 * Delete state -- error because state is foreign key of country in DB, not acceptable
		 */
	}
}
