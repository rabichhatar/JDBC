package com.learnnow.jdbc.exception;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCQueryWithExceptionHandling {

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		
		Connection con = null;
		
		try {
			// Step-1 : Register the Driver
			Class.forName("com.mysql.jdbc.Driver");

			// Step-2 : Create the connection
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mytrainingdb", "root", "root");

			// Step-3 : Create Statement Object
			Statement statement = con.createStatement();

			// Step-4 : Execute the query
			ResultSet rs = statement.executeQuery("select * from employee");

			while (rs.next()) {
				System.out.print(rs.getInt(1));
				System.out.print("\t");
				System.out.print(rs.getString(2));
				System.out.print("\t");
				System.out.print(rs.getInt(3));
				System.out.print("\t");
				System.out.println(rs.getInt(4));
			}

			rs.close();
			statement.close();

		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {

			// Step-5 : Close Connection
			if (con != null) {
				con.close();
			}
		}
	}

}
