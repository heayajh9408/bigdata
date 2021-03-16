package com.lec.ex4update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner scanner = new Scanner(System.in);
		System.out.print("수정할 부서번호는 ?");
		String deptno = scanner.next(); // "50"

		// 입력한 해당 부서번호가 있는지 없는 체크

		System.out.print("수정할 부서의 이름은 ?");
		String dname = scanner.next();
		System.out.print("수정할 부서의 위치은 ?");
		String loc = scanner.next();
		// DB 수정
		Connection conn = null;
		Statement stmt = null;
		String query = "UPDATE DEPT SET DNAME='" + dname + "', LOC='" + loc + "'" + "    WHERE DEPTNO=" + deptno;
		query = String.format("UPDATE DEPT SET DNAME='%s', LOC='%s'" + "    WHERE DEPTNO=%s", dname, loc, deptno);
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(query);
			System.out.println(result > 0 ? deptno + "번 부서 수정 성공" : "해당 부서 존재 안 함");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("수정 실패");
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
