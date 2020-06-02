package com.chahatg.day8;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/*1. Create a linkedhashmap  pair of  key string value object of
 *   any type., then extract only key , sort in natural order and
 *   merge with linkedhashmap with final result showing ordered pairs
*/
public class LinkedHashmapEx {
	public static <T> void main(String[] args) {
		LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
		
		map.put(23, "hello" );
		map.put(91, "world");
		map.put(3, "java");
		map.put(74, "training");
		for(Entry<Integer, String> pair : map.entrySet()) {
			System.out.println(pair.getKey() + " : " + pair.getValue());
		}
		
		//javarevisted.blogspot.com
		map = map.entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(e->e.getKey(), e-> e.getValue(), (e1,e2) -> e2, LinkedHashMap::new));
		
		System.out.println("After merge:- ");
		for(Entry<Integer, String> pair : map.entrySet()) {
			System.out.println(pair.getKey() + " : " + pair.getValue());
		}
		
	}
}
