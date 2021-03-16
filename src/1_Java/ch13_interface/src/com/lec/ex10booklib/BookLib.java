package com.lec.ex10booklib;

/*
 * 2020.12.09~ Lim JaeHyun
 */
public class BookLib extends BookInfo implements ILendable {
	private String borrower;
	private String checkOutDate;
	private byte state;

	public BookLib() {
	}

	public BookLib(String bookNo, String bookTitle, String writer) {
		super(bookNo, bookTitle, writer);
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
	}

	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if (state != STATE_NORMAL) {
			System.out.println("대출중인 도서입니다");
			return;
		}
		// 대출처리 로직
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED;
		// "자바"도서가 대출되었습니다
		System.out.println("\"" + getBookTitle() + "\"도서가 대출되었습니다");

	}

	@Override
	public void checkIn() {
		if (state != STATE_BORROWED) {
			System.out.println("대출 중인 도서가 아닙니다. 이상합니다");
			return;
		}
		// 반납 처리 로직
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		// "자바"도서가 반납되었습니다.
		System.out.println("\"" + getBookTitle() + "\"도서가 반납되었습니다");
	}

	@Override
	public void printState() {
		if (state == STATE_NORMAL) {
			System.out.printf("%s, %s저 - 대출가능\n", getBookTitle(), getWriter());
		} else if (state == STATE_BORROWED) {
			System.out.printf("%s, %s저 - 대출중\n", getBookTitle(), getWriter());
		} else {
			System.out.printf("%s, %s - 유령상태입니다\n", getBookTitle(), getWriter());
		}
//		String msg = getBookTitle()+", "+getWriter() + " - ";
//		msg +=  state==STATE_NORMAL? "대출가능":"대출중";
//		System.out.println(msg);
	}

	public String getBorrower() {
		return borrower;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public byte getState() {
		return state;
	}
}