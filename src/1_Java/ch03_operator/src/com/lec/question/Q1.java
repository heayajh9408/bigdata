package com.lec.question;

import java.util.Scanner;

// 3�� ��� ���� �Ǵ��ϱ� : ����ڷκ��� ���ڸ� �Է� �ް�, �Է� ���� ���ڰ� 3�� ������� �ľ�
public class Q1 {
	public static void main(String[] args) {
		Scanner su= new Scanner(System.in);
		System.out.println("���ڸ� �Է����ּ���");
		int k = su.nextInt();
		System.out.println(k%3==0? "3�� ����̴�":"3�ǹ���� �ƴϴ�");
		su.close();
	}
}
