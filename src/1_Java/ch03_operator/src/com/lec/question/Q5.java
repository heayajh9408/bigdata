package com.lec.question;

import java.util.Scanner;

//국어, 영어, 수학 점수를 변수에 할당하고 각 점수를 출력하고 총점, 평균(소수점2자리까지) 출력하는 프로그램을 구현 하시오
public class Q5 {
	public static void main(String[] args) {
		Scanner su = new Scanner(System.in);
		System.out.println("국어점수는?");
		int kor = su.nextInt();
		System.out.println("영어점수는?");
		int eng = su.nextInt();
		System.out.println("수학점수는?");
		int mat = su.nextInt();
		int result = kor+eng+mat;
		double avg= result/3.0;
		System.out.printf("국어점수는=%3d\n",kor);
		System.out.printf("영어점수는=%3d\n",eng);
		System.out.printf("수학점수는=%3d\n",mat);
		System.out.printf("총점은=%3d\n",result);
		System.out.printf("평균은=%.2f\n",avg);
		su.close();
		
	}
}
