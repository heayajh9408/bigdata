package com.lec.ex01store;

//extends->implements name���� �߰�, �����ڼ���, getter�߰�
public class StoreNum3 implements HeadQuarterStore {
	private String name;

	public StoreNum3(String name) {
		this.name = name;
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

	@Override
	public String getName() {
		return name;
	}
}
