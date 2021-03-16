package com.lec.ex;
// 2차원 배열에 저장된 값의 합계를 구하시오
// int[][] arr = { {5,5,5,5,5}, {10, 10, 10, 10, 10}, 
// {20, 20, 20, 20, 20}, {30, 30, 30, 30, 30}};
public class TodayEx2 {
	public static void main(String[] args) {
		int sum =0;
		int[][] arr = { {5,5,5,5,5}, {10, 10, 10, 10, 10}, 
				{20, 20, 20, 20, 20}, {30, 30, 30, 30, 30}};
		for(int i= 0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				sum+=arr[i][j];
			}
		}
		System.out.println("2차원 배열의 합은"+sum);
	}
}
