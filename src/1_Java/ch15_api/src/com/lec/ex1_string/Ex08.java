package com.lec.ex1_string;

/*
 * 2020.12.14 ~ Lim JaeHyun
 */
public class Ex08 {
	public static void main(String[] args) {
		String str1 = "������"; //
		String str2 = "������";
		if (str1 == str2) {
			System.out.println("str1�� str2�� ���� �ּ�(���� ��ü ����)");
		} else {
			System.out.println("str1�� str2�� �ٸ� �ּ�(�ٸ� ��ü ����)");
		}
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		str1 = str1.concat(" 2002"); // str1 = str1 + " 2002";
		if (str1 == str2) {
			System.out.println("str1�� str2�� ���� �ּ�(���� ��ü ����)");
		} else {
			System.out.println("str1�� str2�� �ٸ� �ּ�(�ٸ� ��ü ����)");
		}
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
	}
}