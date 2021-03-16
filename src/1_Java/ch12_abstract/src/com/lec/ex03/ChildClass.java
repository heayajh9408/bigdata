package com.lec.ex03;

/*
 * 2020.12.08~ Lim JaeHyun
 */
public abstract class ChildClass extends SuperClass {
	// SuperClass로부터 받은 추상 메소드 method1()
	@Override
	public void method2() {
		System.out.println("ChildClass의 method2()");
	}

	public void method3() {
		System.out.println("ChildClass의 method3()");
	}
}

//SuperClass부분에 있던것
//	public abstract void method1(); // 추상메소드
//	public void method2() {
//		System.out.println("Super의 method2()");