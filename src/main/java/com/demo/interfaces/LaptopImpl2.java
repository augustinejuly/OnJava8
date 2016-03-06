package com.demo.interfaces;

public class LaptopImpl2 implements Laptop{

	@Override
	public void fixKeyBoard() {
		System.out.println("Fixing Keyboard");		
	}
	
	@Override
	public void fixTouchScreen() {
		System.out.println("Fixing touch screen in LaptopImpl2...");
	}
	
	public static void main(String[] args) {
		LaptopImpl2 laptopImpl2 = new LaptopImpl2();
		laptopImpl2.fixKeyBoard();
		laptopImpl2.fixTouchScreen();
	}
	
}
