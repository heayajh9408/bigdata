package com.lec.ex2_map;

/*
 * 2020.12.17 ~ Lim JaeHyun
 */
import java.util.Hashtable;
import java.util.Iterator;

public class Ex02_HashTable {
	public static void main(String[] args) {
		Hashtable<String, String> hashtable = new Hashtable<String, String>();
		hashtable.put("010-9999-9999", "ȫ�浿");
		hashtable.put("010-8888-8888", "��浿");
		hashtable.put("010-7777-7777", "�ű浿");
		hashtable.put("010-6666-6666", "���浿");
		System.out.println(hashtable);
		Iterator<String> iterator = hashtable.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key + ":" + hashtable.get(key));
		}
	}
}