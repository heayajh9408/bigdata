package com.lec.ex12account;

/*
 * 2020.12.07~ Lim JaeHyun
 */
public class CreditLineAccount extends CheckingAccount {
	private long creditLine;

	public CreditLineAccount(String accountNo, String ownerName, String cardNo, int creditLine) {
		super(accountNo, ownerName, cardNo);
		this.creditLine = creditLine;
	}

	public CreditLineAccount(String accountNo, String ownerName, int balance, String cardNo, int creditLine) {
		super(accountNo, ownerName, balance, cardNo);
		this.creditLine = creditLine;
	}

	// CreditLineAccount kim =
	// new CreditLineAccount("12","홍",20,"1111~",20);
	// kim.pay("1111~",10);
	@Override
	public void pay(String cardNo, int amount) {
		if (getCardNo().equals(cardNo)) {
			if (creditLine < amount) {
				System.out.println(getOwnerName() + "님, 한도초과입니다. 떽끼");
			} else {
				creditLine -= amount;
				System.out.println(getOwnerName() + "님, " + amount + "원 출금(잔여 한도액: " + creditLine + "원)");
			}
		} else {
			System.out.println("카드번호가 일치하지않습니다");
		}
	}

	@Override
	public void printAccount() {
		super.printAccount();
		System.out.println("카드 한도액 :" + creditLine);
	}

	public long getCreditLine() {
		return creditLine;
	}

}