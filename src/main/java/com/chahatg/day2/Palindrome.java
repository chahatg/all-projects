package com.chahatg.day2;
// 5.Given a string s, find the longest palindromic 
//   substring in s. You may assume that the 
//   maximum length of s is 1000.



public class Palindrome {
	public static void main(String[] args) {   
        String str = "abcbab"; 
        System.out.println("Length is: " +  longestPalindrome(str)); 
    } 
	
	static int longestPalindrome(String str) { 
	    int len= str.length();   // get length of input string 
	
	    boolean arr[][] = new boolean[len][len]; 
	 
	    int maxLen = 1; 
	    for (int i = 0; i < len; i++) 
	        arr[i][i] = true; 
	
	    // check for sub-string of length 2. 
	    int start = 0; 
	    for (int i = 0; i < len - 1; i++) { 
	        if (str.charAt(i) == str.charAt(i + 1)) { 
	            arr[i][i + 1] = true; 
	            start = i; 
	            maxLen = 2; 
	        } 
	    } 
	      
	    for (int k = 3; k <= len; ++k) { 
	          
	        for (int i = 0; i < len - k + 1; ++i)  
	        { 
	            
	            int j = i + k - 1; 
	 
	            if (arr[i + 1][j - 1] && str.charAt(i) ==  
	                                      str.charAt(j)) { 
	                arr[i][j] = true; 
	
	                if (k > maxLen) { 
	                    start = i; 
	                    maxLen = k; 
	                } 
	            } 
	        } 
	    } 
	    System.out.print("Longest palindromic substring is: ");
	    System.out.println(str.substring(start, (start + maxLen - 1) + 1)); 
	      
	    return maxLen;
	} 
}

