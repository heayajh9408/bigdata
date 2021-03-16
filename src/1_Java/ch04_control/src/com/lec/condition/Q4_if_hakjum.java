package com.lec.condition;
/*
 * 2020.12.01~ Lim JaeHyun
 */

import java.util.Scanner;

public class Q4_if_hakjum {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("점수를 입력하세요 : ");
		int jumsu = scanner.nextInt();
		if (jumsu >= 90 && jumsu <= 100) {
			System.out.println("A학점입니다");
		} else if (jumsu >= 80 && jumsu < 90) {
			System.out.println("B학점입니다");
		} else if (jumsu >= 70 && jumsu < 80) {
			System.out.println("C학점입니다");
		} else if (jumsu >= 60 && jumsu < 70) {
			System.out.println("D학점입니다");
		} else if (jumsu >= 0 && jumsu < 60) {
			System.out.println("F학점입니다");
		} else {
			System.out.println("떼끼");
		}
		scanner.close();
	}
}