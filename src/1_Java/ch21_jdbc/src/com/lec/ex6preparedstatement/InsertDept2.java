package com.lec.ex6preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner scanner = new Scanner(System.in);
		String selectSql = "SELECT * FROM DEPT WHERE DEPTNO=?";
		String insertSql = "INSERT INTO DEPT VALUES (?, ?, ?)";

		System.out.print("추가할 부서번호는 ?");
		int deptno = scanner.nextInt();
		// 해당부서번호가 있는지 확인 후 부서 추가
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(selectSql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			if (!rs.next()) { // 추가 가능
				System.out.print("추가할 부서이름은 ?");
				String dname = scanner.next();
				System.out.print("추가할 부서위치는 ?");
				scanner.nextLine();
				String loc = scanner.nextLine();
				rs.close();
				pstmt.close();
				pstmt = conn.prepareStatement(insertSql);
				pstmt.setInt(1, deptno);
				pstmt.setString(2, dname);
				pstmt.setString(3, loc);
				int result = pstmt.executeUpdate();
				System.out.println(result > 0 ? deptno + "번 부서 추가 성공" : "추가실패");
			} else {
				System.out.println("중복된 부서번호는 추가가 불가합니다");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(deptno + "번 추가 실패");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			} // close문의 try-catch
		} // DB 접속 try-catch
	}
}