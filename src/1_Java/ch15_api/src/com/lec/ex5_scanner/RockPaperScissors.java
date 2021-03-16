package com.lec.ex5_scanner;

/*
 * 2020.12.15 ~ Lim JaeHyun
 */
import java.util.Scanner;

public class RockPaperScissors {
	public static void main(String[] args) {
		int computer, you;
		String input;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("����,����,�� �� �ϳ�����(����� �̱涧����) : ");
			input = sc.nextLine().trim();
			computer = (int) (Math.random() * 3);
			if (input.equals("����")) {
				you = 0;
			} else if (input.equals("����")) {
				you = 1;
			} else if (input.equals("��")) {
				you = 2;
			} else {
				you = -1;
				continue;
			}
			if ((you + 2) % 3 == computer) {
				printResult(you, computer);
				System.out.println("����� �̰���");
			} else if (you == computer) {
				printResult(you, computer);
				System.out.println("�����");
			} else {
				printResult(you, computer);
				System.out.println("����� �����");
			} // if��
		} while ((you < 0 || you > 2) || ((you + 1) % 3 == computer || you == computer));
		sc.close();
		System.out.println("bye");
	}// main

	private static void printResult(int you, int computer) {
		System.out.println("����� " + ((you == 0) ? "����" : ((you == 1) ? "����" : "��")));
		System.out.println("��ǻ�ʹ� " + ((computer == 0) ? "����" : ((computer == 1) ? "����" : "��")));
	} // printResult
}