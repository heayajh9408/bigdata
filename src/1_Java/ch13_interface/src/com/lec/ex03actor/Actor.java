package com.lec.ex03actor;

/*
 * 2020.12.09~ Lim JaeHyun
 */
public class Actor implements FireFighter, PoliceMan, Chef {
	private String name;

	public Actor(String name) {
		this.name = name;
	}

	@Override
	public void makePizza() {
		System.out.println(name + "�� ���ڸ� ���� �� �ִ�.");
	}

	@Override
	public void makeSpaghetti() {
		System.out.println(name + "�� ���İ�Ƽ�� ���� �� �ִ�.");
	}

	@Override
	public void canCatchCriminal() {
		System.out.println(name + "�� ������ ���� �� �ִ�.");
	}

	@Override
	public void canSearch() {
		System.out.println(name + "�� ������ ã�� �� �ִ�.");
	}

	@Override
	public void outFire() {
		System.out.println(name + "�� ���� �� �� �ִ�.");
	}

	@Override
	public void saveMan() {
		System.out.println(name + "�� ����� ���Ѵ�");
	}
}