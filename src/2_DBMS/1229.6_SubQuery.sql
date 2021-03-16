-- [VI] SUB QUERY : QUERY�ȿ� QUERY�� ����

-- �� 1. �������� ����
--�������� (1) �����༭������(������������� ������) = > >= < <= != <>
    --    (2) �����༭������(������������� 2���̻�)IN ANY SOME ALL EXISTS
-- SCOTT�� �ٹ��ϴ� �μ��̸� ���
SELECT DNAME FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND ENAME='SCOTT';
SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT'; -- ��������
SELECT DNAME FROM DEPT
 WHERE DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT');--��������
-- JOB�� 'MANAGER'�� ����� �μ��̸�
SELECT DEPTNO FROM EMP WHERE JOB='MANAGER'; -- �����༭������
SELECT DNAME FROM DEPT
   WHERE DEPTNO IN(SELECT DEPTNO FROM EMP WHERE JOB='MANAGER');--����
-- �� 2. ������ ��������
-- ȸ�翡�� �޿��� ���� ���� �޴� ����� �̸��� �޿�
SELECT MAX(SAL) FROM EMP; -- ��������(������, ���Ͽ�)
SELECT ENAME, SAL FROM EMP
    WHERE SAL=(SELECT MAX(SAL) FROM EMP); -- ��������
-- SCOTT�� ���� �μ���ȣ�� ����̸�
SELECT E2.ENAME
    FROM EMP E1, EMP E2
    WHERE E1.ENAME='SCOTT' AND E1.DEPTNO=E2.DEPTNO AND E2.ENAME<>'SCOTT';
SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT';-- ��������
SELECT ENAME FROM EMP
    WHERE DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT')
        AND ENAME<>'SCOTT'; -- ��������
-- SCOTT�� ���� �ٹ����� ����̸� (50�� DALLAS �μ� ȫ�浿�Է���)
INSERT INTO DEPT VALUES (50, 'IT', 'DALLAS');
INSERT INTO EMP (EMPNO, ENAME, DEPTNO) VALUES (9999, 'ȫ',50);
SELECT LOC FROM DEPT D, EMP E
    WHERE D.DEPTNO=E.DEPTNO AND ENAME='SCOTT'; -- ��������
SELECT ENAME FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND 
        LOC=(SELECT LOC FROM DEPT D, EMP E
            WHERE D.DEPTNO=E.DEPTNO AND ENAME='SCOTT')
        AND ENAME<>'SCOTT';
-- SCOTT�� ���� �μ��� �ٺ��ϴ� ������� �޿� ���� ���
SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT'; -- ��������
SELECT SUM(SAL) FROM EMP
    WHERE DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT');--����
-- SCOTT�� ������ JOB�� ���� ����� ��� ������ ���
SELECT * FROM EMP
    WHERE JOB=(SELECT JOB FROM EMP WHERE ENAME='SCOTT');
