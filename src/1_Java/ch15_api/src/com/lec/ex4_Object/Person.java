package com.lec.ex4_Object;

/*
 * 2020.12.14 ~ Lim JaeHyun
 */
public class Person {
	private long juminNo; // 9301113252012

	public Person(long juminNo) {
		this.juminNo = juminNo;
	}

	@Override
	public boolean equals(Object obj) {
		// Person p3;
		// p1.equals(p3) -> false / p1.equals(str1) -> false
		// p1.equals(p2) -> this�� p1, obj�� p2
		// this.juminNo�� obj.juminNo�� ������ true�� return
		if (obj != null && obj instanceof Person) {
			// juminNo == obj.juminNo ���� return
			return juminNo == ((Person) obj).juminNo;
		} // if
		return false;
	}// equals
}// class
