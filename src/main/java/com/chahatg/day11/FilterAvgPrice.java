package com.chahatg.day11;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//1.) Write a program to filter list of products based on price and get
//the average of the price using java 8.

public class FilterAvgPrice {
	public static void main(String[] args) {
		List<Product> products = new ArrayList();
		products.add(new Product("ball", 25.0f));
		products.add(new Product("bat", 145.99f));
		products.add(new Product("racket", 20.50f));
		products.add(new Product("cleats", 110.0f));
		products.add(new Product("shinguards", 40.0f));
		System.out.println("List of Products: " + products);
		List<Float> productPriceList = products.stream().map(Product::getPrice).collect(Collectors.toList());
		System.out.println("List of Prices: " + productPriceList);
		Double avgPrice = productPriceList.stream().mapToDouble(m -> m.doubleValue()).average().getAsDouble();
		System.out.println("Average Price: " + avgPrice);
		
	}
}

class Product {
	String name;
	float price;
	
	public Product(String name, float price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
}