-- DALLAS���� �ٺ��ϴ� ����� �̸�, �μ���ȣ�� ���
ROLLBACK; -- DML ���ɾ� ���
SELECT ENAME, DEPTNO FROM EMP
    WHERE DEPTNO=(SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS');
-- SALES(DNAME) �μ����� �ٹ��ϴ� ������ �̸�, �޿��� ���
SELECT ENAME, SAL FROM EMP
    WHERE DEPTNO=(SELECT DEPTNO FROM DEPT WHERE DNAME='SALES');
-- 'KING'�� ���ӻ���� ����� �̸��� �޿�
SELECT ENAME, SAL FROM EMP
    WHERE MGR=(SELECT EMPNO FROM EMP WHERE ENAME='KING');
-- ��ձ޿� ���Ϸ� �޴� ����� �̸�, �޿��� ���
SELECT ENAME, SAL FROM EMP
    WHERE SAL<=(SELECT AVG(SAL) FROM EMP);
-- SCOTT�� JOB�� �μ���ȣ�� ���� ������ ��� �ʵ� ���(���߿���������)
SELECT * FROM EMP
    WHERE (JOB, DEPTNO) = (SELECT JOB, DEPTNO FROM EMP
                            WHERE ENAME='SCOTT');

-- ������ �������� �������� (1~13������)
--1. ������̺����� ���� ���� �Ի��� ����� �̸�, �޿�, �Ի���
SELECT ENAME, SAL, HIREDATE FROM EMP
    WHERE HIREDATE= (SELECT MIN(HIREDATE) FROM EMP);
-- 2. ȸ�翡�� ���� �޿��� ���� ����� �̸�, �޿�
SELECT ENAME, SAL FROM EMP
    WHERE SAL=(SELECT MIN(SAL) FROM EMP);
-- 3. ȸ�� ��պ��� �޿��� ���� �޴� ����� �̸�, �޿�, �μ��ڵ�
SELECT ENAME, SAL, DEPTNO FROM EMP
    WHERE SAL>(SELECT AVG(SAL) FROM EMP);
--4. ȸ�� ��� ������ �޿��� �޴� ����� �̸�, �޿�, �μ���
SELECT  ENAME, SAL, DNAME FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND SAL<=(SELECT AVG(SAL) FROM EMP);    
--5. SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ���
SELECT ENAME, SAL, HIREDATE, GRADE FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL
    AND HIREDATE<(SELECT HIREDATE FROM EMP 
    WHERE ENAME='SCOTT');
--6. 5��(SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ���)�� �μ��� �߰��ϰ� 
    --�޿��� ū �� ����
SELECT ENAME, SAL, HIREDATE, GRADE, DNAME FROM EMP E, SALGRADE, DEPT D
    WHERE SAL BETWEEN LOSAL AND HISAL
    AND E.DEPTNO=D.DEPTNO
    AND HIREDATE<(SELECT HIREDATE FROM EMP 
    WHERE ENAME='SCOTT')
    ORDER BY SAL DESC;
--7. ������̺����� BLAKE ���� �޿��� ���� ������� ���, �̸�, �޿��� �˻�
SELECT EMPNO, ENAME, SAL FROM EMP
    WHERE SAL>(SELECT SAL FROM EMP WHERE ENAME='BLAKE');
--8. ������̺����� MILLER���� �ʰ� �Ի��� ����� ���, �̸�, �Ի����� �˻��Ͻÿ�
SELECT EMPNO, ENAME, HIREDATE FROM EMP
    WHERE HIREDATE>(SELECT HIREDATE FROM EMP WHERE ENAME='MILLER');
--9. ������̺����� �����ü ��� �޿����� �޿��� ���� ������� ���, �̸�, �޿��� �˻�
SELECT EMPNO, ENAME, SAL FROM EMP
    WHERE SAL>(SELECT AVG(SAL) FROM EMP);
--10. ������̺����� CLARK�� ���� �μ���, ����� 7698�� ������ �޿����� 
        -- ���� �޿��� �޴� ������� ���, �̸�, �޿� �˻�
SELECT EMPNO, ENAME, SAL FROM EMP
    WHERE DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='CLARK')
    AND SAL>(SELECT SAL FROM EMP WHERE EMPNO=7698);
--11.  �����ȭ. ������̺����� CLARK�� ���� �μ����̸�, ����� 7698�� ������ �޿����� 
    --  ���� �޿��� �޴� ������� ���, �̸�, �޿� �˻�
SELECT EMPNO, ENAME, SAL FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO 
    AND DNAME=(SELECT DNAME FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND ENAME='CLARK')
    AND SAL>(SELECT SAL FROM EMP WHERE EMPNO=7698);
--12.  ��� ���̺����� BLAKE�� ���� �μ��� �ִ� ��� ����� �̸��� �Ի����ڸ� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT ENAME, HIREDATE FROM EMP
    WHERE DEPTNO= (SELECT DEPTNO FROM EMP WHERE ENAME='BLAKE');
--13.  ��� ���̺����� ��� �޿� �̻��� �޴� ��� �������� ���ؼ� �����ȣ�� �̸��� ���
        --(�� �޿��� ���� ������ ����Ͽ���.)
SELECT EMPNO, ENAME FROM EMP
    WHERE SAL>=(SELECT AVG(SAL) FROM EMP)
    ORDER BY SAL DESC;
-- �� 3. ������ �������� ;  IN, ALL, ANY=SOME, EXISTS
-- (1) IN ; �������� ��� �� �ϳ��� ��ġ�ϸ� ��
-- �μ����� �Ի����� ���� ���� ����� �μ���ȣ, �̸�, �Ի���, �μ���ȣ ���
SELECT DEPTNO, MAX(HIREDATE) FROM EMP GROUP BY DEPTNO; -- ����
SELECT EMPNO, ENAME, HIREDATE, DEPTNO FROM EMP
    WHERE (DEPTNO, HIREDATE) IN (SELECT DEPTNO, MAX(HIREDATE) 
                                FROM EMP GROUP BY DEPTNO);
-- �޿��� 3000�̻� �޴� ����� �Ҽӵ� �μ����� �ٺ��ϴ� ������� ��� ����
SELECT * FROM EMP
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE SAL>=3000);
--(2)ALL
-- 30�� �μ� �ִ� �޿����� �޿��� �޴� ����� ����
SELECT * FROM EMP
    WHERE SAL>(SELECT MAX(SAL) FROM EMP WHERE DEPTNO=30);
SELECT * FROM EMP
    WHERE SAL > ALL (SELECT SAL FROM EMP WHERE DEPTNO=30);
--(3)ANY=SOME
SELECT * FROM EMP
    WHERE SAL > ANY (SELECT SAL FROM EMP WHERE DEPTNO=30);
