package com.demo.learnings;

import java.util.Arrays;
import java.util.function.Consumer;

public class Learning3 {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		int x = 0;
		
		Runnable runnable = new Runnable() { // place the cursor here and press Curl + 1 in eclipse to convert to lambda expression
			@Override
			public void run() { 
				int x = 0;
				System.out.println("Hi there!");
			}
		};
		
		new Thread(runnable).start();
		
		
		// Don't introduce anonymous classes like this where a lambda expression is required
		Arrays.asList("Hello").stream().map(i -> i).forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
					System.out.println("Hey, Don't do this.!");
			}
		});
		
		
	}

}
