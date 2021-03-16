package com.lec.studentConsole;

import java.util.ArrayList;
import java.util.Scanner;

import com.lec.person_dao.PersonDto;

public class StudentMng {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StudentDao dao = StudentDao.getInstance();
		String fn;
		do {
			System.out.println("1:입력 | 2:학과별출력 | 3:전체출력 | 4:제적자출력 | 그외:종료 >");
			fn = scanner.next();
			switch (fn) {
			case "1": // 이름, 직업명, 국영수 입력받아 dao.insertPerson()호출
				System.out.print("입력할 이름 >");
				String sName = scanner.next();
				System.out.print("학과명 >");
				String mName = scanner.next();
				System.out.print("점수 >");
				int score = scanner.nextInt();
				if (score < 0 || score > 100) {
					System.out.println("유효하지 않은 점수를 입력하셔서 입력 불가합니다");
					continue;
				}
				int result = dao.insertStudent(sName, mName, score);
				System.out.println(result == StudentDao.SUCCESS ? "입력성공" : "입력실패");
				break;
			case "2":
				System.out.print("조회할 학과명은(빅데이터학 | 경영정보학 | 컴퓨터공학 | 소프트웨어 | 인공지능학)? ");
				mName = scanner.next();
				ArrayList<StudentDto> students = dao.selectMname(mName);
				if (students.size() != 0) {
					System.out.println("등수\t이름\t학과\t점수");
					for (StudentDto student : students) {
						System.out.println(student);
					}
				} else {
					System.out.println("해당 학과 학생이 없습니다");
				}
				break;
			case "3":
				students = dao.selectStudent();
				if (students.size() != 0) {
					System.out.println("등수\t이름\t학과\t점수");
					for (StudentDto student : students) {
						System.out.println(student);
					}
				} else {
					System.out.println("해당 학과 학생이 없습니다");
				}
				break;
			case "4":
				students = dao.selectExpel();
				if (students.size() != 0) {
					System.out.println("등수\t이름\t학과\t점수");
					for (StudentDto student : students) {
						System.out.println(student);
					}
				} else {
					System.out.println("해당 학과 학생이 없습니다");
				}
				break;
			}
		} while (fn.equals("1") || fn.equals("2") || fn.equals("3") || fn.equals("4"));
		System.out.println("BYE");
	}
}