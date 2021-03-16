package com.lec.ex09lib;

/*
 * 2020.12.09~ Lim JaeHyun
 */
public interface ILendable {
	public byte STATE_BORROWED = 1; // ������
	public byte STATE_NORMAL = 0; // ���Ⱑ��

	public void checkOut(String borrower, String checkOutDate);

	public void checkIn();

	public void printInfo();
}
