package com.lec.condition;
/*
 * 2020.12.01~ Lim JaeHyun
 */

import java.util.Scanner;

//가위바위보 중 하나를 내고 낸 것을 출력하세요
/// 사용자로부터 가위(0), 바위(1), 보(2) 중 입력받고,
// 컴퓨터도 가위(0)바위(1)보(2) 중 하나를 선택해서 승자를 출력
public class Q3 {
	public static void main(String[] args) {
		Scanner su = new Scanner(System.in);
		System.out.println("가위(0), 바위(1), 보(2) 중 하나를 선택");
		int you = su.nextInt();
		if (you == 0) {
			System.out.println("가위네?");
		} else if (you == 1) {
			System.out.println("바위네?");
		} else {
			System.out.println("보네?");
		}
		su.close();
		int computer = (int) (Math.random() * 3);
		if (computer == 0) {
			System.out.println("컴은 가위야");
		} else if (computer == 1) {
			System.out.println("컴은 바위야");
		} else {
			System.out.println("컴은 보야");
		}
		if (you == 0) {
			if (computer == 0) {
				System.out.println("비겼다");
			} else if (computer == 1) {
				System.out.println("컴이 승");
			} else {
				System.out.println("당신이 승");
			}
		}
		if (you == 1) {
			if (computer == 0) {
				System.out.println("당신이 승");
			} else if (computer == 1) {
				System.out.println("비겼다");
			} else {
				System.out.println("컴이 승");
			}
		}
		if (you == 2) {
			if (computer == 0) {
				System.out.println("컴이 승");
			} else if (computer == 1) {
				System.out.println("당신이 승");
			} else {
				System.out.println("비겼다");
			}
		}
	}
}
