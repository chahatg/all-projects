package com.chahatg.day3;
//2.) Create a program to write file using 
//    character stream and copy the 1st 2 lines of the file to another file

//3.) Write a program with multiple resources
//    in try block using try with resources 


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class charStreamIO {
	public static void main(String[] args) {
		File file1 = new File("C:\\Users\\Chahat\\eclipse-workspace\\HW3\\src\\ioDirectory\\output.txt");
		File file2 = new File("C:\\Users\\Chahat\\eclipse-workspace\\HW3\\src\\ioDirectory\\input.txt");
		
		String line1 = "This is my output using Character Stream. Success.";
		String line2 = "This is the Second line.";
		String line3 = "This is the third line.";
		
		try(FileWriter out1 = new FileWriter(file1);
			BufferedWriter bout1 = new BufferedWriter(out1);){
			//writing to file1
			if(!file1.exists()) {
				file1.createNewFile();
			}
			bout1.write(line1);
			bout1.newLine();
			bout1.write(line2);
			bout1.newLine();
			bout1.write(line3);
			bout1.newLine();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		try(FileReader in = new FileReader(file1);
			BufferedReader bin = new BufferedReader(in);
			FileWriter out2 = new FileWriter(file2);
			BufferedWriter bout2 = new BufferedWriter(out2);){
			//reading file1
			if(!file2.exists()) {
				file2.createNewFile();
			}
			String l;
			int i =0;
			while((l=bin.readLine())!= null && i<2) {
				bout2.write(l);
				bout2.newLine();
				i++;
			}
			
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
				
	}
}
