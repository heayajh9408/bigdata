package com.lec.ex01;

/*
 * 2020.12.09~ Lim JaeHyun
 * InterfaceEx1 (CONSTANT_NUM, method1())
 * InterfaceEx2 (CONSTANT_STRING, method2())
 */
public class InterfaceClass implements InterfaceEx1, InterfaceEx2 {
	@Override
	public void method1() {
		System.out.println("���� ������ implements�� Ŭ�������� �ؿ�");
	}

	@Override
	public String method2() {
		System.out.println("���� ������ implements�� Ŭ�������� �ؿ�");
		return null;
	}
}