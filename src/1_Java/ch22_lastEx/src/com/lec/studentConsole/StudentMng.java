package com.lec.studentConsole;

import java.util.ArrayList;
import java.util.Scanner;

import com.lec.person_dao.PersonDto;

public class StudentMng {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StudentDao dao = StudentDao.getInstance();
		String fn;
		do {
			System.out.println("1:�Է� | 2:�а������ | 3:��ü��� | 4:��������� | �׿�:���� >");
			fn = scanner.next();
			switch (fn) {
			case "1": // �̸�, ������, ������ �Է¹޾� dao.insertPerson()ȣ��
				System.out.print("�Է��� �̸� >");
				String sName = scanner.next();
				System.out.print("�а��� >");
				String mName = scanner.next();
				System.out.print("���� >");
				int score = scanner.nextInt();
				if (score < 0 || score > 100) {
					System.out.println("��ȿ���� ���� ������ �Է��ϼż� �Է� �Ұ��մϴ�");
					continue;
				}
				int result = dao.insertStudent(sName, mName, score);
				System.out.println(result == StudentDao.SUCCESS ? "�Է¼���" : "�Է½���");
				break;
			case "2":
				System.out.print("��ȸ�� �а�����(�������� | �濵������ | ��ǻ�Ͱ��� | ����Ʈ���� | �ΰ�������)? ");
				mName = scanner.next();
				ArrayList<StudentDto> students = dao.selectMname(mName);
				if (students.size() != 0) {
					System.out.println("���\t�̸�\t�а�\t����");
					for (StudentDto student : students) {
						System.out.println(student);
					}
				} else {
					System.out.println("�ش� �а� �л��� �����ϴ�");
				}
				break;
			case "3":
				students = dao.selectStudent();
				if (students.size() != 0) {
					System.out.println("���\t�̸�\t�а�\t����");
					for (StudentDto student : students) {
						System.out.println(student);
					}
				} else {
					System.out.println("�ش� �а� �л��� �����ϴ�");
				}
				break;
			case "4":
				students = dao.selectExpel();
				if (students.size() != 0) {
					System.out.println("���\t�̸�\t�а�\t����");
					for (StudentDto student : students) {
						System.out.println(student);
					}
				} else {
					System.out.println("�ش� �а� �л��� �����ϴ�");
				}
				break;
			}
		} while (fn.equals("1") || fn.equals("2") || fn.equals("3") || fn.equals("4"));
		System.out.println("BYE");
	}
}