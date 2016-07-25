package vn.com.nguacon.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import vn.com.nguacon.model.MyUser;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private BCryptPasswordEncoder bcCryptPasswordEncoder;
	
	@Override
	public MyUser findByUsername(String username) {
		//MOCK user.
		//TODO get user from database
		List<String> roles = new ArrayList<>();
		roles.add("ROLE_USER");
		roles.add("ROLE_ADMIN");
		String password = bcCryptPasswordEncoder.encode("123456");
		return new MyUser(username, password, roles);
	}

}
