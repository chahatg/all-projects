package com.chahatg.day6;
import java.util.ArrayList;
import java.util.List;


//1.Design a class that acts as a library for
//  the following kinds of media: book, video, 
//  and newspaper. Provide one version of the 
//  class that uses generics and one that does not.

public class MediaLibrary {
	public static void main(String[] args) {
		Book RedRidingHood = new Book("Red Riding Hood");
		Video gangnamStyle = new Video("Gangnam Style Music Video");
		Newspaper dailyTimes = new Newspaper("Daily Times");
		
		RegLib regularLibrary = new RegLib();
		regularLibrary.addItem(RedRidingHood);
		regularLibrary.addItem(dailyTimes);
		Media lastMedia1 = regularLibrary.getLastAdded();
		System.out.println("Last item added to the regular library is: " + lastMedia1.getName());
		
		GenLib genericLibrary = new GenLib();
		genericLibrary.addItem(dailyTimes);
		genericLibrary.addItem(gangnamStyle);
		Media lastMedia2 = genericLibrary.getLastAdded();
		System.out.println("Last item added to the generic library is: " + lastMedia2.getName());

		
	}
}
//non-generic library
class RegLib{
	private List libItems = new ArrayList();
	
	public void addItem(Media item) {
		libItems.add(item);
	}
	public Media getLastAdded() {
		return (Media) libItems.get(libItems.size() - 1);
	}
}

//generic library
class GenLib<T extends Media>{
	private List<T> libItems = new ArrayList<T>();
	
	public void addItem(T item) {
		libItems.add(item);
	}
	public T getLastAdded() {
		return libItems.get(libItems.size() - 1);
	}
}

interface Media {
	public String getName();
}

class Book implements Media{
	String name;
	
	Book(String name){
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}

class Video implements Media{
	String name;
		
	Video(String name){
		this.name = name;
	}
		
	public String getName() {
		return this.name;
	}
}

class Newspaper implements Media{
	String name;
	
	Newspaper(String name){
		this.name = name;
	}
		
	public String getName() {
		return this.name;
	}
}