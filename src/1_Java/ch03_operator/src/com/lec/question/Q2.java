package com.lec.question;

import java.util.Scanner;

//입력한 수가 짝수인지 홀수인지 출력
public class Q2 {
	public static void main(String[] args) {
		Scanner su = new Scanner(System.in);
		System.out.println("숫자를 입력해주세요");
		int k = su.nextInt();
		System.out.println(k%2==0? "짝수":"홀수");
		su.close();
	}
}
