package com.lec.loop;
/*
 * 2020.12.02~ Lim JaeHyun
 */
public class Ex03for {
	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
//		for (int j=1 ; j<=5 ; j++) {
//			System.out.print('*');
//		}
	}
}