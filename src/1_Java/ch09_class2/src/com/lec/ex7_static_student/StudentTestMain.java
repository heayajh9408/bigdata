package com.lec.ex7_static_student;
/*
 * 2020.12.04~ Lim JaeHyun
 */
public class StudentTestMain {
	public static void main(String[] args) {
		Student[] students = { new Student("정우성", 90, 91, 91), new Student("김하늘", 100, 80, 95),
				new Student("황정민", 95, 80, 90), new Student("강동원", 95, 90, 99), new Student("유아인", 90, 90, 80), };
		int[] tot = new int[5];
		int[] avg = new int[tot.length];
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t\t\t성 적 표");
		System.out.println("------------------------------------------------------------");
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
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
			avg[idx] = tot[idx] / students.length; // 버림
			avg[idx] = (int) ((double) tot[idx] / students.length + 0.5); // 반올림
		}
		System.out.print("총점" + "\t\t");
		for (int t : tot) {
			System.out.print(t + "\t");
		}
		System.out.println();
		System.out.print("평균" + "\t\t");
		for (int a : avg) {
			System.out.print(a + "\t");
		}
		System.out.println();
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
	}
}