package com.lec.ex13final;

/*
 * 2020.12.07~ Lim JaeHyun
 */
public class Rabbit extends Animal {
	@Override
	public void running() {
		speed += 30;
		System.out.println("마구 뛰어요. 현재 속도 : " + speed);
	}
}