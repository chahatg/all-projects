package com.chahatg.day1.allProjects;

public class Bank extends Institution {
	
	boolean offersLoan = false;
	
	Bank(String name, boolean offersLoan){
		super(name);
		this.offersLoan = offersLoan;
	}
	
	@Override
	public void sayHi() {
		System.out.println("Demonstrating Overriding: Hi from Bank");
	}
	//overloading
	public void sayHi(String username) {
		System.out.println("Demonstrating Overloading: Hi from Bank to " + username);
	}
}
