package com.lec.loop;

/*
 * 2020.12.02~ Lim JaeHyun
 */
public class Homework1 {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i < 21; i++) {
			if (i % 2 != 0 && i % 3 != 0) {
				sum += i;
			}

		}
		System.out.println("2와 3의 배수가 아닌 수의 합은=" + sum);
	}
}