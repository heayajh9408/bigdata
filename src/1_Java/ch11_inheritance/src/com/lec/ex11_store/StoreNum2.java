package com.lec.ex11_store;

/*
 * 2020.12.07~ Lim JaeHyun
 * �δ��-5,000  �����-5,000 �����-����
 */
public class StoreNum2 extends HeadQuarterStore {
	public StoreNum2(String name) {
		super(name);
	}

	// �������̵�(������) ; �θ�Ŭ������ �޼ҵ带 ������
	// �����ε�(�ߺ�����) ; �Ű������� ���� Ÿ������ ���� �̸��� �Լ��� �ߺ� ����
	@Override
	public void bude() {
		System.out.println("�δ�� 5,000��");
	}

	@Override
	public void bibib() {
		System.out.println("����� 5,000��");
	}

	@Override
	public void gonggibab() {
		System.out.println("����� 0��. ����");
	}
}