package com.lec.ex06toy;

/*
 * 2020.12.09~ Lim JaeHyun
 */
public class Pooh implements IMoveArmLeg {
	public Pooh() {
		System.out.println("������ Ǫ�Դϴ�.");
		canMoveArmLeg();
		System.out.println("=====================");
	}

	@Override
	public void canMoveArmLeg() {
		System.out.println("�ȴٸ��� ������ �� �ֽ��ϴ�");
	}

	@Override
	public String toString() {
		return "�ȴٸ� �����̴� ������ Ǫ";
	}
}