package com.learnown.jdbc.datasource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class JDBCSimpleDataSource {

	public static DataSource getDataSource() {

		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/mytrainingdb");
		dataSource.setUser("root");
		dataSource.setPassword("root");
		return dataSource;
	}

	public static void main(String[] args) throws SQLException {

		// Step-1 : Create the dataSource
		DataSource dataSource = getDataSource();

		// Step-2 : Create the connection
		try (Connection con = dataSource.getConnection()) {

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

			// Step-5 : Close the ResultSet, Statement
			rs.close();
			statement.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
