package com.lec.ex01store;

/*
 * 2020.12.09~ Lim JaeHyun
 * 추상(abstract) 클래스 : 추상메소드가 1개 이상 있는 클래스
 * HeadQuarterStore h = new HeadQuarterStore(); 불가
 * h.kimchi()
 */
public interface HeadQuarterStore {
	public void kimchi(); // 추상(abstract) 메소드

	public void bude();

	public void bibib();

	public void sunde();

	public void gonggibab();

	public String getName();
}