package com.lec.ex8_decimalFormat;

/*
 * 2020.12.15 ~ Lim JaeHyun
 */
import java.text.DecimalFormat;

// �����ڸ��� : #(���������,��������¾���) 0(�ݵ�� ���)
// , %, E
public class Ex02 {
	public static void main(String[] args) {
		String[] patterns = { "00000000.00000", "########.##", "#,###,###.00000", "#.#%", "#.#####E00" };
		double number = 1234567.8889;
		for (String pattern : patterns) {
			DecimalFormat df = new DecimalFormat(pattern);
			System.out.println(df.format(number));
		}
	}
}