package com.lec.ex05volume;

/*
 * 2020.12.09~ Lim JaeHyun
 * Radio�� volumeUp()�̳� volumeDown() +1, -1�� ����
 */
public class Radio implements IVolume {
	private int volumeLevel;

	public Radio() {
		volumeLevel = 10;
	}

	public Radio(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}

	@Override
	public void volumeUp() {
		// 29 - > 30��ŭ
		volumeLevel++;
		if (volumeLevel >= RADIO_MAX_VOLUME) {
			volumeLevel = RADIO_MAX_VOLUME;
			System.out.println("������ �ִ�ġ�Դϴ�. û�¿� �����մϴ�");
		} else {
			System.out.println("Radio ������ " + 1 + "��ŭ �÷� " + volumeLevel);
		}
	}

	@Override
	public void volumeUp(int level) {
		// 20 - > 30��ŭ
		volumeLevel += level;
		if (volumeLevel >= RADIO_MAX_VOLUME) {
			volumeLevel = RADIO_MAX_VOLUME;
			System.out.println("������ �ִ�ġ�Դϴ�. û�¿� �����մϴ�");
		} else {
			System.out.println("Radio ������ " + level + "��ŭ �÷� " + volumeLevel);
		}
	}

	@Override
	public void volumeDown() {
		volumeLevel--;
		if (volumeLevel <= MIN_VOLUME) {
			volumeLevel = MIN_VOLUME;
			System.out.println("���� �����Դϴ�");
		}
		System.out.println("Radio ������ " + 1 + "��ŭ ���� " + volumeLevel);
	}

	@Override
	public void volumeDown(int level) {
		volumeLevel -= level;
		if (volumeLevel <= MIN_VOLUME) {
			volumeLevel = MIN_VOLUME;
			System.out.println("���� �����Դϴ�");
		}
		System.out.println("Radio ������ " + level + "��ŭ ���� " + volumeLevel);
	}
}