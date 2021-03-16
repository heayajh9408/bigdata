package com.lec.loop;
/*
 * 2020.12.02~ Lim JaeHyun
 */
public class Ex05forbreak {
	public static void main(String[] args) {
		for (int i = 1; i < 11; i++) {
			if (i == 5) {
				// break; // 반복문 블럭을 빠려 나가
				continue; // 증감식으로 올라가
			}
			System.out.print(i + " ");
		}
	}
}