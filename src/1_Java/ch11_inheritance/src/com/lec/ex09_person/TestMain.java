package com.lec.ex09_person;

/*
 * 2020.12.07~ Lim JaeHyun
 */
public class TestMain {
	public static void main(String[] args) {
		Person papa = new Person("¾Æºü°õ", "¶×¶×ÇØ");
		Person mom = new Person("¾ö¸¶°õ", "³¯¾ÀÇØ");
		papa.intro();
		mom.intro();
		System.out.println("========================");
		Baby child1 = new Baby();
		child1.setName("¾Æ±â°õ1");
		child1.setCharacter("¹¹ Á» ±Í¿©¿ö");
		child1.intro();
		Baby child2 = new Baby("¾Æ±â°õ2", "±Í¿©¿ö");
		child2.cry();
	}
}