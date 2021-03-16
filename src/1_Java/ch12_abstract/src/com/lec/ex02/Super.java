package com.lec.ex02;

/*
 * 2020.12.08~ Lim JaeHyun
 * 추상클래스는 한개이상의 추상메소드를 갖음
 * Super s = new Super(); 불가
 * Super s = new Super(); 불가
 * s.method1(); 불가
 */
public abstract class Super {
	public Super() {
	} // 디폴트 생성자

	public abstract void method1(); // 추상메소드

	public void method2() {
		System.out.println("Super의 method2()");
	}
}
