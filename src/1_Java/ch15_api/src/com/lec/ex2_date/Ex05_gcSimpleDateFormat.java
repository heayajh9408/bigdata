package com.lec.ex2_date;

/*
 * 2020.12.14 ~ Lim JaeHyun
 */
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Ex05_gcSimpleDateFormat {
	public static void main(String[] args) {
		GregorianCalendar gc = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("M월 d일(E) a h시 m분");
		System.out.println(sdf.format(gc.getTime()));
	}
}
