package com.lec.ex7_static_student;

/*
 * 2020.12.04~ Lim JaeHyun
 */
public class Student {
	private static int count = 0;
	private int no;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double avg;

	public Student() {
	}

	public Student(String name, int kor, int eng, int mat) {
		no = ++count;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		tot = kor + eng + mat;
		avg = tot / 3.0; // ¹Ý¿Ã¸²
	}

	public void print() {
		System.out.printf("%d\t %s\t %d\t %d\t %d\t %d\t %5.2f\n", no, name, kor, eng, mat, tot, avg);
	}

	public void infoString() {
		System.out.printf("%d\t %s\t %d\t %d\t %d\t %d\t %5.2f\n", no, name, kor, eng, mat, tot, avg);
		return;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Student.count = count;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}
}