package vn.com.nguacon.repository;

import java.util.List;

import vn.com.nguacon.model.Employee;

public interface EmployeeDao {

	void saveOrUpdate(Employee user);

	Employee findById(int id);

	List<Employee> findAll();

	void delete(int id);

}
