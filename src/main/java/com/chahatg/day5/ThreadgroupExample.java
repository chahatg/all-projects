package com.chahatg.day5;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Thread;
import java.lang.ThreadGroup;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//4.) Using Thread groups create a application which
//performs.. group of tasks related to each other like.. 
//reading a file and copying to another file.. 
//another group to write the  file content to DB

public class ThreadgroupExample {
	public static final FileClass fileclass = new FileClass();
	public static final Databases db = new Databases();
	public static void main(String[] args) {
		ThreadGroup FileOps = new ThreadGroup("File Operations Group");
		ThreadGroup DataEntry = new ThreadGroup("Data Entry into DB");
		Runnable read = () -> { 
			fileclass.readFile();
		};
		Runnable write = () -> {
			fileclass.copyToFile();
		};
		Runnable getData = () -> {
			db.readData();
		};
		Runnable enterData = () -> {
			db.writeData();
		};
		Thread t1 = new  Thread(FileOps, read);
		Thread t2 = new Thread(FileOps, write);
		Thread t3 = new Thread(DataEntry, getData);
		Thread t4 = new Thread(DataEntry, enterData);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		System.out.println("Active FileOps threads: " + FileOps.activeCount());
		System.out.println("Ative DataEntry threads: " + DataEntry.activeCount());
	}
}

class Employee{
	int id;
	String lname;
	String fname;
	String extension;
	String email;
	String officeCode;
	int reportsTo;
	String title;
	
	public Employee(String line) {
		String[] values = line.split("\t");
		id = Integer.parseInt(values[0]);
		lname = values[1];
		fname = values[2];
		extension = values[3];
		email = values[4];
		officeCode = values[5];
		reportsTo = Integer.parseInt(values[6]);
		title = values[7];
	}
}

class FileClass {
	StringBuilder sb = new StringBuilder();
	String content;
	synchronized public void readFile() {
		System.out.println("thread 1 running...");
		File file1 = new File("C:\\Users\\Chahat\\eclipse-workspace\\multithreading-practice\\src\\files\\input.txt");
		
		try(FileReader in = new FileReader(file1);
			BufferedReader bin = new BufferedReader(in);){
			//reading file1
			if(!file1.exists()) {
				file1.createNewFile();
			}
			
	        String line = bin.readLine();
			
			while(line!= null) {
				sb.append(line);
				line = bin.readLine();
			}
			content = sb.toString();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	synchronized public void copyToFile() {
		System.out.println("thread 2 running...");
		File file2 = new File("C:\\Users\\Chahat\\eclipse-workspace\\multithreading-practice\\src\\files\\output.txt");
		
		try(FileWriter out1 = new FileWriter(file2);
			BufferedWriter bout1 = new BufferedWriter(out1);){
				//writing to file1
				if(!file2.exists()) {
					file2.createNewFile();
				}
				System.out.println("i have access to content: " + content);
				bout1.write(content);
			}
			catch(IOException e){
				e.printStackTrace();
			}
	}
	
	
}

class Databases {
	StringBuilder sb = new StringBuilder();
	String content;
	Employee employee;
	
	synchronized public void readData() {
		System.out.println("thread 3 running...");
		File file = new File("C:\\Users\\Chahat\\eclipse-workspace\\multithreading-practice\\src\\files\\data.txt");
		try(FileReader in = new FileReader(file);
			BufferedReader bin = new BufferedReader(in);){
				//reading file1
				if(!file.exists()) {
					file.createNewFile();
				}
				
				String line = bin.readLine();
				while(line!= null) {
					sb.append(line);
					line = bin.readLine();
				}
				
				content = sb.toString();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	synchronized public void writeData() {
		System.out.println("thread 4 running...");

		final String query = "insert into employees values(?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			if(content ==  null) {
				Thread.sleep(5000);
			}
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		
		employee = new Employee(content);
		
		
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels?useSSL=false", "root" , "");){
			int k;
			
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, employee.id);
			pst.setString(2, employee.lname);
			pst.setString(3, employee.fname);
			pst.setString(4, employee.extension);
			pst.setString(5, employee.email);
			pst.setString(6, employee.officeCode);
			pst.setInt(7, employee.reportsTo);
			pst.setString(8, employee.title);
			k = pst.executeUpdate();
			System.out.println("Records affected: " + k + employee.fname);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
		
}

