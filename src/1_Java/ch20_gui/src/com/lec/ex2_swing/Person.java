package com.lec.ex2_swing;

public class Person {
	private String name;
	private String phone;
	private int age;
	public Person(String name, String phone, int age) {
		this.name=name;
		this.phone=phone;
		this.age=age;
	}
	@Override
	public String toString() {
		return "name=" + name + ", tel=" + phone + ", age=" + age+"\n";
	}
}
