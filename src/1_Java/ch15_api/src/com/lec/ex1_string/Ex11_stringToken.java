package com.lec.ex1_string;

/*
 * 2020.12.14 ~ Lim JaeHyun
 */
import java.util.StringTokenizer;

public class Ex11_stringToken {
	public static void main(String[] args) {
		String str1 = "정해인 유준상 강동원 김윤석 하정우";
		String str2 = "2020/12/14";
		// space, \t, \n단위로 token나눔
		StringTokenizer token1 = new StringTokenizer(str1);
		StringTokenizer token2 = new StringTokenizer(str2, "/");

		System.out.println("token1의 갯수:" + token1.countTokens());
		while (token1.hasMoreTokens()) {
			System.out.println(token1.nextToken());
		}

		System.out.println("token2의 갯수:" + token2.countTokens());
		while (token2.hasMoreElements()) {
			System.out.println(token2.nextToken());
		}
	}
}
