package com.demo.learnings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

/**
 * Each section in the below example demonstrates an issue.
 * So, run them with caution (if required) knowing their consequences 
 *
 */
@SuppressWarnings("unused")
public class Learning7 {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(1,2,3,4,5);

		//1 stream already closed
		/*Stream<Integer> stream = numbers.stream();
		stream.forEach(System.out::println);

		stream.filter(x -> x%2 ==0)
		.map(i -> (i * 2))
		.forEach(System.out::println);*/

//		//2 infinite loop
		/*IntStream.iterate(0, i -> i + 1)
        .forEach(System.out::println);*/

//		//3 no terminal after peek() method
		/*numbers.stream()
		.filter(x -> x%2 ==0)
		.map(i -> (i * 2))
		.peek(System.out::println);*/

		//4 subtle infinite
		/*IntStream.iterate(0, i -> ( i + 1 ) % 2)
        .distinct()
        .limit(10)
        .forEach(System.out::println);*/

		//5 infinite loop with parallel stream
		/*IntStream.iterate(0, i -> ( i + 1 ) % 2)
        .parallel()
        .distinct()
        .limit(10)
        .forEach(System.out::println);*/

		//6 Mixing up the order of operations 
		/*IntStream.iterate(0, i -> i + 1)
       
        .skip(5)   // OFFSET
        .limit(10) // LIMIT
        .forEach(System.out::println);*/


		//7 never modify a backing collection while consuming a stream
		/*List<Integer> list = 
				IntStream.range(0, 10)
				.boxed()
				.collect(Collectors.toCollection(ArrayList::new));
		list.stream()
		.peek(list::remove)
		.forEach(System.out::println);*/

	}

}
