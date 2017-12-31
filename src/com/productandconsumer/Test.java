package com.productandconsumer;

public class Test {
	public static void main(String[] args) {
		Basket basket = new Basket();
		Producer producer = new Producer(basket);
		Consumer consumer = new Consumer(basket);
		producer.setName("生产者");
		consumer.setName("消费者");
		 producer.start();
		 
		 consumer.start();
		 
		 
	}
}
