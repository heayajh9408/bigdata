package com.lec.ex2_date;

/*
 * 2020.12.14 ~ Lim JaeHyun
 */
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* yyyy (�⵵ 4�ڸ�) yy(�⵵ 2�ڸ�)
 * M (9) MM (09) ��
 * d (9) dd (09) ��
 * E ����
 * a ����/����
 * H 24�ð�
 * h 12�ð�             	
 * m ��
 * s ��
 * S �и�����
 * w (�̹� �⵵�� ���° ������) W(�̹� ���� ���° ������) D(������ ���° ��)
 */
public class Ex04_CalDateSimpleFormat {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		// 2020�� 12�� 14�� 3��03�� 05��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� E���� a hh�� mm�� ss��");
		// cal.getTime() : cal�� Date������ ��ȯ
		String today = sdf.format(cal.getTime());
		System.out.println(today);
	}
}