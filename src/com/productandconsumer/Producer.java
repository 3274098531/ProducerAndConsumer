package com.productandconsumer;

 
public class Producer extends Thread {
	private Basket basket;

	public Producer(Basket basket) {
		super();
		this.basket = basket;
	}

	@Override
	public void run() {
		for (int i = 1; i <=20; i++) {
			Apple apple = new Apple();
			apple.setName(String.valueOf(i));
			this.basket.put(apple);
		}
	}

}
