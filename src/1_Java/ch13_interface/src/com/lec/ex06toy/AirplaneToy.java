package com.lec.ex06toy;

/*
 * 2020.12.09~ Lim JaeHyun
 */
public class AirplaneToy implements IMissile, ILight {
	public AirplaneToy() {
		System.out.println("비행기 장난감입니다");
		canLight();
		canMissile();
		System.out.println("========================");
	}

	@Override
	public void canLight() {
		System.out.println("불빛 발사 가능합니다");
	}

	@Override
	public void canMissile() {
		System.out.println("미사일 쏠 수 있습니다.");
	}

	@Override
	public String toString() {
		return "불빛과 미사일 나가는 비행기";
	}
}