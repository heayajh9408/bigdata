package com.lec.ex03;

/*
 * 2020.12.08~ Lim JaeHyun
 */
public abstract class SuperClass {
	public SuperClass() {
	}

	public abstract void method1(); // 추상메소드

	public void method2() {
		System.out.println("Super의 method2()");
	}
}