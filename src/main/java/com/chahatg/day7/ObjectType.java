package com.chahatg.day7;
import java.util.ArrayList;

/*2. Create a new type of container that uses a private ArrayList
 *  to hold the objects. Using a class reference, capture the type
 *  of the first object you put in it, and then allow the user to 
 *  insert objects of only that type from then on.*/

public class ObjectType {
	public static void main(String[] args) {
		MyContainer mc= new MyContainer(new String("hello"));
		System.out.println("You can only enter " + mc.getObjectType() + " type now");
		
		mc.addObject(23);
		mc.addObject(new String("success"));
		
		
		
	}
}

class MyContainer<T extends Object>{
	private ArrayList<T> objList;
	
	public MyContainer(T obj) {
		objList = new ArrayList<T>();
		objList.add(obj);
	}
	
	public String getObjectType() {
		T obj = objList.get(0);
		String type = obj.getClass().getName();
		return type;
	}
	
	public void addObject(T t) {
		System.out.println("t type = " + t.getClass());
		System.out.println("first obj type = " + objList.get(0).getClass());
		if(!t.getClass().isAssignableFrom(objList.get(0).getClass())) {
			System.out.println("Sorry this Object list can only accept " + objList.get(0).getClass().getName() + " class objects only!");
		}
		else {
			if(objList.add(t))
				System.out.println("Object added!");
		}
	}
	
	
}