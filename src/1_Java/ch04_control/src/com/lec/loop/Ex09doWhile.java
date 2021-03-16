package com.lec.loop;
/*
 * 2020.12.02~ Lim JaeHyun
 */
import java.util.Scanner;
public class Ex09doWhile {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num;
		do {
			System.out.print("짝수를 입력하세요 : ");
			num = scanner.nextInt();
			// 사용자로부터 입력받은 수를 num 할당
		}while(num%2 == 1 || num%2==-1);
		System.out.println("입력하신 짝수는 "+num);
		scanner.close();
	}
}
