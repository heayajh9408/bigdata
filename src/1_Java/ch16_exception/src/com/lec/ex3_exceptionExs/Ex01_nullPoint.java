package com.lec.ex3_exceptionExs;

/*
 * 2020.12.16 ~ Lim JaeHyun
 */
public class Ex01_nullPoint {
	public static void main(String[] args) {
		String greeting = "Hello";
		System.out.println(greeting.toUpperCase());
		greeting = null;
		System.out.println(greeting.toUpperCase());
	}
}