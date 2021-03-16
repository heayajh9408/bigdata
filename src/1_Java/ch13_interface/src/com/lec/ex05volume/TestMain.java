package com.lec.ex05volume;

/*
 * 2020.12.09~ Lim JaeHyun
 */
public class TestMain {
	public static void main(String[] args) {
		// IVolume[] device = {new Radio(),new TV()};
		Radio radio = new Radio(3);
		TV tv = new TV(9);
		IVolume[] device = new IVolume[2];
		device[0] = radio;
		device[1] = tv;
		radio.volumeUp(10);
		tv.volumeUp(10);
		System.out.println("�������ʹ� �������̽��� �̿��� ȣ���Դϴ�");
		for (int i = 0; i < device.length; i++)
			device[i].volumeUp(10);
		for (IVolume d : device)
			d.volumeUp();
	}
}