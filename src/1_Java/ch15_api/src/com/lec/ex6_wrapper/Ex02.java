package com.lec.ex6_wrapper;

/*
 * 2020.12.15 ~ Lim JaeHyun
 */
// 가변인자함수 cf.인자==매개변수
public class Ex02 {
	public static void main(String[] args) {
		int total = valueSum("10", "20");
		System.out.println("들어온 값의 합계는 " + total);
	}

	private static int valueSum(String... value) {
		int result = 0; // 누적변수
		for (int i = 0; i < value.length; i++) {
			result += Integer.parseInt(value[i]);
			// Integer.parseInt(val); val문자열을 정수로 바꿈
		}
		return result;
	}
}