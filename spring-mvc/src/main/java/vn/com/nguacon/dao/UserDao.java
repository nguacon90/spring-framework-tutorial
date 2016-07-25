package vn.com.nguacon.dao;

import vn.com.nguacon.model.MyUser;

public interface UserDao {
	MyUser findByUsername(String username);
}
