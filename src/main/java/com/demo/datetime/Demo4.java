package com.demo.datetime;

import java.time.Instant;

/**
 * Example on Instant 
 *
 */
public class Demo4 {
	
	public static void main(String[] args) throws InterruptedException {
		
		//Instant before = Instant.now(Clock.systemDefaultZone());
		Instant before = Instant.now();
		
		System.out.println(before);
		
		Thread.sleep(1000);
		
		Instant after = Instant.now();
	
		System.out.println("Time elapsed in seconds " + (after.getEpochSecond() - before.getEpochSecond()));
		
	}

}
