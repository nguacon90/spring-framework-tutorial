package vn.com.nguacon;

import java.util.Scanner;

import vn.com.nguacon.repository.DepartmentDao;
import vn.com.nguacon.repository.DepartmentDaoImpl;

public class CallNameQueriesDemo {
	public static void main(String[] args) {
		DepartmentDao departmentDao = new DepartmentDaoImpl();
		System.out.println(departmentDao.findAllByCallNameQueries());
		Scanner scanner = new Scanner(System.in);
		System.out.print("DepartmentId: ");
		Integer id = scanner.nextInt();
		
		System.out.println(departmentDao.findByIdCallingNameQueries(id));
		scanner.close();
	}
}
