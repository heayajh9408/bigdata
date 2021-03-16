package com.lec.ex;
/*
 * 2020.12.01 Lim JaeHyun
 * 관계(비교)연산자 : 같은지?(==), 다른지?(!=), 큰지?(>), 작은지?(<), 크거나 같은지?(>=) 
 */
public class Ex03 {
	public static void main(String[] args) {
		int n1 = 10, n2 = 5;
		boolean result = n1 > n2;
		System.out.printf("%d %s %d = %b\n", n1, ">", n2, result);
		result = n1 >= n2;
		System.out.printf("%d %s %d = %b\n", n1, ">=", n2, result);
		result = n1 == n2;
		System.out.printf("%d %s %d = %b\n", n1, "==", n2, result);
		result = n1 != n2;
		System.out.printf("%d %s %d = %b\n", n1, "!=", n2, result);
	}
}