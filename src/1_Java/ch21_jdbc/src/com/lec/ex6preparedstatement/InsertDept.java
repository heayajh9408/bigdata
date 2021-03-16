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
		System.out.print("�߰��� �μ���ȣ�� ?");
		int deptno = scanner.nextInt();
		System.out.print("�߰��� �μ��̸��� ?");
		String dname = scanner.next();
		System.out.print("�߰��� �μ���ġ�� ?");
		scanner.nextLine();
		String loc = scanner.nextLine();
		// DB �����Ͽ� insert ����
		String sql = "INSERT INTO DEPT VALUES (?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			// stmt = conn.createStatemenst();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno); // deptno ������ int�� setInt
			pstmt.setString(2, dname); // dname�� String�̶� setString
			pstmt.setString(3, loc);
			// int result = stmt.executeUpdate(sql);
			int result = pstmt.executeUpdate();
			System.out.println(result > 0 ? deptno + "�� �Է� ����" : "�Է½���");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(deptno + "�� �Է½���");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			} // close���� try-catch
		} // DB ���� try-catch
	}
}