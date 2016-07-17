package vn.com.nguacon.service;

import java.util.List;

import vn.com.nguacon.model.Department;
import vn.com.nguacon.repository.DepartmentDao;

public class DepartmentServiceImpl implements DepartmentService {
	
	private DepartmentDao departmentDao;
	
	public DepartmentServiceImpl(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	
	@Override
	public void saveOrUpdate(Department department) {
		departmentDao.saveOrUpdate(department);
	}

	@Override
	public Department findById(int id) {
		return departmentDao.findById(id);
	}

	@Override
	public List<Department> findAll() {
		return departmentDao.findAll();
	}

	@Override
	public void delete(int id) {
		departmentDao.delete(id);
	}

}
