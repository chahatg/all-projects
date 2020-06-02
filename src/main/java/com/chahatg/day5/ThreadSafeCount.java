package com.chahatg.day5;
//3.) Create a thread safe counter where it
//counts the no of persons entering in different 
//entries of hall. 

import java.util.concurrent.atomic.AtomicInteger;

import org.w3c.dom.css.Counter;

public class ThreadSafeCount {
	public static final Person person = new Person();
	public static void main(String[] args) {
	
		Runnable task = () -> {
			for(int i = 0; i < 5; i++) {
				AtomicInteger count = person.walkThruHall();
				System.out.println(Thread.currentThread().getName() + " Number of persons: " + count);
			}
		};
		
		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		Thread t3 = new Thread(task);
		t1.start();
		t2.start();
		t3.start();

	}
}

class Person {
	static AtomicInteger counter = new AtomicInteger();
	public AtomicInteger walkThruHall() {
		System.out.println(Thread.currentThread().getName() + " Another person walked through..");
		counter.getAndIncrement();
		return counter;
	}
}
