package com.lec.ex;

/*
 * 2020.12.02
 * �Ž����� 2680�� 500, 100, 50, 10¥�� �������� �ٶ�      ��� �־�� �ϳ�?
 */
public class TodayEx3 {
	public static void main(String[] args) {
		int[] arr = { 500, 100, 50, 10 };
		int money = 2680;
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "����" + (money / arr[i] + "��"));
			money = money % arr[i];

		}
	}
}
