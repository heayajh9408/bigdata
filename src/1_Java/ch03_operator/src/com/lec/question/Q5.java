package com.lec.question;

import java.util.Scanner;

//����, ����, ���� ������ ������ �Ҵ��ϰ� �� ������ ����ϰ� ����, ���(�Ҽ���2�ڸ�����) ����ϴ� ���α׷��� ���� �Ͻÿ�
public class Q5 {
	public static void main(String[] args) {
		Scanner su = new Scanner(System.in);
		System.out.println("����������?");
		int kor = su.nextInt();
		System.out.println("����������?");
		int eng = su.nextInt();
		System.out.println("����������?");
		int mat = su.nextInt();
		int result = kor+eng+mat;
		double avg= result/3.0;
		System.out.printf("����������=%3d\n",kor);
		System.out.printf("����������=%3d\n",eng);
		System.out.printf("����������=%3d\n",mat);
		System.out.printf("������=%3d\n",result);
		System.out.printf("�����=%.2f\n",avg);
		su.close();
		
	}
}
