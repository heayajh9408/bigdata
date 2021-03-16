package com.lec.ex7_timer;

/*
 * 2020.12.15 ~ Lim JaeHyun
 */
import java.util.TimerTask;

public class TimerTaskEx1 extends TimerTask {
	// 오버라이드 함수 run에 작업정의
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("★ ★ ★ ★ ★ 작업1 : 2초후에 한번 timer 걸 예정");
	}
}