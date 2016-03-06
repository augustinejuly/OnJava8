package com.demo.streams.examples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example8 {
	
	private static Map<String,Long> getCharCountMap(){
		String [] tokens = {"Java", "rules", "again", "and", "it", "is", "really", "good"};
		
		HashMap<String,Long> map = new HashMap<>();
		
		for (String s : tokens) {
			for(String st : s.split("")){
				if(map.containsKey(st)){
					Long occurrance = map.get(st);
					map.put(st, ++occurrance);
				}else{
					map.put(st,1L);
				}
			}
		}
		
		return map;
	}

	public static void main(String[] args) {

		/*String[] arrayOfWords = {"Hello", "World"};
		Stream<String> streamOfwords = Arrays.stream(arrayOfWords);
		streamOfwords.forEach(System.out::println);*/

		//old way
		System.out.println(getCharCountMap());
		
		// lambda way
		Stream<String>	words = Stream.of("Java", "rules", "again", "and", "it", "is", "really", "good");
		
		Map<String, Long> charCountMap = words.map(w -> w.split(""))
				.flatMap(Arrays::stream)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(charCountMap);
	}

}
