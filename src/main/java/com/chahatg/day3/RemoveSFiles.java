package com.chahatg.day3;
//5.) Write a program to remove files starting
//    with letter S or s in a folder.

//6.) Create own custom exception class with 
//    real time example.

import java.io.File;

public class RemoveSFiles {
	public static void main(String[] args) {
		File mainDir = new File("C:\\Users\\Chahat\\eclipse-workspace\\HW3\\src\\ioDirectory");
		File[] fileList = mainDir.listFiles();
		
		for(File file : fileList) {
			if(file.isFile() && (file.getName().startsWith("s") || file.getName().startsWith("S"))) {
				file.delete();
			}
		}
	}
}


