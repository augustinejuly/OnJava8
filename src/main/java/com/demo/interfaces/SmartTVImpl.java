package com.demo.interfaces;

public class SmartTVImpl implements SmatTV{
	
	@Override
	public void fixKeyBoard() {
		
	}

	@Override
	public void fixTouchScreen() {
		// TODO Auto-generated method stub
		SmatTV.super.fixTouchScreen();
	}

	public static void main(String[] args) {
		SmartTVImpl smartTv = new SmartTVImpl();
		smartTv.fixTouchScreen();
	}
	
}
