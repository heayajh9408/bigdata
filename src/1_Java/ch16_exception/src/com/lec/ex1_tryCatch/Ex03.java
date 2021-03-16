package com.lec.ex1_tryCatch;

/*
 * 2020.12.16 ~ Lim JaeHyun
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i, j = 1;
		do {
			try {
				System.out.print("ù��° ���� ?");
				i = scanner.nextInt(); // @\n
				break;
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				System.out.println("ù��° ���� ���ڸ� ���� ������");
				scanner.nextLine(); // ���۸� ����� ����
			}
		} while (true);
		System.out.print("�ι�° ���� ?");
		try {
			j = scanner.nextInt();
			System.out.println("i = " + i + ", j=" + j);
			System.out.println("i * j = " + (i * j));
			System.out.println("i / j = " + (i / j));
		} catch (InputMismatchException e) {
			System.out.println(e.getMessage());
			System.out.println("�ι�° ���� �߸� �Է��ϼż� 1�� �ʱ�ȭ ��");
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage() + "0���� ������ ���� �н�");
		} catch (Exception e) {
			System.out.println(e.getMessage() + "���� �����ϱ�? ");
		}
		System.out.println("i + j = " + (i + j));
		System.out.println("i - j = " + (i - j));
		System.out.println("DONE");
		scanner.close();
	}
}
