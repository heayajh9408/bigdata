package com.lec.ex3_set;

/*
 * 2020.12.17 ~ Lim JaeHyun
 */
import java.util.HashSet;
import java.util.Iterator;

public class Ex01_HashSet {
	public static void main(String[] args) {
		HashSet<String> hashset = new HashSet<String>();
		// "str0", "str1", "str2", "str3", "str2"
		hashset.add("str0");
		hashset.add("str1");
		hashset.add("str2");
		hashset.add("str3");
		System.out.println(hashset);
		System.out.println("hashset 사이즈 : " + hashset.size());
		hashset.add("str2");
		System.out.println(hashset);
		System.out.println("hashset 사이즈 : " + hashset.size());
		Iterator<String> iterator = hashset.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
