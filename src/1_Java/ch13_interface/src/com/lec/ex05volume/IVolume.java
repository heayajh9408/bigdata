package com.lec.ex05volume;

/*
 * 2020.12.09~ Lim JaeHyun
 */
public interface IVolume {
	public int TV_MAX_VOLUME = 50;
	public int RADIO_MAX_VOLUME = 30;
	public int MIN_VOLUME = 0;

	public void volumeUp();

	public void volumeUp(int level);

	public void volumeDown();

	public void volumeDown(int level);

	public default void mute() {
		System.out.println("무음처리합니다");
	}
}