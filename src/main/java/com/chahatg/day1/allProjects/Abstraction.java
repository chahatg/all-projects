package com.chahatg.day1.allProjects;

public class Abstraction {
	public static void main(String[] args) {
		Level1 candyland = new Level1(1, "candyland");
		candyland.initializeLevel();
		Entity e1 = new blueMonster("gru", "flying", 5, 7);
		e1.doSomething();
		candyland.destroyLevel();
	}
}


abstract class Entity{
	String name;
	String skill;
	int strength; //out of 10
	public Entity(String name, String skill, int strength){
		this.name = name;
		this.skill = skill;
		this.strength = strength;
	}
	
	abstract void doSomething();
}

class blueMonster extends Entity{
	int badness; //out of 10
	blueMonster(String name, String skill, int strength, int badness){
		super(name, skill, strength);
		this.badness = badness;
	}
	
	@Override
	void doSomething() {
		System.out.println("blueMonster did something");
	}
	
	
}


//complete abstraction
class Level1 implements Level{
	int levelNum;
	String location;
	
	Level1(int levelNum, String loc){
		this.levelNum = levelNum;
		this.location = loc;
	}
	
	public void initializeLevel() {
		System.out.println("Level " + levelNum + ": " + location + " initialized");
	}
	
	public void destroyLevel() {
		System.out.println("Level " + levelNum + ": " + location + " destroyed");

	}
}