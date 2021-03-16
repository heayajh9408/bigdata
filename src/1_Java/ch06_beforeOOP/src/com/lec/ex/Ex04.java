package com.lec.ex;

/*
 * 2020.12.03~ Lim JaeHyun
 */
public class Ex04 {
	public static void main(String[] args) {
		printCh();
		System.out.println("Hello, World!");
		printCh('=');
		System.out.println("Hello, Java");
		printCh('-', 30);
	}

	private static void printCh(char ch, int count) {
		for (int cnt = 1; cnt <= count; cnt++) {// ch�� count�� �ִ� ����
			System.out.print(ch);
		}
		System.out.println();
	}

	private static void printCh(char ch) {
		for (int cnt = 1; cnt <= 20; cnt++) { // ch�� 20�� �ִ� ����
			System.out.print(ch);
		}
		System.out.println();// ����
	}

	private static void printCh() {
		for (int cnt = 1; cnt <= 20; cnt++) { // *�� 20�� �ִ� ����
			System.out.print('*');
		}
		System.out.println();
	}
}