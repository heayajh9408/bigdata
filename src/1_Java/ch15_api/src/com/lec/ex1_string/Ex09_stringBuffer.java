package com.lec.ex1_string;

/*
 * 2020.12.14 ~ Lim JaeHyun
 */
public class Ex09_stringBuffer {
	public static void main(String[] args) {
		String str = new String("abc");
		StringBuilder strBu = new StringBuilder("abc");
		System.out.println("1." + strBu);
		strBu.append("def"); // abcdef
		System.out.println("2." + strBu);
		strBu.insert(3, "AAA"); // 3���ε����� "AAA"�߰�=abcAAAdef
		System.out.println("3." + strBu);
		strBu.delete(3, 6); // 3���ε������� 6���ձ��� ���� abcdef
		System.out.println("4." + strBu);
		int capacitySize = strBu.capacity(); // ����ũ��
		System.out.println("����ũ�� : " + capacitySize);
		System.out.println("�� strBu�� �ؽ��ڵ� : " + strBu.hashCode());
		strBu.append("12345678901234567890");
		capacitySize = strBu.capacity();
		System.out.println("����ũ�� ���� : " + capacitySize);
		System.out.println("������ strBu�� �ؽ��ڵ�:" + strBu.hashCode());
		// ����ũ�⸦ ���������� �ø���
		strBu.ensureCapacity(1000);
		capacitySize = strBu.capacity();
		System.out.println("����ũ�� ���� : " + capacitySize);
		System.out.println("������ strBu�� �ؽ��ڵ�:" + strBu.hashCode());

	}
}
