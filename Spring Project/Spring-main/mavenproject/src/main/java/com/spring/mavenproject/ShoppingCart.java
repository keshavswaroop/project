package com.spring.mavenproject;

public class ShoppingCart {
	Item item=new Item();

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "ShoppingCart [item=" + item + "]";
	}
}
