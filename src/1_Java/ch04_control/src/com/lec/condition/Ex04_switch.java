package com.lec.condition;
/*
 * 2020.12.01~ Lim JaeHyun
 */
public class Ex04_switch {
	public static void main(String[] args) {
		int num = 2;
		switch (num) {
		case 1:
			System.out.println("주사위 1");
			break;
		case 2:
			System.out.println("주사위 2");
			break;
		case 3:
			System.out.println("주사위 3");
			break;
		default:
			System.out.println("그 외");
			break;
		}
	}
}