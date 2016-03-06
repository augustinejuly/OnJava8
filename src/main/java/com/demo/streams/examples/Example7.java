package com.demo.streams.examples;

import java.util.Arrays;
import java.util.List;

/**
 * Example on parallel stream 
 */
public class Example7 {
	
	public static int squareTheNumber(int num){
		try {Thread.sleep(1000);
		} catch (InterruptedException e) {}
		
		return num * num;
	}
	
	
	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		long start = System.currentTimeMillis();
		
		numbers.stream()
		//numbers.parallelStream()
		.map(Example7::squareTheNumber)
		.forEach(System.out::println);
		
		System.out.println("Time in milliseconds " + (System.currentTimeMillis() - start));
	}

}
