package com.lec.ex6_wrapper;

/*
 * 2020.12.15 ~ Lim JaeHyun
 * ��Ʈ�� -> ����
 * ���� -> ��Ʈ��
 */
public class Ex03 {
	public static void main(String[] args) {
		System.out.println("��Ʈ���� ���� : Integer.parseInt(���ڿ�)");
		int i = Integer.parseInt("123");
		System.out.println(i);
		System.out.println("������ ��Ʈ�� : String.valueOf(����)");
		// String monthString = ""+12;
		String monthString = String.valueOf(12);
		System.out.println(monthString);
	}
}