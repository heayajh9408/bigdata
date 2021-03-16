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
		System.out.print("�����ϰ��� �ϴ� �μ���ȣ�� ?");
		int deptno = scanner.nextInt();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql1);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// ���� ����
				System.out.print("������ �μ� �̸��� ?");
				String dname = scanner.next();
				System.out.print("������ �μ� ��ġ�� ?");
				String loc = scanner.next();
				rs.close();
				pstmt.close();
				String sql2 = "UPDATE DEPT SET DNAME=?, LOC=? WHERE DEPTNO=?";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, dname);
				pstmt.setString(2, loc);
				pstmt.setInt(3, deptno);
				int result = pstmt.executeUpdate();
				System.out.println(result > 0 ? "���� ����" : "���� ����");
			} else {
				System.out.println("�������� �ʴ� �μ��Դϴ�.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("��������");
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
			} // close���� try-catch
		} // DB ���� try-catch
	}
}
