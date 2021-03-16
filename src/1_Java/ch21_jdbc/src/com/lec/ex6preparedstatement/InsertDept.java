package com.lec.ex6preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner scanner = new Scanner(System.in);
		System.out.print("추가할 부서번호는 ?");
		int deptno = scanner.nextInt();
		System.out.print("추가할 부서이름은 ?");
		String dname = scanner.next();
		System.out.print("추가할 부서위치는 ?");
		scanner.nextLine();
		String loc = scanner.nextLine();
		// DB 접속하여 insert 실행
		String sql = "INSERT INTO DEPT VALUES (?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			// stmt = conn.createStatemenst();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno); // deptno 변수가 int라 setInt
			pstmt.setString(2, dname); // dname이 String이라 setString
			pstmt.setString(3, loc);
			// int result = stmt.executeUpdate(sql);
			int result = pstmt.executeUpdate();
			System.out.println(result > 0 ? deptno + "번 입력 성공" : "입력실패");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(deptno + "번 입력실패");
		} finally {
			try {
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