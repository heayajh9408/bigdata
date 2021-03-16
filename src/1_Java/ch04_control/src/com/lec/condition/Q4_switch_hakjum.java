package com.lec.condition;
/*
 * 2020.12.01~ Lim JaeHyun
 */

import java.util.Scanner;

public class Q4_switch_hakjum {
	public static void main(String[] args) {
		Scanner su = new Scanner(System.in);
		System.out.println("점수를 입력하세요");
		int k = su.nextInt();
		int score = k == 100 ? k - 1 : k;
		switch (score / 10) {
		case 9:
			System.out.println("A학점");
			break;
		case 8:
			System.out.println("B학점");
			break;
		case 7:
			System.out.println("C학점");
			break;
		case 6:
			System.out.println("D학점");
			break;
		case 5:
		case 4:
		case 3:
		case 2:
		case 1:
			System.out.println("F학점");
			break;
		default:
			System.out.println("떼끼");

		}

	}
}
