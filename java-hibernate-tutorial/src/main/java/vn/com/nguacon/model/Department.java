package vn.com.nguacon.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@NamedQueries({
	@NamedQuery(name="findAll", query="from Department"),
	@NamedQuery(name="findById", query="from Department where departmentId = :departmentId")
})
@Entity
@Table(name="departments")
public class Department {
	
	@Id
	@Column(name="departmentId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer departmentId;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@OneToMany(mappedBy="department")
	private List<Employee> employees;
	
	public Department() {
		
	}
	
	public Department(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "[departmentId=" + departmentId + ", name=" + name + "] , Employess:" + "\n" + employees;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
}
