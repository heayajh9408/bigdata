package com.lec.ex01store;

public class TestMain2 {
	public static void main(String[] args) {
		HeadQuarterStore[] store = {
				// new HeadQuarterStore("== ���� =="),
				new StoreNum1("== ���ð� 1ȣ�� =="), new StoreNum2("== ���а� 2ȣ�� =="), new StoreNum3("== ���ǰ� 3ȣ�� ==") };
		for (HeadQuarterStore s : store) {
			System.out.println(s.getName());
			s.kimchi();
			s.bude();
			s.bibib();
			s.sunde();
			s.gonggibab();
		}
//		for(int idx=0 ; idx<store.length ; idx++) {
//			System.out.println(store[idx].getName());
//			store[idx].kimchi();
//			store[idx].bude();
//			store[idx].bibib();
//			store[idx].sunde();
//			store[idx].gonggibab();
//		}
	}
}