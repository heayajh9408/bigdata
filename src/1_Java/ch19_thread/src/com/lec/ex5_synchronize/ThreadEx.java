package com.lec.ex5_synchronize;

// 쓰레드 N개가 작업객체1를 공유 - Runnable을 이용
public class ThreadEx implements Runnable {
	private int num = 0; // 공유변수

	@Override
	// synchronized run()수행중에는 아무 도 못 껴들어
	public void run() {
		for (int i = 0; i < 10; i++) {
			out();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		} // for
	}// main

	private synchronized void out() {
		String threadName = Thread.currentThread().getName();
		if (threadName.equals("A")) {
			System.out.println("~ ~ ~ A 수행중 ~ ~ ~");
			num++;
		}
		System.out.println(threadName + "의 num = " + num);
	}
}