package com.demo.learnings;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.demo.streams.examples.Order;
import com.demo.streams.examples.Order.ITEM;

/**
 * Examples showing the usage of Optional to avoid null pointer exception
 */
public class Learning4 {
	
	public static void main(String[] args) {

		Order order = new Order(1, ITEM.TV, null, BigDecimal.valueOf(10));
		
		// the below line will produce NullPointerException
		//System.out.println("Order Name : "  + order.getBrandName().toUpperCase());
		
		System.out.println("Order Name : "  + Optional.<String>ofNullable(order.getBrandName()).orElse("Unknown Brand name"));
		
		 Map<String,String> letterMap = new HashMap<>();
		 letterMap.put("A", "Apple");
		 letterMap.put("B", "Ball");
		 letterMap.put("C", null);
		 letterMap.put("D", "Desk");
		 letterMap.put("E", "Elephant");
		
		 letterMap.keySet().stream()
		 
		/*.map(k -> letterMap.get(k))
		.forEach(x -> System.out.println(x.toUpperCase()));
		*/
		 
		 // uncomment the above two lines and comment the below three lines to see the problem
		.map(k -> Optional.<String>ofNullable(letterMap.get(k)))
		.filter(Optional::isPresent)
		.forEach(x -> System.out.println(x.get().toUpperCase()));
		
	}

}
