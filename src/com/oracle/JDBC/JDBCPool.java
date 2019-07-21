package com.oracle.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.junit.Test;

public class JDBCPool {
	private static String username;
	private static String password;
	private static String url;
	private static String driver;
	private static List<Connection> connectionPool = new ArrayList<Connection>();

	static {
		try {
			getMsgFromPropertiesFile();
			Class.forName(driver);
			for (int i = 0; i < 10; i++)
				connectionPool.add(DriverManager.getConnection(url, username, password));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void getMsgFromPropertiesFile() {
		ResourceBundle bundle = PropertyResourceBundle.getBundle("db");
		driver = bundle.getString("db.driverClass");
		url = bundle.getString("db.url");
		username = bundle.getString("db.username");
		password = bundle.getString("db.password");
	}

	public static Connection getConnection() {
		Connection connection = null;
		if (connectionPool.isEmpty()) {
			try {
				connection = DriverManager.getConnection(url, username, password);
				return connection;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		connection = connectionPool.remove(0);
		return connection;
	}

	public static boolean closeConnection(Connection connection) {
		if (connectionPool.size() >= 10) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
		connectionPool.add(connection);
		return true;
	}
}
