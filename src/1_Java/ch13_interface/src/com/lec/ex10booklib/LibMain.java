package com.lec.ex10booklib;

/*
 * 2020.12.09~ Lim JaeHyun
 */
import java.util.Scanner;

public class LibMain {
	public static void main(String[] args) {
		BookLib[] books = { new BookLib("890��-100", "java", "�ƹ���"), new BookLib("890��-101", "hadoop", "������"),
				new BookLib("890��-102", "oracle", "�̹���"), new BookLib("890��-103", "python", "�蹫��"),
				new BookLib("892��-100", "spark", "�Ź���") };
		Scanner sc = new Scanner(System.in);
		int fn, idx = 0; // ��ɹ�ȣ(1:����,2:�ݳ�...), �ε���(books��)
		String bTitle, borrower, checkOutDate; // å����,������,������
		do {
			System.out.print("1:���� | 2:�ݳ� | 3:������Ȳ | 0:���� ");
			fn = sc.nextInt();
			switch (fn) {
			case 1: // å�̸�->å��ȸ ->�ش�å�� ����->������,������->����
				// å�̸� �Է�
				System.out.print("������ å�̸���?");
				bTitle = sc.next(); // ��Ʈ���� �ޱ� ���� next()
				// å��ȸ
				for (idx = 0; idx < books.length; idx++) {
					if (bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				} // for
					// å��ȸ���� å�� ã�Ҵ��� ��ã�Ҵ��� ���� ���� ����
				if (idx == books.length) {
					System.out.println("�� ���������� �ش� ������ �����ϴ�");
				} else if (books[idx].getState() == ILendable.STATE_BORROWED) {
					System.out.println(bTitle + " ������ �������Դϴ�");
				} else {
					// ���� �����̴� ������, ������ �Է¹ް� ��������
					System.out.print("�������� ?");
					borrower = sc.next();
					System.out.print("�������� ?");
					checkOutDate = sc.next();
					books[idx].checkOut(borrower, checkOutDate);
				} // if
				break;
			case 2: // å�̸�->å��ȸ->�ݳ�
				System.out.print("�ݳ��� å�̸���?");
				bTitle = sc.next();
				for (idx = 0; idx < books.length; idx++) {
					if (bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				} // for
				if (idx == books.length) {
					System.out.println("�ش絵���� �� �������� å�� �ƴմϴ�");
				} else {
					books[idx].checkIn();
				} // if
				break;
			case 3: // for���� �̿��ؼ� �������� ���
				for (BookLib book : books) {
					book.printState();
				} // for
			}// switch
		} while (fn != 0);
		sc.close();
		System.out.println("�ý��� ����");
	}
}