SELECT * FROM EMP
    WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO=30);
-- (4) EXISTS ; �������� ����� �����ϸ� ��
-- ���Ӻ��ϰ� �ִ� �������� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL 
    FROM EMP M
    WHERE EXISTS (SELECT * FROM EMP W WHERE M.EMPNO=W.MGR);
SELECT EMPNO, ENAME, SAL 
    FROM EMP MANAGER
    WHERE EXISTS (SELECT * FROM EMP WHERE MANAGER.EMPNO=MGR);
-- ���ܻ���� ��� �ʵ� ���� ���
SELECT * FROM EMP MANAGER
    WHERE NOT EXISTS (SELECT * FROM EMP WHERE MANAGER.EMPNO=MGR);
-- źź������
-- �μ����� ���� �޿��� ���� �޴� ����� ���, �̸�, �޿�, �μ���ȣ
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO; -- ������ ��������
SELECT EMPNO, ENAME, SAL, DEPTNO
    FROM EMP
    WHERE (DEPTNO, SAL) IN (SELECT DEPTNO, MAX(SAL) 
                            FROM EMP GROUP BY DEPTNO);
                            
--����(JOB)�� MANAGER�� ����� ���� �μ��� �μ� ��ȣ�� �μ����� ����(IN)
SELECT DEPTNO, DNAME, LOC FROM DEPT 
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE JOB='MANAGER');
    -- SUB QUERY�� ���� �ʰ� JOIN�� ���� �Ʒ��� ����    
SELECT E.DEPTNO, DNAME, LOC FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND JOB='MANAGER';
    
--������ 3000�̻��� ����� �� ���� ����� ����� �ش� ��޺� �ְ� ������ 
    --�޴� ������� ���, �̸�, ����, �Ի���, �޿�, �޿������ ���
SELECT * FROM SALGRADE; -- 3000�̻��� 4��ް� 5��޻�
SELECT GRADE, MAX(SAL) FROM EMP, SALGRADE 
    WHERE SAL BETWEEN LOSAL AND HISAL 
        AND SAL>=3000 GROUP BY GRADE; -- ������ ��������
SELECT EMPNO, ENAME, JOB, HIREDATE, SAL, GRADE FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL 
    AND (GRADE, SAL) IN (SELECT GRADE, MAX(SAL) FROM EMP, SALGRADE
        WHERE  SAL BETWEEN LOSAL AND HISAL 
            AND SAL>=3000
        GROUP BY GRADE); -- ��������
-- �����ȭ 
-- �Ի��� �б⺰�� ���� ���� ������ �޴� ������� 
    -- �б�, ���, �̸�, JOB, �����, �Ի���, �޿�, �󿩸� ����ϼ���
-- �б� ���
SELECT CEIL(EXTRACT(MONTH FROM HIREDATE)/3) QUARTER ,EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM FROM EMP
    WHERE (CEIL(EXTRACT(MONTH FROM HIREDATE)/3), SAL) IN 
        (SELECT CEIL(EXTRACT(MONTH FROM HIREDATE)/3), MAX(SAL) FROM EMP
            GROUP BY CEIL(EXTRACT(MONTH FROM HIREDATE)/3))
    ORDER BY QUARTER;

-- SALESMAN ��� ����� ���� �޿��� ���� �޴� ������� �̸��� �޿��� 
    -- ����(��� ����)�� ����ϵ� ���� ����� ������� �ʴ´�.(ALL�̿�)
SELECT ENAME, SAL, JOB FROM EMP 
    WHERE SAL > ALL(SELECT SAL FROM EMP WHERE JOB='SALESMAN') ;
--SALESMAN �Ϻ� � �� ������� �޿��� ���� �޴� ������� �̸��� 
    --�޿��� ����(��� ����)�� ���. ��������� ���(ANY)
SELECT ENAME, SAL, JOB FROM EMP 
    WHERE SAL > ANY (SELECT SAL FROM EMP WHERE JOB='SALESMAN');
--�޿��� 3000�̸��� ��� �߿� ���� �ֱٿ� �Ի��� ����� �����ȣ�� �̸�, 
    -- ����, �Ի����� ���
SELECT EMPNO, ENAME, SAL, HIREDATE FROM EMP 
    WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP WHERE SAL<3000);
--������ ��SALESMAN���� ����� �޴� �޿��� �ּ� �޿����� ���� �޴� ������� 
 --�̸�, �޿�, ����, �μ���ȣ�� ����ϵ� �μ���ȣ�� 20���� ����� �����Ѵ�(ANY ������ �̿�)
SELECT ENAME, SAL, JOB, DEPTNO 
    FROM EMP 
    WHERE SAL > (SELECT MIN(SAL) FROM EMP 
                    WHERE JOB='SALESMAN') AND DEPTNO <> 20;
                    
