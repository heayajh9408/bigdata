package com.lec.ex3_math;

/*
 * 2020.12.14 ~ Lim JaeHyun
 */
import java.util.Random;

public class Ex03_random {
	public static void main(String[] args) {
		System.out.println((int) (Math.random() * 45) + 1);
		Random random = new Random();
		System.out.println("int 난수 : " + random.nextInt()); // 정수
		System.out.println("0~100까지 int 난수 : " + random.nextInt(101));
		System.out.println("0~44까지 int 난수 : " + random.nextInt(45));
		System.out.println("1~45까지 int 난수 : " + (random.nextInt(45) + 1));
		System.out.println("double 난수 : " + random.nextDouble()); // Math.ranodm()
		System.out.println("T/F 중에 하나 선택 : " + random.nextBoolean());

	}
}