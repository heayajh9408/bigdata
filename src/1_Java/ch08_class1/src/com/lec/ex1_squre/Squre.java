package com.lec.ex1_squre;

/*
 * 2020.12.03~ Lim JaeHyun
 * Squre s1 = new Squre()
 * Squre s2 = new Squre(10);
 * Scanner sc = new Scanner(System.in)
 */
public class Squre {
	private int side;

	public Squre() { // �Ű����� ���� ������ => ������ �����ε�
		System.out.println("�Ű����� ���� ������ ȣ���");
	}

	public Squre(int side) {// �Ű����� �ִ� ������
		this.side = side;
		System.out.println("�Ű����� �ִ� ������ ȣ���");
	}

	public int area() {
		return side * side;
	}

	public int getSide() { // ~.getSide() ���
		return side;
	}

	public void setSide(int side) {// ~.setSide(10)
		this.side = side;
	}
}