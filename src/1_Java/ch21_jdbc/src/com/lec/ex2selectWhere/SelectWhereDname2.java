package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// �μ����� �Է¹޾� �ش� �μ��� ������ ��� ����Ʈ ���(���, �̸�, �޿�, �޿����)
public class SelectWhereDname2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner scanner = new Scanner(System.in);
		System.out.print("���ϴ� �μ��̸��� ?");
		String dname = scanner.next();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql1 = String.format("SELECT * FROM DEPT WHERE DNAME='%s'", dname);
		String sql2 = String.format("SELECT e.EMPNO, ENAME, SAL, GRADE " + " FROM EMP E, SALGRADE, DEPT D "
				+ " WHERE E.DEPTNO=D.DEPTNO " + "AND SAL BETWEEN LOSAL AND HISAL" + "      AND DNAME='%s'", dname);
		try {
			Class.forName(driver);// (1)
			conn = DriverManager.getConnection(url, "scott", "tiger");// (2)
			stmt = conn.createStatement(); // (3)
			rs = stmt.executeQuery(sql1); // (4)+(5)
			if (rs.next()) {// (6)
				System.out.println("�μ���ȣ : " + rs.getInt("deptno"));
				System.out.println("�μ��̸� : " + dname);
				System.out.println("�μ���ġ : " + rs.getString("loc"));
				rs.close();
				rs = stmt.executeQuery(sql2);
				if (rs.next()) {
					System.out.println("���\t�̸�\t�޿�\t�޿����");
					do {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						int sal = rs.getInt("sal");
						int grade = rs.getInt("grade");
						System.out.println(empno + "\t" + ename + "\t" + sal + "\t" + grade);
					} while (rs.next());
				} else {
					System.out.println("�ش� �μ��� ����� �������� �ʽ��ϴ�");
				}
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