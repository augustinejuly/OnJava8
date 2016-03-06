package com.demo.lambdas;

/**
 * The type casting is required when there is an ambiguity
 */
public class LambdaExample5 {
	
	interface Demo1{
		public void execute(int a, int b);
	}
	
	interface Demo2{
		public void execute(String s1, String s2);
	}
	
	interface Demo3{
		public void execute(int a, int b);
	}
	
	static class Handler{
		
		public void execute(Demo1 d1){
			System.out.println("Executing Demo1");
			d1.execute(10, 15);
		}
		
		public void execute(Demo2 d2) {
			System.out.println("Executing Demo2");
			d2.execute("Hello", "World");
		}
		
		public void execute(Demo3 d3){
			System.out.println("Executing Demo3");
			d3.execute(100, 200);
		}
		
	}

	public static void main(String[] args) {
		
		Handler handler = new Handler();
		
		handler.execute((Demo1)(int a, int b) -> { System.out.format("In Demo1 a is %d , b is %d \n", a , b); });
		handler.execute((String t1 , String t2)-> {System.out.format("The tokens received are %s and %s \n" , t1, t2 );});
		
		handler.execute((Demo3)(int a, int b) -> {System.out.format("In Demo3 a is %d , b is %d \n", a , b); } );
	}
	
}
