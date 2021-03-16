package com.lec.ex07car;

/*
 * 2020.12.08~ Lim JaeHyun
 * LowGradeCar lowCar = new LowGradeCar("red","����",2000,"�Ŀ��ڵ�");
 */
public abstract class Car {
	private String color; // ������
	private String tire; // Ÿ�̾�
	private int displacement; // ��ⷮ
	private String handle; // �ڵ�

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