package com.lec.ex1_squre;

/*
 * 2020.12.03~ Lim JaeHyun
 */
public class SqureMain {
	public static void main(String[] args) {
		Squre s1 = new Squre();
		Squre s2 = new Squre(10);
		System.out.println("s1�� �Ѻ��� ���̴� " + s1.getSide());
		System.out.println("s1�� ���̴� " + s1.area());
		System.out.println("s2�� �Ѻ��� ���̴� " + s2.getSide());
		System.out.println("s2�� ���̴� " + s2.area());
		s2.setSide(5);
		System.out.println("s2�� ���̴� " + s2.area());
	}
}
