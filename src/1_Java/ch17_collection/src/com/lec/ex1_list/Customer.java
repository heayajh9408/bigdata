package com.lec.ex1_list;

/*
 * 2020.12.17 ~ Lim JaeHyun
 */
public class Customer {
	private String name;
	private String phone;
	private String address;

	// new Customer("ȫ","010","seoul");
	public Customer(String name, String phone, String address) {
		this.name = name;
		this.phone = phone;
		this.address = address;
	}

	@Override
	public String toString() {
		return name + "\t" + phone + "\t" + address;
	}
}