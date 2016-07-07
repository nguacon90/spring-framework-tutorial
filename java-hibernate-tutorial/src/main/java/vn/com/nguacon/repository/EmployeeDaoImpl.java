package vn.com.nguacon.repository;

import java.util.List;

import vn.com.nguacon.model.Employee;

public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {

	@Override
	public void saveOrUpdate(Employee user) {
		save(user);
	}

	@Override
	public Employee findById(int id) {
		return (Employee) get(Employee.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findAll() {
		return findAll(Employee.class);
	}

	@Override
	public void delete(int id) {
		Employee user = findById(id);
		if(user == null) {
			throw new RuntimeException("User is not existed.");
		}
		
		delete(user);
	}
	
}
