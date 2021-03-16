package com.lec.ex2_dataInputStreamoutputStream;

/*
 * 2020.12.18 ~ Lim JaeHyun
 */
public class Product {
	private String name;
	private int price;
	private int ps;

	public Product(String name, int price, int ps) {
		this.name = name;
		this.price = price;
		this.ps = ps;
	}

	@Override
	public String toString() {
		return name + "\t" + price + "¿ø\t" + ps + "°³";
	}
}