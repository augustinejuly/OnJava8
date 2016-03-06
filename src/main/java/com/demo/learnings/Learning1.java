package com.demo.learnings;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.demo.streams.examples.Order;
import com.demo.streams.examples.Order.ITEM;

/**
 * Breaking the streams operations into separate line will help to identify the exact line 
 * that is causing the problem in the exception stack trace
 * 
 */
public class Learning1 {
	
	public static void localPrinter(int orderId){
		throw new RuntimeException();
	}
	
	public static void main(String[] args) {
		
		List<Order> orders = Arrays.asList(new Order(1, ITEM.TV, "Sony", BigDecimal.valueOf(10000)), null);
		
		// will print the method name in the stack
		//orders.stream().map(o -> o.getId()).forEach(o -> Learning1.localPrinter(o)); 
		
		// will show the line number of the code that is causing the exception, here .map(o -> o.getId())
		orders.stream()
		.map(o -> o.getId())
		.forEach(o -> System.out.println(o));
	}

}
