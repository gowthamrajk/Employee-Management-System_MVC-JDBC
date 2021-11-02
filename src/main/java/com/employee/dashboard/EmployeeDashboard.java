package com.employee.dashboard;

import org.apache.log4j.Logger;
import com.employee.exception.EmployeeNotFoundException;
import com.employee.model.Employee;
import com.employee.repository.EmployeeInterface;
import com.employee.service.EmployeeService;
import java.util.Scanner;

public class EmployeeDashboard {

	public static final Logger logger = Logger.getLogger(EmployeeDashboard.class);

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		EmployeeInterface serviceObj = new EmployeeService();
		int empId = 101;
		
		logger.trace("Welcome to Employee management Portal !!!\n");
		while (true) {
			logger.trace("Choose an Option : \n1) Add new Employee \n2) Update Details \n3) Delete Employee "
					+ "\n4) View All Employee \n5) Exit \n");
			int option = scanner.nextInt();
			scanner.nextLine();
			switch (option) {
			
			case 1: {
				
				logger.info("\n<=>Add New Employee Menu<=>\n");
				logger.trace("Enter Employee Details as name, email, department, mobile, address to create a new Employee...");
				String[] employeeDetails = scanner.nextLine().split(",");
				
				Employee employee = new Employee(empId++, employeeDetails[0], employeeDetails[1], employeeDetails[2], Long.parseLong(employeeDetails[3]), employeeDetails[4]);				
				logger.info("Employee Details Added Successfully !!!\n" + serviceObj.addNewEmployee(employee) + "\n");				
				break;
			}
			case 2: {
				
				logger.info("\n<=>Update Employee Menu<=>\n");
				logger.trace("Enter Employee ID :");
				int employeeId = scanner.nextInt();
				scanner.nextLine();
				logger.trace("Enter updated Employee Details as name, email, department, mobile, address to update the Employee with Id : " + employeeId);
				String[] updatedDetails = scanner.nextLine().split(",");
				
				try {
				    logger.info("Employee Details Updated Successfully !!!\n" 
				                + serviceObj.updateEmployee(serviceObj.getEmployeeById(employeeId), updatedDetails) + "\n");				
				}
				catch(EmployeeNotFoundException exception) {
					logger.error(exception);
				}
				break;
			}
			case 3: {
				
				logger.info("\n<=>Delete Employee Menu<=>\n");
				logger.trace("Enter Employee ID : \n");
				int employeeId = scanner.nextInt();
				
				try {
				    logger.info("Employee Details deleted Successfully !!!\n" 
			                    + serviceObj.deleteEmployee(serviceObj.getEmployeeById(employeeId)) + "\n");
				}
				catch(EmployeeNotFoundException exception) {
					logger.error(exception);
				}
				break;
			}
			case 4: {
				
				logger.info("\n<=>Employee List Menu<=>\n");
				logger.info("All the Available employees are => \n" 
			            + serviceObj.getAllEmployee() + "\n");
				break;
			}
			case 5: {
				logger.info("Thankyou !!!");
				return;
			}
			default: {
				logger.warn("Invalid Option !!! Try again...");
				break;
			}
			}
		}
	}
}
