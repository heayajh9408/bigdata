package com.lec.ex2_map;

/*
 * 2020.12.17 ~ Lim JaeHyun
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import com.lec.ex1_list.Customer;

public class Ex03_CustomerMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String answer, name, phone, address;
		HashMap<String, Customer> customers = new HashMap<String, Customer>();
		while (true) {
			System.out.print("ȸ�������� �����Ͻðڽ��ϱ�(Y/N)?");
			answer = scanner.nextLine().trim();
			if (answer.equalsIgnoreCase("n")) {
				break;
			} else if (answer.equalsIgnoreCase("y")) {
				System.out.print("������ ȸ���� �̸��� ?");
				name = scanner.nextLine();
				System.out.print("������ ȸ���� ����ȣ�� ?");
				phone = scanner.nextLine();
				System.out.print("������ ȸ���� �ּҴ� ?");
				address = scanner.nextLine();
				customers.put(phone, new Customer(name, phone, address));
			}
		}
		scanner.close();
		if (customers.isEmpty()) {
			System.out.println("������ ȸ���� �����ϴ�");
		} else {
			System.out.println("������ ȸ�� ����Ʈ ���");
			Iterator<String> iterator = customers.keySet().iterator();
			while (iterator.hasNext()) {
				String key = iterator.next();
				System.out.println(customers.get(key));
			} // while
		} // if
	}// main
}// class