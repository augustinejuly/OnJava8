package com.demo.learnings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Learning2 {
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3);
		
		// will not return any output and never run like this
		/*list.stream()
		.filter(o -> o > 0)
		.peek(System.out::println);*/
		
		list.stream()
		.filter(o -> o > 0)
		.peek(System.out::println)
		.forEach(o -> System.out.print(""));
		
		//to add loggers and System.out.println in the middle of streams operations
		list.stream()
		.peek(s -> System.out.println("Before filter " + s))
		.filter(o -> o > 0)
		.peek(s -> System.out.println("Before map " + s))
		.map(m -> m * 2)
		.peek(s -> System.out.println("After map " + s))
		.collect(Collectors.toList());
		
	}

}
