package com.lec.homework;

/*
 * 2020.12.18 ~ Lim JaeHyun
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerMain {
	public static void main(String[] args) {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		PrintWriter printwriter = null;
		Scanner sc = new Scanner(System.in);
		try {
			printwriter = new PrintWriter("txtFile/customer.txt");
			do {
				System.out.println("ȸ�������� �Է��Ͻðڽ��ϱ�?(Y/N)");
				String answer = sc.nextLine();
				if (!answer.equalsIgnoreCase("y")) {
					break;
				}
				System.out.println("�̸���?");
				String name = sc.nextLine();
				printwriter.print(name + "\t");
				System.out.print("��ȭ��ȣ��?");
				String phone = sc.nextLine();
				printwriter.print(phone + "\t");
				System.out.print("������?");
				String birth = sc.nextLine();
				printwriter.print(birth + "\t");
				System.out.println("�� �ּҴ�?");
				String address = sc.nextLine();
				printwriter.print(address + "\n");
				customers.add(new Customer(name, phone, birth, address));
			} while (true);

		} catch (IOException e) {
			System.out.println("������ ����Ʈ��");
		} finally {
			try {
				if (printwriter != null)
					printwriter.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		for (Customer customer : customers) {
			System.out.println(customer);
		}
	}
}
