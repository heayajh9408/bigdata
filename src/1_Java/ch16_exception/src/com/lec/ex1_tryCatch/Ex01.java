package com.lec.ex1_tryCatch;

/*
 * 2020.12.16 ~ Lim JaeHyun
 */
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i, j;
		System.out.print("첫번째 수는 ?");
		i = scanner.nextInt();
		System.out.print("두번째 수는 ?");
		j = scanner.nextInt();
		System.out.println("i = " + i + ", j=" + j);
		System.out.println("i * j = " + (i * j));
		System.out.println("i / j = " + (i / j));
		System.out.println("i + j = " + (i + j));
		System.out.println("i - j = " + (i - j));
		System.out.println("DONE");
		scanner.close();
	}
}