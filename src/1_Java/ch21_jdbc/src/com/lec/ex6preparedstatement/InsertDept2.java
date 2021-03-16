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

		System.out.print("�߰��� �μ���ȣ�� ?");
		int deptno = scanner.nextInt();
		// �ش�μ���ȣ�� �ִ��� Ȯ�� �� �μ� �߰�
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(selectSql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			if (!rs.next()) { // �߰� ����
				System.out.print("�߰��� �μ��̸��� ?");
				String dname = scanner.next();
				System.out.print("�߰��� �μ���ġ�� ?");
				scanner.nextLine();
				String loc = scanner.nextLine();
				rs.close();
				pstmt.close();
				pstmt = conn.prepareStatement(insertSql);
				pstmt.setInt(1, deptno);
				pstmt.setString(2, dname);
				pstmt.setString(3, loc);
				int result = pstmt.executeUpdate();
				System.out.println(result > 0 ? deptno + "�� �μ� �߰� ����" : "�߰�����");
			} else {
				System.out.println("�ߺ��� �μ���ȣ�� �߰��� �Ұ��մϴ�");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(deptno + "�� �߰� ����");
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