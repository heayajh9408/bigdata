package com.lec.question;

import java.util.Scanner;

//�μ��� �Է¹޾� 
//�� ���� ������ ����� O�� X�� ���(ex. �μ��� ������ ���� : X).
//ù��° ���� �� ū�� ����� O�� X�� ����Ѵ�(ex. ù��° ���� ū�� ���� : O).
public class Q3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("ù ����?");
		int k = scanner.nextInt();
		System.out.println("�ι�° ����?");
		int m = scanner.nextInt();
		String result= k==m? "o":"x";
		System.out.println("k==m �����"+result);
		boolean result2 = k>m;
		System.out.println("k>m ����� "+((result2==true)? "o":"x"));
		scanner.close();
	}
}
