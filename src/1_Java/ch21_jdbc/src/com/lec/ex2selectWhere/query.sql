SELECT * FROM DEPT WHERE DEPTNO=30;

SELECT w.EMPNO, w.ENAME, w.SAL, M.ENAME MANAGER
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO AND W.DEPTNO=30;

SELECT * FROM DEPT WHERE DNAME='SALES';

SELECT e.EMPNO, e.ENAME, e.SAL, GRADE 
    FROM EMP E, SALGRADE, DEPT D 
    WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL
        AND DNAME='SALES';

SELECT EMPNO, ENAME, SAL, GRADE
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL
        AND DEPTNO=(SELECT DEPTNO FROM DEPT WHERE DNAME='SALES'); 