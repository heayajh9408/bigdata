package com.lec.ex5_booklib;

/*
 * 2020.12.16 ~ Lim JaeHyun
 */
public interface ILendable {
	public byte STATE_BORROWED = 1;
	public byte STATE_NORMAL = 0;

	public void checkOut(String borrower) throws Exception;

	public void checkIn() throws Exception;

}
