package com.lec.ex1_tryCatch;

/*
 * 2020.12.16 ~ Lim JaeHyun
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i, j = 1;
		do {
			try {
				System.out.print("첫번째 수는 ?");
				i = scanner.nextInt(); // @\n
				break;
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				System.out.println("첫번째 수에 문자를 넣지 마세요");
				scanner.nextLine(); // 버퍼를 지우는 목적
			}
		} while (true);
		System.out.print("두번째 수는 ?");
		try {
			j = scanner.nextInt();
			System.out.println("i = " + i + ", j=" + j);
			System.out.println("i * j = " + (i * j));
			System.out.println("i / j = " + (i / j));
		} catch (InputMismatchException e) {
			System.out.println(e.getMessage());
			System.out.println("두번째 수를 잘못 입력하셔서 1로 초기화 함");
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage() + "0으로 나누는 것은 패스");
		} catch (Exception e) {
			System.out.println(e.getMessage() + "무슨 에러일까? ");
		}
		System.out.println("i + j = " + (i + j));
		System.out.println("i - j = " + (i - j));
		System.out.println("DONE");
		scanner.close();
	}
}
