package com.lec.ex02phone;

/*
 * 2020.12.09~ Lim JaeHyun
 */
//a��ǰ : DMB�ۼ��źҰ�, 5G, TV������ ��ž��, 
public class AModel implements IAcor {
	private String modelName;

	public AModel() {
		modelName = "A��";
	}

	@Override
	public void dmbReceive() {
		System.out.println(modelName + "�� DMB �ۼ��� �Ұ�");
	}

	@Override
	public void lte() {
		System.out.println(modelName + "�� 5G");
	}

	@Override
	public void tvRemoteControl() {
		System.out.println(modelName + "�� TV������ ��ž��");
	}
}