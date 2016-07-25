package vn.com.nguacon.repository;

import java.util.List;

import vn.com.nguacon.model.Department;

public interface DepartmentDao {
	void saveOrUpdate(Department department);

	Department findById(int id);

	List<Department> findAll();

	void delete(int id);
	
	List<Department> findAllByCallNameQueries();
	
	Department findByIdCallingNameQueries(int id);
}
