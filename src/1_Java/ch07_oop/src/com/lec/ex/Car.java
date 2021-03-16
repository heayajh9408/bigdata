package com.lec.ex;

/*
 * 2020.12.03~ Lim JaeHyun
 * Car myPorsche = new Car();
 * Scanner sc = new Scanner(~);
 */
public class Car {
	private String color; // ������(private)��
	private int cc;
	private int speed;

	public Car() { // ������ �Լ� = ����Ÿ���� ���� Ŭ������� ���� �̸��� �޼ҵ�
		// ����Ʈ�������Լ��� �������Լ��� ���� �� JVM�� �ڵ�����
		// ��ü������ ������ �� �ڵ� ȣ��
		cc = 1000;
	}

	public void drive() { // �޼ҵ�(public)��
		speed = 60;
		System.out.println("�����Ѵ� ���� �ӵ� : " + speed);
	}

	public void park() {
		speed = 0;
		System.out.println("�����Ѵ� ���� �ӵ� : " + speed);
	}

	public void race() {
		speed = 120;
		System.out.println("���̽��Ѵ�. ���� �ӵ� : " + speed);
	}

	// ~.setColor("red")
	public void setColor(String color) {
		this.color = color;
	}

	// ~.getColor()
	public String getColor() {
		return color;
	}

	// ~.getCc()
	public int getCc() {
		return cc;
	}
}