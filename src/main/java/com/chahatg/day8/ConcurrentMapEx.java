package com.chahatg.day8;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/*Create a map like Map<String,List<T>> where string should
 *be of any unique element which has list of any type parameters.. 
 *considering map should allow concurrency where list can be added
 *by 3 difference threads and remove by 2 diff threads*/


public class ConcurrentMapEx {
	public static <T> void main(String[] args) {
		
		ConcurrentHashMap<String, List<Integer>> map = new ConcurrentHashMap();
		List<Integer> nums1 = new ArrayList<Integer>(){{
      			add(2);
                add(35);
                add(7);
        }};
        List<Integer> nums2 = new ArrayList<Integer>(){{
  			add(45);
            add(333);
            add(9);
        }};
        List<Integer> nums3 = new ArrayList<Integer>(){{
  			add(8);
            add(0);
            add(6);
        }};
        List<Integer> nums4 = new ArrayList<Integer>(){{
  			add(8);
            add(260);
            add(77);
        }};
        List<Integer> nums5 = new ArrayList<Integer>(){{
  			add(36);
            add(19);
            add(450);
        }};
		map.put("List0", nums1);
		map.put("List4", nums2);
		
		AddThread addT1 = new AddThread(map, "add-thread-1", nums3);
		AddThread addT2 = new AddThread(map, "add-thread-2", nums3);
		AddThread addT3 = new AddThread(map, "add-thread-3", nums3);
		System.out.println(map.entrySet());
		RemoveThread removeT1 = new RemoveThread(map, "remove-thread-1", "List0");
		RemoveThread removeT2 = new RemoveThread(map, "remove-thread-2", "List3");
		addT1.start();
		addT2.start();
		addT3.start();
		removeT1.start();
		removeT2.start();

	}
}

class AddThread extends Thread{
	private ConcurrentHashMap<String, List<Integer>> map;
	private String name;
	private List<Integer> list;
	
	public AddThread(ConcurrentHashMap<String, List<Integer>> m, String threadName, List<Integer> nums) {
		this.map = m;
		this.name = threadName;
		this.list = nums;
	}
	
	public void run() {
		map.put("List1", list);
		System.out.println("Thread " + this.name + " inserted list");
		System.out.println(map.entrySet());
	}
}


class RemoveThread extends Thread{
	private ConcurrentHashMap<String, List<Integer>> map;
	private String name;
	private String key;
	
	public RemoveThread(ConcurrentHashMap<String, List<Integer>> m, String threadName, String key) {
		this.map = m;
		this.name = threadName;
		this.key = key;
	}
	
	public void run() {
		map.remove(key);
		System.out.println("Thread " + name + " removed list of key " + key);
		System.out.println(map.entrySet());
	}
}

