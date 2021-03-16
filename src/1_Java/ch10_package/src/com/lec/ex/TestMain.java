package com.lec.ex;

/*
 * 2020.12.07~ Lim JaeHyun
 */
import com.acom.ex.Emp;

public class TestMain {
	public static void main(String[] args) {
		Emp emp = new Emp(101); // acom°Í
		com.bcom.ex.Emp emp1 = new com.bcom.ex.Emp(); // bcom °Í
		System.out.println(emp.getNo());
		System.out.println(emp1.getI());
	}
}