package com.lec.ex;
/*
 *  2020.11.30~ Lim JaeHyun
 */
public class VarEx05_06 {
	public static void main(String[] args) {
		float f;
		double d;
		f = 3.14159265359f;
		d = 3.14159265359;
		System.out.println(f);
		System.out.println(d);
		f = 10.001f;
		d = 10.001;
		System.out.println("f=" + f);
		System.out.println("d=" + d);
		if (f == d)
			System.out.println("f�� d�� ����");
		else
			System.out.println("f�� d�� �ٸ���");
	}
}