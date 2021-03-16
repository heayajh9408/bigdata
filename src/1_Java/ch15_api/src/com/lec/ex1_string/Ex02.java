package com.lec.ex1_string;

/*
 * 2020.12.14 ~ Lim JaeHyun
 * �پ��� String�� method��
 */
public class Ex02 {
	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = new String("ABCXabc");
		String str3 = "      ja  va  ";
		System.out.println("1." + str1.concat(str2));// abcXabcABCXabc
		System.out.println("2." + str1.substring(3));// 3��°���� ������
		System.out.println("3." + str1.substring(3, 5));// 3��°����5���ձ���
		System.out.println("4." + str1.length());// ���ڱ���(7)
		System.out.println("5." + str1.toUpperCase());// �빮�ڷ�
		System.out.println("6." + str2.toLowerCase());// �ҹ��ڷ�
		System.out.println("7." + str1.charAt(3));// 3�� index��° �����ϳ�
		System.out.println("8." + str1.indexOf("b"));// ùb�� index
		System.out.println("9." + str1.indexOf("b", 3));// 3idx���ͳ����� ùb�� index
		System.out.println("10." + str1.lastIndexOf("b"));// ������b index
		System.out.println("11." + str1.indexOf("z")); // ������ -1
		System.out.println("12." + str1.equals(str2));// true | false
		System.out.println("13." + str1.equalsIgnoreCase(str2));
		System.out.println("14." + str3.trim());// �¿� space����
		System.out.println("15." + str1.replace('a', '�o'));
		System.out.println("16." + str1.replace("ab", "�ٲ�"));
		System.out.println("���� str1 : " + str1);
	}
}