package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// ����ڿ��� ���ϴ� �μ���ȣ�� �Է¹޾� �μ����� �Ѹ���
public class SelectWhereDeptno {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; // select�� ���� ����� �ޱ� ���� ����
		Scanner scanner = new Scanner(System.in);
		System.out.print("���ϴ� �μ���ȣ�� ?");
		int deptno = scanner.nextInt();
		String sql = "SELECT * FROM dept where deptno=" + deptno;
		try {
			Class.forName(driver); // (1)
			conn = DriverManager.getConnection(url, "scott", "tiger"); // (2)
			stmt = conn.createStatement(); // (3)
			rs = stmt.executeQuery(sql); // (4)+(5)
			if (rs.next()) { // �ش�μ��� ���� (6)
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				System.out.println(deptno + "�� �μ��� ������ ������ �����ϴ�.");
				System.out.println("�μ��� : " + dname);
				System.out.println("�� ġ : " + loc);
			} else { // �ش�μ��� ����
				System.out.println("�ش� �μ��� �������� �ʽ��ϴ�");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { // (7)
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}