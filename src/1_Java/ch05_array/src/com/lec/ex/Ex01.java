package com.lec.ex;

/*
 * 2020.12.02
 */
public class Ex01 {
	public static void main(String[] args) {
		int i = 10; // 변수의 선언과 초기화
		int[] iArr = { 10, 20, 30, 40, 50 }; // 1. 배열 변수 선언과 초기화
		iArr[3] = 300; // 배열은 index로 접근 (index:0~4)
		for (int idx = 0; idx < 5; idx++) {
			System.out.println(iArr[idx]);
		}
		int[] iArr2 = new int[5]; // 2.배열 변수 선언과 배열메모리 공간
		iArr2[0] = 999;
		for (int idx = 0; idx < iArr2.length; idx++) {
			System.out.println(idx + "번째값 : " + iArr2[idx]);
		}
		System.out.println("*******************");
		int[] iArr3; // 3. 배열 변수 선언
		iArr3 = new int[5]; // 0 0 0 0 0
		for(int temp : iArr3) {//확장for문으로 값변경(x)
			temp = 10;
		}
		for(int temp : iArr3) {// 확장 for문
			System.out.println(temp);
		}
		for(int idx=0; idx<iArr3.length ; idx++) {
			iArr3[idx] = 10;//일반for문으로 값 변경(O)
		}
		for(int temp : iArr3) {// 확장 for문
			System.out.println(temp);
		}
	}
}
