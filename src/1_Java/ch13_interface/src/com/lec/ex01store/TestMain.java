package com.lec.ex01store;

public class TestMain {
	public static void main(String[] args) {
//		HeadQuarterStore st = new HeadQuarterStore("== ���� ==");
//		System.out.println(st.getName());
//		st.kimchi();
//		st.bude();
//		st.bibib();
//		st.sunde();
//		st.gonggibab();
		StoreNum1 st1 = new StoreNum1("== ���ð� 1ȣ�� ==");
		System.out.println(st1.getName());
		st1.kimchi();
		st1.bude();
		st1.bibib();
		st1.sunde();
		st1.gonggibab();
		StoreNum2 st2 = new StoreNum2("== ���а� 2ȣ�� ==");
		System.out.println(st2.getName());
		st2.kimchi();
		st2.bude();
		st2.bibib();
		st2.sunde();
		st2.gonggibab();
		StoreNum3 st3 = new StoreNum3("== ���ǰ� 3ȣ�� ==");
		System.out.println(st3.getName());
		st3.kimchi();
		st3.bude();
		st3.bibib();
		st3.sunde();
		st3.gonggibab();
//		HeadQuarterStore[] store = {st, st1, st2, st3};
	}
}