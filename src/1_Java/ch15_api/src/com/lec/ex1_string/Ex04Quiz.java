package com.lec.ex1_string;

/*
 * 2020.12.14 ~ Lim JaeHyun
 */
import java.util.Scanner;

// I:checkIn("�ݳ��Ǿ����ϴ�" ���), O:checkOut("����Ǿ����ϴ�"���)
// x:����
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
				System.out.println("�ݳ��Ǿ����ϴ�");
			} else if (fn.equalsIgnoreCase("o")) {
				System.out.println("����Ǿ����ϴ�");
			}
		}
//		do {
//			System.out.print("I:checkIn, O:checkOut, x:Exit ?");
//			fn = scanner.next();
//			if(fn.equalsIgnoreCase("i")) {
//				System.out.println("�ݳ��Ǿ����ϴ�");
//			}else if(fn.equalsIgnoreCase("o")) {
//				System.out.println("����Ǿ����ϴ�");
//			}
//		}while(!fn.equalsIgnoreCase("x"));
		System.out.println("DONE");
	}
}