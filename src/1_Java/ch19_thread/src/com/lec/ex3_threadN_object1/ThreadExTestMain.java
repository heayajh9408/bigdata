package com.lec.ex3_threadN_object1;

public class ThreadExTestMain {
	public static void main(String[] args) {
		Runnable target = new ThreadEx(); // 작업객체1개 쓰레드 공유
		Thread t1 = new Thread(target, "A");
		Thread t2 = new Thread(target, "B");
		t1.start();
		t2.start();

	}
}