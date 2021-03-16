package com.lec.ex5_momchild;

/*
 * 2020.12.04~ Lim JaeHyun
 * Child child1 = new Child("첫째 똘똘이");
 * child1.takeMoney(100);
 */
public class Child {
	private String name;
	static MomPouch momPouch = new MomPouch();

	public Child(String name) {
		this.name = name;
	}

	public void takeMoney(int money) {
		if (momPouch.money >= money) {
			// momPouch.money = momPouch.money - money;
			momPouch.money -= money;
			System.out.println(name + "가 " + money + "가져가서 엄마지갑엔 " + momPouch.money);
		} else {
			System.out.println(name + "가 돈을 못 받음. 현재 엄마 돈은 " + momPouch.money);
		}
	}
}
