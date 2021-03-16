package com.lec.ex02_super;

/*
 * 2020.12.07~ Lim JaeHyun
 */
public class Child extends SuperIJ {
	private int total;

	public Child(int i, int j) {
		setI(i);// this.i = i;
		setJ(j);
	}

	public void sum() {
		// total에 i+j를 할당
		total = getI() + getJ();
		System.out.println("본 객체의 total:" + total);
	}
}