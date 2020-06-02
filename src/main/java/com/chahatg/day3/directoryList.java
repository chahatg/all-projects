package com.chahatg.day3;
import java.io.File;
import java.io.ByteArrayInputStream;
public class directoryList {
	public static void main(String[] args) {
		File mainDir = new File("C:\\Users\\Chahat\\eclipse-workspace\\HW3\\src\\ioDirectory");
		File fileList[];
		
		if(mainDir.exists() && mainDir.isDirectory()) {
			fileList = mainDir.listFiles();
			printFiles(fileList, 1);
		}	
	}
	static void printFiles(File[] files, int subLevel) {
		for(File file : files) {
			for(int i = 1; i <= subLevel; i++)
				System.out.print("\t");
			if(file.isFile())
				System.out.println(file.getName());
			else if(file.isDirectory()) {
				File[] subFiles = file.listFiles();
				System.out.println("~Subdirectory~ " + file.getName());
				printFiles(subFiles, (subLevel+1));
			}		
		}
	}
}
