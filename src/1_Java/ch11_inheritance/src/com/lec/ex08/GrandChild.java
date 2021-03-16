package com.lec.ex08;

/*
 * 2020.12.07~ Lim JaeHyun
 */
public class GrandChild extends Child1 {
	private int gc = 3;

	public GrandChild() {
		System.out.println("GrandchildÇü °´Ã¼ »ý¼º");
	}

	public int getGc() {
		return gc;
	}

	public void setGc(int gc) {
		this.gc = gc;
	}
}