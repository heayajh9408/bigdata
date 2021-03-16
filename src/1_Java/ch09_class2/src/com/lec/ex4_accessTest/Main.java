package com.lec.ex4_accessTest;

/*
 * 2020.12.04~ Lim JaeHyun
 */
import com.lec.ex3_accessTest.AccessTest;

public class Main {
	public static void main(String[] args) {
		AccessTest obj = new AccessTest();
		// System.out.println(obj.defaultMember);
		// System.out.println(obj.protectedMember);
		System.out.println(obj.publicMember);
		// obj.defaultMethod();
		// obj.protectedMethod();
		obj.publicMethod();
	}
}