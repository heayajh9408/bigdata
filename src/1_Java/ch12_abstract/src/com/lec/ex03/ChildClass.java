package com.lec.ex03;

/*
 * 2020.12.08~ Lim JaeHyun
 */
public abstract class ChildClass extends SuperClass {
	// SuperClass�κ��� ���� �߻� �޼ҵ� method1()
	@Override
	public void method2() {
		System.out.println("ChildClass�� method2()");
	}

	public void method3() {
		System.out.println("ChildClass�� method3()");
	}
}

//SuperClass�κп� �ִ���
//	public abstract void method1(); // �߻�޼ҵ�
//	public void method2() {
//		System.out.println("Super�� method2()");