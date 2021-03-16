package com.lec.ex5_booklib;

/*
 * 2020.12.16 ~ Lim JaeHyun
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BookLib implements ILendable {
	private String bookNo; // 책번호
	private String bookTitle; // 책제목
	private String writer; // 저자
	private String borrower; // 대출인
	private Date checkOutDate; // 대출일
	private byte state; // 대출중(1)or대출가능(0)

	public BookLib() {
	}

	// Book b = new Book("890ㄱ-01","java","홍길동");
	public BookLib(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
		state = STATE_NORMAL;
	}

	@Override
	public void checkOut(String borrower) throws Exception {
		if (state != STATE_NORMAL) {
			throw new Exception(bookTitle + "은 대출 중이예요");
		}
		this.borrower = borrower;
		checkOutDate = new Date();
		state = STATE_BORROWED;
		System.out.println("\"" + bookTitle + "\"이(가) ★대출★되었습니다");
		System.out.println("[대출인] " + borrower);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일(E)");
		System.out.println("[대출일]" + sdf.format(checkOutDate));
	}

	@Override
	public void checkIn() throws Exception {
		if (state != STATE_BORROWED) {
			throw new Exception(bookTitle + "은 대출중이 아니였는데 반납한다고 합니다");
		}
		Date now = new Date();
		long diff = now.getTime() - checkOutDate.getTime();
		long day = diff / (24 * 60 * 60 * 1000);
		if (day > 14) {
			System.out.println("연체료 일일 100원 부가합니다");
			day = day - 14;
			System.out.println("내셔야 할 연체료는 " + (day * 100) + "원");
			Scanner sc = new Scanner(System.in);
			System.out.print("연체료를 내셨나요(Y/N)? ");
			if (!sc.next().equalsIgnoreCase("y")) {
				System.out.println("연체료를 내셔야 반납처리가 됩니다");
				return;
			}
		}
		this.borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println("\"" + bookTitle + "\"이(가) ★반납★되었습니다");
	}

	@Override
	public String toString() {
		String temp = "\"" + bookTitle + "(" + bookNo + ")\" " + writer + "著 ";
		if (state == STATE_NORMAL) {
			temp += "대출가능";
		} else if (state == STATE_BORROWED) {
			SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd E요일");
			temp += "대출(" + sdf.format(checkOutDate) + ") 중";
		} else {
			temp += " 유령상태";
		}
		return temp;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public byte getState() {
		return state;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
}