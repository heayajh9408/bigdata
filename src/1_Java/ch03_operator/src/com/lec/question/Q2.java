package com.lec.question;

import java.util.Scanner;

//�Է��� ���� ¦������ Ȧ������ ���
public class Q2 {
	public static void main(String[] args) {
		Scanner su = new Scanner(System.in);
		System.out.println("���ڸ� �Է����ּ���");
		int k = su.nextInt();
		System.out.println(k%2==0? "¦��":"Ȧ��");
		su.close();
	}
}
