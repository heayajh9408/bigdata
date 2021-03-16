package com.lec.ex1_string;

/*
 * 2020.12.14 ~ Lim JaeHyun
 */
import java.util.Scanner;

// I:checkIn("반납되었습니다" 출력), O:checkOut("대출되었습니다"출력)
// x:종료
public class Ex04Quiz {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String fn;
		while (true) {
			System.out.print("I:checkIn, O:checkOut, x:Exit ?");
			fn = scanner.next();
			if (fn.equalsIgnoreCase("x")) {
				break;
			} else if (fn.equalsIgnoreCase("i")) {
				System.out.println("반납되었습니다");
			} else if (fn.equalsIgnoreCase("o")) {
				System.out.println("대출되었습니다");
			}
		}
//		do {
//			System.out.print("I:checkIn, O:checkOut, x:Exit ?");
//			fn = scanner.next();
//			if(fn.equalsIgnoreCase("i")) {
//				System.out.println("반납되었습니다");
//			}else if(fn.equalsIgnoreCase("o")) {
//				System.out.println("대출되었습니다");
//			}
//		}while(!fn.equalsIgnoreCase("x"));
		System.out.println("DONE");
	}
}