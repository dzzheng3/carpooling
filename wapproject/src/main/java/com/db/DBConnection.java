package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static DBConnection databaseConnection;
	private static final String USER = "root";	
	private static final String PASSWORD = "1234";
	private static final String DRIVER_URL = "com.mysql.jdbc.Driver";
	String dburl = "jdbc:mysql://localhost:3306/project";
	//private static final String DB_URL = "jdbc:mysql://172.17.2.236:3306/project";
	//private static final String DB_URL = "jdbc:mysql://localhost:3306/carpoolingdb";
	
	private Connection connection;
	
	private DBConnection(){
		initializeConnection();
	}
	
	public static DBConnection getInstance() {
		if (databaseConnection == null) {
			databaseConnection = new DBConnection();			
		}			
		return databaseConnection;
	}
	
	private void initializeConnection(){
		
        try {
        	
			Class.forName(DRIVER_URL);
			System.out.println("Initialized JDBC Driver!");
			
			connection = DriverManager.getConnection(dburl,USER, PASSWORD);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
        catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public void closeConnection() {
		try {
			System.out.println("Closing connection...");
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}
	
	

}
