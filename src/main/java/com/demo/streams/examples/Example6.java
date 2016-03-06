package com.demo.streams.examples;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.demo.streams.examples.Order.ITEM;

public class Example6 {

	public static List<Integer> getLapTopOrderIdsSortedOnValueList(List<Order> orderList){
		List<Order> laptopList = new ArrayList<>();
		for (Order order : orderList) {
			if(order.getItem().equals(ITEM.LAPTOP)){
				laptopList.add(order);
			}
		}

		Collections.sort(laptopList, new Comparator<Order>() {
			@Override
			public int compare(Order o1, Order o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});

		List<Integer> orderIds = new ArrayList<>();
		for (Order order : laptopList) {
			orderIds.add(order.getId());
		}
		
		return orderIds;
	}

	public static void main(String[] args) {
		List<Order> orderList = Arrays.asList(new Order(1, ITEM.MOBILE, "Samsung", BigDecimal.valueOf(10000)),
				new Order(2, ITEM.LAPTOP, "Lenova", BigDecimal.valueOf(22000)),
				new Order(3, ITEM.TV, "Sony", BigDecimal.valueOf(25000)),
				new Order(4, ITEM.MOBILE, "Apple", BigDecimal.valueOf(18000)),
				new Order(5, ITEM.LAPTOP, "DeLL", BigDecimal.valueOf(20000)));

		
		//list of all the ids of laptop order sorted on their price value
		System.out.println(getLapTopOrderIdsSortedOnValueList(orderList));
		
		//lambda
		System.out.println(orderList.stream()
		.filter(o -> o.getItem().equals(ITEM.LAPTOP))
		.sorted(Comparator.comparing(Order::getValue))
		.map(Order::getId)
		.collect(Collectors.toList()));
		
		// all the mobile orders
		System.out.println(orderList.stream()
				.filter(o -> o.getItem().equals(ITEM.MOBILE))
				.collect(Collectors.toList()));
		
		// Whether all the order values are above 10000
		System.out.println(orderList.stream()
				.allMatch(o -> o.getValue().intValue() >= 10000)
				);
		
		// Is any order less than 15000
		System.out.println(orderList.stream()
				.anyMatch(o -> o.getValue().intValue() < 15000));
		
		// Highest value of the all order
		System.out.println(orderList.stream()
				.map(Order::getValue)
				.sorted(Comparator.reverseOrder())
				.findFirst().get());
		
		// see if any motorola order exists
		System.out.println(orderList.stream()
				.map(Order::getBrandName)
				.filter(s -> s.equals("Motorola"))
				.findAny().orElse("No Motorola order found"));
		
		//group by Item
		Map<ITEM, List<Order>> groupByItem = orderList.stream()
		.collect(Collectors.groupingBy(Order::getItem));
		
		groupByItem.forEach((k,v) -> System.out.println(k + " " + v));
		
	}

}
