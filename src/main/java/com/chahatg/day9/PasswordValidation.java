package com.chahatg.day9;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*1.) Create a password validator using regex should have criteria 
 *like min length 8, max 15, no 3 consecutive char , atleast 1 
 *alphabet and number and special char */

public class PasswordValidation {
	public static void main(String[] args) {
		List<String>  passwords = Arrays.asList("1mc2sT3r@in4ing", "hn%%fh35", "chad67hr@#", "dfgevg45r67##78*gfd", "567895678", "$%$%^%^%", "8y%8");
		
		String regex = "^(?=.*\\d)(?=.*\\W)(?=.\\w)(?:(.)(?!\\1\\1)).{7,14}$"; //(?!.*...)
		Pattern p = Pattern.compile(regex);
		
		for(String pw : passwords) {
			Matcher m = p.matcher(pw);
			if(m.matches()) {
				System.out.println(pw + " - Acceptable password" );
			}
			else {
				System.out.println(pw + " - Not Acceptable password");
			}
		}
		
	}
}
