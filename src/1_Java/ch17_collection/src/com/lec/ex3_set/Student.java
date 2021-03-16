package com.lec.ex3_set;

/*
 * 2020.12.17 ~ Lim JaeHyun
 * 이름, 학년 new Student("홍길동",5);
 */
public class Student {
	private String name;
	private int grade;

	public Student(String name, int grade) {
		this.name = name;
		this.grade = grade;
	}

	@Override
	public String toString() {
		return name + ":" + grade; // "홍길동:5"
	}

	@Override // new Student("장보고",1).equals(new Student("장보고",1))
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj != null && obj instanceof Student) {
			boolean nameChk = name.equals(((Student) obj).name);
			boolean gradeChk = grade == ((Student) obj).grade;
			return nameChk && gradeChk;
//			return toString().equals(obj.toString());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
		// "장보고:1"
	}
}