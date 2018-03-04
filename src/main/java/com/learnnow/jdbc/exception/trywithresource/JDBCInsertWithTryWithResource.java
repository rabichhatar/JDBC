package com.learnnow.jdbc.exception.trywithresource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCInsertWithTryWithResource {

	public static void main(String[] args) throws ClassNotFoundException {

		// Step-1 : Register the Driver
		Class.forName("com.mysql.jdbc.Driver");

		// Step-2 : Create the connection
		try (Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/mytrainingdb", "root", "root")) {

			// Step-3 : Create Statement Object
			Statement statement = con.createStatement();

			// Step-4 : Execute the query
			int i = statement
					.executeUpdate("insert into employee(EmpId,Name,Salary,DeptNo) values(104,'Sukanta',12000,12)");

			System.out.println(i + " record(s) inserted");

			statement.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
