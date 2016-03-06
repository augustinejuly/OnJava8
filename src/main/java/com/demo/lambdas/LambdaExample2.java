package com.demo.lambdas;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Using lambda for comparator implementation 
 */
public class LambdaExample2 {
	public static void main(String[] args) {

		String [] fruits = {"Banana", "Orange", "Apple"};
		
		//anonymous inner class style
		Arrays.sort(fruits, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
		});
		
		// lambda style
		//Arrays.sort(fruits, (String s1 , String s2) -> {return s1.compareTo(s2);}); // valid lambda
		Arrays.sort(fruits, (s1,s2) -> s1.compareTo(s2)); // simplified lambda
		
		for (String fruit : fruits) {
			System.out.println(fruit);
		}
	}

}
