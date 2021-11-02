package com.employee.testcase;

import org.junit.Test;
import com.employee.exception.EmployeeNotFoundException;
import com.employee.model.Employee;
import com.employee.service.EmployeeService;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;

public class ServiceTestCase {
	
	EmployeeService employeeService = new EmployeeService();
	Employee employee1 = new Employee(101, "Gowtham", "gowtham@gmail.com", "Delivery", 1234567891, "abc");
	Employee employee2 = null;
	List<Employee> employeeList = new ArrayList<>();
	
	String[] updatedDetails = {"Raj", "raj@gmail.com", "Consultant", "1122334455", "abcd"};
	
	@Test
	public void addingEmployeeTest() {
		Assert.assertEquals(employeeService.addNewEmployee(employee1), employee1);
	}
	
	@Test
	public void updateEmployeeTest() {
		Assert.assertEquals(employeeService.updateEmployee(employee1, updatedDetails), employee1);
	}
	
	@Test
	public void deleteEmployeeTest() {
		Assert.assertEquals(employeeService.deleteEmployee(employee1), employee1);
	}
	
	@Test
	public void getEmployeeDetailsTest() {
		Assert.assertEquals(employeeService.getAllEmployee(), employeeList);
	}
	
	@Test
	public void getEmployeeByIdTest() {
		
		try {
			Assert.assertEquals(employeeService.getEmployeeById(101), employee1);
		} 
		catch (EmployeeNotFoundException e) {		
			e.printStackTrace();
		}
	}
	
	@Test(expected = EmployeeNotFoundException.class)
	public void employeeNotFoundTest() {
		
		try {
			employeeService.getEmployeeById(102);
		} 
		catch (EmployeeNotFoundException e) {
			e.printStackTrace();
		}
	}
}
