package com.lec.ex;

/*
 * 2020.12.02
 */
public class Ex01 {
	public static void main(String[] args) {
		int i = 10; // ������ ����� �ʱ�ȭ
		int[] iArr = { 10, 20, 30, 40, 50 }; // 1. �迭 ���� ����� �ʱ�ȭ
		iArr[3] = 300; // �迭�� index�� ���� (index:0~4)
		for (int idx = 0; idx < 5; idx++) {
			System.out.println(iArr[idx]);
		}
		int[] iArr2 = new int[5]; // 2.�迭 ���� ����� �迭�޸� ����
		iArr2[0] = 999;
		for (int idx = 0; idx < iArr2.length; idx++) {
			System.out.println(idx + "��°�� : " + iArr2[idx]);
		}
		System.out.println("*******************");
		int[] iArr3; // 3. �迭 ���� ����
		iArr3 = new int[5]; // 0 0 0 0 0
		for(int temp : iArr3) {//Ȯ��for������ ������(x)
			temp = 10;
		}
		for(int temp : iArr3) {// Ȯ�� for��
			System.out.println(temp);
		}
		for(int idx=0; idx<iArr3.length ; idx++) {
			iArr3[idx] = 10;//�Ϲ�for������ �� ����(O)
		}
		for(int temp : iArr3) {// Ȯ�� for��
			System.out.println(temp);
		}
	}
}
