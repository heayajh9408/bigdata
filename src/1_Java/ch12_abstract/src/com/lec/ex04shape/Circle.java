package com.lec.ex04shape;

/*
 * 2020.12.08~ Lim JaeHyun
 */
public class Circle extends Shape {
	private int r;

	public Circle() {
	}

	public Circle(int r) {
		this.r = r;
	}

	@Override
	public void computeArea() {
		System.out.println("���� ���̴� " + (3.14 * r * r));
	}

	@Override
	public void draw() {
		System.out.print("�� ");
		super.draw();
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}
}