package vn.com.nguacon.service;

import java.util.List;

import vn.com.nguacon.model.Employee;
import vn.com.nguacon.repository.EmployeeDao;

public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDao employeeDao;
	
	public EmployeeServiceImpl(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@Override
	public void saveOrUpdate(Employee employee) {
		employeeDao.saveOrUpdate(employee);
	}

	@Override
	public Employee findById(int id) {
		return employeeDao.findById(id);
	}

	@Override
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Override
	public void delete(int id) {
		employeeDao.delete(id);
	}

}
