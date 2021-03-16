package com.lec.ex1_string;

/*
 * 2020.12.14 ~ Lim JaeHyun
 * 이름, 전화번호, 생일(12-12) Friend f = new Friend("홍","8","12-12")
 * print() : [이름]홍 [전화]8 [생일]12-12
 */
public class Friend {
	private String name;
	private String tel;
	private String birth;

	public Friend() {
	}

	public Friend(String name, String tel, String birth) {
		this.name = name;
		this.tel = tel;
		this.birth = birth;
	}

	// f.print()
	public void print() {
		System.out.printf("[이름]%s [전화]%s [생일]%s\n", name, tel, birth);
	}

	// System.out.println(f.toString())
	@Override
	public String toString() {
		return "[이름]" + name + " [전화]" + tel + " [생일]" + birth;
	}

	public String getName() {
		return name;
	}

	public String getTel() {
		return tel;
	}

	public String getBirth() {
		return birth;
	}
}
