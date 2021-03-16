package com.lec.question;

import java.util.Scanner;

//두수를 입력받아 
//두 수가 같은지 결과를 O나 X로 출력(ex. 두수가 같은지 여부 : X).
//첫번째 수가 더 큰지 결과를 O나 X로 출력한다(ex. 첫번째 수가 큰지 여부 : O).
public class Q3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("첫 수는?");
		int k = scanner.nextInt();
		System.out.println("두번째 수는?");
		int m = scanner.nextInt();
		String result= k==m? "o":"x";
		System.out.println("k==m 결과는"+result);
		boolean result2 = k>m;
		System.out.println("k>m 결과는 "+((result2==true)? "o":"x"));
		scanner.close();
	}
}
