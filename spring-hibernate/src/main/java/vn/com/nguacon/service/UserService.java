package vn.com.nguacon.service;

import java.util.List;

import vn.com.nguacon.model.User;

public interface UserService {

	void saveOrUpdate(User user);

	User findById(int id);

	List<User> findAll();

	void delete(int id);

}
