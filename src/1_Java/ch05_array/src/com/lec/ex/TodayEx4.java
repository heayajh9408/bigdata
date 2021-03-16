package com.lec.ex;

/*
 * 2020.12.02
 * 6,45,34,89,100,50,90,92  8개의 값을 1차원 배열로 초기화 하고
 * 값에 합계와  평균 그리고 최대값과 최소값을 구하는 프로그램을 작성 하시요.
 */
public class TodayEx4 {
	public static void main(String[] args) {
		int[] arr = { 6, 45, 34, 89, 100, 50, 90, 92 };
		int sum = 0;
		int avg = sum / arr.length;
		int max = -300;
		int min = 300;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];

			if (arr[i] >= max) {
				max = arr[i];
			} else {
				min = arr[i];
			}
		}
		avg = sum / arr.length;
		System.out.printf("합계는 %d 평균은 %d 최대값은 %d 최소값은 %d", sum, avg, max, min);
	}
}
