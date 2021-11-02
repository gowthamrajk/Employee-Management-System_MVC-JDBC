package com.employee.configuration;

public class JdbcUtils {
	
	private String url = "jdbc:mysql://localhost:3306/demo?allowPublicKeyRetrieval=true&useSSL=false";
	private String userName = "root";
	private String password = "Gowthamraj@258";
	private String driverName = "com.mysql.cj.jdbc.Driver";
	
	public String getUrl() {
		return this.url;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getDriverName() {
		return this.driverName;
	}
}