package com.lec.ex07_super;

/*
 * 2020.12.07~ Lim JaeHyun
 */
public class ParentClass {
	private String pStr = "�θ�Ŭ����";

	public ParentClass() {
		System.out.println("�θ������");
	}

	public void getPapaName() {
		System.out.println("�ƺ� ȫ�浿");
	}

	public void getMamiName() {
		System.out.println("���� �����");
	}

	public String getpStr() {
		return pStr;
	}

	public void setpStr(String pStr) {
		this.pStr = pStr;
	}
}