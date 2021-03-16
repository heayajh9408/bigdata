package com.lec.ex13final;

/*
 * 2020.12.07~ Lim JaeHyun
 */
public class Animal {
	protected int speed;

	public void running() {
//		final int TEMP = 10;
//		TEMP += 5;
		speed += 5;
		System.out.println("¶Ù°í ÀÖ¾î¿ä. ÇöÀç ¼Óµµ : " + speed);
	}

	public final void stop() {
		speed = 0;
		System.out.println("¸ØÃã");
	}
}
