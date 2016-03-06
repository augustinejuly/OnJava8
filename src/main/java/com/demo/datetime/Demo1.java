package com.demo.datetime;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;

/**
 * Introduction LocalDate and some of its methods
 *
 */
public class Demo1 {

	public static void main(String[] args) {
		
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);
		
		LocalTime localTime = LocalTime.now();
		System.out.println(localTime);
		
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		
		/******************************************************/
		
		//2016-01-15
		LocalDate fifteenthJan2016 = LocalDate.of(2016, Month.JANUARY, 15);
		System.out.println("FifteenthJan2016 " + fifteenthJan2016);
		// months values start at 1 (2015-07-10)
		LocalDate tenthJuly2015 = LocalDate.of(2015, 7, 10);
		System.out.println("TenthJuly2015 " + tenthJuly2015);
		// the 75th day of 2012 (2013-03-16)
		LocalDate sixtyFifthDayOf2010 = LocalDate.ofYearDay(2015, 75);
		System.out.println("SixtyFifthDayOf2010 " + sixtyFifthDayOf2010);
		
		/****************************************************/
		
		// current (local) time in Los Angeles
		LocalTime currentTimeInLosAngeles = LocalTime.now(ZoneId.of("America/Los_Angeles"));
		System.out.println("Current Time In LosAngeles : " + currentTimeInLosAngeles);
		// current time in UTC time zone
		LocalTime nowInUtc = LocalTime.now(Clock.systemUTC());
		System.out.println("Current time in UTC " + nowInUtc);
		
	}
}
