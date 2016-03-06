package com.demo.datetime;

import java.time.LocalDate;
import java.time.Period;

/**
 * Example on manipulating dates 
 *
 */
public class Demo3 {
	
	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		
		LocalDate plus10Days = now.plusDays(10);
		System.out.println("Plus 10 days from now : " + plus10Days);
		
		LocalDate minus2Weeks = now.minusWeeks(2);
		System.out.println("2 weeks before from now " + minus2Weeks);
		
		Period p = Period.ofDays(100);
		LocalDate then = now.plus(p);
		System.out.println("100 days from now : " + then);
		
		Period ofWeeks = Period.ofWeeks(3);
		LocalDate minus3weeks = now.minus(ofWeeks);
		System.out.println("3 weeks before from now " + minus3weeks);
		
	}

}
