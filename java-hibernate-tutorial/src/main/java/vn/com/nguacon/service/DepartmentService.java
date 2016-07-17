package vn.com.nguacon.service;

import java.util.List;

import vn.com.nguacon.model.Department;

public interface DepartmentService {

	void saveOrUpdate(Department department);

	Department findById(int id);

	List<Department> findAll();

	void delete(int id);

}
