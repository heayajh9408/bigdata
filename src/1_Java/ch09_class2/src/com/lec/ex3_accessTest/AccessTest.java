package com.lec.ex3_accessTest;

/*
 * 2020.12.04~ Lim JaeHyun
 */
public class AccessTest {
	private int privateMember; // ���� Ŭ���� ��������
	int defaultMember; // ����Ʈ:���� ��Ű��������
	protected int protectedMember; // ���� ��Ű���� ��ӹ��� ����Ŭ��������
	public int publicMember; // �ܺο��� �ƹ�����

	private void privateMethod() { // ���� Ŭ���� ��������
		System.out.println("private �޼ҵ� ȣ��");
	}

	void defaultMethod() { // ���� ��Ű��������
		System.out.println("����Ʈ �޼ҵ� ȣ��");
	}

	protected void protectedMethod() {
		System.out.println("protected �޼ҵ� ȣ��");
	}

	public void publicMethod() {
		System.out.println("public �޼ҵ� ȣ��");
	}
}
