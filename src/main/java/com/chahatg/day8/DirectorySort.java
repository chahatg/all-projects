package com.chahatg.day8;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*5. Write a program to read the directories and files, subdirectories..
 *create a sort by method based on filename,  date, file type in asc, desc.
 *The input to sort should be through console.
 *
 *6. Write a program to read directories and files and list the number of total files., each type files count like 4 .doc files , 10 .txt files . and distinct how many type of file available in the folder..  like 3 type of files .doc, .txt, .jpg
*/
public class DirectorySort {
	public static void main(String[] args) {
		File folder = new File(args[0]);
		File[] fileList = folder.listFiles();
		List<File> files = Arrays.asList(fileList);
		int i = 0;
		//sort by filename
		sortFiles(files, "fileNameAsc");
		System.out.println("Files sorted by file name ascending: ");
		for(i = 0; i < files.size(); i++) {
			System.out.print(files.get(i).getName() + ", ");
		}
		
		sortFiles(files, "fileNameDesc");
		System.out.println("\n\nFiles sorted by file name descending: ");
		for(i = 0; i < files.size(); i++) {
			System.out.print(files.get(i).getName() + ", ");
		}
		
		sortFiles(files, "dateModifiedAsc");
		System.out.println("\n\nFiles sorted by date modified descending: ");
		for(i = 0; i < files.size(); i++) {
			System.out.print(files.get(i).getName() + ", ");
		}
		
		sortFiles(files, "dateModifiedDesc");
		System.out.println("\n\nFiles sorted by date modified ascending: ");
		for(i = 0; i < files.size(); i++) {
			System.out.print(files.get(i).getName() + ", ");
		}
		
		sortFiles(files, "fileTypeAsc");
		System.out.println("\n\nFiles sorted by file type ascending: ");
		for(i = 0; i < files.size(); i++) {
			System.out.print(files.get(i).getName() + ", ");
		}
		

		
	}
	
	public static void sortFiles(List<File> files, String sortByParameter) {
		switch(sortByParameter) {
		
		case "fileNameAsc":
			Collections.sort(files, new Comparator<File>() {
				@Override
				public int compare(File f1, File f2) {
					return String.valueOf(f1.getName()).compareTo(f2.getName());
				}
			});
			break;
		case "fileNameDesc":
			Collections.sort(files, Collections.reverseOrder(new Comparator<File>() {
				@Override
				public int compare(File f1, File f2) {
					return String.valueOf(f1.getName()).compareTo(f2.getName());
				}
			}));
			break;
		case "dateModifiedAsc":
			Collections.sort(files, new Comparator<File>() {
				@Override
				public int compare(File f1, File f2) {
					return Long.valueOf(f1.lastModified()).compareTo(f2.lastModified());
				}
			});
			break;
		case "dateModifiedDesc":
			Collections.sort(files, Collections.reverseOrder(new Comparator<File>() {
				@Override
				public int compare(File f1, File f2) {
					return Long.valueOf(f1.lastModified()).compareTo(f2.lastModified());
				}
			}));
			break;
		case "fileTypeAsc":
			Collections.sort(files, new Comparator<File>() {
				@Override
				public int compare(File f1, File f2) {
					String f1ProbeContent = null, f2ProbeContent = null;
					try {
						f1ProbeContent = Files.probeContentType(f1.toPath());
						f2ProbeContent = Files.probeContentType(f2.toPath());
					}	
					catch(IOException e) {
						e.printStackTrace();
					}
					if (f1ProbeContent == null) {
						f1ProbeContent = "probeContentTypeIsNull";
			        }
			        if (f2ProbeContent == null) {
			            f2ProbeContent = "probeContentTypeIsNull";
			        }
					return String.valueOf(f1ProbeContent).compareTo(f2ProbeContent);
				}
			});
		
		}
	}

}
