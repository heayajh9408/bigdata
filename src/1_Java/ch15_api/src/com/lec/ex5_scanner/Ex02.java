package com.lec.ex5_scanner;

/*
 * 2020.12.15 ~ Lim JaeHyun
 */
import java.util.Scanner;

// cf. next()->nextLine()�� ���� ����� -> nextLine()�̿�
// nextLine()�̿� -> next() �̿�
public class Ex02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("�ּҸ� �Է��ϼ���");
		String address = scanner.nextLine();
		System.out.println("�Է��Ͻ� �ּҴ� " + address);
		System.out.print("�̸��� �Է��ϼ��� ");
		String name = scanner.nextLine(); // space����
		System.out.println("�Է��Ͻ� �̸��� " + name);
		System.out.print("���̸� �Է��ϼ��� ");
		int age = scanner.nextInt();
		System.out.println("�Է��Ͻ� ���̴� " + age);
	}
}