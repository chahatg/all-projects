package com.chahatg.day7;
/*3. Restricting a class from creating multiple objects or restricting
 * 	 class from creating not more than three objects*/

public class RestrictObjCreation {
	public static void main(String[] args) {
		for(int i = 0; i < 5; i++) {
			new Obj();
		}
		
		
	}
}

class Obj{
	static int objCounter;
	String name;
	
	public Obj() {
		if(objCounter < 3) {
			this.name = "Default Obj " + objCounter;
			objCounter++;
			System.out.println(name + " created");
		}
		else {
			System.out.println("Sorry, cannot create more than three Obj instances!");
		}
	}
	
	public Obj(String name) {
		if(objCounter < 3) {
			this.name = name;
			objCounter++;
			System.out.println(name + " created");
		}
		else {
			System.out.println("Sorry, cannot create more than three Obj instances!");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
