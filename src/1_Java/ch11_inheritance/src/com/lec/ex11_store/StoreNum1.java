package com.lec.ex11_store;

/*
 * 2020.12.07~ Lim JaeHyun
 * �δ��-5,000, ���뱹-���Ⱦ�   StoreNum1 store1 = new StoreNum1("���ð� 1ȣ��");
 */
public class StoreNum1 extends HeadQuarterStore {
	public StoreNum1(String name) {
		super(name);
	}

	@Override
	public void bude() {
		System.out.println("�δ�� 5,000��");
	}

	@Override
	public void sunde() {
		System.out.println("���뱹 �� �Ⱦ�");
	}
}