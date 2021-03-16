package com.lec.ex6preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql1 = "SELECT * FROM DEPT WHERE DEPTNO=?";
		System.out.print("수정하고자 하는 부서번호는 ?");
		int deptno = scanner.nextInt();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql1);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// 수정 진행
				System.out.print("수정할 부서 이름은 ?");
				String dname = scanner.next();
				System.out.print("수정할 부서 위치는 ?");
				String loc = scanner.next();
				rs.close();
				pstmt.close();
				String sql2 = "UPDATE DEPT SET DNAME=?, LOC=? WHERE DEPTNO=?";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, dname);
				pstmt.setString(2, loc);
				pstmt.setInt(3, deptno);
				int result = pstmt.executeUpdate();
				System.out.println(result > 0 ? "수정 성공" : "수정 실패");
			} else {
				System.out.println("존재하지 않는 부서입니다.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("수정실패");
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
