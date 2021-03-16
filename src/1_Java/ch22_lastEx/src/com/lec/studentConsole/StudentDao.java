package com.lec.studentConsole;
// public int insertStudent(String sName, mName, score)

// public ArrayList<StudentDto> selectMname(String mName)
// public ArrayList<StudentDto> selectStudent()
// public ArrayList<StudentDto> selectExpel()

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	private static StudentDao INSTANCE;

	public static StudentDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new StudentDao();
		}
		return INSTANCE;
	}

	public StudentDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public int insertStudent(String sName, String mName, int score) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO STUDENT (sNO, sNAME, mNO, SCORE) VALUES" + "    (TO_CHAR(SYSDATE, 'YYYY')"
				+ "    ||TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL,'000'))," + "    ?,(SELECT mNO FROM MAJOR WHERE mNAME=?), ?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sName);
			pstmt.setString(2, mName);
			pstmt.setInt(3, score);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

	public ArrayList<StudentDto> selectMname(String mName) {
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM RANK, sNo, sNAME, mNAME, SCORE" + "    FROM (SELECT * FROM STUDENT S, MAJOR M "
				+ "            WHERE S.mNO=m.mNO AND mNAME=?" + "            ORDER BY SCORE DESC)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mName);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int rank = rs.getInt("rank");
				String sNo = rs.getString("sNo");
				String sName = rs.getString("sName");
				int score = rs.getInt("score");
				dtos.add(new StudentDto(rank, sNo, sName, mName, score));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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
			}
		}
		return dtos;
	}

	public ArrayList<StudentDto> selectStudent() {
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM RANK, sNo, sNAME, mNAME, SCORE"
				+ "    FROM (SELECT * FROM STUDENT S, MAJOR M WHERE S.mNO=m.mNO AND sEXPEL=0"
				+ "            ORDER BY SCORE DESC)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int rank = rs.getInt("rank");
				String sNo = rs.getString("sNo");
				String sName = rs.getString("sName");
				String mName = rs.getString("mName");
				int score = rs.getInt("score");
				dtos.add(new StudentDto(rank, sNo, sName, mName, score));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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
			}
		}
		return dtos;
	}

	public ArrayList<StudentDto> selectExpel() {
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM RANK, sNo, sNAME, mNAME, SCORE"
				+ "    FROM (SELECT * FROM STUDENT S, MAJOR M WHERE S.mNO=m.mNO AND sEXPEL=1"
				+ "            ORDER BY SCORE DESC)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int rank = rs.getInt("rank");
				String sNo = rs.getString("sNo");
				String sName = rs.getString("sName");
				String mName = rs.getString("mName");
				int score = rs.getInt("score");
				dtos.add(new StudentDto(rank, sNo, sName, mName, score));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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
			}
		}
		return dtos;
	}
}