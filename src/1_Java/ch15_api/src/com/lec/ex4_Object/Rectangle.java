package com.lec.ex4_Object;

/*
 * 2020.12.14 ~ Lim JaeHyun
 */
public class Rectangle {
	private int width;
	private int height;
	private String color;

	public Rectangle() {
		color = "검정";
	}

	public Rectangle(int width, int height, String color) {
		this.width = width;
		this.height = height;
		this.color = color;
	}

	@Override
	public String toString() {
		return "[가로 " + width + "cm, 세로 " + height + "cm의 " + color + "색 사각형]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj != null && obj instanceof Rectangle) {
			boolean widthChk = width == ((Rectangle) obj).width;
			boolean heightChk = height == ((Rectangle) obj).height;
			boolean colorChk = color.equals(((Rectangle) obj).color);
			return widthChk && heightChk && colorChk;
		}
		return false;
	}
}