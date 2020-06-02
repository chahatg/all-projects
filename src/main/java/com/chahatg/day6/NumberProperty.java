package com.chahatg.day6;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

//2.Write a generic method to count the number of
//  elements in a collection that have a specific 
//  property (e.g., odd integers, prime numbers, palindromes).

public class NumberProperty {
	public static void main(String[] args) {
			Collection<Integer> numList = Arrays.asList(1, 12, 3, 8, 9, 11, 5, 99, 54);
			Collection<String> strList = Arrays.asList("hello", "abccba", "helleh", "world", "chaahc");
			
			System.out.println("Odd number count: " + CountTypes.count(numList, new Odd()));
			System.out.println("Prime number count: " + CountTypes.count(numList, new Prime()));
			System.out.println("Palindrome count: " + CountTypes.count(strList, new Palindrome()));
			
	}
}

class CountTypes{
	public static <T> int count(Collection<T> c, Property<T> p) {
		int counter = 0;
		for(T t : c) {
			if(p.checkProperty(t))
				counter++;
		}
		return counter;
	}
}

interface Property<T>{
	public boolean checkProperty(T t);

}

class Odd implements Property<Integer>{
	public boolean checkProperty(Integer num) {
		if(num % 2 == 0)
			return false;
		else
			return true;
	}
}

class Prime implements Property<Integer>{
	public boolean checkProperty(Integer num) {
		 
        if (num <= 1) return false; 
      
        for (int i = 2; i < num; i++) 
            if (num % i == 0) 
                return false; 
        
        return true; 
	}
}

class Palindrome implements Property<String>{

	@Override
	public boolean checkProperty(String str) {
		 int startItr = 0, endItr = str.length() - 1; 
		  
	        while (startItr < endItr) { 
	  
	            if (str.charAt(startItr) != str.charAt(endItr)) 
	                return false; 
	            
	            startItr++; 
	            endItr--; 
	        } 
	  
	        // Given string is a palindrome 
	        return true; 
	}
	
}