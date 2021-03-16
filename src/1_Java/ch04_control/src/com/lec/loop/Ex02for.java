package com.lec.loop;
/*
 * 2020.12.02~ Lim JaeHyun
 * 1+2+3+4+5...+19+=20= 210
 */
public class Ex02for {
	public static void main(String[] args) {
		int sum = 0; // 합계 누적 변수
		for (int i = 1; i < 21; i++) {
			sum = sum + i;
			if (i != 20) {
				System.out.print(i + "+");
			} else {
				System.out.print(i + "=");
			}
		}
		System.out.println(sum);
	}
}
