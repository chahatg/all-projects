package com.chahatg.day11;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//3.) Write a program filter based on names and sort it then collect 
//the result in a set .which uses java 8 map, filter, collect..  

public class MapFilterCollect {
	public static void main(String[] args) {
		List<Person> people = new ArrayList<Person>();
		people.add(new Person("Rahul", 28));
		people.add(new Person("Aashna", 22));
		people.add(new Person("Sanya", 19));
		people.add(new Person("Sidharth", 26));
		people.add(new Person("Ayush", 24));
		people.add(new Person("Ria", 23));
		
		List<String> filteredPeople = people.stream().filter(p->(p.getName() == "Rahul" || p.getName() == "Sidharth" || p.getName() == "Ayush"))
				.sorted(Comparator.comparing(Person::getName)).map(Person::getName).collect(Collectors.toList());
		
		System.out.println(filteredPeople);
	}
}

class Person{
	String name;
	int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age =  age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}