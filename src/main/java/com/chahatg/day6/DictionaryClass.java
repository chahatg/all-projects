package com.chahatg.day6;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*4. Sketch the class definition and method signatures for a Dictionary class, 
 * which allows one to store or look up a value indexed by a key. Give the method
 * signatures for get, put, isEmpty, keys, and values. The last two methods should
 * return parameterized collections. (This class is similar to the built in class 
 * HashMap in the Java collections library.)
 */

public class DictionaryClass {
	public static void main(String[] args) {
		Dictionary<Integer, String> StudentRoll = new Dictionary<Integer, String>();
		System.out.println("Dictionary is " + (StudentRoll.isEmpty() ? "Empty" : "not Empty"));
		StudentRoll.put(1, "Aaron");
		StudentRoll.put(2,  "Erin");
		StudentRoll.put(3, "Rahul");
		System.out.println("Roll number 3 is: " + StudentRoll.get(3));
		System.out.println("Dictionary is " + (StudentRoll.isEmpty() ? "Empty" : "not Empty"));
		System.out.println("HERE ARE THE KEYS: " + StudentRoll.keys());
		System.out.println("HERE ARE THE VALUES: " + StudentRoll.values());
	}
}

class Dictionary<K,V> {
	HashMap<K,V> pairs;
	//new Map<K,V>();
	//Collection<V> values;
	Dictionary(){
		pairs = new HashMap<K,V>();
	}
	void put(K key, V value) {
		pairs.put(key, value);
	}
	
	V get(K key) {
		return pairs.get(key);
	}
	
	boolean isEmpty() {
		return pairs.isEmpty();
	}
	
	Collection<K> keys(){
		return pairs.keySet();
	}
	Collection<V> values(){
		return pairs.values();
	}
}