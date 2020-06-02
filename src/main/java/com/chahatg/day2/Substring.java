package com.chahatg.day2;
//4. Given a string, find the length of 
//   the longest substring without repeating.


public class Substring {
	public static void main(String[] args) {
		String str = args[0];
		
		char[] charArr = str.toCharArray();
		int temp = 0;
		int currentSubLength = 0;
		for(int i = 0; i < str.length() -1; i++) {
			if(str.charAt(i) != str.charAt(i+1)) {
				currentSubLength++;
				/*if(i == (str.length() - 1)) {
					currentSubLength++;
				}*/
			}
			else {
				currentSubLength++;
				if(temp < currentSubLength) {
					temp = currentSubLength;
				}
				currentSubLength = 0;
				continue;
			}
		}
		if(temp < currentSubLength) {
			temp = currentSubLength;
		}
		System.out.println("Length of longest substring is: " + temp);
	}
}
