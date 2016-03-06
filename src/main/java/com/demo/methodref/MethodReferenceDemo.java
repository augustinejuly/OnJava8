package com.demo.methodref;

import static java.util.Comparator.comparing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * The following example explains the Method Reference feature
 * 
 * Types explained are, 
 * 1. Calling instance method
 * 2. Calling static method
 * 3. Calling instance method with class name as target object
 * 4. Calling constructors
 * 
 */
public class MethodReferenceDemo {

	private static void getSqureRoot(Integer num) {
		System.out.println("SQRT of " + num + " is " + Math.sqrt(num));
	}

	private boolean IsEven(int num) {
		return num % 2 == 0;
	}
	
	public void printEvenNumber(Integer number){
			if(IsEven(number)){
				System.out.println("Num is " + number);
			}
	}
	
	public List<Integer> collectEvenNumberlist(List<Integer> numbers, Supplier<List<Integer>> evenNumbers){
		List<Integer> evenList = evenNumbers.get();
		for (Integer num : numbers) {
			if(IsEven(num)){
				evenList.add(num);
			}
		}
		return evenList;
	}

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		MethodReferenceDemo methodReferenceDemo = new MethodReferenceDemo();
		
		// print all numbers
		numbers.forEach(System.out::println); //calling on instance method
		
		numbers.forEach(methodReferenceDemo::printEvenNumber); //calling on instance method
		
		numbers.forEach(MethodReferenceDemo::getSqureRoot); //calling on static method
		
		numbers.sort(comparing(Integer::intValue)); // Calling instance method with class name as target object
		
		Supplier<List<Integer>> supplier = ArrayList::new; // calling constructors
		System.out.println("Even Numbers are : " + methodReferenceDemo.collectEvenNumberlist(numbers, supplier));
	}

}
