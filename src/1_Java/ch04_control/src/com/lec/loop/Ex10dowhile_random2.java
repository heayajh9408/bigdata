package com.lec.loop;

/*
 * 2020.12.02~ Lim JaeHyun
 */
import java.util.Scanner;

public class Ex10dowhile_random2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int lotto = (int) (Math.random() * 45) + 1; // 컴퓨터 로또 난수
		int su; // 사용자에게 입력받은 수를 저장하는 변수
		int min = 1;
		int max = 45;
		do {
			System.out.printf("%d부터 %d까지 번호 한개를 알아맞춰 보세요", min, max);
			su = scanner.nextInt();
			if (su > lotto) {
				System.out.println(su + "보다 작은수를 도전하세요");
				max = su - 1;
			} else if (su < lotto) {
				System.out.println(su + "보다 큰수를 도전하세요");
				min = su + 1;
			}
		} while (su != lotto);
		System.out.println("축하축하 맞추셨습니다");
		scanner.close();
	}
}
