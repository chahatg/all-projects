package com.chahatg.day2;
//import java.util.List;
//import java.util.ArrayList;

public class IntWrapper {
	public static void main(String[] args) {
		int num1 = 12, num2 = 45;
		String str = "4632";
		
		Integer n1 = num1;
		Integer n2 = Integer.valueOf(num2);
		
		//List<Integer> numList = new ArrayList();
		//numList.add(number);	
		
		System.out.println("Number 1 = " + n1);
		System.out.println("Number 2 = " + n2);
		System.out.println("String-number is " + str);

		String n1Str = n1.toString();
		System.out.println("Number 1 converted to string: " + n1Str);
		
		String n1HexStr = Integer.toHexString(n1);
		System.out.println("Number 1 converted to Hex string representation: " + n1HexStr);
		//System.out.println("Hex string back to Integer: " + Integer.decode(n1HexStr));
		
		Integer strToInteger = Integer.valueOf(n1Str);
		System.out.println("Number 1 converted from string format to Interger object: " + strToInteger);
		
		System.out.println("String Number converted from string to primitive int: " + Integer.parseInt(str));
		
		System.out.println("Comparing " + n1 + "(Integer object)  and " + num1 + "(int type) returns " + n1.compareTo(num1));
		
		System.out.println("Comparing " + n1 + "(Integer object)  and " + num1 + "(int type) returns " + n1.equals(num1));
		
		System.out.println("Comparing " + n1 + "(Integer object)  and " + n2 + "(int type) returns " + n1.equals(n2));
		
		System.out.println("Converting " + n2 + "(Integer object) to primitive double" + n2.doubleValue());
		
	}
	
}
