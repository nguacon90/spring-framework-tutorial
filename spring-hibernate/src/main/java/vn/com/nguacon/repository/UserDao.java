package vn.com.nguacon.repository;

import java.util.List;

import vn.com.nguacon.model.User;

public interface UserDao {

	void saveOrUpdate(User user);

	User findById(int id);

	List<User> findAll();

	void delete(int id);

}
