package com.lec.ex;
/*
 * 2020.11.30~ Lim JaeHyun
 * ����ȯ = �������� ����ȯ, ������� ����ȯ
 */
public class VarEx07 {
	public static void main(String[] args) {
		int i1 = 10; // 4byte
		long l1 = 2200000000L;
		l1 = 10; // long�� 8byte�� 4byte¥�� 10�� �Ҵ��ϱ� ����
		// 4byte¥�� 10�� 8byte¥�� long������ �������� ����ȯ�� ��
		double d = i1; // �������� ����ȯ
		d = 10.7;
		i1 = (int) d; // ������� ����ȯ�ÿ��� ������ �ս��� �� �� �ִ�
		System.out.print("i1=" + i1);
	}
}