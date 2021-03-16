package com.lec.ex4_threadNobjectN;

public class ThreadEx implements Runnable {
	private int num = 0; // 공유변수

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			String threadName = Thread.currentThread().getName();
			if (threadName.equals("A")) {
				System.out.println("~ ~ ~ A 수행중 ~ ~ ~");
				num++;
			}
			System.out.println(threadName + "의 num = " + num);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		} // for
	}// main
}