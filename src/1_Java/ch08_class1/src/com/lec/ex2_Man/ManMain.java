package com.lec.ex2_Man;

/*
 * 2020.12.03~ Lim JaeHyun
 */
public class ManMain {
	public static void main(String[] args) {
		Man kim = new Man(20,170,60,"010-999-9999");
		Man yi  = new Man(20,170,60);
		Man kang = new Man(20, "010-9999-9999");
		yi.setTel("010-8888-8888");
		kang.setHeight(180); kang.setWeight(65);
		double biman = kim.calculateBMI();
		if(biman>24) {
			System.out.println("kim�� ���̴� �ǰ� ����");
		}else {
			System.out.println("kim�� ���̾�Ʈ ����");
		}
		biman = yi.calculateBMI();
		System.out.println(biman>24? "�ǰ����ɴ��̾�Ʈ":"���̾�Ʈ ����");
		biman = kang.calculateBMI();
		System.out.println(biman>24? "�ǰ����ɴ��̾�Ʈ":"���̾�Ʈ ����");
	}
}