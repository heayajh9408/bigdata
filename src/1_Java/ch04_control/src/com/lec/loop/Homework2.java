package com.lec.loop;
/*
 * 2020.12.02~ Lim JaeHyun
 * �ֻ����� ������ �μ���  ���� 6�� �Ǵ� ���
 */

public class Homework2 {
	public static void main(String[] args) {
		for (int i = 1; i < 7; i++) {
			for (int j = 1; j < 7; j++) {
				if (i + j == 6) {
					System.out.printf("%d + %d = %d\n", i, j, (i + j));
				}
			}
		}
	}
}