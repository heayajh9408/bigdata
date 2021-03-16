package com.lec.ex3_math;

/*
 * 2020.12.14 ~ Lim JaeHyun
 */
import java.util.Random;

// �ߺ��� �ζ� ��ȣ�� �߻����� �ʵ��� ó���ؾ� ��
public class Ex04_lotto2 {
	public static void main(String[] args) {
		Random random = new Random();
		int[] lotto = new int[6];
		for (int i = 0; i < lotto.length; i++) {
			int temp = random.nextInt(45) + 1;
			boolean ok = true;
			for (int j = 0; j < i; j++) {
				if (temp == lotto[j]) { // �ߺ��� �� ���� ���
					i--;
					ok = false;
					break; // for-j �ݺ��� ��������
				}
			} // for - �ߺ�Ȯ��
			if (ok) {
				lotto[i] = temp;
			}
		}
		for (int l : lotto) {
			System.out.print(l + "\t");
		}
	}
}