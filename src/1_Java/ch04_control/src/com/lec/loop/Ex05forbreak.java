package com.lec.loop;
/*
 * 2020.12.02~ Lim JaeHyun
 */
public class Ex05forbreak {
	public static void main(String[] args) {
		for (int i = 1; i < 11; i++) {
			if (i == 5) {
				// break; // �ݺ��� ���� ���� ����
				continue; // ���������� �ö�
			}
			System.out.print(i + " ");
		}
	}
}