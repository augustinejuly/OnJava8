package com.demo.interfaces;

public interface TV {
	
	default public void fixTouchScreen(){
		System.out.println("Fixing the touch screen in TV...");
	}

}
