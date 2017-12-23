package com.smj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.smj.domain.Account;

public class DbUtil {

	private static final String URL = "jdbc:mysql://127.0.0.1:3306/mall";
	private static final String USER = "root";
	private static final String PASSWORD = "970425";
	// com.mysql.jdbc.Driver.class
	private static final String JDBC_Driver = "com.mysql.jdbc.Driver";

	static {
		try {
			Class.forName(JDBC_Driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

	public static void close(Connection connection, PreparedStatement statement, ResultSet resultSet)
			throws SQLException {
		if (resultSet != null) {
			resultSet.close();
		}

		if (statement != null) {
			statement.close();
		}

		if (connection != null) {
			connection.close();
		}
	}

}
