package com.demo.streams.examples;

import java.util.Arrays;
import java.util.List;

public class Example4 {

	public static Double findTotalTaxedBill(List<Integer> nums, double tax){
		double sum = 0;
		for (Integer n : nums) {
			double taxedAmount = n + (n * tax);
			sum += taxedAmount;
		}

		return sum;
	}

	public static void main(String[] args) {
		double tax = 0.1;

		List<Integer> bills = Arrays.asList(100, 200, 300, 400, 500);
		
		System.out.println(findTotalTaxedBill(bills,tax));


		double taxedBill = bills.stream()
				.mapToDouble(cost-> cost + (tax * cost) )
				//.reduce(0, (sum, cost) -> sum + cost); // valid reduce operation
				//.reduce(0, Double::sum); // valid reduce operation
				.sum();
		System.out.println(taxedBill);

	}

}
