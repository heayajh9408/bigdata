package com.lec.ex03actor;

/*
 * 2020.12.09~ Lim JaeHyun
 * ����implements(���߱���)�� �̿��� ������
 */

public class TestMain {
	public static void main(String[] args) {
		Actor park = new Actor("�ں���");
		park.canCatchCriminal();
		park.canSearch();
		park.makePizza();
		park.makeSpaghetti();
		park.outFire();
		park.saveMan();
		FireFighter firePark = park;
		firePark.outFire();
		firePark.saveMan();
		// firePark.canCatchCriminal();
		PoliceMan policePark = park;
		policePark.canCatchCriminal();
		policePark.canSearch();
		Chef chefPark = park;
		chefPark.makePizza();
		chefPark.makeSpaghetti();
		// chefPark.saveMan();
	}
}