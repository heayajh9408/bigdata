package com.lec.loop;
/*
 * 2020.12.02~ Lim JaeHyun
 * i가 1일 때 누적합은 X이다(i가 1~10까지)
 */

public class Ex08while {
	public static void main(String[] args) {
		int i=1;
		int sum = 0;
		while(i<=10) {
			sum += i; // sum = sum+i;
			System.out.printf("i가 %d일 때 누적합은 %d이다\n",i, sum);
			++i;
		}
//	for(int j=1 ; j<=10 ; j++) {
//			System.out.printf("i가 %d일 때 누적합은 %d이다\n",j, sum);
		}
	}