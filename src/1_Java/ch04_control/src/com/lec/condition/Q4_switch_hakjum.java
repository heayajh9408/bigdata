package com.lec.condition;
/*
 * 2020.12.01~ Lim JaeHyun
 */

import java.util.Scanner;

public class Q4_switch_hakjum {
	public static void main(String[] args) {
		Scanner su = new Scanner(System.in);
		System.out.println("������ �Է��ϼ���");
		int k = su.nextInt();
		int score = k == 100 ? k - 1 : k;
		switch (score / 10) {
		case 9:
			System.out.println("A����");
			break;
		case 8:
			System.out.println("B����");
			break;
		case 7:
			System.out.println("C����");
			break;
		case 6:
			System.out.println("D����");
			break;
		case 5:
		case 4:
		case 3:
		case 2:
		case 1:
			System.out.println("F����");
			break;
		default:
			System.out.println("����");

		}

	}
}
