package com.lec.ex10booklib;

/*
 * 2020.12.09~ Lim JaeHyun
 */
import java.util.Scanner;

public class LibMain {
	public static void main(String[] args) {
		BookLib[] books = { new BookLib("890ㄱ-100", "java", "아무개"), new BookLib("890ㄱ-101", "hadoop", "저무개"),
				new BookLib("890ㄱ-102", "oracle", "이무개"), new BookLib("890ㄱ-103", "python", "김무개"),
				new BookLib("892ㄱ-100", "spark", "신무개") };
		Scanner sc = new Scanner(System.in);
		int fn, idx = 0; // 기능번호(1:대출,2:반납...), 인덱스(books의)
		String bTitle, borrower, checkOutDate; // 책제목,대출인,대출일
		do {
			System.out.print("1:대출 | 2:반납 | 3:도서현황 | 0:종료 ");
			fn = sc.nextInt();
			switch (fn) {
			case 1: // 책이름->책조회 ->해당책의 상태->대출인,대출일->대출
				// 책이름 입력
				System.out.print("대출할 책이름은?");
				bTitle = sc.next(); // 스트링을 받기 위해 next()
				// 책조회
				for (idx = 0; idx < books.length; idx++) {
					if (bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				} // for
					// 책조회에서 책을 찾았는지 못찾았는지 보고 대출 진행
				if (idx == books.length) {
					System.out.println("본 도서관에는 해당 도서가 없습니다");
				} else if (books[idx].getState() == ILendable.STATE_BORROWED) {
					System.out.println(bTitle + " 도서는 대출중입니다");
				} else {
					// 대출 가능이니 대출인, 대출일 입력받고 대출진행
					System.out.print("대출인은 ?");
					borrower = sc.next();
					System.out.print("대출일은 ?");
					checkOutDate = sc.next();
					books[idx].checkOut(borrower, checkOutDate);
				} // if
				break;
			case 2: // 책이름->책조회->반납
				System.out.print("반납할 책이름은?");
				bTitle = sc.next();
				for (idx = 0; idx < books.length; idx++) {
					if (bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				} // for
				if (idx == books.length) {
					System.out.println("해당도서는 본 도서관의 책이 아닙니다");
				} else {
					books[idx].checkIn();
				} // if
				break;
			case 3: // for문을 이용해서 도서상태 출력
				for (BookLib book : books) {
					book.printState();
				} // for
			}// switch
		} while (fn != 0);
		sc.close();
		System.out.println("시스템 종료");
	}
}