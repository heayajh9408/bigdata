package com.lec.ex01store;
/*
 * 2020.12.08~ Lim JaeHyun
 */

public abstract class HeadQuarterStore {
	private String name;

	public HeadQuarterStore(String name) {
		this.name = name;
	}

	public abstract void kimchi(); // 추상(abstract) 메소드

	public abstract void bude();

	public abstract void bibib();

	public abstract void sunde();

	public abstract void gonggibab();

	public String getName() {
		return name;
	}
}