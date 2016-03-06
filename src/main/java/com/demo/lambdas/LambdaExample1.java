package com.demo.lambdas;

/**
 * Examples on simple lambda expressions
 */
public class LambdaExample1 {
	
	public static void main(String[] args) {
		
		//anonymous inner class style
		Thread threadOne = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello Anonymous inner class");
			}
		});
		
		threadOne.start();
		
		// lambda style
		Thread threadTwo = new Thread(() -> System.out.println("Hello Lambda"));

		threadTwo.start();
		
		//lambda style
		Runnable r = () -> System.out.println("Lambda assigned to a varible");
		new Thread(r).start();
		
	}

}
