package com.productandconsumer;

public class Consumer extends Thread {
	private Basket basket;

	public Consumer(Basket basket) {
		super();
		this.basket = basket;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			this.basket.get();
		}
	}

}
