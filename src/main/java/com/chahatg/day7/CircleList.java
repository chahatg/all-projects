package com.chahatg.day7;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
import java.math.BigDecimal;
import java.math.MathContext;


/*1.Make a List of Circle objects. Use a random radius. 
 * Keep adding circles to the list until Math.random() 
 * returns less than 0.01. Then, loop down the list and 
print out each area. If you do not have a good Circle 
class to use, steal mine from the shapes3 package of the
oop-advanced project.
*/

public class CircleList {
	public static final BigDecimal REQUIRED_RADIUS = new BigDecimal(0.01); 
	public static void main(String[] args) {
		
		List<Circle> circles = new ArrayList<Circle>();
		
		BigDecimal radius;
		BigDecimal temp =  new BigDecimal("" + Math.random());
		radius = temp.round(new MathContext(2));
		double area = 0.0;
		while(REQUIRED_RADIUS.compareTo(radius) != 1) {
			circles.add(new Circle(radius));
			area = Math.PI*Math.pow(radius.doubleValue(), 2);
			System.out.println("Circle - Radius: " + radius + ", Area: "+ area);
			temp =  new BigDecimal("" + Math.random());
			radius = temp.round(new MathContext(2));
		}
		System.out.println("Circle - Radius: " + radius + ", Area: "+ area);
		System.out.println("found radius less that 0.01");
		
	}

}

class Circle{
	private BigDecimal radius;
	
	public Circle(BigDecimal rad) {
		this.radius = rad;
	}

	public BigDecimal getRadius() {
		return radius;
	}

	public void setRadius(BigDecimal radius) {
		this.radius = radius;
	}
	
	
}

