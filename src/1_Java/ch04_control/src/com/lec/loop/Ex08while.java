package com.lec.loop;
/*
 * 2020.12.02~ Lim JaeHyun
 * i�� 1�� �� �������� X�̴�(i�� 1~10����)
 */

public class Ex08while {
	public static void main(String[] args) {
		int i=1;
		int sum = 0;
		while(i<=10) {
			sum += i; // sum = sum+i;
			System.out.printf("i�� %d�� �� �������� %d�̴�\n",i, sum);
			++i;
		}
//	for(int j=1 ; j<=10 ; j++) {
//			System.out.printf("i�� %d�� �� �������� %d�̴�\n",j, sum);
		}
	}