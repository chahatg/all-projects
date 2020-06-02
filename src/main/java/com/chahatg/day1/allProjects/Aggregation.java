package com.chahatg.day1.allProjects;
import java.util.ArrayList;
import java.util.List;

public class Aggregation {
	public static void main(String[] args) {
		Department d1 = new Department("Sales", 25);
		Department d2 = new Department("IT", 12);
		Department d3 = new Department("Manufacturing", 50);
		List<Department> departments = new ArrayList<Department>();
		departments.add(d1);
		departments.add(d2);
		departments.add(d3);
		
		Company c = new Company("Wire Inc.", departments);
		System.out.println(c.name + " has " + c.getDepts().size() + " departments");
		
	}
}

class Department{
	String name;
	int numOfEmployees;
	
	Department (String name, int num){
		this.name = name;
		this.numOfEmployees = num;
	}
	
}

class Company{
	String name;
	List<Department> depts;
	
	Company(String name, List<Department> depts){
		this.name = name;
		this.depts = depts;
	}

	public List<Department> getDepts() {
		return depts;
	}

	
	
}