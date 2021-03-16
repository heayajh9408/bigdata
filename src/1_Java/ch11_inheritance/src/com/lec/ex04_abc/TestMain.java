package com.lec.ex04_abc;

/*
 * 2020.12.07~ Lim JaeHyun
 */
public class TestMain {
	public static void main(String[] args) {
		S s = new S();
		// A a = new A();
		S a = new A();
		// Object a = new A();
		System.out.println(a.s);
		S b = new B();
		S c = new C();
		S[] sArr = { new A(), new B(), new C() };
	}
}