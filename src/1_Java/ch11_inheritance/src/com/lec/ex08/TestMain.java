package com.lec.ex08;

/*
 * 2020.12.07~ Lim JaeHyun
 */
public class TestMain {
	public static void main(String[] args) {
		Parent parent = new Parent();
		Child1 child1 = new Child1();
		Child2 child2 = new Child2();
		GrandChild grandchild = new GrandChild();
		System.out.println("parent�� p : " + parent.getP()); // ����
		System.out.println("child1.p : " + child1.getP()); // ����
		System.out.println(child1.getC1()); // ����
		System.out.println(child2.getP()); // ����
		// System.out.println(child2.getC1()); //�Ұ���
		System.out.println(child2.getC2()); // ����
		System.out.println(grandchild.getP());
		System.out.println(grandchild.getC1());
		System.out.println(grandchild.getGc());
		// System.out.println(grandchild.getC2()); //�Ұ���

	}
}