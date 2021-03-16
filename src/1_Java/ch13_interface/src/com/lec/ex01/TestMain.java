package com.lec.ex01;
/*
 * 2020.12.09~ Lim JaeHyun
 * InterfaceEx1   InterfaceEx2
 * InterfaceClass
 */

public class TestMain {
	public static void main(String[] args) {
		// InterfaceEx1 ex1 = new InterfaceEx1();
		// InterfaceEx2 ex1 = new InterfaceEx2();
		InterfaceClass obj1 = new InterfaceClass();
		obj1.method1();
		obj1.method2();
		InterfaceEx1 obj2 = new InterfaceClass();
		obj2.method1();
		// obj2.method2(); 불가(InterfaceEx1엔 method2()가 없음)
		InterfaceEx2 obj3 = new InterfaceClass();
		if (obj3 instanceof InterfaceClass) {
			((InterfaceClass) obj3).method1();
		}
		// obj3.method1(); 불가
		obj3.method2();
	}
}
