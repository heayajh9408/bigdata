package com.lec.loop;
/*
 * 2020.12.02~ Lim JaeHyun
 * �ֻ����� ������ �μ���  ���� 6�� �Ǵ� ���
 * ��ǻ�Ϳ� ���������� ������ -1�� �Է��Ҷ����� ���ѹݺ��ϴ� ������ �ۼ��Ͻÿ�
 */

import java.util.Scanner;

public class Homework3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int you, computer;
		while (true) {
			System.out.println("����(0), ����(1), ��(2), ����(-1) �� �ϳ��� ���� :");
			you = scanner.nextInt();
			if (you == -1) {
				break;
			}
			computer = (int) (Math.random() * 3);
			if (you > 2 || you < -1) {
				System.out.println("����(0), ����(1), ��(2)�� ����� ������");
			} else if ((you + 2) % 3 == computer) {
				System.out.println("����� �̰��");
			} else if (you == computer) {
				System.out.println("����");
			} else {
				System.out.println("��ǻ�Ͱ� �̰��.");
			}
		}
		scanner.close();
	}

}