package com.lec.ex02;

/*
 * 2020.12.08~ Lim JaeHyun
 */
public class TestMain {
	public static void main(String[] args) {
		// Super s = new Super(); �߻�Ŭ������ ��ü�� ������ �� ����.
		Child c1 = new Child();
		c1.method1();
		c1.method2();
		c1.method3();
		Super c2 = new Child();
		c2.method1();
		c2.method2();
		// c2.method3(); �Ұ�(c2������ SuperŸ���̹Ƿ� Super�� �͸� ����)
	}
}