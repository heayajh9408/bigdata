package com.lec.condition;
/*
 * 2020.12.01~ Lim JaeHyun
 */
public class Ex02_if {
	public static void main(String[] args) {
		int seoulLunchPrice = 8000;
		if (seoulLunchPrice > 7000) {
			System.out.println("���� �� �� ��γ�");
		} else if (seoulLunchPrice >= 6000) {
			System.out.println("�� ��ᰪ ��ŭ�̳�");
		} else if (seoulLunchPrice >= 4000) {
			System.out.println("����䰪 ������");
		} else {
			System.out.println("�� �Ĵ� ������ ��������?");
		}
	}
}