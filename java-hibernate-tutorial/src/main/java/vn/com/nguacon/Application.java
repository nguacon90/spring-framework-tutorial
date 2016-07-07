package vn.com.nguacon;

import java.util.List;
import java.util.Scanner;

import vn.com.nguacon.model.Employee;
import vn.com.nguacon.repository.EmployeeDao;
import vn.com.nguacon.repository.EmployeeDaoImpl;
import vn.com.nguacon.service.EmployeeService;
import vn.com.nguacon.service.EmployeeServiceImpl;

public class Application {
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		EmployeeService employeeService = new EmployeeServiceImpl(employeeDao);
		String option = "";
		while (true) {
			showOptions();	
			option = scanner.nextLine();
			if("".equals(option) || "0".equals(option)) {
				System.out.println("Exited application. Thank you!");
				System.exit(0);
			}
			
			if("1".equals(option)) {
				Employee employee = showInputUser(scanner);
				System.out.println("Đang xử lý lưu ...");
				employeeService.saveOrUpdate(employee);
				System.out.println("------Save employee successfully!------");
				continue;
			}
			
			if("2".equals(option)) {
				List<Employee> employees = employeeService.findAll();
				System.out.println("------Employees List------");
				System.out.println(employees);
				continue;
			}
			
			if("3".equals(option)) {
				System.out.println("Enter userId: ");
				String userId = scanner.nextLine();
				try {
					int id = Integer.valueOf(userId);
					employeeService.delete(id);
					System.out.println("------Delete user successfully!------");
				} catch (NumberFormatException e) {
					System.err.println("UserId should be integer: " + userId);
				} catch (RuntimeException e) {
					System.err.println("Delete user fail: " + e.getMessage());
				}
				continue;
			}
			
			if("4".equals(option)) {
				System.out.println("Enter userId: ");
				String userId = scanner.nextLine();
				try {
					int id = Integer.valueOf(userId);
					Employee employee = employeeService.findById(id);
					if(employee == null) {
						System.out.println("Cannot find employee with id: " + id);
					} else {
						System.out.println("------Employee detail: ------");
						System.out.println(employee);
					}
				} catch (NumberFormatException e) {
					System.err.println("UserId should be integer: " + userId);
				} catch (RuntimeException e) {
					System.err.println("Delete user fail: " + e.getMessage());
				}
				continue;
			}
		}
	}

	private static Employee showInputUser(Scanner scanner) {
		Employee employee = new Employee();
		System.out.print("Name: ");
		employee.setName(scanner.nextLine());
		System.out.print("Email: ");
		employee.setEmail(scanner.nextLine());
		System.out.print("Gender (M or F): ");
		employee.setGender(scanner.nextLine());
		return employee;
	}

	private static void showOptions() {
		StringBuilder message = new StringBuilder("Please select options: \n");
		message.append("0. Exit \n");
		message.append("1. Insert User \n");
		message.append("2. View list of users \n");
		message.append("3. Delete User \n");
		message.append("4. View user detail \n");
		System.out.println(message);
		System.out.println("Your choice: ");
		
	}
}
