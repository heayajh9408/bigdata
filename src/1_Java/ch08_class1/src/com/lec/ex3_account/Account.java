package com.lec.ex3_account;

/* 
 * 2020.12.03~ Lim JaeHyun
 * 은행계좌클래스
 *  데이터 : 계좌번호 (accountNo:String)
 *         예금주   (ownerName:String) 
 *         잔액      (balance:int)
 *  메소드 : 예금한다 (void deposit(int money))new Account("110-352","홍",10)
 *         인출하다 (void withdraw(int money))new Account("110-352","홍")
 */
public class Account {
	private String accountNum;
	private String name;
	int balance;

	public Account() {
	}

	public Account(String accountNum, String name) {
		this.accountNum = accountNum;
		this.name = name;
	}

	public Account(String accountNum, String name, int balance) {
		this.accountNum = accountNum;
		this.name = name;
		this.balance = balance;
	}

	public void deposit(int money) {
		balance += money;
	}

	public void withdraw(int money) {
		if (balance >= money) {
			balance -= money;
		} else {
			System.out.println("잔액부족!");
		}
	}

	public void info() {
		System.out.println("계좌번호:" + accountNum + ", " + name + "님 잔액은 " + balance);
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}
