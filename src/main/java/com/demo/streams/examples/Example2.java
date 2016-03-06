package com.demo.streams.examples;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class Example2 {

	public static void main(String[] args) {

		// Intstream Examples
		System.out.println("-----------IntStream.range(0, 10)-----------");
		IntStream.range(0, 10).forEach(System.out::println);

		System.out.println("-------------IntStream.rangeClosed(0, 10)-----------------------");

		IntStream.rangeClosed(0, 10).forEach(System.out::println);

		System.out.println("----------IntStream.of(5, 7, 8, 9, 4)--------------------------");

		IntStream.of(5, 7, 8, 9, 4).forEach(System.out::println);

		System.out.println("---------------IntStream.iterate with limit 5 -------------------------------");

		IntStream.iterate(0, i -> i + 1)
		.limit(5)
		.forEach(System.out::println);

		System.out.println("----------------IntStream.of(5, 7, 8, 9, 4).average()--------------------");
		double average = IntStream.of(5, 7, 8, 9, 4).average().getAsDouble();
		System.out.println(average);

		System.out.println("----------------IntStream.of(5, 7, 8, 9, 4).sum()--------------------");
		int sum = IntStream.of(5, 7, 8, 9, 4).sum();
		System.out.println(sum);


		System.out.println("----------------IntStream.iterate with limit 5 and skiping first 3 elements--------");
		IntStream.iterate(0, i -> i + 1)
		.skip(3)
		.limit(5)
		.forEach(System.out::println);

		System.out.println("---------------IntStream.of().distinct()--------------");
		IntStream.of(3,3,4,4,5,5).distinct().forEach(System.out::println);
		
		System.out.println("-----------IntStream Summary Statistics--------------");
		IntSummaryStatistics summaryStatistics = IntStream.rangeClosed(10, 20).map(i -> i).summaryStatistics();
		System.out.println("Average " + summaryStatistics.getAverage());
		System.out.println("Sum " + summaryStatistics.getSum());
		System.out.println("Count " + summaryStatistics.getCount());
		System.out.println("Max " + summaryStatistics.getMax());
		System.out.println("Min " + summaryStatistics.getMin());
		
		
		System.out.println("-----------Intstream Builder------------------------");
		IntStream even = IntStream.builder().add(2).add(4).add(6).build();
		IntStream odd = IntStream.builder().add(1).add(3).add(5).build();
		IntStream.concat(even, odd).sorted().forEach(System.out::println);
		
	}

}
