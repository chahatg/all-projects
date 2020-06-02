package com.chahatg.day4;
// 2.) Create an application to get the inputs from
//     console and save the records in table.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertFromConsole {
	public static void main(String[] args) {
		
		int id = Integer.parseInt(args[0]);
		String lname = args[1];
		String fname = args[2];
		String extension = args[3];
		String email = args[4];
		String officeCode = args[5];
		int reportsTo = Integer.parseInt(args[6]);
		String title = args[7]+ " " + args[8];
		//System.out.println(extension);

		final String query = "insert into employees values(?, ?, ?, ?, ?, ?, ?, ?)";
		
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels?useSSL=false", "root", "");){
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			stmt.setString(2, lname);
			stmt.setString(3, fname);
			stmt.setString(4, extension);
			stmt.setString(5, email);
			stmt.setString(6, officeCode);
			stmt.setInt(7, reportsTo);
			stmt.setString(8, title);
			
			int result = stmt.executeUpdate();
			System.out.println("Records affected: " + result);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
