package com.lec.ex02_super;

/*
 * 2020.12.07~ Lim JaeHyun
 */
public class TestMain {
	public static void main(String[] args) {
		Child child = new Child(10, 20);
		System.out.println("i�� : " + child.getI());
		System.out.println("j�� : " + child.getJ());
		child.sum();
	}
}