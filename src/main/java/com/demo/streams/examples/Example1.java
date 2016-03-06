package com.demo.streams.examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Example1 {
	
	// old traditional way
	public static void printSquareOfOddNumbers(List<Integer> numbers){
		for (int i = 0; i < numbers.size(); i++) {
			Integer num = numbers.get(i);
			if(num%2 != 0){
				num = num * num;
				System.out.println(num);
			}
		}
	}
	
	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		//without streams
		printSquareOfOddNumbers(numbers);
		
		System.out.println("-----------------------------------------");
		
		//with streams
		numbers.stream()
		.filter(x -> x%2 != 0)
		.map(n -> n * n)
		.forEach(System.out::println);
		
		System.out.println("-----------------------------------------");
		
		// in detail 
		Predicate<Integer> predicate = x -> x%2 != 0;
		UnaryOperator<Integer> function = n -> n * n; // Equivalent to Function<Integer, Integer>
		Consumer<Integer> consumer = System.out::println;
		
		numbers.stream()
		.filter(predicate)
		.map(function)
		.forEach(consumer);
		
		System.out.println("-----------------------------------------");
		
		
		/*Stream<Integer> stream = numbers.stream();
		stream.filter(x -> x%2 != 0)
		.map(n -> n * n)
		.forEach(System.out::println); // The stream is closed when it is consumed
		
		stream // you cannot use a closed stream
		.forEach(System.out::println);*/
	}

}
