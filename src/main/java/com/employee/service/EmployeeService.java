package com.employee.service;

import java.util.ArrayList;
import java.util.List;

import com.employee.exception.EmployeeNotFoundException;
import com.employee.model.Employee;
import com.employee.repository.EmployeeInterface;
import com.employee.repository.JdbcConnection;

public class EmployeeService implements EmployeeInterface {
	
	private List<Employee> employees = new ArrayList<>();
	private JdbcConnection jdbcConnection = new JdbcConnection();
	private String employeeNotFoundMessage = "Employee Not Found !!!";

	@Override
	public Employee addNewEmployee(Employee employee) {
		this.employees.add(employee);
		jdbcConnection.insertNewEmployee(employee);
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee, String[] updatedDetails) {
		employee.setEmpName(updatedDetails[0]);
		employee.setEmail(updatedDetails[1]);
		employee.setEmpDepartment(updatedDetails[2]);
		employee.setMobile(Long.parseLong(updatedDetails[3]));
		employee.setAddress(updatedDetails[4]);
		return employee;
	}

	@Override
	public Employee deleteEmployee(Employee employee) {
		this.employees.remove(employee);
		return employee;
	}

	@Override
	public List<Employee> getAllEmployee() {	
		return this.employees;
	}

	@Override
	public Employee getEmployeeById(int employeeId) throws EmployeeNotFoundException {
		
		Employee employee = null;
		for(Employee employeeObj : employees) {
			if(employeeObj.getEmpId() == employeeId)
				employee = employeeObj;
		}
		
		if(employee == null)
			throw new EmployeeNotFoundException(employeeNotFoundMessage);
		
		return employee;
	}
}
