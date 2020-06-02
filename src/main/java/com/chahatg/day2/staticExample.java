package com.chahatg.day2;
//2. Create a single program having static variables,  
//   static block and static method
import java.time.LocalDateTime;    


public class staticExample {
	
	static {   //static block
		System.out.println("Welcome to the staticExample class");
		System.out.println("It is " + LocalDateTime.now().getDayOfWeek() + "\n");
		Object.howManyObjectInstances();
	}
	
	public static void main(String args[]) {
		
		Object o1 = new Object(2,5);
		Object o2 = new Object(5,9);
		Object o3 = new Object(7,7);
		Object.howManyObjectInstances();
		Object o4 = new Object(3,6);
		Object.howManyObjectInstances();
	}
}

class Object {
	static int objCounter; //static variable
	int a;
	int b;
	Object(int a, int b){
		objCounter = objCounter + 1;
		this.a = a;
		this.b = b;
		System.out.println("Object created");
	}
	
	public static void howManyObjectInstances() { //static method
		System.out.println("Object Count: " + objCounter);
	}
}