package com.lec.ex3_set;

/*
 * 2020.12.17 ~ Lim JaeHyun
 */
import java.util.HashSet;
import java.util.Random;

public class Ex02_lotto {
	public static void main(String[] args) {
		HashSet<Integer> lotto = new HashSet<Integer>();
		Random random = new Random();
		while (lotto.size() < 6
				) {
			// lotto.add((int)(Math.random()*45)+1);
			lotto.add(random.nextInt(9) + 1);
		}
		System.out.println(lotto);
	}
}