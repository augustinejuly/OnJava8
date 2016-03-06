package com.demo.interfaces;

public class LaptopImpl implements Laptop{

	@Override
	public void fixKeyBoard() {
		System.out.println("Fixing Keyboard");
	}
	
	public static void main(String[] args) {
		LaptopImpl laptopImpl = new LaptopImpl();
		
		laptopImpl.fixTouchScreen();
		
		System.out.println("Calling static method in Laptop :" + Laptop.getDefaultLaptopSpecification("XYZ"));
	}

}
