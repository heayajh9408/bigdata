package com.lec.ex4_boxrect;

/*
 * 2020.12.03~ Lim JaeHyun
 */
public class BoxOrRectMain {
	public static void main(String[] args) {
		BoxOrRect box = new BoxOrRect(5, 6, 10);
		BoxOrRect rect = new BoxOrRect(10, 5);
		box.calculate();
		rect.calculate();
		System.out.println(box.getVolume());
		System.out.println(rect.getVolume());
	}
}
