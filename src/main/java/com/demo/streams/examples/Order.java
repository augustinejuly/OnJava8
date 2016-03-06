package com.demo.streams.examples;

import java.math.BigDecimal;

/**
 * A simple POJO class 
 *
 */
public class Order {
	
	public enum ITEM{
		MOBILE, LAPTOP, TV
	}
	
	private int id;
	
	private ITEM item;
	
	private String brandName;
	
	private BigDecimal value;

	public Order(int id, ITEM item, String brandName, BigDecimal value) {
		this.id = id;
		this.item = item;
		this.brandName = brandName;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ITEM getItem() {
		return item;
	}

	public void setItem(ITEM item) {
		this.item = item;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", item=" + item + ", brandName=" + brandName + ", value=" + value + "]";
	}
	
}
