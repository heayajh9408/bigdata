package com.lec.ex1_string;

/*
 * 2020.12.14 ~ Lim JaeHyun
 */
import java.util.StringTokenizer;

public class Ex12_tokenArray {
	public static void main(String[] args) {
		// str�� tokenizer�Ͽ� names�迭��
		String str = "������ ���ػ� ������ ������ ������";
		String[] names;
		// space, \t, \n =>WhiteSpace
		StringTokenizer tokenizer = new StringTokenizer(str);
		names = new String[tokenizer.countTokens()];
		int idx = 0;
		while (tokenizer.hasMoreElements()) {
			names[idx++] = tokenizer.nextToken();
		}
		System.out.println("����� �迭�� ������ ����");
		for (String name : names) {
			System.out.println(name);
		}
	}
}