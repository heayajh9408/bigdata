package com.lec.ex2_date;

/*
 * 2020.12.14 ~ Lim JaeHyun
 */
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.lec.ex1_string.Friend;

public class Ex07_birthDay2 {
	public static void main(String[] args) {
		Friend[] friends = { new Friend("ȫ�浿", "010-9999-9999", "12-14"), new Friend("ȫ�繫", "010-8888-8888", "01-01"),
				new Friend("�ű浿", "010-1234-1234", "12-14") };
		// friends �迭���� ������ ���� ������� ��� ���
		// ���� ������ ����� ������ ���ٰ� ���
		Calendar now = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String today = sdf.format(now.getTime());
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
		} // if
	}
}