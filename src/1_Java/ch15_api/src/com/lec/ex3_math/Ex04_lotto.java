package com.lec.ex3_math;

/*
 * 2020.12.14 ~ Lim JaeHyun
 */
import java.util.Random;

// 이렇게 하면 중복된 로또 번호가 발생될 수도 있음
public class Ex04_lotto {
	public static void main(String[] args) {
		Random random = new Random();
		int[] lotto = new int[6];
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = random.nextInt(9) + 1;
		}
		for (int l : lotto) {
			System.out.print(l + "\t");
		}
	}
}