package com.lec.ex03;

/*
 * 2020.12.08~ Lim JaeHyun
 */
public class TestMain {
	public static void main(String[] args) {
		// SuperClass sup = new Superclass();
		// ChildClass child = new ChildClass();
		SuperClass sup = new GrandChildClass();
		sup.method1();
		sup.method2();
		// sup.method3();
		ChildClass child = new GrandChildClass();
		child.method1();
		child.method2();
		child.method3();
		GrandChildClass grand = new GrandChildClass();
		grand.method1();
		grand.method2();
		grand.method3();
	}
}