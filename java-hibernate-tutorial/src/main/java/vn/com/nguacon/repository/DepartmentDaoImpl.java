package vn.com.nguacon.repository;

import java.util.List;

import org.hibernate.query.Query;

import vn.com.nguacon.model.Department;

public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

	@Override
	public void saveOrUpdate(Department department) {
		save(department);
	}

	@Override
	public Department findById(int id) {
		return (Department) get(Department.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> findAll() {
		return findAll(Department.class);
	}

	@Override
	public void delete(int id) {
		Department department = findById(id);
		if(department == null) {
			throw new RuntimeException("Department is not existed.");
		}
		
		delete(department);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> findAllByCallNameQueries() {
		openSession();
		Query<Department> namedQuery = session.getNamedQuery("findAll");
		return namedQuery.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Department findByIdCallingNameQueries(int id) {
		openSession();
		Query<Department> namedQuery = session.getNamedQuery("findById");
		namedQuery.setParameter("departmentId", id);
		return namedQuery.getSingleResult();
	}

}
