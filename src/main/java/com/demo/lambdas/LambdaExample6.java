package com.demo.lambdas;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * This example is to show how to iterate elements in List and Map
 */
public class LambdaExample6 {
	
	public static void main(String[] args) {
		// list iterating
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		list.forEach(n -> System.out.println(n));
		
		
		// Map iterating
		HashMap<String, Integer> map = new HashMap<>();
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);
		map.put("D", 4);
		map.put("E", 5);
		map.forEach((k,v) -> System.out.format("Key: %s Value: %d \n", k, v)); 
	}

}
