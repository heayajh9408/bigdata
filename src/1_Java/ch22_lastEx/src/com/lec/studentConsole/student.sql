 -- DROP
DROP TABLE STUDENT;
DROP TABLE MAJOR;
DROP SEQUENCE STUDENT_SEQ;
-- CREATE
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
COMMIT;
-- �ܼ� StudentMng
-- 2021001������ ����� ����
SELECT TO_CHAR(SYSDATE, 'YYYY')||
        TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL, '000')) 
    FROM DUAL;

SELECT TO_CHAR(SYSDATE, 'YYYY')||
        LPAD(STUDENT_SEQ.NEXTVAL,3,'0') FROM DUAL;

-- 1�� ���. �̸�, ������, ������ �Է¹޾� �Է�
--    �й��� �������� �̿��Ͽ� "����⵵||������ȣ"�� �Է��Ѵ�

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

--2�� ���. ���ϴ� �а��̸��� �Է¹޾�
--    �а��� ��ȸ�� ������ ���� ������ ���
-- 1��    	���켺(2021001)     ��������      	90
SELECT ROWNUM RANK, sNAME||'('||sNO||')' sNAME, mNAME, SCORE
    FROM (SELECT * FROM STUDENT S, MAJOR M 
            WHERE S.mNO=m.mNO AND mNAME='��ǻ�Ͱ���'
            ORDER BY SCORE DESC); -- (1)���
            
SELECT ROWNUM RANK, sNo, sNAME, mNAME, SCORE
    FROM (SELECT * FROM STUDENT S, MAJOR M 
            WHERE S.mNO=m.mNO AND mNAME='��ǻ�Ͱ���'
            ORDER BY SCORE DESC);-- (2)���
--3�� ������  
-- ���������� ���� ��ü �л��� ��ȸ �� ������ ���� �� ���
--���           �̸�         �а�      	����
--������������������������������������������������������������
--1��    	������(2021005)     �ΰ�������     	100
SELECT ROWNUM RANK, sNAME||'('||sNO||')' sNAME, mNAME, SCORE
    FROM (SELECT * FROM STUDENT S, MAJOR M WHERE S.mNO=m.mNO AND sEXPEL=0
            ORDER BY SCORE DESC);-- (1)���
SELECT ROWNUM RANK, sNo, sNAME, mNAME, SCORE
    FROM (SELECT * FROM STUDENT S, MAJOR M WHERE S.mNO=m.mNO AND sEXPEL=0
            ORDER BY SCORE DESC);-- (2)���
--4�� ������  
-- �������� ��ü �л��� ��ȸ �� ������ ���� �� ���
--���           �̸�         �а�      	����
--������������������������������������������������������������
--1��    ȫö��(2021006)     ����Ʈ����		20
SELECT ROWNUM RANK, sNAME||'('||sNO||')' sNAME, mNAME, SCORE
    FROM (SELECT * FROM STUDENT S, MAJOR M WHERE S.mNO=m.mNO AND sEXPEL=1
            ORDER BY SCORE DESC);-- (1)���
SELECT ROWNUM RANK, sNo, sNAME, mNAME, SCORE
    FROM (SELECT * FROM STUDENT S, MAJOR M WHERE S.mNO=m.mNO AND sEXPEL=1
            ORDER BY SCORE DESC);-- (2)���
COMMIT;
select mname from major;