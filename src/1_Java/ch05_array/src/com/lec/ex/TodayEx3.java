package com.lec.ex;

/*
 * 2020.12.02
 * 거스름돈 2680을 500, 100, 50, 10짜리 동전으로 줄때      몇개씩 주어야 하나?
 */
public class TodayEx3 {
	public static void main(String[] args) {
		int[] arr = { 500, 100, 50, 10 };
		int money = 2680;
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "원은" + (money / arr[i] + "개"));
			money = money % arr[i];

		}
	}
}
