package com.lec.loop;
/*
 * 2020.12.02~ Lim JaeHyun
 */
import java.util.Scanner;
public class Ex09doWhile {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num;
		do {
			System.out.print("¦���� �Է��ϼ��� : ");
			num = scanner.nextInt();
			// ����ڷκ��� �Է¹��� ���� num �Ҵ�
		}while(num%2 == 1 || num%2==-1);
		System.out.println("�Է��Ͻ� ¦���� "+num);
		scanner.close();
	}
}
