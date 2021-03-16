package com.lec.loop;
/*
 * 2020.12.02~ Lim JaeHyun
 */
public class Ex04for {
	public static void main(String[] args) {
		for (int i = 15; i < 51; i++) {
			System.out.print(i + "\t");
			if (i % 5 == 4) {
				System.out.println();// 개행하라
			} // if
		} // for
	}
}