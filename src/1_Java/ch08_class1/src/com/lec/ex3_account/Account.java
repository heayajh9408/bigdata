package com.lec.ex3_account;

/* 
 * 2020.12.03~ Lim JaeHyun
 * �������Ŭ����
 *  ������ : ���¹�ȣ (accountNo:String)
 *         ������   (ownerName:String) 
 *         �ܾ�      (balance:int)
 *  �޼ҵ� : �����Ѵ� (void deposit(int money))new Account("110-352","ȫ",10)
 *         �����ϴ� (void withdraw(int money))new Account("110-352","ȫ")
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
			System.out.println("�ܾ׺���!");
		}
	}

	public void info() {
		System.out.println("���¹�ȣ:" + accountNum + ", " + name + "�� �ܾ��� " + balance);
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
