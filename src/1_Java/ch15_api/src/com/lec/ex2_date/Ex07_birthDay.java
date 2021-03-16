package com.lec.ex2_date;

/*
 * 2020.12.14 ~ Lim JaeHyun
 */
import java.util.Calendar;

import com.lec.ex1_string.Friend;

public class Ex07_birthDay {
	public static void main(String[] args) {
		Friend[] friends = { new Friend("ȫ�浿", "010-9999-9999", "12-16"), new Friend("ȫ�繫", "010-8888-8888", "01-01"),
				new Friend("�ű浿", "010-1234-1234", "12-16") };
		// friends �迭���� ������ ���� ������� ��� ���
		// ���� ������ ����� ������ ���ٰ� ���
		Calendar now = Calendar.getInstance();
		int month = now.get(Calendar.MONTH) + 1;
		int day = now.get(Calendar.DAY_OF_MONTH);

		String monthString = (month < 10) ? "0" + month : "" + month;
		String dayString = (day < 10) ? "0" + day : "" + day;
		String today = monthString + "-" + dayString;
		System.out.println("������ " + today);
		boolean searchOk = false;
		System.out.println("���� ������ ����� ����� ������ �����ϴ�");
		for (int idx = 0; idx < friends.length; idx++) {
			String birthday = friends[idx].getBirth();
			if (birthday.equals(today)) {
				System.out.println(friends[idx]);
				searchOk = true;
			} // if
		} // for
		if (!searchOk) {
			System.out.println("������ ������ ����� �����ϴ�.");
		}
	}
}