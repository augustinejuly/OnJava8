package com.demo.lambdas;

/**
 * This example shows the flavors of functional interfaces 
 * Predicate, Consumer, Function, Supplier
 */
public class LambdaExample4 {
	
	@FunctionalInterface
	interface Validatable{
		public boolean validateLength(String token);
		//public boolean validateLength1(String token1); //@FunctionalInterface will allow only one abstract method
	}
	
	interface Printable{
		public void print(String token);
	}
	
	interface Findable{
		public int findBigger(int num1 , int num2);
	}
	
	interface Randomizable{
		public Double getRamdon();
	}
	
	public static void main(String[] args) {
		
		Validatable validatable = s -> s != null && s.length() >= 7; //Predicate
		
		Printable printable = s -> System.out.println(s); // Consumer
		
		Findable findable = (n1, n2) ->  (n2 > n1 ? n2 : n1);  //Function
		
		Randomizable randomizable = () -> { return Math.random(); }; //Supplier
		
		System.out.println(validatable.validateLength("Hello"));
		printable.print("Hello World");
		System.out.println("The bigger of 5 and 6 is: " + findable.findBigger(5, 6));
		System.out.println("The double random number is: " + randomizable.getRamdon());
		
	}

}
