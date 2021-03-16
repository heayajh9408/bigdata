package com.lec.ex3_math;

/*
 * 2020.12.14 ~ Lim JaeHyun
 */
import java.util.Random;

// 중복된 로또 번호를 발생하지 않도록 처리해야 함
public class Ex04_lotto2 {
	public static void main(String[] args) {
		Random random = new Random();
		int[] lotto = new int[6];
		for (int i = 0; i < lotto.length; i++) {
			int temp = random.nextInt(45) + 1;
			boolean ok = true;
			for (int j = 0; j < i; j++) {
				if (temp == lotto[j]) { // 중복된 것 뽑힌 경우
					i--;
					ok = false;
					break; // for-j 반복문 빠져나감
				}
			} // for - 중복확인
			if (ok) {
				lotto[i] = temp;
			}
		}
		for (int l : lotto) {
			System.out.print(l + "\t");
		}
	}
}