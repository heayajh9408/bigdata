package com.lec.ex1_runnable;

public class TargetExTestMain {
	public static void main(String[] args) {
		Runnable target01 = new TargetEx01();
		// TargetEx01 target01 = new TargetEx01();
		Runnable target02 = new TargetEx02();
		// TargetEx02 target02 = new TargetEx02();

		// "A"라는 이름의 쓰레드 생성 - target01.run()을 수행하는 쓰레드
		Thread threadA = new Thread(target01, "A");
		// "B"라는 이름의 쓰레드 생성 - target02.run()을 수행하는 쓰레드
		Thread threadB = new Thread(target02, "B");
		threadA.start();
		threadB.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("나는 " + Thread.currentThread().getName());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		} // for
	}// main
}// class
