package com.demo.streams.examples;

import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Example9 {
	
	public static void main(String[] args) {
		
		//Returns a new String composed of copies of the CharSequence elements 
		//joined together with a copy of the specified delimiter
		String joinedString = String.join("-", "Hello", "World", "it", "is", "a", "new", "method", "in", "java8");
		
		System.out.println(joinedString);
		
		
		//an IntStream of char values from this sequence
		String collect = joinedString
			    .chars()
			    .distinct()
			    .mapToObj(c -> String.valueOf((char)c))
			    .sorted()
			    .collect(Collectors.joining(""));
		
				System.out.println(collect);
				
		// StringJoiner
		//StringJoiner is used to construct a sequence of characters separated 
		//by a delimiter and optionally starting with a supplied prefix and ending with a supplied suffix.
				
					 StringJoiner sj = new StringJoiner(":", "{", "}");
					 sj.add("Hello").add("World").add("How is it?");
					 System.out.println("Joined String : " + sj.toString());
		
	}

}
