package com.learnnow.jdbc.exception.trywithresource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCQueryWithTryWithResource {

	public static void main(String[] args) throws ClassNotFoundException {
		
		// Step-1 : Register the Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		// Step-2 : Create the connection
		try(Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/mytrainingdb", "root", "root")) {

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

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
