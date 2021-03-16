package com.lec.ex;

/*
 * 2020.12.03~ Lim JaeHyun
 */
public class Arithmetic {
	public int sum(int to) {
		int result = 0; // 누적해서 전달할 변수
		for (int i = 1; i <= to; i++) {
			result = result + i; // result += i;
		}
		return result;
	}

	public int sum(int from, int to) {// from=1, to=100
		int result = 0; // 누적해서 전달할 변수
		for (int i = from; i <= to; i++) {
			result = result + i; // result += i;
		}
		return result;
	}

	public String evenOdd(int value) {
		String result = value % 2 == 0 ? "짝수입니다" : "홀수입니다";
		return result;
	}

	public static int abs(int value) {
		int result = (value >= 0) ? value : -value;
//		if(value>=0) {
//			result = value;
//		}else {
//			result = -value;
//		}
		return result;
	}
}
