package com.lec.condition;
/*
 * 2020.12.01~ Lim JaeHyun
 */

import java.util.Scanner;

// ���� �Է¹޾� ���밪�� ����ϴ� ���α׷�
public class Q1_if {
	public static void main(String[] args) {
		Scanner su = new Scanner(System.in);
		System.out.println("���� �Է����ּ���");
		int k = su.nextInt();
		if (k >= 0) {
			System.out.println("���밪��=" + k);
		} else {
			System.out.println("���밪��=" + (k * -1));
		}
		su.close();
	}
}
