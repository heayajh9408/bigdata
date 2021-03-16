package com.lec.ex4_boxrect;
/*
 * 2020.12.03~ Lim JaeHyun
 * 직육면체의 가로, 세로, 높이, 부피나 직사각형의 가로, 세로, 넓이를 
 * 속성으로 갖는 클래스를 구현하라. 부피나 넓이를 
 * 구하는 메소드 calNsetVolume()도 구현한다.
 */

public class BoxOrRect {
	private int width;
	private int height;
	private int depth;
	private int volume;

	public BoxOrRect() {
	}

	public BoxOrRect(int width, int height, int depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
	}

	public BoxOrRect(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public void calculate() {
		if (depth == 0) {
			volume = width * height;
		} else {
			volume = width * height * depth;
		}

	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
}
