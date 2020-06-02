package com.chahatg.day11;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
//2.) Create your own functional interface for comparator to compare two objects 

public class FunctionalInterfaceComp {
	public static void  main(String[] args) {
		List<Product1> products = new ArrayList<Product1>();
		products.add(new Product1("ball", 25.0));
		products.add(new Product1("bat", 145.99));
		products.add(new Product1("racket", 20.50));
		products.add(new Product1("cleats", 110.0));
		products.add(new Product1("shinguards", 40.0));
		
		Comparator<Product1> cName = (p1,p2) -> (p1.getName().compareTo(p2.getName()));
		Comparator<Product1> cPrice = (p1,p2) -> (p1.getPrice().compareTo(p2.getPrice()));
		
		//List<Product1> sortedByName = 
		System.out.println("\nSorted By Name");
		products.stream().sorted(cName).forEach((product)->System.out.println(product.getName() + " : " + product.getPrice()));
		
		System.out.println("\nSorted By Price");
		products.stream().sorted(cPrice).forEach((product)->System.out.println(product.getName() + " : " + product.getPrice()));
				
			//.collect(Collectors.toList());
		//System.out.println("Sorted By Price: " + sortedByPrice);
		
		Comparator<Product1> c = Comparator.comparing(Product1::getPrice).thenComparing(Product1::getName);
		//List<Product1> sortedProducts = 
		System.out.println("\nSorted By Price, then Name");
		products.stream().sorted(cPrice).forEach((product)->System.out.println(product.getName() + " : " + product.getPrice()));
		//collect(Collectors.toList());
		//System.out.println("Sorted By Name, then Price: " + sortedProducts);
	}
}

class Product1 {
	String name;
	Double price;
	
	public Product1(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
}