package com.lec.ex3_set;

/*
 * 2020.12.17 ~ Lim JaeHyun
 */
import java.util.Random;
import java.util.TreeSet;

public class Ex02_lotto2 {
	public static void main(String[] args) {
		TreeSet<Integer> lotto = new TreeSet<Integer>();
		Random random = new Random();
		while (lotto.size() < 6) {
			// lotto.add((int)(Math.random()*45)+1);
			lotto.add(random.nextInt(45) + 1);
		}
		System.out.println(lotto);
	}
}