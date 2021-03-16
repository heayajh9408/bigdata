package com.lec.ex3_math;

/*
 * 2020.12.14 ~ Lim JaeHyun
 */
public class Ex02_round {
	public static void main(String[] args) {
		System.out.println("소수점에서 반올림, 올림, 버림");
		System.out.println("9.12을 올림 : " + (int) Math.ceil(9.12));
		System.out.println("9.12을 반올림 : " + Math.round(9.12));
		System.out.println("9.12을 버림 : " + (int) Math.floor(9.12));

		System.out.println("소수점 한자리에서 반올림, 올림, 버림");
		System.out.println("9.15을 올림 : " + Math.ceil(9.15 * 10) / 10);
		System.out.println("9.15을 반올림 : " + Math.round(9.15 * 10) / 10.0);
		System.out.println("9.15을 내림 : " + Math.floor(9.15 * 10) / 10);

		System.out.println("일의 자리에서 반올림, 올림, 버림");
		System.out.println("85을 올림(90) : " + Math.ceil(85 / 10.0) * 10);
		System.out.println("85을 반올림(90) : " + Math.round(85 / 10.0) * 10);
		System.out.println("85을 내림(80) : " + Math.floor(85 / 10.0) * 10);
	}
}