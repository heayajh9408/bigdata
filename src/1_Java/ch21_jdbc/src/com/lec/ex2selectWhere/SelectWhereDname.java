package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectWhereDname {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner scanner = new Scanner(System.in);
		System.out.print("���ϴ� �μ���ȣ�� ?");
		String dname = scanner.next();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM DEPT WHERE DNAME='" + dname + "'";
		sql = String.format("SELECT * FROM DEPT WHERE DNAME='%s'", dname);
		try {
			Class.forName(driver);// (1)
			conn = DriverManager.getConnection(url, "scott", "tiger");// (2)
			stmt = conn.createStatement(); // (3)
			rs = stmt.executeQuery(sql); // (4)+(5)
			if (rs.next()) {// (6)
				System.out.println("�μ���ȣ : " + rs.getInt("deptno"));
				System.out.println("�μ��̸� : " + dname);
				System.out.println("�μ���ġ : " + rs.getString("loc"));
			} else {
				System.out.println("�ش� �μ��̸��� �������� �ʽ��ϴ�");
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
			}
		}
	}
}
