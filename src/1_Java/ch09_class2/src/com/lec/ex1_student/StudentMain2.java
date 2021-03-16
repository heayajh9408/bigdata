package com.lec.ex1_student;

/*
 * 2020.12.04~ Lim JaeHyun
 */
public class StudentMain2 {
	public static void main(String[] args) {
		Student[] kim = { new Student("정우성", 90, 90, 90), new Student("김하늘", 90, 90, 91),
				new Student("황정민", 80, 80, 80), new Student("강동원", 80, 80, 81), new Student("유아인", 70, 70, 70) };
		int[] sum = new int[5];
		double[] avg = new double[5];
		String[] arr = { "이름", "국어", "영어", "수학", "총점", "평균" };
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t\t\t 성적표 \t\t\t");
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
		System.out.print("\t총점");
		for (int i = 0; i < avg.length; i++) {
			avg[i] = sum[i] / kim.length;
			System.out.print("\t " + sum[i]);
		}
		System.out.print("\n\t평균");
		for (double a : avg) {
			System.out.print("\t" + a);
		}
		System.out.println();
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
	}
}
