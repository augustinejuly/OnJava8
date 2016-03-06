package com.demo.interfaces;

public interface Laptop {
	
	public void fixKeyBoard();
	
	default public void fixTouchScreen(){
		System.out.println("Fixing the touch screen in Laptop...");
	}
	
	public static String getDefaultLaptopSpecification(String code){
		return "specification details for " + code;
	}

}
