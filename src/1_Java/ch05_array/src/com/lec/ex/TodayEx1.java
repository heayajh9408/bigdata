package com.lec.ex;

/*
 * 2020.12.02
 * 다음 배열에 담긴 값을 더하는 프로그램을 작성 
 *int[] arr =  { 10, 20, 30, 40, 50}
 */
public class TodayEx1 {
	public static void main(String[] args) {
		int sum = 0;
		int[] arr = { 10, 20, 30, 40, 50 };
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println("배열의 합은=" + sum);
	}
}
