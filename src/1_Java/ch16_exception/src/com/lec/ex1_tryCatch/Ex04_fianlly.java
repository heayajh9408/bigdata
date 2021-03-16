package com.lec.ex1_tryCatch;

/*
 * 2020.12.16 ~ Lim JaeHyun
 */
public class Ex04_fianlly {
	public static void main(String[] args) {
		int[] iArr = { 0, 1, 2 };
		for (int i = 0; i <= iArr.length; i++) {
			try {
				System.out.println("iArr[" + i + "] = " + iArr[i]);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("���� �޼��� : " + e.getMessage());
			} finally {
				System.out.println("try�� �����Ŀ��� catch�� �����Ŀ��� ����� �ᱹ ����");
			}
		} // for
		System.out.println("���α׷� ��");
	}// main
}