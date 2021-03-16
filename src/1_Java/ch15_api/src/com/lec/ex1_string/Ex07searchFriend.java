package com.lec.ex1_string;

/*
 * 2020.12.14 ~ Lim JaeHyun
 */
import java.util.Scanner;

// 전화번호 뒷자리로 친구 찾기
public class Ex07searchFriend {
	public static void main(String[] args) {
		Friend[] friends = { new Friend("홍길동", "010-9999-9999", "12-14"), new Friend("신길동", "010-9999-8888", "08-14"),
				new Friend("마미숙", "010-9999-7777", "01-14") };
		Scanner scanner = new Scanner(System.in);
		// 찾을 친구의 전화번호 뒷자리를 입력받음
		System.out.print("찾고 싶은 친구의 전화번호 뒷자리는 ?");
		String searchTel = scanner.next();
		int idx;
		boolean searchOk = false;
		// friends배열에서 해당 전화번호 뒷자리와 같은 친구가 있으면 그 친구를 출력
		// 없으면 없다고 출력
		for (idx = 0; idx < friends.length; idx++) {
			String temp = friends[idx].getTel();
			String post = temp.substring(temp.lastIndexOf("-") + 1);
			if (post.equals(searchTel)) {
				System.out.println(friends[idx]); // Object의 toString()
				// friends[idx].print();
				searchOk = true; // 중복된 뒷번호가 있을 경우
				break; // 중복된 뒷번호가 없을 경우
			} // if
		} // for
		if (!searchOk) {
			System.out.println("해당번호의 친구가 없습니다.");
		}
	}
}