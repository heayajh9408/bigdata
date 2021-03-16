package com.lec.ex09lib;

/*
 * 2020.12.09~ Lim JaeHyun
 */
public class Book implements ILendable {
	private String bookNo;
	private String bookTitle;
	private String writer;
	private String borrower;
	private String checkOutDate;
	private byte state;

	public Book() {
	}

	public Book(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
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
		System.out.println("\"" + bookTitle + "\"도서가 대출되었습니다");

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
		System.out.println("\"" + bookTitle + "\"도서가 반납되었습니다");

	}

	@Override
	public void printInfo() {
		if (state == STATE_NORMAL) {
			System.out.printf("%s, %s저 - 대출가능\n", bookTitle, writer);
		} else if (state == STATE_BORROWED) {
			System.out.printf("%s, %s저 - 대출중\n", bookTitle, writer);
		} else {
			System.out.printf("%s, %s - 유령상태입니다\n", bookTitle, writer);
		}

	}

	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getBorrower() {
		return borrower;
	}

	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public byte getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}

}
