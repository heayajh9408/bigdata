package com.lec.ex1_student;

/*
 * 2020.12.04~ Lim JaeHyun
 */
public class StudentMain2 {
	public static void main(String[] args) {
		Student[] kim = { new Student("���켺", 90, 90, 90), new Student("���ϴ�", 90, 90, 91),
				new Student("Ȳ����", 80, 80, 80), new Student("������", 80, 80, 81), new Student("������", 70, 70, 70) };
		int[] sum = new int[5];
		double[] avg = new double[5];
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
			sum[0] += li.getKor();
			sum[1] += li.getEng();
			sum[2] += li.getMat();
			sum[3] += li.getTot();
			sum[4] += li.getAvg();
		}
		System.out.println("-----------------------------------------------------------------");
		System.out.print("\t����");
		for (int i = 0; i < avg.length; i++) {
			avg[i] = sum[i] / kim.length;
			System.out.print("\t " + sum[i]);
		}
		System.out.print("\n\t���");
		for (double a : avg) {
			System.out.print("\t" + a);
		}
		System.out.println();
		System.out.println("������������������������������������������������������������������");
	}
}
