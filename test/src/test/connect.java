package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connect {

	private final String className = "com.mysql.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost:3306/nguyenvanson";
	private final String user = "admin";
	private final String pass = "heartbreaker96";
	private String table = "thamgia";

	private Connection connection;

	
	public connect() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public String getUser() {
		return user;
	}


	public String getPass() {
		return pass;
	}


	public void myconnect() {
		try {
			Class.forName(className);
			connection = DriverManager.getConnection(url, user, pass);
			System.out.println("Connect success!");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		} catch (SQLException e) {
			System.out.println("Error connect!");
		}
	}

}
