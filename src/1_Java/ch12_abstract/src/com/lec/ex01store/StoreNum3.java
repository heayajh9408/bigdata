package com.lec.ex01store;

/*
 * 2020.12.08~ Lim JaeHyun
 */
public class StoreNum3 extends HeadQuarterStore {
	public StoreNum3(String name) {
		super(name);
	}

	@Override
	public void kimchi() {
		System.out.println("��ġ� 6,000��");
	}

	@Override
	public void bude() {
		System.out.println("�δ�� 7,000��");
	}

	@Override
	public void bibib() {
		System.out.println("����� 7,000��");
	}

	@Override
	public void sunde() {
		System.out.println("���뱹 6,000��");
	}

	@Override
	public void gonggibab() {
		System.out.println("����� 1,000��");
	}
}