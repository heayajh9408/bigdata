package com.lec.ex05_override;

/*
 * 2020.12.07~ Lim JaeHyun
 */
public class ParentClass {
	// �����ڰ� 2�� : �������Լ��� �����ε�overloading(�Լ��� �ߺ�����)
	public ParentClass() {
		System.out.println("P �Ű����� ���� ������");
	}

	public ParentClass(int i) {
		System.out.println("P �Ű����� �ִ� ������");
	}

	public void method1() {
		System.out.println("Parent�� method1()");
	}

	public void method2() {
		System.out.println("Parent�� method2()");
	}
}