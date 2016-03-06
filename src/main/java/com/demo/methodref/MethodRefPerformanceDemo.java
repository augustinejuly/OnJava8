package com.demo.methodref;

import java.util.Arrays;
import java.util.List;

/**
 * Given the following use case, the lambda with Method Reference 
 * seems to be faster than regular lambda expressions
 * 
 */
public class MethodRefPerformanceDemo {
	
	public static void print(int num){
		System.out.println(num);
	}

	
	public static void main(String[] args) {
		
		List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		long start = System.currentTimeMillis();
		nums.forEach(n -> MethodRefPerformanceDemo.print(n));
		System.out.println("Time taken " + (System.currentTimeMillis() - start));
		
		start = System.currentTimeMillis();
		nums.forEach(MethodRefPerformanceDemo::print); // faster than the above
		System.out.println("Time taken " + (System.currentTimeMillis() - start));
		
	}
}
