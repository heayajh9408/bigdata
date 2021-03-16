package com.lec.ex07car;

/*
 * 2020.12.08~ Lim JaeHyun
 * LowGradeCar lowCar = new LowGradeCar("red","광폭",2000,"파워핸들");
 */
public abstract class Car {
	private String color; // 차색상
	private String tire; // 타이어
	private int displacement; // 배기량
	private String handle; // 핸들

	public Car(String color, String tire, int displacement, String handle) {
		this.color = color;
		this.tire = tire;
		this.displacement = displacement;
		this.handle = handle;
	}

	public abstract void getSpec();

	public String getColor() {
		return color;
	}

	public String getTire() {
		return tire;
	}

	public int getDisplacement() {
		return displacement;
	}

	public String getHandle() {
		return handle;
	}
}