package com.lec.loop;

/*
 * 2020.12.02~ Lim JaeHyun
 */
import java.util.Scanner;

//��ǻ�Ϳ� ���������� ������ ����� �� ������ ���ѹݺ��ϴ� ������ �ۼ��Ͻÿ�.
public class Homework4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int you, computer;
		do {
			System.out.println("����(0), ����(1), ��(2)�� �ϳ��� ���� :");
			you = scanner.nextInt();
			computer = (int) (Math.random() * 3);
			if (you > 2 || you < -1) {
				System.out.println("����(0), ����(1), ��(2)�� ����� ������");
			} else if ((you + 2) % 3 == computer) {
				System.out.println("����� �̰��");
			} else if (you == computer) {
				System.out.println("����");
			} else {
				System.out.println("��ǻ�Ͱ� �̰��.");
			}
		} while (you == computer || (you + 1) % 3 == computer);
		scanner.close();
	}

}