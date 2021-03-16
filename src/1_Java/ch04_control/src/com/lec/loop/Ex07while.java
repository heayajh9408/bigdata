package com.lec.loop;
/*
 * 2020.12.02~ Lim JaeHyun
 * 10. 9. 8. 7. 6. 5. .. 2. 1.
 */
public class Ex07while {
	public static void main(String[] args) {
		int i = 10;
		while (i >= 1) {
			System.out.print(i + ". ");
			i--;
		}

		for (int j = 10; j >= 1; j--) {
			System.out.print(j + ". ");
		}
	}
}