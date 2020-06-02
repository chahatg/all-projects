package com.chahatg.day4;
// 4.) Remove duplicate records from table using JDBC.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class removeDuplicates {
	public static void main(String[] args) {
		final String q = "delete from employees where employeeNumber not in"
						+ "(select * from"
							+ "(select min(employeeNumber) from employees group by firstName, lastName, email) as temp_table);";
				
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels?useSSL=false", "root", "");){
			PreparedStatement stmt = con.prepareStatement(q);

			int result = stmt.executeUpdate();
			System.out.println("Records affected: " + result);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
