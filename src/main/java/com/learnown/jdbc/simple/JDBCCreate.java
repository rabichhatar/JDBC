package com.learnown.jdbc.simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCCreate {

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		
		// Step-1 : Register the Driver
		Class.forName("com.mysql.jdbc.Driver");

		// Step-2 : Create the connection
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/mytrainingdb", "root", "root");

		// Step-3 : Create Statement Object
		Statement statement = con.createStatement();

		// Step-4 : Execute the query
		int i = statement
				.executeUpdate("update employee set salary=5000 where empId=103)");

		System.out.println(i + " record(s) updated");

		// Step-5 : Close the Statement and Connection
		statement.close();
		con.close();
	}

}
