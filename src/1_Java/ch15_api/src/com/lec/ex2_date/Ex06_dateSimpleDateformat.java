package com.lec.ex2_date;

/*
 * 2020.12.14 ~ Lim JaeHyun
 */
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex06_dateSimpleDateformat {
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd(E) HH:mm");
		System.out.println(sdf.format(date));
	}
}