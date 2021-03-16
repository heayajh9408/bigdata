package com.lec.ex03actor;

/*
 * 2020.12.09~ Lim JaeHyun
 * 다중implements(다중구현)를 이용한 다형성
 */

public class TestMain {
	public static void main(String[] args) {
		Actor park = new Actor("박보검");
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