package com.lec.ex13final;

/*
 * 2020.12.07~ Lim JaeHyun
 * final Ŭ���� : ��ӺҰ�
 */
public final class Dog extends Animal {
	@Override
	public void running() {
		speed += 10;
		System.out.println("�������� �ٸ鼭 ������ �����. ���ӵ�:" + speed);
	}

	public void method() {
		System.out.println("method()");
	}
}