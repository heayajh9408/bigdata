package com.lec.person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PersonMng {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String fn;
		try {
			Class.forName(driver); // 1단계는 처음 한번만
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		do {
			System.out.print("1:입력 | 2:직업별출력 | 3:전체출력 | 그외:종료 > ");
			fn = scanner.next();
			switch (fn) {
			case "1": // 이름, 직업명, 국어, 영어, 수학을 입력받아 입력(insert)
				System.out.print("입력할 이름은 ?");
				String name = scanner.next();
				System.out.print("직업명은 (배우 | 가수 | 엠씨) ?");
				String jname = scanner.next();
				System.out.print("국어?");
				int kor = scanner.nextInt();
				System.out.print("영어?");
				int eng = scanner.nextInt();
				System.out.print("수학?");
				int mat = scanner.nextInt();
				String sql1 = "INSERT INTO PERSON VALUES " + "    (PERSON_NO_SQ.NEXTVAL, ?,"
						+ "        (SELECT JNO FROM JOB WHERE JNAME=?),?,?,?)";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql1);
					pstmt.setString(1, name);
					pstmt.setString(2, jname);
					pstmt.setInt(3, kor);
					pstmt.setInt(4, eng);
					pstmt.setInt(5, mat);
					int result = pstmt.executeUpdate();
					System.out.println(result > 0 ? "입력성공" : "입력실패");
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} finally {
					try {
						if (pstmt != null)
							pstmt.close();
						if (conn != null)
							conn.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
				break;
			case "2": // 직업명을 입력받아 직업별 출력(select)
				System.out.print("출력하고자 하는 직업명은(배우|가수|엠씨)?");
				jname = scanner.next();
				String sql2 = "SELECT ROWNUM RANK, S.*"
						+ "    FROM (SELECT NAME||'('||NO||'번)' NAME, JNAME, KOR, ENG, MAT,"
						+ "        KOR+ENG+MAT SUM " + "    FROM PERSON P, JOB J" + "    WHERE P.JNO=J.JNO AND JNAME=?"
						+ "    ORDER BY SUM DESC) S";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql2);
					pstmt.setString(1, jname);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						System.out.println("등수\t이름\t직업\t국어\t영어\t수학\t총점");
						do {
							int rank = rs.getInt("rank");
							name = rs.getString("name");
							jname = rs.getString("jname");
							kor = rs.getInt("kor");
							eng = rs.getInt("eng");
							mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							System.out.println(rank + "\t" + name + "\t" + jname + "\t" + kor + "\t" + eng + "\t" + mat
									+ "\t" + sum);
						} while (rs.next());
					} else {
						System.out.println("해당 직업명의 사람이 없습니다");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} finally {
					try {
						if (rs != null)
							rs.close();
						if (pstmt != null)
							pstmt.close();
						if (conn != null)
							conn.close();
					} catch (Exception e2) {
						// TODO: handle exception
					} // close() try-catch
				} // DB접속 try-catch
				break;
			case "3": // 전체 출력(select)
				String sql3 = "SELECT ROWNUM RANK, S.*"
						+ "    FROM (SELECT NAME||'('||NO||'번)' NAME, JNAME, KOR, ENG, MAT,"
						+ "        KOR+ENG+MAT SUM " + "    FROM PERSON P, JOB J" + "    WHERE P.JNO=J.JNO "
						+ "    ORDER BY SUM DESC) S";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql3);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						System.out.println("등수\t이름\t직업\t국어\t영어\t수학\t총점");
						do {
							int rank = rs.getInt("rank");
							name = rs.getString("name");
							jname = rs.getString("jname");
							kor = rs.getInt("kor");
							eng = rs.getInt("eng");
							mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							System.out.println(rank + "\t" + name + "\t" + jname + "\t" + kor + "\t" + eng + "\t" + mat
									+ "\t" + sum);
						} while (rs.next());
					} else {
						System.out.println("해당 직업명의 사람이 없습니다");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} finally {
					try {
						if (rs != null)
							rs.close();
						if (pstmt != null)
							pstmt.close();
						if (conn != null)
							conn.close();
					} catch (Exception e2) {
						// TODO: handle exception
					} // close() try-catch
				} // DB접속 try-catch
				break;
			}
		} while (fn.equals("1") || fn.equals("2") || fn.equals("3"));
		System.out.println("BYE");
	}
}