package com.productandconsumer;

import java.util.ArrayList;
import java.util.List;

public class Basket {
	private List<Apple> list = new ArrayList<>();

	public void put(Apple apple) {
		while (list.size() == 10) {
			try {
				synchronized (this) {
					this.wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		synchronized (this) {
			list.add(apple);
			System.out.println(Thread.currentThread().getName() + "开始生产苹果 "+apple.getName()+"当前苹果个数为：" + list.size());
			this.notify();
		}
	}

	public void get() {
		while (list.size() == 0) {
			try {
				synchronized (this) {
					this.wait();
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		synchronized (this) {
			Apple apple = list.get(list.size() - 1);
			list.remove(apple);
			System.out.println(
					Thread.currentThread().getName() + "取出苹果" + apple.getName() + "当前剩余" + list.size() + "个苹果");
			this.notify();
		}

	}
}
