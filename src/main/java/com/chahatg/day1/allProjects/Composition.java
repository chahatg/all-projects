package com.chahatg.day1.allProjects;

public class Composition {
	public static void main(String[] args) {
		
		House house = new House();
		System.out.println("House cannot NOT have a " + house.getRoom().type);
		System.out.println(house.getRoom().type + " cannot exist without a House");

	}
}

class Room{
	String type;
	
	Room(String type){
		this.type = type;
	}
}

class House {
	private final Room room;
	
	public House(){
		this.room = new Room("bathroom");
	}

	public Room getRoom() {
		return room;
	}

}

