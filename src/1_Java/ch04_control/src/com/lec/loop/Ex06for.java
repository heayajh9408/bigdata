package com.lec.loop;
/*
 * 2020.12.02~ Lim JaeHyun
 * loop문을 작성할 때는 무한반복문에 들어가지 않도록 주의!!!!!!중요!!!!!
 */

public class Ex06for {
	public static void main(String[] args) {
		int i=0;
		for( ;  ; ) {
			System.out.println(i);
		}
	}
}