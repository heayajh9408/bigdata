package com.lec.loop;

/*
 * 2020.12.02~ Lim JaeHyun
 */
import java.util.Scanner;

public class Ex10dowhile_random2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int lotto = (int) (Math.random() * 45) + 1; // ��ǻ�� �ζ� ����
		int su; // ����ڿ��� �Է¹��� ���� �����ϴ� ����
		int min = 1;
		int max = 45;
		do {
			System.out.printf("%d���� %d���� ��ȣ �Ѱ��� �˾Ƹ��� ������", min, max);
			su = scanner.nextInt();
			if (su > lotto) {
				System.out.println(su + "���� �������� �����ϼ���");
				max = su - 1;
			} else if (su < lotto) {
				System.out.println(su + "���� ū���� �����ϼ���");
				min = su + 1;
			}
		} while (su != lotto);
		System.out.println("�������� ���߼̽��ϴ�");
		scanner.close();
	}
}
