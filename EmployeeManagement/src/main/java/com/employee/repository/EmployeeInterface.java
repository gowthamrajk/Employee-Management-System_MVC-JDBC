package com.employee.repository;

import java.util.List;

import com.employee.exception.EmployeeNotFoundException;
import com.employee.model.Employee;

public interface EmployeeInterface {
	
	public Employee addNewEmployee(Employee employee);
	
	public Employee updateEmployee(Employee employee, String[] updatedDetails);
	
	public Employee deleteEmployee(Employee employee);
	
	public List<Employee> getAllEmployee();

	public Employee getEmployeeById(int employeeId) throws EmployeeNotFoundException ;
}
