package com.lec.ex06toy;

/*
 * 2020.12.09~ Lim JaeHyun
 */
public class AirplaneToy implements IMissile, ILight {
	public AirplaneToy() {
		System.out.println("����� �峭���Դϴ�");
		canLight();
		canMissile();
		System.out.println("========================");
	}

	@Override
	public void canLight() {
		System.out.println("�Һ� �߻� �����մϴ�");
	}

	@Override
	public void canMissile() {
		System.out.println("�̻��� �� �� �ֽ��ϴ�.");
	}

	@Override
	public String toString() {
		return "�Һ��� �̻��� ������ �����";
	}
}