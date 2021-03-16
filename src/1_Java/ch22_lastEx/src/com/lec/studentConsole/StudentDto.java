package com.lec.studentConsole;

public class StudentDto {
	private int rank; // 등수
	private String sNo; // 학번
	private String sName; // 학생이름
	private String mName; // 학과이름
	private int score; // 점수

	public StudentDto(int rank, String sNo, String sName, String mName, int score) {
		this.rank = rank;
		this.sNo = sNo;
		this.sName = sName;
		this.mName = mName;
		this.score = score;
	}

	@Override
	public String toString() {
		return rank + "등\t" + sName + "(" + sNo + ")\t" + mName + "\t" + score;
	}
}