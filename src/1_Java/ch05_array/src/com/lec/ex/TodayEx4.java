package com.lec.ex;

/*
 * 2020.12.02
 * 6,45,34,89,100,50,90,92  8���� ���� 1���� �迭�� �ʱ�ȭ �ϰ�
 * ���� �հ��  ��� �׸��� �ִ밪�� �ּҰ��� ���ϴ� ���α׷��� �ۼ� �Ͻÿ�.
 */
public class TodayEx4 {
	public static void main(String[] args) {
		int[] arr = { 6, 45, 34, 89, 100, 50, 90, 92 };
		int sum = 0;
		int avg = sum / arr.length;
		int max = -300;
		int min = 300;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];

			if (arr[i] >= max) {
				max = arr[i];
			} else {
				min = arr[i];
			}
		}
		avg = sum / arr.length;
		System.out.printf("�հ�� %d ����� %d �ִ밪�� %d �ּҰ��� %d", sum, avg, max, min);
	}
}