-- ������ �������� �ѿ�������
-- 14. �̸��� ��T���� �ִ� ����� �ٹ��ϴ� �μ����� �ٹ��ϴ� ����� ����
    --���,�̸�,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�. �� ��� ������ ���
SELECT EMPNO, ENAME, SAL FROM EMP
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%')
    ORDER BY EMPNO;

-- 15. �μ� ��ġ�� Dallas�� ��� �������� ���� �̸�,����,�޿��� ���
SELECT ENAME, JOB, SAL FROM EMP
    WHERE DEPTNO IN (SELECT DEPTNO FROM DEPT WHERE INITCAP(LOC)='Dallas');

-- 16. King���� �����ϴ� ��� ����� �̸��� �޿��� ����ϴ� SELECT��
SELECT ENAME, SAL FROM EMP 
    WHERE MGR=(SELECT EMPNO FROM EMP WHERE INITCAP(ENAME)='King');
    
-- 17. SALES�μ� ����� �̸�,������ ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT ENAME, JOB FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME='SALES');
    -- join�� �̿��ϸ� �Ʒ��� ���� -- 
SELECT ENAME, JOB FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND DNAME='SALES';

-- 18. ��� ���̺����� ������ �μ� 30�� ���� ���޺��� ���� ����� ���
SELECT * FROM EMP 
    WHERE SAL>(SELECT MIN(SAL)  FROM EMP WHERE DEPTNO=30);

-- 19. �μ� 10���� �μ� 30�� ����� ���� ������ �ð� �ִ� ����� �̸�,������ ���
SELECT ENAME, JOB FROM EMP 
    WHERE DEPTNO=10 AND 
    JOB IN (SELECT JOB FROM EMP WHERE DEPTNO=30);

-- 20. ��� ���̺����� FORD�� ������ ���޵� ���� ����� ��� ������ ���
SELECT * FROM EMP 
    WHERE (JOB, SAL) = (SELECT JOB, SAL FROM EMP WHERE ENAME='FORD') AND ENAME != 'FORD';

-- 21. �̸��� JONES�� ������ JOB�� ���ų� 
    --������ FORD ���� �̻��� ����� ������ �̸�,����,�μ���ȣ,�޿��� ����ϴ� SELECT���� �ۼ�.
    -- ��, ������ ���ĺ� ��, ������ ���� ������ ����Ͽ���.
SELECT ENAME JOB, DEPTNO, SAL FROM EMP
    WHERE JOB=(SELECT JOB FROM EMP WHERE ENAME='JONES') OR
          SAL>=(SELECT SAL FROM EMP WHERE ENAME='FORD')
    ORDER BY JOB, SAL DESC;
-- 22. ��� ���̺����� SCOTT �Ǵ� WARD�� ������ ���� ����� ������ �̸�,����,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT ENAME, JOB, SAL FROM EMP
    WHERE SAL IN (SELECT SAL FROM EMP WHERE ENAME='SCOTT' OR ENAME='WARD');
-- 23. ��� ���̺����� CHICAGO���� �ٹ��ϴ� ����� ���� ������ �ϴ� ������� �̸�,������ ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT ENAME, JOB FROM EMP
    WHERE JOB IN (SELECT JOB FROM EMP E, DEPT D 
                    WHERE E.DEPTNO=D.DEPTNO AND LOC='CHICAGO');
-- 24. ��� ���̺����� �μ����� ������ ��� ���޺��� ���� ����� �����ȣ,�̸�,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT EMPNO, ENAME, SAL FROM EMP E
    WHERE SAL>(SELECT AVG(SAL) FROM EMP WHERE DEPTNO=E.DEPTNO);
-- 25. ��� ���̺����� �������� ������ ��� ���޺��� ���� ����� �μ���ȣ,�̸�,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT DEPTNO, ENAME, SAL FROM EMP E
    WHERE SAL>(SELECT AVG(SAL) FROM EMP WHERE JOB=E.JOB);
-- 26 ��� ���̺����� ��� �� �� �̻����κ��� ������ ���� �� �ִ� ����� ����,�̸�,�����ȣ,�μ���ȣ�� ���(��, �μ���ȣ ������ �������� ����)
SELECT JOB, ENAME, EMPNO, DEPTNO FROM EMP
    WHERE EMPNO IN(SELECT MGR FROM EMP)
    ORDER BY DEPTNO;
SELECT JOB, ENAME, EMPNO, DEPTNO FROM EMP M
    WHERE EXISTS(SELECT EMPNO FROM EMP WHERE M.EMPNO=MGR);
-- 27. ��� ���̺����� ���� ����� �����ȣ, �̸�, ����, �μ���ȣ�� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT JOB, ENAME, EMPNO, DEPTNO FROM EMP M
    WHERE NOT EXISTS(SELECT EMPNO FROM EMP WHERE M.EMPNO=MGR);
    