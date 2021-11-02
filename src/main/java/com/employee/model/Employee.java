package com.employee.model;

public class Employee {
	
	private int empId;
	private String empName;
	private String email;
	private String empDepartment;
	private long mobile;
	private String address;
	
	public Employee(int empId, String empName, String email, String empDepartment, 
			       long mobile, String address) {
		this.empId = empId;
		this.empName = empName;
		this.email = email;
		this.empDepartment = empDepartment;
		this.mobile = mobile;
		this.address = address;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmpDepartment() {
		return empDepartment;
	}

	public void setEmpDepartment(String empDepartment) {
		this.empDepartment = empDepartment;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		
		return "Employee Details => ID : " + empId + ", Name : " + empName + ", Email : " 
		        + email + ", Department : " + empDepartment + ", Mobile : " + mobile + ", Address : " + address;
	}
}
