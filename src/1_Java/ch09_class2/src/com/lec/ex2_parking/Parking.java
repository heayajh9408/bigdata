package com.lec.ex2_parking;

/*
 * 2020.12.04~ Lim JaeHyun
 */
import com.lec.cons.PiClass;

class Parking {
	private String number;
	private int inTime;
	private int outTime;
	private int fee;

	public Parking() {
	}

	public Parking(String number, int inTime) {
		this.number = number;
		this.inTime = inTime;
		System.out.println(number + "�� �������.\n" + "�����ð�: " + inTime + "��");
		System.out.println("***********************");
	}

	public void out(int outTime) {
		this.outTime = outTime;
		fee = (outTime - inTime) * PiClass.HOURLYRATE;
		System.out.println(number + "�� �ȳ���������");
		System.out.println("�����ð�: " + inTime);
		System.out.println("�����ð�: " + outTime);
		System.out.println("�������: " + fee);
		System.out.println("***********************");
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getInTime() {
		return inTime;
	}

	public void setInTime(int inTime) {
		this.inTime = inTime;
	}

	public int getOutTime() {
		return outTime;
	}

	public void setOutTime(int outTime) {
		this.outTime = outTime;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

}
