package com.lec.ex;

/*
 * 2020.12.03~ Lim JaeHyun
 */
public class CarMain {
	public static void main(String[] args) {
		Car myPorsche = new Car();
		Car yourPorsche = new Car();
		myPorsche.drive();
		yourPorsche.drive();
		myPorsche.park();
		myPorsche.race();
		myPorsche.setColor("red");// myPorsche.color = "red";
		System.out.println("�� ������ ���� : " + myPorsche.getColor());
		System.out.println("�� ������ ���� : " + yourPorsche.getColor());
		System.out.println("�� ������ ��ⷮ : " + myPorsche.getCc());
	}
}