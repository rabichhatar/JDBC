package com.learnown.jdbc.simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCSimple {

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
		ResultSet rs = statement.executeQuery("select * from login");

		while (rs.next()) {
			System.out.println(rs.getInt(1));
		}

		// Step-5 : Close the ResultSet, Statement and Connection
		rs.close();
		statement.close();
		con.close();
	}

}
