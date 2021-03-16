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
			System.out.println("�������� �����Դϴ�");
			return;
		}
		// ����ó�� ����
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED;
		// "�ڹ�"������ ����Ǿ����ϴ�
		System.out.println("\"" + bookTitle + "\"������ ����Ǿ����ϴ�");

	}

	@Override
	public void checkIn() {
		if (state != STATE_BORROWED) {
			System.out.println("���� ���� ������ �ƴմϴ�. �̻��մϴ�");
			return;
		}
		// �ݳ� ó�� ����
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		// "�ڹ�"������ �ݳ��Ǿ����ϴ�.
		System.out.println("\"" + bookTitle + "\"������ �ݳ��Ǿ����ϴ�");

	}

	@Override
	public void printInfo() {
		if (state == STATE_NORMAL) {
			System.out.printf("%s, %s�� - ���Ⱑ��\n", bookTitle, writer);
		} else if (state == STATE_BORROWED) {
			System.out.printf("%s, %s�� - ������\n", bookTitle, writer);
		} else {
			System.out.printf("%s, %s - ���ɻ����Դϴ�\n", bookTitle, writer);
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
