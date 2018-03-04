package com.learnnow.jdbc.exception;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCInsertWithExceptionHandling {

	public static void main(String[] args) throws SQLException {
		
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
			int i = statement
					.executeUpdate("insert into employee(EmpId,Name,Salary,DeptNo) values(104,'Sukanta',12000,12)");

			System.out.println(i + " record(s) inserted");

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
