package com.lec.ex01store;

//extends->implements name���� �߰�, �����ڼ���, getter�߰�
public class StoreNum2 implements HeadQuarterStore {
	private String name;

	public StoreNum2(String name) {
		this.name = name;
	}

	// �������̵�(������) ; �θ�Ŭ������ �޼ҵ带 ������
	// �����ε�(�ߺ�����) ; �Ű������� ���� Ÿ������ ���� �̸��� �Լ��� �ߺ� ����
	@Override
	public void kimchi() {
		System.out.println("��ġ� 5,000��");
	}

	@Override
	public void bude() {
		System.out.println("�δ�� 5,000��");
	}

	@Override
	public void bibib() {
		System.out.println("����� 5,000��");
	}

	@Override
	public void sunde() {
		System.out.println("���뱹 5,000��");
	}

	@Override
	public void gonggibab() {
		System.out.println("����� 0��. ����");
	}

	@Override
	public String getName() {
		return name;
	}
}
