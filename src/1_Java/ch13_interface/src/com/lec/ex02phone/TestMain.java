package com.lec.ex02phone;

/*
 * 2020.12.09~ Lim JaeHyun
 */
public class TestMain {
	public static void main(String[] args) {
		AModel aPhone = new AModel();
		BModel bPhone = new BModel();
		CModel cPhone = new CModel();
		IAcor[] phones = { aPhone, bPhone, cPhone };
		for (IAcor phone : phones) {
			// ��ü�� Ŭ����Ÿ��
			System.out.println(phone.getClass().getName());
			phone.dmbReceive();
			phone.lte();
			phone.tvRemoteControl();
		}
	}
}