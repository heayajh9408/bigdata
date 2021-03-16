package com.lec.ex1_list;

/*
 * 2020.12.17 ~ Lim JaeHyun
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Ex05_CustomerMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String answer, name, phone, address;
		ArrayList<Customer> customers = new ArrayList<Customer>();
		// Customer[] cs = new Customer[10];
		do {
			System.out.print("회원가입 진행하시겠습니까(Y/N)? ");
			answer = scanner.next();
			if (answer.equalsIgnoreCase("y")) {// 회원가입 진행
				System.out.print("가입하실 회원님 이름은 ?");
				name = scanner.next();
				System.out.print("가입하실 회원님 전화번호는 ?");
				phone = scanner.next();
				System.out.print("가입하실 회원님 주소는 ?");
				scanner.nextLine(); // 버퍼지우는 용도
				address = scanner.nextLine();
//				Customer temp = new Customer(name, phone, address);
//				customers.add(temp);
				customers.add(new Customer(name, phone, address));
			} else if (answer.equalsIgnoreCase("n")) {
				break;
			}
		} while (true);
		System.out.println("가입한 회원 리스트 목록");
		for (Customer customer : customers) {
			System.out.println(customer);
		}
//		for(int idx = 0 ; idx<customers.size() ; idx++) {
//			System.out.println(customers.get(idx));
//		}
	}// main
}// class