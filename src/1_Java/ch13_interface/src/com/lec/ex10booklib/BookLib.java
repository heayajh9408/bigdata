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
			System.out.println("�������� �����Դϴ�");
			return;
		}
		// ����ó�� ����
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED;
		// "�ڹ�"������ ����Ǿ����ϴ�
		System.out.println("\"" + getBookTitle() + "\"������ ����Ǿ����ϴ�");

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
		System.out.println("\"" + getBookTitle() + "\"������ �ݳ��Ǿ����ϴ�");
	}

	@Override
	public void printState() {
		if (state == STATE_NORMAL) {
			System.out.printf("%s, %s�� - ���Ⱑ��\n", getBookTitle(), getWriter());
		} else if (state == STATE_BORROWED) {
			System.out.printf("%s, %s�� - ������\n", getBookTitle(), getWriter());
		} else {
			System.out.printf("%s, %s - ���ɻ����Դϴ�\n", getBookTitle(), getWriter());
		}
//		String msg = getBookTitle()+", "+getWriter() + " - ";
//		msg +=  state==STATE_NORMAL? "���Ⱑ��":"������";
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