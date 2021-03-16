package com.lec.studentGUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

/*
0. ùȭ�鿡 �����̸��� �޺��ڽ��� �߰�(mName) 
	: public Vector<String> getMNamelist()
1. �й��˻� (sNo, sName, mName, score) 
	: public StudentSwingDto sNogetStudent(String sNo)
2. �̸��˻� (sNo, sName, mName, score) 
	: public ArrayList<StudentSwingDto> sNamegetStudent(String sName)
3. �����˻� (rank, sName(sNo����), mName(mNo����), score) 
	: public ArrayList<StudentSwingDto> mNamegetStudent(String mName)
4. �л��Է� 
	: public int insertStudent(String sName, String mName, int score)
    public int insertStudent(StudentSwingDto dto)
5. �л����� 
	: public int updateStudent(String sNo,String sName,
															String mName,int score)
    public int updateStudent(StudentSwingDto dto)
6. �л���� (rank, sName(sNo����), mName(mNo����), score) 
	: public ArrayList<StudentSwingDto> getStudents()
7. ���������  (rank, sName(sNo����), mName(mNo����), score) 
	: public ArrayList<StudentSwingDto> getStudentsExpel()
8. ����ó�� : public int sNoExpel(String sNo)
*/
public class StudentSwingDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	private static StudentSwingDao INSTANCE;

	public static StudentSwingDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new StudentSwingDao();
		}
		return INSTANCE;
	}

	public StudentSwingDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	// 0. ùȭ�鿡 �����̸��� �޺��ڽ��� �߰��� �� ���
	public Vector<String> getMNamelist() {
		Vector<String> mnames = new Vector<String>();
		mnames.add("");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT MNAME FROM MAJOR";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				mnames.add(rs.getString("mname"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return mnames;
	}

	// 1. �й��˻� (sNo, sName, mName, score)
	public StudentSwingDto sNogetStudent(String sNo) {
		StudentSwingDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT SNO, SNAME, MNAME, SCORE FROM STUDENT S, MAJOR M " + "    WHERE S.MNO=M.MNO AND SNO=?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String sName = rs.getString("sName");
				String mName = rs.getString("mName");
				int score = rs.getInt("score");
				dto = new StudentSwingDto(sNo, sName, mName, score);
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
			}
		}
		return dto;
	}

	// 2. �̸��˻� (sNo, sName, mName, score)
	public ArrayList<StudentSwingDto> sNamegetStudent(String sName) {
		ArrayList<StudentSwingDto> dtos = new ArrayList<StudentSwingDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT SNO, SNAME, MNAME, SCORE FROM STUDENT S, MAJOR M " + "    WHERE S.MNO=M.MNO AND SNAME=?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sName);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String sNo = rs.getString("sNo");
				// String sName = rs.getString("sName");
				String mName = rs.getString("mName");
				int score = rs.getInt("score");
				dtos.add(new StudentSwingDto(sNo, sName, mName, score));
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

//2. 3. �����˻� (rank, sName(sNo����), mName(mNo����), score) - 1 ���켺(2021001) ��������(1) 90
	public ArrayList<StudentSwingDto> mNamegetStudent(String mName) {
		ArrayList<StudentSwingDto> dtos = new ArrayList<StudentSwingDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM RANK, sNAME||'('||sNO||')' SNAME, mNAME||'('||mNO||')' mNAME, SCORE"
				+ "    FROM (SELECT S.*, MNAME FROM STUDENT S, MAJOR M " + "            WHERE S.mNO=m.mNO AND mNAME=?"
				+ "            ORDER BY SCORE DESC)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mName);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int rank = rs.getInt("rank");
				String sName = rs.getString("sName");
				mName = rs.getString("mName"); // �Ķ���ͷ� �Էµ� mName�� �������� ��� ���⼭�� mName�� ������(1)
				int score = rs.getInt("score");
				dtos.add(new StudentSwingDto(rank, sName, mName, score));
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

	// 4. �л��Է�
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

	public int insertStudent(StudentSwingDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO STUDENT (sNO, sNAME, mNO, SCORE) VALUES" + "    (TO_CHAR(SYSDATE, 'YYYY')"
				+ "    ||TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL,'000')),"
				+ "    ?,(SELECT mNO FROM MAJOR WHERE mNAME='?), ?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getsName());
			pstmt.setString(2, dto.getmName());
			pstmt.setInt(3, dto.getScore());
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

	// 5. �л�����
	public int updateStudent(String sNo, String sName, String mName, int score) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE STUDENT SET  sNAME=?, " + "                    mNO=(SELECT mNO FROM MAJOR WHERE mNAME=?),"
				+ "                    SCORE = ?" + "                WHERE SNO=?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sName);
			pstmt.setString(2, mName);
			pstmt.setInt(3, score);
			pstmt.setString(4, sNo);
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

	public int updateStudent(StudentSwingDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE STUDENT SET  sNAME=?, " + "                    mNO=(SELECT mNO FROM MAJOR WHERE mNAME=?),"
				+ "                    SCORE = ?" + "                WHERE SNO=?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getsName());
			pstmt.setString(2, dto.getmName());
			pstmt.setInt(3, dto.getScore());
			pstmt.setString(4, dto.getsNo());
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

	// 6. �л���� (rank, sName(sNo����), mName(mNo����), score) ��� : 1 ���켺(2021001)
	// ��������(1) 90
	public ArrayList<StudentSwingDto> getStudents() {
		ArrayList<StudentSwingDto> dtos = new ArrayList<StudentSwingDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM RANK, sNAME||'('||sNO||')' sNAME, mNAME||'('||MNO||')' MNAME, SCORE"
				+ "    FROM (SELECT S.*, MNAME FROM STUDENT S, MAJOR M " + "            WHERE S.mNO=m.mNO AND sEXPEL=0"
				+ "            ORDER BY SCORE DESC)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int rank = rs.getInt("rank");
				String sName = rs.getString("sName");
				String mName = rs.getString("mName"); // �Ķ���ͷ� �Էµ� mName�� �������� ��� ���⼭�� mName�� ������(1)
				int score = rs.getInt("score");
				dtos.add(new StudentSwingDto(rank, sName, mName, score));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return dtos;
	}

//6. �л���� (rank, sName(sNo����), mName(mNo����), score) ��� : 1 ���켺(2021001) ��������(1) 90
	public ArrayList<StudentSwingDto> getStudentsExpel() {
		ArrayList<StudentSwingDto> dtos = new ArrayList<StudentSwingDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM RANK, sNAME||'('||sNO||')' sName, mNAME||'('||mNO||')' mNAME, SCORE"
				+ "    FROM (SELECT S.*, mNAME FROM STUDENT S, MAJOR M " + "            WHERE S.mNO=m.mNO AND sEXPEL=1"
				+ "            ORDER BY SCORE DESC)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int rank = rs.getInt("rank");
				String sName = rs.getString("sName");
				String mName = rs.getString("mName"); // �Ķ���ͷ� �Էµ� mName�� �������� ��� ���⼭�� mName�� ������(1)
				int score = rs.getInt("score");
				dtos.add(new StudentSwingDto(rank, sName, mName, score));
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

	// 8. ����ó��
	public int sNoExpel(String sNo) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE STUDENT SET sEXPEL = 1 WHERE SNO=?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sNo);
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
}