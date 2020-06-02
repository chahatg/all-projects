package com.chahatg.day4;
//1.) Create a database connection and fetch
//    the results from the DB using JDBC API

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import com.mysql.cj.xdevapi.Statement;

public class SimpleJDBC {
	public static void main(String[] args) {
		final String query = "select firstName, lastName, jobTitle from employees limit 6;";
		
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels?useSSL=false", "root" , "L@vemus1c");){
			Statement stmt = con.createStatement();
			
			ResultSet result = stmt.executeQuery(query);
			System.out.println("Query Result :- \n" );
			while(result.next()) {
				String fname = result.getString(1);
				String lname = result.getString(2);
				String title = result.getString(3);
				System.out.println(fname + " " + lname + " is " + title);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
}
