package com.lec.ex1_student;

/*
 * 2020.12.04~ Lim JaeHyun
 */
public class StudentMain1 {
	public static void main(String[] args) {
		Student[] kim = { new Student("���켺", 90, 90, 90), new Student("���ϴ�", 90, 90, 91),
				new Student("Ȳ����", 80, 80, 80), new Student("������", 80, 80, 81), new Student("������", 70, 70, 70) };
		String[] arr = { "�̸�", "����", "����", "����", "����", "���" };
		System.out.println("������������������������������������������������������������������");
		System.out.println("\t\t\t ����ǥ \t\t\t");
		System.out.println("-----------------------------------------------------------------");
		for (String s : arr) {
			System.out.print("\t" + s);
		}
		System.out.println();
		System.out.println("-----------------------------------------------------------------");
		for (Student li : kim) {
			li.print();
		}
		System.out.println("������������������������������������������������������������������");
	}
}
