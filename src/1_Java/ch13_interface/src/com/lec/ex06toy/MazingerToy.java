package com.lec.ex06toy;

/*
 * 2020.12.09~ Lim JaeHyun
 */
public class MazingerToy implements IMissile, IMoveArmLeg {
	public MazingerToy() {
		System.out.println("��¡�� �峭���Դϴ�.");
		canMissile();
		canMoveArmLeg();
		System.out.println("========================");
	}

	@Override
	public void canMoveArmLeg() {
		System.out.println("�ȴٸ��� ������ �� �ֽ��ϴ�.");
	}

	@Override
	public void canMissile() {
		System.out.println("�̻����� �� �� �ֽ��ϴ�.");
	}

	@Override
	public String toString() {
		return "�̻��Ͻ�� �ȴٸ� �����̴� ��¡�� �峭��";
	}
}
