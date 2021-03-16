package com.lec.ex01_parentchild;

/*
 * 2020.12.07~ Lim JaeHyun
 */
public class TestMain {
	public static void main(String[] args) {
		ChildClass child = new ChildClass();
		child.getPapaName();
		child.getMamiName();
		System.out.println(child.pStr);
		System.out.println(child.cStr);
	}
}