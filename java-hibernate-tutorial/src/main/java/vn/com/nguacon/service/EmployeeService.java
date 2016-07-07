package vn.com.nguacon.service;

import java.util.List;

import vn.com.nguacon.model.Employee;

public interface EmployeeService {

	void saveOrUpdate(Employee user);

	Employee findById(int id);

	List<Employee> findAll();

	void delete(int id);

}
