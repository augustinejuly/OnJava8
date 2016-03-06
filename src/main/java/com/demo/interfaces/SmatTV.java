package com.demo.interfaces;

public interface SmatTV  extends Laptop  , TV{
	
	//Option 1
	// Just extend the default methods from Interface

	// Option2
	@Override
	default void fixTouchScreen() {
		System.out.println("This is default fixTouchScreen method in Smart TV");
		Laptop.super.fixTouchScreen();
	}

	//Option3 make it abstract again
	//public abstract void fixTouchScreen();

}
