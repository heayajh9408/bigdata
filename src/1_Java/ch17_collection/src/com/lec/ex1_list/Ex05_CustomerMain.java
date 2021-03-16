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
			System.out.print("ȸ������ �����Ͻðڽ��ϱ�(Y/N)? ");
			answer = scanner.next();
			if (answer.equalsIgnoreCase("y")) {// ȸ������ ����
				System.out.print("�����Ͻ� ȸ���� �̸��� ?");
				name = scanner.next();
				System.out.print("�����Ͻ� ȸ���� ��ȭ��ȣ�� ?");
				phone = scanner.next();
				System.out.print("�����Ͻ� ȸ���� �ּҴ� ?");
				scanner.nextLine(); // ��������� �뵵
				address = scanner.nextLine();
//				Customer temp = new Customer(name, phone, address);
//				customers.add(temp);
				customers.add(new Customer(name, phone, address));
			} else if (answer.equalsIgnoreCase("n")) {
				break;
			}
		} while (true);
		System.out.println("������ ȸ�� ����Ʈ ���");
		for (Customer customer : customers) {
			System.out.println(customer);
		}
//		for(int idx = 0 ; idx<customers.size() ; idx++) {
//			System.out.println(customers.get(idx));
//		}
	}// main
}// class