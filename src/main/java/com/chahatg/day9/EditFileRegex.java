package com.chahatg.day9;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*2.) Read a file containing text of 100 or more  lines find a 
 *particular text using regex and change the font and highlight
 *the text and save it in same file.
*/
public class EditFileRegex {
	public static void main(String[] args) {
		File file = new File("C:\\Users\\Chahat\\eclipse-workspace\\RegexNLogging\\src\\input.txt");
		if(!file.exists()) {
			System.out.println("File not found");
			System.exit(0);
		}
		String regex = "^We will.*$";
		Pattern p = Pattern.compile(regex);
	
		try(FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);){
			
			String l;
			while((l = br.readLine()) != null) {
				Matcher m = p.matcher(l);
				if(m.matches()) {
					
				}
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
