package com.demo.lambdas;

import java.time.LocalDate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * The below example demonstrates the functional interfaces
 */
public class LambdaExample7 {

	/**
	 * interface Predicate<T> {
	 * 		boolean test(T t);
	 * }
	 * interface Function<T,R> {
	 * 		apply( R apply(T t); 
	 * }
	 * interface Consumer<T>{
	 * 		void accept(T t);
	 * }
	 * interface Supplier<T>{
	 * 		T get();
	 * }
	 */

	public static void main(String[] args) {

		//Predicate
		Predicate<String> validatePredicate = s -> s != null && s.length() >= 7;
		System.out.println(validatePredicate.test("Hello"));

		//Function
		Function<String, Integer> parseIntFunction = s -> Integer.parseInt(s);
		System.out.println(parseIntFunction.apply("1000"));

		//Consumer
		Consumer<Integer> consumer = x -> {
			System.out.println("Received Number is : " + x);
			String message = (x%2 ==0) ? "It is an even number" : "It is not an even number";  
			System.out.println(message);
		};
		consumer.accept(5);
		consumer.accept(4);

		//Supplier
		Supplier<LocalDate> supplier = () -> { return LocalDate.now();};
		System.out.println("Day of month " + supplier.get().getDayOfMonth());

	}
}
