package com.lec.ex5_scanner;

/*
 * 2020.12.15 ~ Lim JaeHyun
 */
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("���̸� �Է��ϼ��� :");
		int age = scanner.nextInt(); // \n
		System.out.println("�Է��Ͻ� ���̴� " + age);
		System.out.print("�̸��� �Է��ϼ��� : ");

		String name = scanner.next(); // ���ۿ� ó�� ������\n�� �����ϰ� whiteSpace������ ������ ����
		System.out.println("�Է��Ͻ� �̸��� " + name);
		System.out.print("�ּҸ� �Է��ϼ���");
		scanner.nextLine(); // ���� �����(\n������)
		String address = scanner.nextLine(); // ���ۿ� \n�� ������ �ձ��� ����
		System.out.println("�Է��Ͻ� �ּҴ� " + address);
		System.out.println("========���α׷� ��=====");
	}
}