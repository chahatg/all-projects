package com.chahatg.day8;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


/*6. Write a program to read directories and files and list the number of total files.
 * , each type files count like 4 .doc files , 10 .txt files . and distinct how many 
 * type of file available in the folder..  like 3 type of files .doc, .txt, .jpg
 */


public class FileTypeCount {
	
	public static void main(String[] args) throws IOException {
		File folder = new File(args[0]);
		File[] fileList = folder.listFiles();
		List<File> files = Arrays.asList(fileList);
		countFileType(files);
	}
	
	public static void countFileType(List<File> files) throws IOException{
		HashMap<String, Integer> filetypes = new HashMap<String, Integer>();
		String retVal = "";
		for(File file : files) {
			retVal = Files.probeContentType(file.toPath());
			
			if(!filetypes.containsKey(retVal)) {
				if(file.isDirectory() && retVal == null) {
					filetypes.put("sub-directory", 1);
				}
				else {
					filetypes.put(retVal, 1);
				}
				
			}
			else {
				if(file.isDirectory() && retVal == null) {
					filetypes.put("sub-directory", filetypes.get("sub-directory") + 1);
				}
				else {
					filetypes.replace(retVal, (filetypes.get(retVal) + 1));
				}
			}
		}
		System.out.println("Number of  files of type: " + filetypes);
		System.out.println("Count of different file types: " + filetypes.size());
		
	}
}
