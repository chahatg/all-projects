package com.chahatg.day11;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//4.) Write a program which uses optional variables to avoid null pointer exception 
public class OptionalVar {
	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(200, 34, 11, 452, 6,7,34);
		List<Integer> emptyList = Arrays.asList();
		
		Optional<Integer> maxNum = nums.stream().reduce(Integer::max);
		System.out.println("Max num: " + maxNum);
		Optional<Integer> minNum = nums.stream().reduce(Integer::min);
		System.out.println("Min num: " + minNum);
		
		Optional<Integer> maxInEmptyList = emptyList.stream().reduce(Integer::min); //should print Optional.empty
		System.out.println("Max run on empty list: " + maxInEmptyList);

	}
}
