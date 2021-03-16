package com.lec.ex1_string;

/*
 * 2020.12.14 ~ Lim JaeHyun
 */
public class Ex09_stringBuffer {
	public static void main(String[] args) {
		String str = new String("abc");
		StringBuilder strBu = new StringBuilder("abc");
		System.out.println("1." + strBu);
		strBu.append("def"); // abcdef
		System.out.println("2." + strBu);
		strBu.insert(3, "AAA"); // 3번인덱스에 "AAA"추가=abcAAAdef
		System.out.println("3." + strBu);
		strBu.delete(3, 6); // 3번인덱스부터 6번앞까지 삭제 abcdef
		System.out.println("4." + strBu);
		int capacitySize = strBu.capacity(); // 가용크기
		System.out.println("가용크기 : " + capacitySize);
		System.out.println("현 strBu의 해쉬코드 : " + strBu.hashCode());
		strBu.append("12345678901234567890");
		capacitySize = strBu.capacity();
		System.out.println("가용크기 변경 : " + capacitySize);
		System.out.println("변경후 strBu의 해쉬코드:" + strBu.hashCode());
		// 가용크기를 인위적으로 늘리기
		strBu.ensureCapacity(1000);
		capacitySize = strBu.capacity();
		System.out.println("가용크기 변경 : " + capacitySize);
		System.out.println("변경후 strBu의 해쉬코드:" + strBu.hashCode());

	}
}
