package com.demo.interfaces;

public class SmartLaptop implements Laptop, TV{

	@Override
	public void fixKeyBoard() {
		System.out.println("Fixing keyboard in LaptopImpl3 ...");
	}

	@Override
	public void fixTouchScreen() {
		Laptop.super.fixTouchScreen();
	}
	
	public static void main(String[] args) {
			SmartLaptop smartLaptop = new SmartLaptop();
			smartLaptop.fixTouchScreen();
	}
	
}
