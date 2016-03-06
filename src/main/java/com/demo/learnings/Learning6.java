package com.demo.learnings;

import java.io.IOException;
import java.util.function.Function;

/*interface Function<T,R>{
	R apply(T t); // no throws clause in the original declaration
}*/

class Handler{

	public static String handle(Integer number ) throws IOException{
		return String.valueOf(number);
	};
}

interface MyFunction<T,R, E extends IOException> {
	R apply(T instance) throws E;
}

/**
 * This example demonstrates that functional interfaces in java 8 do not
 * handle checked Exceptions
 *
 */
public class Learning6 {

	public static void main(String[] args) throws IOException  {

		// The below line will complain unhandled IOException
		//Function<Integer, String> functionHandler = i -> Handler.handle(i);
		
		// Option 1
		Function<Integer, String> functionHandler = i -> {
			try {
				return Handler.handle(i);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		};
		
		System.out.println("Option 1 thowing runtime exception : " + functionHandler.apply(10));

		//Option 2 Creating a new custom function interface with appropriate throws declaration
		MyFunction<Integer, String, IOException> fixedHandler = i -> Handler.handle(i);
		System.out.println("Option 2 After fixing the Handler: " + fixedHandler.apply(10));
		
		
		//Another example
		//Function<String, Connection> sql1 = url ->DriverManager.getConnection(url);
		 
	}

}
