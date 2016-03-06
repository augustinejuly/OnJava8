package com.demo.datetime;

import java.time.LocalDate;
import java.time.Period;

/**
 * Example on finding difference between dates
 * 
 */
public class Demo2 {
	
	public static void main(String[] args) {
		LocalDate _31stAugust2010 = LocalDate.of(2010, 8, 31);
		
		LocalDate _10stFebruary2015 = LocalDate.of(2015, 2, 10);
		
		Period between = Period.between(_31stAugust2010, _10stFebruary2015);
		
		System.out.println("Years between " + between.getYears());
		System.out.println("Months between " + between.getMonths());
		System.out.println("Days between " + between.getDays());
	}

}
