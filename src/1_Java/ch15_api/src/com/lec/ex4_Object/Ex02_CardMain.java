package com.lec.ex4_Object;

/*
 * 2020.12.14 ~ Lim JaeHyun
 */
public class Ex02_CardMain {
	public static void main(String[] args) {
		Card[] cards = { new Card('��', 2), new Card('��', 7), new Card('��', 8) };
		Card yours = new Card('��', 8);
		System.out.println("��� ī�� : " + yours);
		for (int idx = 0; idx < cards.length; idx++) {
			System.out.print(cards[idx]);
			if (yours.equals(cards[idx])) {
				System.out.println(" - ��� ī��� ��ġ�մϴ�");
			} else {
				System.out.println(" - ��� ī��� ��ġ���� �ʽ��ϴ�");
			} // if
		} // for
	}// main

}