package com.chahatg.day1.allProjects;

public class oopsConcepts {
	public static void main(String[] args) {
		Person justAPerson = new Person("Raj", 23);
		Student student1 = new Student("Asha", 19, "CS", 5);
		Professor prof1 = new Professor("Rajiv", 45, "Physics", 35);
		
		System.out.println(prof1.name + " teaches " + student1.name + "( " + student1.major + "major) " + prof1.subject);
		
		//encapsulation
		System.out.println(student1.name + " is enrolled in " + student1.getClassesEnrolled() + " classes.");
		System.out.println(prof1.name + " teaches " + prof1.getStudentsTaught() + " students.");
		
		System.out.println(justAPerson.name + "is just a random person");
		
		//polymorphism
		Institution inst = new Institution("org");
		Institution bofa = new Bank("Bofa", true);
		Bank tdbank = new Bank("TD", true);
		//overriding
		inst.sayHi();
		bofa.sayHi();
		tdbank.sayHi("Ritu"); //overloading
		
		
	}
}

class Person{
	String name;
	int age;
	
	Person(String name, int age){
		super();
		this.name = name;
		this.age = age;
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

class Professor extends Person{ //inheritance
	String subject;
	private int studentsTaught;
	
	Professor(String name, int age, String subject, int students){
		super(name, age);
		this.subject = subject;
		this.studentsTaught = students;
	}
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getStudentsTaught() {
		return studentsTaught;
	}

	public void setStudentsTaught(int studentsTaught) {
		this.studentsTaught = studentsTaught;
	}

}

class Student extends Person{ //inheritance
	String major;
	private int classesEnrolled;
	
	Student(String name, int age, String major, int classes){
		super(name, age);
		this.major = major;
		this.classesEnrolled = classes;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getClassesEnrolled() {
		return classesEnrolled;
	}

	public void setClassesEnrolled(int classesEnrolled) {
		this.classesEnrolled = classesEnrolled;
	}
	
}