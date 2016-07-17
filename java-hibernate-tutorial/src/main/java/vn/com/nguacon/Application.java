package vn.com.nguacon;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import vn.com.nguacon.model.Department;
import vn.com.nguacon.model.Employee;
import vn.com.nguacon.model.Meeting;
import vn.com.nguacon.repository.DepartmentDao;
import vn.com.nguacon.repository.DepartmentDaoImpl;
import vn.com.nguacon.repository.EmployeeDao;
import vn.com.nguacon.repository.EmployeeDaoImpl;
import vn.com.nguacon.repository.MeetingDao;
import vn.com.nguacon.repository.MeetingDaoImpl;
import vn.com.nguacon.service.DepartmentService;
import vn.com.nguacon.service.DepartmentServiceImpl;
import vn.com.nguacon.service.EmployeeService;
import vn.com.nguacon.service.EmployeeServiceImpl;
import vn.com.nguacon.service.MeetingService;
import vn.com.nguacon.service.MeetingServiceImpl;

public class Application {
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		DepartmentDao departmentDao = new DepartmentDaoImpl(); 
		MeetingDao meetingDao = new MeetingDaoImpl();
		
		EmployeeService employeeService = new EmployeeServiceImpl(employeeDao);
		DepartmentService departmentService = new DepartmentServiceImpl(departmentDao);
		MeetingService meetingService = new MeetingServiceImpl(meetingDao);
		
		String option = "";
		while (true) {
			showOptions();	
			option = scanner.nextLine();
			if("".equals(option) || "0".equals(option)) {
				System.out.println("Exited application. Thank you!");
				System.exit(0);
			}
			
			if("1".equals(option)) {
				Employee employee = showInputEmployee(scanner, departmentService);
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
				System.out.println("Enter EmployeeId: ");
				String userId = scanner.nextLine();
				try {
					int id = Integer.valueOf(userId);
					employeeService.delete(id);
					System.out.println("------Delete user successfully!------");
				} catch (NumberFormatException e) {
					System.err.println("EmployeeId should be integer: " + userId);
				} catch (RuntimeException e) {
					System.err.println("Delete user fail: " + e.getMessage());
				}
				continue;
			}
			
			if("4".equals(option)) {
				System.out.println("Enter EmployeeId: ");
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
					System.err.println("EmployeeId should be integer: " + userId);
				} catch (RuntimeException e) {
					System.err.println("Delete Employee fail: " + e.getMessage());
				}
				continue;
			}
			
			if("5".equals(option)) {
				System.out.print("Enter department Name: ");
				String name = scanner.nextLine();
				Department department = new Department(name);
				departmentService.saveOrUpdate(department);
				System.out.println("------Save successfully!--------");
			}
			if("6".equals(option)) {
				System.out.print("Departments : ");
				System.out.println(departmentService.findAll());
			}
			if("7".equals(option)) {
				Meeting meeting = inputMeeting(scanner, employeeService);
				meetingService.saveOrUpdate(meeting);
				System.out.println("Save successfully.");
			}
			
			if("8".equals(option)) {
				System.out.println("Meetings list: ");
				System.out.println(meetingService.findAll());
			}
			
		}
	}

	private static Meeting inputMeeting(Scanner scanner2, EmployeeService employeeService) {
		Meeting meeting = new Meeting();
		System.out.print("Subject: ");
		meeting.setSubject(scanner.nextLine());
		
		System.out.print("Date (dd/MM/yyyy): ");
		String dateStr = scanner.nextLine();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			meeting.setMeetingDate(simpleDateFormat.parse(dateStr));
		} catch (ParseException e) {
			System.err.println("Meeting date invalid format");
		}
		System.out.println("Employee List" +  employeeService.findAll());
		System.out.print("Employee Ids attend (separate by comma): ");
		String employeeIds = scanner.nextLine();
		String[] ids = employeeIds.replaceAll(" " , "").split(",");
		List<Employee> employees = new ArrayList<>();
		for (String id : ids) {
			Employee employee = employeeService.findById(Integer.valueOf(id)); 
			employees.add(employee);
		}
		
		meeting.setEmployees(employees);
		System.out.println(meeting);
		return meeting;
		
	}

	private static Employee showInputEmployee(Scanner scanner, DepartmentService departmentService) {
		Employee employee = new Employee();
		System.out.print("Name: ");
		employee.setName(scanner.nextLine());
		System.out.print("Email: ");
		employee.setEmail(scanner.nextLine());
		System.out.print("Gender (M or F): ");
		employee.setGender(scanner.nextLine());
		System.out.println("List department: ");
		System.out.println(departmentService.findAll());
		System.out.print("Department id: ");
		String departmentId = scanner.nextLine();
		Department department = new Department();
		department.setDepartmentId(Integer.valueOf(departmentId));
		employee.setDepartment(department);
		return employee;
	}

	private static void showOptions() {
		StringBuilder message = new StringBuilder("Please select options: \n");
		message.append("0. Exit \n");
		message.append("1. Insert Employee \n");
		message.append("2. View list of employees \n");
		message.append("3. Delete Employee \n");
		message.append("4. View employee detail \n");
		message.append("5. Insert department \n");
		message.append("6. View all department \n");
		message.append("7. Create meeting \n");
		message.append("8. View all meetings \n");
		System.out.println(message);
		System.out.println("Your choice: ");
		
	}
}
