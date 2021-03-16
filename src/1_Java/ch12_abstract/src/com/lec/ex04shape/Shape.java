package com.lec.ex04shape;

/*
 * 2020.12.08~ Lim JaeHyun
 */
public abstract class Shape {
	public void draw() {
		System.out.println("도형을 그려요");
	}

	public abstract void computeArea(); // 추상메소드
}