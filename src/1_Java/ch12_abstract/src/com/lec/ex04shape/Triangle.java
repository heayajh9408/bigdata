package com.lec.ex04shape;

/*
 * 2020.12.08~ Lim JaeHyun
 */
public class Triangle extends Shape {
	private int w; // �غ�
	private int h; // ����

	public Triangle() {
	}

	public Triangle(int w, int h) {
		this.w = w;
		this.h = h;
	}

	@Override
	public void computeArea() {
		System.out.println("�ﰢ���� ���̴� " + (w * h * 0.5));
	}

	@Override
	public void draw() {
		System.out.print("�ﰢ�� ");
		super.draw();
	}
}