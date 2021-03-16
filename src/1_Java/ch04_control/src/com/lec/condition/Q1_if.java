package com.lec.condition;
/*
 * 2020.12.01~ Lim JaeHyun
 */

import java.util.Scanner;

// 수를 입력받아 절대값을 출력하는 프로그램
public class Q1_if {
	public static void main(String[] args) {
		Scanner su = new Scanner(System.in);
		System.out.println("수를 입력해주세요");
		int k = su.nextInt();
		if (k >= 0) {
			System.out.println("절대값은=" + k);
		} else {
			System.out.println("절대값은=" + (k * -1));
		}
		su.close();
	}
}
