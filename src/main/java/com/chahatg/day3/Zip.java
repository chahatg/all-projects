package com.chahatg.day3;
// 4.) Write a program to zip files in separate
//     zip file and folders in separate zip file.

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;



public class Zip {
	public static void main(String[] args) {
		File mainDir = new File("C:\\Users\\Chahat\\eclipse-workspace\\HW3\\src\\ioDirectory");
		if(mainDir.exists() && mainDir.isDirectory()) {
			zipFiles(mainDir);
		}	
		
	}
	
	public static void zipFiles(File dir) {
		try(FileOutputStream fosFile = new FileOutputStream("C:\\Users\\Chahat\\eclipse-workspace\\HW3\\src\\ioDirectory\\files.zip");
			ZipOutputStream zosFile = new ZipOutputStream(fosFile);
			FileOutputStream fosDir = new FileOutputStream("C:\\Users\\Chahat\\eclipse-workspace\\HW3\\src\\ioDirectory\\dirs.zip");
			ZipOutputStream zosDir = new ZipOutputStream(fosDir);
			){
			
			File[] fileList = dir.listFiles();
			byte[] bytes;
			
			for(File file : fileList) {
				if(file.isFile()) {
					zosFile.putNextEntry(new ZipEntry(file.getName()));
					bytes = new byte[1024];
					zosFile.write(bytes, 0, bytes.length);
				}
				else if(file.isDirectory()) {
					zosDir.putNextEntry(new ZipEntry(file.getName()));
					bytes = new byte[1024];
					zosDir.write(bytes, 0, bytes.length);
				}
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}