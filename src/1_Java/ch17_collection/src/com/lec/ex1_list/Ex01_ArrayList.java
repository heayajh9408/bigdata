package com.lec.ex1_list;

/*
 * 2020.12.17 ~ Lim JaeHyun
 */
import java.util.ArrayList;

public class Ex01_ArrayList {
	public static void main(String[] args) {
		String[] array = new String[3];
		array[0] = "str0";
		array[1] = "str1";
		array[2] = "str2";
		for (int idx = 0; idx < array.length; idx++) {
			System.out.println("array[" + idx + "] = " + array[idx]);
		}
		for (String arr : array) {
			System.out.println(arr);
		}
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("str0"); // 0인덱스
		arrayList.add("str1"); // 2인덱스
		arrayList.add("str2"); // 3인덱스
		arrayList.add(1, "111111");// 1 인덱스
		for (int idx = 0; idx < arrayList.size(); idx++) {
			System.out.println(idx + "번째 = " + arrayList.get(idx));
		}
		arrayList.remove(1); // 1번 인덱스값 삭제(2번인덱스가1번으로, 3번인덱스가 2번으로)
		System.out.println(arrayList);
		arrayList.clear(); // arrayList의 모든 데이터 삭제
		// if(arrayList.size()==0) {
		if (arrayList.isEmpty()) {
			System.out.println("arrayList 비워짐");
		}
		System.out.println(arrayList);
		arrayList = null;
		if (arrayList.size() == 0) {
			System.out.println("arrayList 비워짐");
		}
	}
}
