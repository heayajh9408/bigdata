package com.lec.loop;

/*
 * 2020.12.02~ Lim JaeHyun
 */
import java.util.Scanner;

//컴퓨터와 가위바위보 게임을 당신이 질 때까지 무한반복하는 게임을 작성하시오.
public class Homework4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int you, computer;
		do {
			System.out.println("가위(0), 바위(1), 보(2)중 하나를 선택 :");
			you = scanner.nextInt();
			computer = (int) (Math.random() * 3);
			if (you > 2 || you < -1) {
				System.out.println("가위(0), 바위(1), 보(2)를 제대로 내세요");
			} else if ((you + 2) % 3 == computer) {
				System.out.println("당신이 이겼다");
			} else if (you == computer) {
				System.out.println("비겼다");
			} else {
				System.out.println("컴퓨터가 이겼다.");
			}
		} while (you == computer || (you + 1) % 3 == computer);
		scanner.close();
	}

}