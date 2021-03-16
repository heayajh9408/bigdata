package com.lec.ex3insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner scanner = new Scanner(System.in);
		System.out.print("�Է��� �μ���ȣ�� ?");
		int deptno = scanner.nextInt();
		System.out.print("�Է��� �μ��̸��� ?");
		String dname = scanner.next();
		System.out.print("�Է��� �μ��� ��ġ�� ?");
		scanner.nextLine(); // '\n'�� �ִ� ���� clear
		String loc = scanner.nextLine(); // seoul korea
		Connection conn = null;
		Statement stmt = null;
		String sql = "INSERT INTO DEPT VALUES (" + deptno + ",'" + dname + "','" + loc + "')";
		sql = String.format("INSERT INTO DEPT VALUES (%d,'%s','%s')", deptno, dname, loc);
		try {
			Class.forName(driver); // (1)
			conn = DriverManager.getConnection(url, "scott", "tiger");// (2)
			stmt = conn.createStatement(); // (3)
			int result = stmt.executeUpdate(sql); // (4)+(5)
			System.out.println(result > 0 ? "�μ��Է¼���" : "�μ��Է½���"); // (6)
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally { // (7)
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
