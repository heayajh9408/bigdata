package com.lec.ex;

/*
 * 2020.12.02
 */
public class Ex02 {
	public static void main(String[] args) {
		int i = 10;
		int j = i;
		j = 100;
		System.out.printf("i=%d, j=%d\n", i, j);
		int[] score = { 10, 20, 30, 40, 50 };
		int[] s = score;
		s[0] = 100;
		for (int idx = 0; idx < score.length; idx++) {
			System.out.printf("score[%d] = %d, s[%d]=%d\n", idx, score[idx], idx, s[idx]);
		}
	}
}
