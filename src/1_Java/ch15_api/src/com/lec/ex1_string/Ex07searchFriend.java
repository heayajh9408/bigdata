package com.lec.ex1_string;

/*
 * 2020.12.14 ~ Lim JaeHyun
 */
import java.util.Scanner;

// ��ȭ��ȣ ���ڸ��� ģ�� ã��
public class Ex07searchFriend {
	public static void main(String[] args) {
		Friend[] friends = { new Friend("ȫ�浿", "010-9999-9999", "12-14"), new Friend("�ű浿", "010-9999-8888", "08-14"),
				new Friend("���̼�", "010-9999-7777", "01-14") };
		Scanner scanner = new Scanner(System.in);
		// ã�� ģ���� ��ȭ��ȣ ���ڸ��� �Է¹���
		System.out.print("ã�� ���� ģ���� ��ȭ��ȣ ���ڸ��� ?");
		String searchTel = scanner.next();
		int idx;
		boolean searchOk = false;
		// friends�迭���� �ش� ��ȭ��ȣ ���ڸ��� ���� ģ���� ������ �� ģ���� ���
		// ������ ���ٰ� ���
		for (idx = 0; idx < friends.length; idx++) {
			String temp = friends[idx].getTel();
			String post = temp.substring(temp.lastIndexOf("-") + 1);
			if (post.equals(searchTel)) {
				System.out.println(friends[idx]); // Object�� toString()
				// friends[idx].print();
				searchOk = true; // �ߺ��� �޹�ȣ�� ���� ���
				break; // �ߺ��� �޹�ȣ�� ���� ���
			} // if
		} // for
		if (!searchOk) {
			System.out.println("�ش��ȣ�� ģ���� �����ϴ�.");
		}
	}
}