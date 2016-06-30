package vn.com.nguacon.repository;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import vn.com.nguacon.model.User;

@Repository
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public void saveOrUpdate(User user) {
		save(user);
	}

	@Override
	public User findById(int id) {
		return hibernateTemplate.get(User.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		return (List<User>) hibernateTemplate.findByCriteria(criteria);
	}

	@Override
	public void delete(int id) {
		User user = findById(id);
		delete(user);
	}
	
}
