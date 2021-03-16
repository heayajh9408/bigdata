package com.lec.ex7_static_student;
/*
 * 2020.12.04~ Lim JaeHyun
 */
public class StudentTestMain {
	public static void main(String[] args) {
		Student[] students = { new Student("���켺", 90, 91, 91), new Student("���ϴ�", 100, 80, 95),
				new Student("Ȳ����", 95, 80, 90), new Student("������", 95, 90, 99), new Student("������", 90, 90, 80), };
		int[] tot = new int[5];
		int[] avg = new int[tot.length];
		System.out.println("�������������������������������������������������������������");
		System.out.println("\t\t\t�� �� ǥ");
		System.out.println("------------------------------------------------------------");
		System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���");
		System.out.println("------------------------------------------------------------");
		for (Student student : students) {
			student.infoString();
			tot[0] += student.getKor();
			tot[1] += student.getEng();
			tot[2] += student.getMat();
			tot[3] += student.getTot();
			tot[4] += student.getAvg();
		}
		System.out.println("------------------------------------------------------------");
		for (int idx = 0; idx < avg.length; idx++) {
			avg[idx] = tot[idx] / students.length; // ����
			avg[idx] = (int) ((double) tot[idx] / students.length + 0.5); // �ݿø�
		}
		System.out.print("����" + "\t\t");
		for (int t : tot) {
			System.out.print(t + "\t");
		}
		System.out.println();
		System.out.print("���" + "\t\t");
		for (int a : avg) {
			System.out.print(a + "\t");
		}
		System.out.println();
		System.out.println("�������������������������������������������������������������");
	}
}