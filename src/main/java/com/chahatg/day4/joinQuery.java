package com.chahatg.day4;
//3.) Create multiple tables, and fetch the records
//    using join query in java and update the date 
//    in one of the table using date function 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Date;

public class joinQuery {
	public static void main(String[] args) {
		final String query = "SELECT o.orderNumber, c.customerName, o.orderDate, o.status FROM Orders o INNER JOIN Customers c ON o.customerNumber=c.customerNumber limit 15;";
		final String updateQ = "update orders set requiredDate = ? where (customerNumber = ? and orderNumber = ?);";
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels?useSSL=false", "root", "");){
			
			Statement st = con.createStatement();		
			PreparedStatement pst = con.prepareStatement(updateQ);
			String str="2004-01-01";  
		    java.sql.Date newDate=Date.valueOf(str);
			pst.setDate(1, newDate);
			pst.setInt(2, 103);
			pst.setInt(3, 10123);
			
			ResultSet rs = st.executeQuery(query);
			System.out.println("~~~~~~~~~~~~ Orders records with Customer Name ~~~~~~~~~~~~ \n");
			String sf=String.format("%7s %25s %11s %8s","orderNumber", "customerName" , "orderDate", "status");
			System.out.println(sf);
			while(rs != null && rs.next()) {
				int id = rs.getInt(1);
				String customer = rs.getString(2);
				Date date = rs.getDate(3);
				String status = rs.getString(4);
				String sf1=String.format("%7s %30s %11s %8s",id, customer, date, status);  
				System.out.println(sf1);
			}
			
			int updated = pst.executeUpdate();
			System.out.println("Records affected by date change: " + updated);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
