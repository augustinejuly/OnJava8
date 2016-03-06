package com.demo.streams.examples;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Example3 {
	
	public static void main(String[] args) {
		
		List<String> strList = Arrays.asList("xyz", "", "doe", "", "kpale", "jaeoq", "kl", "sw");
		
		// find empty strings
		System.out.println("Empty Count " + strList.stream()
													.filter(x -> x.isEmpty())
													.count());
		
		// Count String with length more than 3
		System.out.println("Strings with more than 3 in length : " + 
		strList.stream()
		.filter(x -> x.length()> 3)
		.count());		
		
		//remove empty strings
		 List<String> filteredList = strList.stream()
				 					.filter(x -> !x.isEmpty())
				 					.collect(Collectors.toList());
		 System.out.println("Non-empty string list : " + filteredList);
		 
		 // convert all non-empty strings to uppercase
		 List<String> upperCasedList = strList.stream()
										 .filter(x -> !x.isEmpty())
										 .map(x -> x.toUpperCase(Locale.ROOT))
										 .collect(Collectors.toList());
		 System.out.println("Uppercased List elements : " + upperCasedList);
		 
		 //join all non-empty string with hyphen
		 String joinedString = strList.stream()
										 .filter(x -> !x.isEmpty())
										 .collect(Collectors.joining("-"));
		 System.out.println("Joined String " + joinedString);
	}

}
