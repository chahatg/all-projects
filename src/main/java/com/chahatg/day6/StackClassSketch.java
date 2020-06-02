package com.chahatg.day6;
import java.util.EmptyStackException;

//3. Sketch the class definition and method signatures 
//for a Stack class, parameterized by the type of element on the
//stack. Give the method signatures for push, pop, and isEmpty.

public class StackClassSketch {
	public static void main(String[] args) {
		Stack<Integer> intStack = new Stack<Integer>(15);
		Stack<String> strStack = new Stack<String>(12);
		try {
			System.out.println("Is intStack empty right now? " + (intStack.isEmpty() ? "Yes" : "No"));
			intStack.push(2);
			intStack.push(5);
			intStack.push(244);
			intStack.push(93);
			strStack.push("java");
			strStack.push("training");
			strStack.push("hello world");
			
			System.out.println("Popped from intStack: "+ intStack.pop());
			System.out.println("Popped from intStack: "+ strStack.pop());
			System.out.println("Is strStack empty right now? " + (strStack.isEmpty() ? "Yes" : "No"));

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

class Stack<T>{
	private int capacity;
	private int size;
	private T[] items;
	
	public Stack(int cap) {
		this.capacity = cap > 0 ? cap : 10;
		size = -1;
		items = (T[]) new Object[capacity];
	}
	public Stack() {
		this(10);
	}
	
	public void push(T t) throws FullStackException {
		if(size == capacity-1)
			throw new FullStackException("Stack is full, cannot, push value: " + t);
		
		items[++size] = t;
	}
	T pop() {
		if (size == -1)
			throw new EmptyStackException();
		
		return items[size--];
	}
	
	boolean isEmpty() {
		if(size == -1)
			return true;
		else
			return false;
	}
}

class FullStackException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FullStackException(String msg) {
		super(msg);
	}
}
