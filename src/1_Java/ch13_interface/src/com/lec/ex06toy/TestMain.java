package com.lec.ex06toy;

/*
 * 2020.12.09~ Lim JaeHyun
 */
public class TestMain {
	public static void main(String[] args) {
		IToy[] toy = { new Pooh(), new MazingerToy(), new AirplaneToy() };
		for (IToy t : toy) {
			// t��ü�� Ŭ���� �̸����
			System.out.println(t.getClass().getName());
			// t.toString()ȣ��
			System.out.println(t);
			System.out.println("~ ~ ~ ~ ~ ~ ~ ~");
		}
	}
}
