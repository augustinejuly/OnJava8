package com.demo.interfaces;

public interface ILaptop extends Laptop{
	
	//Option 1
	// Just extend the default methods from Interface
	
	//Option 2 
	// Override the methods
	
	//Option 3
	// define them as abstract again
	

	@Override
	default void fixKeyBoard() {
			System.out.println("Overring the abstract method is Laptop");
	}

}
