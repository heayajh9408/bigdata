package com.lec.condition;
/*
 * 2020.12.01~ Lim JaeHyun
 */

import java.util.Scanner;

//���������� �� �ϳ��� ���� �� ���� ����ϼ���
/// ����ڷκ��� ����(0), ����(1), ��(2) �� �Է¹ް�,
// ��ǻ�͵� ����(0)����(1)��(2) �� �ϳ��� �����ؼ� ���ڸ� ���
public class Q3 {
	public static void main(String[] args) {
		Scanner su = new Scanner(System.in);
		System.out.println("����(0), ����(1), ��(2) �� �ϳ��� ����");
		int you = su.nextInt();
		if (you == 0) {
			System.out.println("������?");
		} else if (you == 1) {
			System.out.println("������?");
		} else {
			System.out.println("����?");
		}
		su.close();
		int computer = (int) (Math.random() * 3);
		if (computer == 0) {
			System.out.println("���� ������");
		} else if (computer == 1) {
			System.out.println("���� ������");
		} else {
			System.out.println("���� ����");
		}
		if (you == 0) {
			if (computer == 0) {
				System.out.println("����");
			} else if (computer == 1) {
				System.out.println("���� ��");
			} else {
				System.out.println("����� ��");
			}
		}
		if (you == 1) {
			if (computer == 0) {
				System.out.println("����� ��");
			} else if (computer == 1) {
				System.out.println("����");
			} else {
				System.out.println("���� ��");
			}
		}
		if (you == 2) {
			if (computer == 0) {
				System.out.println("���� ��");
			} else if (computer == 1) {
				System.out.println("����� ��");
			} else {
				System.out.println("����");
			}
		}
	}
}
