package com.lec.ex07_super;

/*
 * 2020.12.07~ Lim JaeHyun
 */
public class ChildClass extends ParentClass {
	private String cStr = "�ڽ�Ŭ����";

	public ChildClass() {
		System.out.println("�ڽ� ������");
	}

	@Override
	public void getMamiName() {
		// this. ; �� ��ü��
		// this() ; �������Լ�(��Ŭ������)
		// super. ; �θ��� (�ƹ����� �� �� ����)
		// super() ; �θ�Ŭ������ ������ (�ݵ�� �� �� �ٿ� ��)
		System.out.print("�̻� ���� �̻� ");
		super.getMamiName();
	}

	public String getcStr() {
		return cStr;
	}

	public void setcStr(String cStr) {
		this.cStr = cStr;
	}
}