package com.lec.question;

import java.util.Scanner;

// 3의 배수 숫자 판단하기 : 사용자로부터 숫자를 입력 받고, 입력 받은 숫자가 3의 배수인지 파악
public class Q1 {
	public static void main(String[] args) {
		Scanner su= new Scanner(System.in);
		System.out.println("숫자를 입력해주세요");
		int k = su.nextInt();
		System.out.println(k%3==0? "3의 배수이다":"3의배수가 아니다");
		su.close();
	}
}
