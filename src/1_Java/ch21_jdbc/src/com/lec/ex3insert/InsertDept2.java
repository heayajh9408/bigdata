package com.lec.ex3insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner scanner = new Scanner(System.in);
		System.out.print("�Է��� �μ���ȣ�� ?");
		int deptno = scanner.nextInt();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String selectSql = "SELECT * FROM DEPT WHERE DEPTNO=" + deptno;
		try {
			Class.forName(driver);// (1)
			conn = DriverManager.getConnection(url, "scott", "tiger"); // (2)
			stmt = conn.createStatement(); // (3)
			rs = stmt.executeQuery(selectSql); // (4)+(5)
			if (rs.next()) {
				System.out.println("�ߺ��� �μ���ȣ�� �Է��� �Ұ��մϴ�.");
			} else {
				System.out.print("�Է��� �μ��̸��� ?");
				String dname = scanner.next();
				System.out.print("�Է��� �μ���ġ�� ?");
				scanner.nextLine(); // ���� clear
				String loc = scanner.nextLine();
				String insertSql = String.format("INSERT INTO DEPT VALUES (%d,'%s','%s')", deptno, dname, loc);
				int result = stmt.executeUpdate(insertSql);
				if (result > 0) {
					System.out.println("�Է� ����");
				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally { // (7)
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} // �������� try-catch
		} // try-catch
	}// main
}// class
