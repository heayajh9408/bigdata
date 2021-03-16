package com.lec.ex08employee;

/*
 * 2020.12.08~ Lim JaeHyun
 */
public abstract class Employee {
	private String name;

	public Employee(String name) {
		this.name = name;
	}

	public abstract int computePay();

	public final int computeIncentive() {
		int incen;
		incen = computePay();
		if (incen > 2000000) {
			return (int) (incen * 0.1);
		}
		return 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
