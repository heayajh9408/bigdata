package com.lec.condition;
/*
 * 2020.12.01~ Lim JaeHyun
 */

import java.util.Scanner;

public class Q4_if_hakjum {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("������ �Է��ϼ��� : ");
		int jumsu = scanner.nextInt();
		if (jumsu >= 90 && jumsu <= 100) {
			System.out.println("A�����Դϴ�");
		} else if (jumsu >= 80 && jumsu < 90) {
			System.out.println("B�����Դϴ�");
		} else if (jumsu >= 70 && jumsu < 80) {
			System.out.println("C�����Դϴ�");
		} else if (jumsu >= 60 && jumsu < 70) {
			System.out.println("D�����Դϴ�");
		} else if (jumsu >= 0 && jumsu < 60) {
			System.out.println("F�����Դϴ�");
		} else {
			System.out.println("����");
		}
		scanner.close();
	}
}