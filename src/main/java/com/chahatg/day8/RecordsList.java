package com.chahatg.day8;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/*List of 1 to 100 records should be printed in reverse
 *(100 to 1) without using loops, or in built apis, function.*/

public class RecordsList {
	public static void main(String[] args) {
		List<Integer> records = new CopyOnWriteArrayList<Integer>();
		//using for loop to populate the list
		for(int i = 1; i <=100; i++) {
			records.add(i);
		}
		int i = records.size();
		
		List<Integer> temp = reverseList(records);
		
		print(temp.size() - 1, temp);
	}
	
	public static List<Integer> reverseList(List<Integer> list) {
		Collections.reverse(list);
		return list;
	}
	
	public static void print(int i, List<Integer> list) {
		if(i >= 0) 
        { 
            print(i - 1, list);
            System.out.println("Record: " + list.get(i));
        } 
	}
}

