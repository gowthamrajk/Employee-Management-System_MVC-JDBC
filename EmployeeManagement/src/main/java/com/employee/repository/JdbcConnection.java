package com.employee.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.log4j.Logger;
import com.employee.configuration.JdbcUtils;
import com.employee.model.Employee;

public class JdbcConnection {

	private static final Logger logger = Logger.getLogger(JdbcConnection.class);
	private Connection connection = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	private int counter = 1;
	private JdbcUtils jdbcUtils = new JdbcUtils();

	public JdbcConnection() {
		establishConnection(connection);
	}

	public void establishConnection(Connection connection) {

		try {
			Class.forName(jdbcUtils.getDriverName());
			connection = DriverManager.getConnection(jdbcUtils.getUrl(), jdbcUtils.getUserName(), jdbcUtils.getPassword());
			statement = connection.createStatement();
		} catch (Exception exception) {
			logger.error(exception);
		}
	}

	public void insertNewEmployee(Employee employee) {

		try {
			connection = DriverManager.getConnection(jdbcUtils.getUrl(), jdbcUtils.getUserName(), jdbcUtils.getPassword());
			preparedStatement = connection.prepareStatement("insert into employee (id, empname, email, department, phone, address) VALUES (?, ?, ?, ?, ?, ?)");
			preparedStatement.setInt(1, employee.getEmpId());
			preparedStatement.setString(2, employee.getEmpName());
			preparedStatement.setString(3, employee.getEmail());
			preparedStatement.setString(4, employee.getEmpDepartment());
			preparedStatement.setLong(5, employee.getMobile());
			preparedStatement.setString(6, employee.getAddress());
			preparedStatement.executeUpdate();
			logger.trace("Records Added Successfully !!!\n");

			resultSet = statement.executeQuery("select * from users");

			while (resultSet.next()) {

				logger.info("Record " + counter++ + " : ");
				logger.info("ID : " + resultSet.getInt("id") + "\nNAME : " + resultSet.getString("empname") + "\nEMAIL : "
							+ resultSet.getString("email") + "\nMOBILE : " + resultSet.getString("phone") + "\nDEPARTMENT : " 
						    + resultSet.getString("department") + "\nADDRESS : " + resultSet.getString("address") + "\n");
			}
		} catch (Exception exception) {
			logger.error(exception);
		}

	}

}
