package com.lec.ex1_string;

/*
 * 2020.12.14 ~ Lim JaeHyun
 */
public class Ex10_speedChk {
	public static void main(String[] args) {
		String str = "A";
		// ���۽ð� ����
		long start = System.currentTimeMillis();
		for (int i = 0; i < 200000; i++) {
			str = str.concat("a");
		}
		// ������ �ð� ����
		long end = System.currentTimeMillis();
		System.out.println("��Ʈ�� ���� �ð� : " + (end - start));

		StringBuffer strBuff = new StringBuffer("A");
		start = System.currentTimeMillis();
		for (int i = 0; i < 200000; i++) {
			strBuff.append("a");
		}
		end = System.currentTimeMillis();
		System.out.println("StringBuff����ð� : " + (end - start));
		StringBuilder strBuil = new StringBuilder("A");
		start = System.currentTimeMillis();
		for (int i = 0; i < 200000; i++) {
			strBuil.append("a");
		}
		end = System.currentTimeMillis();
		System.out.println("StringBuilder ����ð� : " + (end - start));
	}
}
