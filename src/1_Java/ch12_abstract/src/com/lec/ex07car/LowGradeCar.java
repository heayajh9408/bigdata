package com.lec.ex07car;

/*
 * 2020.12.08~ Lim JaeHyun
 */
public class LowGradeCar extends Car {
	private int tax = 50000;

	public LowGradeCar(String color, String tire, int displacement, String handle) {
		super(color, tire, displacement, handle);
	}

	@Override
	public void getSpec() { // spec들 출력(tax포함)
		System.out.println("********************");
		System.out.println("색   상 : " + getColor());
		System.out.println("타이어 : " + getTire());
		System.out.println("배기량 : " + getDisplacement());
		System.out.println("핸   들 : " + getHandle());
		if (getDisplacement() > 1000) {
			// tax = tax + (getDisplacement()-1000)*100;
			tax += (getDisplacement() - 1000) * 100;
		}
		System.out.println("세   금 : " + tax);
		System.out.println("*********************");
	}
}