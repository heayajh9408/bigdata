package com.lec.ex02phone;

/*
 * 2020.12.09~ Lim JaeHyun
 */
//DMB송수신가능, LTE, TV리모콘 미탑재, 
public class CModel implements IAcor {
	private String modelName;

	public CModel() {
		modelName = "C모델";
	}

	@Override
	public void dmbReceive() {
		System.out.println(modelName + "은 DMB 송수신 가능");
	}

	@Override
	public void lte() {
		System.out.println(modelName + "은 LTE");
	}

	@Override
	public void tvRemoteControl() {
		System.out.println(modelName + "은 TV리모콘 미탑재");
	}
}