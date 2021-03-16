DROP TABLE STUDENT;
DROP TABLE MAJOR;
DROP SEQUENCE STUDENT_SEQ; 

CREATE TABLE MAJOR(
    mNO NUMBER(2),
    mNAME VARCHAR2(50),
    PRIMARY KEY(mNO));
CREATE SEQUENCE STUDENT_SEQ MAXVALUE 999 NOCACHE NOCYCLE;
CREATE TABLE STUDENT(
    sNO VARCHAR2(7),
    sNAME VARCHAR2(50),
    mNO NUMBER(2),
    SCORE NUMBER(3) DEFAULT 0 CHECK(SCORE>=0 AND SCORE<=100),
    sEXPEL NUMBER(1) DEFAULT 0 CHECK(sEXPEL=0 OR sEXPEL=1),
    PRIMARY KEY(sNO),
    FOREIGN KEY(mNO) REFERENCES MAJOR(mNO));
-- �а����� �Է�
INSERT INTO MAJOR VALUES (1, '��������');
INSERT INTO MAJOR VALUES (2, '�濵������');
INSERT INTO MAJOR VALUES (3, '��ǻ�Ͱ���');
INSERT INTO MAJOR VALUES (4, '����Ʈ����');
INSERT INTO MAJOR VALUES (5, '�ΰ�������');
SELECT * FROM MAJOR;
INSERT INTO STUDENT (sNO, sNAME, mNO, SCORE) VALUES
    (TO_CHAR(SYSDATE, 'YYYY')
    ||TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL,'000')),
    '���켺',(SELECT mNO FROM MAJOR WHERE mNAME='��������'), 90) ;
INSERT INTO STUDENT (sNO, sNAME, mNO, SCORE) VALUES
    (TO_CHAR(SYSDATE, 'YYYY')
    ||TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL,'000')),
    '�ڼ���',(SELECT mNO FROM MAJOR WHERE mNAME='��������'), 80) ;
INSERT INTO STUDENT (sNO, sNAME, mNO, SCORE) VALUES
    (TO_CHAR(SYSDATE, 'YYYY')
    ||TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL,'000')),
    '�����',(SELECT mNO FROM MAJOR WHERE mNAME='��ǻ�Ͱ���'), 20) ;
INSERT INTO STUDENT VALUES
    (TO_CHAR(SYSDATE, 'YYYY')
    ||TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL,'000')),
    '������',(SELECT mNO FROM MAJOR WHERE mNAME='��ǻ�Ͱ���'), 10, 1) ;
SELECT * FROM STUDENT;
COMMIT;
-- ����StudentMng���� �ʿ��� Query
-- 0. ùȭ�鿡 �����̸��� �޺��ڽ��� �߰�(mName) : DAO���� public Vector<String> getMNamelist()
SELECT MNAME FROM MAJOR;
-- 1. �й��˻� (sNo, sName, mName, score) : DAO���� public StudentSwingDto sNogetStudent(String sNo)
SELECT SNO, SNAME, MNAME, SCORE FROM STUDENT S, MAJOR M 
    WHERE S.MNO=M.MNO AND SNO='2021001';
-- 2. �̸��˻� (sNo, sName, mName, score) : DAO���� public ArrayList<StudentSwingDto> sNamegetStudent(String sName)
SELECT SNO, SNAME, MNAME, SCORE FROM STUDENT S, MAJOR M 
    WHERE S.MNO=M.MNO AND SNAME='�����';
-- 3. �����˻� (rank, sName(sNo����), mName(mNo����), score) : DAO���� public ArrayList<StudentSwingDto> mNamegetStudent(String mName)
--- ��� : 1 ���켺(2021001) ��������(1) 90 
SELECT ROWNUM RANK, sNAME||'('||sNO||')' sName, mNAME||'('||mNO||')' mNAME, SCORE
    FROM (SELECT S.*, MNAME FROM STUDENT S, MAJOR M 
            WHERE S.mNO=m.mNO AND mNAME='��������'
            ORDER BY SCORE DESC);
-- 4. �л��Է� : DAO���� public int insertStudent(String sName, String mName, int score)
--              DAO���� public int insertStudent(StudentSwingDto dto)
INSERT INTO STUDENT (sNO, sNAME, mNO, SCORE) VALUES
    (TO_CHAR(SYSDATE, 'YYYY')
    ||TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL,'000')),
    '�ű浿',(SELECT mNO FROM MAJOR WHERE mNAME='�濵������'), 40);
COMMIT;
-- 5. �л����� : DAO���� public int updateStudent(String sNo, String sName, String mName, int score)
--              DAO���� public int updateStudent(StudentSwingDto dto)
SELECT * FROM STUDENT;
UPDATE STUDENT SET  sNAME='�ű浿', 
                    mNO=(SELECT mNO FROM MAJOR WHERE mNAME='�ΰ�������'),
                    SCORE = 50
                WHERE SNO='2021006';
COMMIT;
-- 6. �л���� (rank, sName(sNo����), mName(mNo����), score) : DAO���� public ArrayList<StudentSwingDto> getStudents()
-- ��� : 1 ���켺(2021001) ��������(1) 90
SELECT ROWNUM RANK, sNAME||'('||sNO||')' sName, mNAME||'('||MNO||')' MNAME, SCORE
    FROM (SELECT S.*, MNAME FROM STUDENT S, MAJOR M 
            WHERE S.mNO=m.mNO AND sEXPEL=0
            ORDER BY SCORE DESC);
-- 7. ���������  (rank, sName(sNo����), mName(mNo����), score) : DAO���� public ArrayList<StudentSwingDto> getStudentsExpel()
-- ��� : 1 ������(2021004) ��ǻ�Ͱ���(3) 10
SELECT ROWNUM RANK, sNAME||'('||sNO||')' sName, 
        mNAME||'('||mNO||')' mNAME, SCORE
    FROM (SELECT s.*, mName FROM STUDENT S, MAJOR M 
            WHERE S.mNO=m.mNO AND sEXPEL=1
            ORDER BY SCORE DESC);
-- 8. ����ó�� : DAO���� public int sNoExpel(String sNo)
UPDATE STUDENT SET sEXPEL = 1 WHERE SNO='2021006';
COMMIT;
SELECT * FROM STUDENT;
SELECT * FROM MAJOR;
UPDATE STUDENT SET sEXPEL = 0;