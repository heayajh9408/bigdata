package com.lec.ex2_map;

/*
 * 2020.12.17 ~ Lim JaeHyun
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Ex01_HashMap {
	public static void main(String[] args) {
		String[] strArr = new String[5];
		ArrayList<String> strlist = new ArrayList<String>();
		strlist.add("str11");
		HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
		hashmap.put(9, "str11");
		hashmap.put(19, "str22");
		hashmap.put(23, "str40");
		System.out.println(hashmap.get(23));
		System.out.println("remove전 : " + hashmap);
		hashmap.remove(19);
		System.out.println("remove후 : " + hashmap);
		hashmap.clear(); // hashmap의 데이터 모두 제거
		hashmap.put(0, "Hong gildong");
		hashmap.put(1, "Kim dongil");
		hashmap.put(2, "Lee soonsin");
		hashmap.put(3, "Yu ain");
		Iterator<Integer> iterator = hashmap.keySet().iterator();
		while (iterator.hasNext()) {
			Integer key = iterator.next();
			System.out.println(key + "의 데이터는 " + hashmap.get(key));
		} // while

	}
}