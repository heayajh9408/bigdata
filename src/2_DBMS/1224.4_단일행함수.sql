-- [IV] 단일행함수
-- 함수 = 단일행함수 + 그룹함수
SELECT HIREDATE, TO_CHAR(HIREDATE,'YY"년"MM"월"DD"일"') FROM EMP;
SELECT ENAME, INITCAP(ENAME) FROM EMP; -- 단일행 함수
SELECT SUM(SAL) FROM EMP; -- 그룹함수
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY DEPTNO; --그룹함수
-- EX. 숫자함수, 문자함수, 날짜함수, 형변환함수, NVL(), DECODE, ETC...
-- (1) 숫자함수
DESC DUAL; -- 오라클에서 제공하는 1행1열짜리 DUMMY TABLE
SELECT ABS(-9) FROM DUAL; -- 절대값
SELECT FLOOR(34.5678) FROM DUAL; -- 소수점에서 내림
SELECT FLOOR(34.5678*10)/10 FROM DUAL; -- 소수점 한자리에서 내림
SELECT TRUNC(34.5678) FROM DUAL; -- 소수점에서 내림
SELECT TRUNC(34.5678,1) FROM DUAL; -- 소수점 한자리에서 내림
SELECT TRUNC(34.5678,-1) FROM DUAL; -- 일의 자리에서 내림
-- emp 테이블에서 이름, 급여(십의 자리에서 내림)
SELECT ENAME, TRUNC(SAL, -2) FROM EMP;
SELECT CEIL(34.5678) FROM DUAL; -- 소수점에서 올림
SELECT ROUND(34.5678) FROM DUAL; -- 소수점에서 반올림
SELECT ROUND(34.5678, 1) FROM DUAL; -- 소수점 한자리에서 반올림
SELECT ROUND(34.5678, -1) FROM DUAL;-- 일의 자리에서 반올림

SELECT FLOOR(10/4) FROM DUAL;
SELECT MOD(9, 2) FROM DUAL; -- 나머지 연산
SELECT MOD('9',2) FROM DUAL; -- 9/2의 나머지
-- 홀수달에 입사한 직원들의 모든 필드를 출력
SELECT * FROM EMP WHERE MOD(TO_CHAR(HIREDATE, 'MM'),2)=1;

-- (2) 문자관련함수
SELECT UPPER('abcABC') FROM DUAL;
SELECT LOWER('abcABC') FROM DUAL;
SELECT INITCAP('abcABC') FROM DUAL;
-- JOB이 MANAGER인 직원의 모든 필드
SELECT * FROM EMP WHERE UPPER(JOB) = 'MANAGER';
SELECT EMPNO, INITCAP(ENAME) FROM EMP;
-- 문자 연결
SELECT 'AB'||'CD'||'EF'||'GH' FROM DUAL;
SELECT CONCAT(CONCAT('AB','CD'),CONCAT('EF','GH')) FROM DUAL;
-- xxx는 xx다(이름은 JOB이다)
SELECT ENAME||'은 '||JOB||'이다' FROM EMP;
SELECT CONCAT(CONCAT(ENAME,'은 '), CONCAT(JOB, '이다')) FROM EMP;
-- SUBSTR(STR, 시작위치, 문자갯수) 첫번째 위치가 1
-- SUBSTRB(STR, 시작위치, 문자바이트수)
SELECT SUBSTR('WELCOM TO ORACLE', 3, 2) FROM DUAL;-- 3번째 부터 2문자
SELECT SUBSTRB('WELCOM TO ORACLE', 3, 2) FROM DUAL; --3번째부터 2BYTE
SELECT SUBSTR('데이터베이스',4,3) FROM DUAL; -- 4번째부터 3문자
SELECT SUBSTRB('데이터베이스',4,3) FROM DUAL; -- 4번째BYTE부터 3BYTE
-- 영어는 한문자가 1BYTE, 한글 한문자가 3BYTE
-- 9월에 입사한 사원의 모든 필드 81/01/01
SELECT * FROM EMP WHERE SUBSTR(HIREDATE, 4,2)='09';
SELECT SUBSTR('02-716-9999',-4,4) FROM DUAL;
-- 9일에 입사한 사원의 모든 필드 
SELECT * FROM EMP WHERE SUBSTR(HIREDATE, -2,2)='09';

SELECT LENGTH('ABCD') FROM DUAL; -- 문자 갯수 : 4
SELECT LENGTHB('ABCD') FROM DUAL; -- 문자BYTE 수 : 4
SELECT LENGTH('오라클') FROM DUAL; -- 문자갯수 : 3
SELECT LENGTHB('오라클') FROM DUAL; -- 문자갯수 : 3
-- INSTR(str, 찾을글자) ; str에서 찾을글자의 위치(첫번째1). 없으면 0
-- INSTR(str, 찾을글자,시작위치) 
--       ; str에서 시작위치부터 찾아서 찾을글자의 위치(첫번째1). 없으면 0
SELECT INSTR('ABCABC', 'B') FROM DUAL;     -- 2
SELECT INSTR('ABCABC', 'B', 3) FROM DUAL;  -- 5
-- 9월에 입사한 사원(INSTR이용)
SELECT * FROM EMP WHERE INSTR(HIREDATE, '09')=4;
-- 9일에 입사한 사원(INSTR이용) 81/12/09
SELECT * FROM EMP WHERE INSTR(HIREDATE, '09')=7;
-- LPAD(문자, 자리수, '*') 문자를 자리수만큼 확보하고 왼쪽 빈자리엔 *
SELECT LPAD('ORACLE', 20, '#') FROM DUAL;
SELECT RPAD('ORACLE', 20, '*') FROM DUAL;
SELECT ENAME, LPAD(SAL, 6, '*') FROM EMP;
-- 사번, S****(이름은 앞한문자만 출력하고 나머지는 *) 출력
SELECT EMPNO, RPAD(SUBSTR(ENAME, 1,2),LENGTH(ENAME),'*' ) NAME
    FROM EMP;
-- 7369(사번), S****(이름) 80/12/**(입사일) 출력
SELECT EMPNO, RPAD(SUBSTR(ENAME, 1, 1), LENGTH(ENAME), '*') NAME,
    RPAD(SUBSTR(HIREDATE, 1, 6),LENGTH(HIREDATE),'*') HIRE
    FROM EMP;
-- 7369(사번), ****H(이름) 80/12/**(입사일) 출력
SELECT EMPNO, LPAD(SUBSTR(ENAME, -1,1), LENGTH(ENAME), '*') NAME,
    RPAD(SUBSTR(HIREDATE, 1, 6),LENGTH(HIREDATE),'*') HIRE
    FROM EMP;
-- 이름의 세번째 자리가 R인 사원 출력(INSTR, SUBSTR, LIKE)
SELECT * FROM EMP WHERE ENAME LIKE '__R%';
SELECT * FROM EMP WHERE INSTR(ENAME, 'R')=3;
SELECT * FROM EMP WHERE SUBSTR(ENAME, 3, 1) = 'R';
SELECT TRIM('    ORCALE DB    ') FROM DUAL;
SELECT LTRIM('    ORCALE DB    ') FROM DUAL;
SELECT RTRIM('    ORCALE DB    ') FROM DUAL;
SELECT REPLACE(ENAME, 'A','XX') FROM EMP;

-- (3) 날짜 관련 예약어, 함수
SELECT SYSDATE FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YY-MM-DD HH24:MI:SS"초"') FROM DUAL;
SELECT SYSDATE-1 어제, SYSDATE 지금, SYSDATE+1 내일 FROM DUAL;
-- 14일 후
SELECT SYSDATE+14 FROM DUAL;
-- 이름, 입사일, 근무일자 출력
SELECT ENAME, HIREDATE, FLOOR(SYSDATE-HIREDATE) 근무일자 FROM EMP;
SELECT ENAME, HIREDATE, TRUNC(SYSDATE-HIREDATE) 근무일자 FROM EMP;
-- 이름, 입사일, 근무주수, 근무년수 출력
SELECT ENAME, HIREDATE, FLOOR((SYSDATE-HIREDATE)/7) 근무주수,
        FLOOR((SYSDATE-HIREDATE)/365) 근무년수 
    FROM EMP;
-- MONTHS_BETWEEN() 특정한 두 시점 사이의 개월수
-- 이름, 입사일, 근무월수
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE))
    FROM EMP;
-- ADD_MONTHS(특정날짜, 개월수) 특정한 날짜로부터 몇개월 후의 시점
-- 이름, 입사일, 수습기간만료일(수습기간은 6개월)
SELECT ENAME, HIREDATE, ADD_MONTHS(HIREDATE, 6) FROM EMP;
-- NEXT_DAY(특정날짜, '수') 특정날짜로부터 처음 도래하는 수요일
SELECT NEXT_DAY(SYSDATE, '토') FROM DUAL;
-- LAST_DAY(특정날짜) ; 특정날짜인 달의 말일
-- 이름, 입사일, 월급날(월급은 말일)
SELECT ENAME, HIREDATE, LAST_DAY(HIREDATE) FROM EMP;
-- ROUND;날짜반올림, TRUNC;날짜버림
SELECT ROUND(SYSDATE-30, 'YEAR') FROM DUAL; -- 결과 가까운 1월1일
SELECT ROUND(SYSDATE-30, 'MONTH') FROM DUAL; -- 결과 가까운 1일
SELECT ROUND(SYSDATE, 'DAY') FROM DUAL;   -- 결과 가까운 일요일
SELECT ROUND(SYSDATE) FROM DUAL;         -- 결과 가까운 0시
-- ROUND;날짜반올림, TRUNC;날짜버림
SELECT TRUNC(SYSDATE-30, 'YEAR') FROM DUAL; -- 결과 지난 1월1일
SELECT TRUNC(SYSDATE-30, 'MONTH') FROM DUAL; -- 결과 지난 1일
SELECT TRUNC(SYSDATE, 'DAY') FROM DUAL;   -- 결과 지난 일요일
SELECT TRUNC(SYSDATE) FROM DUAL;          -- 결과 지난 0시
-- ex1. 이름, 입사일, 입사일달의 1일
SELECT ENAME, HIREDATE, TRUNC(HIREDATE, 'MONTH') FROM EMP;
-- ex2. 이름, 입사일, 월급날(24일)
SELECT ENAME, HIREDATE, ROUND(HIREDATE-8, 'MONTH')+23
    FROM EMP;
-- ex3. 이름, 입사일, SAL(월급), 이때까지 받은 월급합
SELECT ENAME, HIREDATE, SAL, 
    SAL*TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) FROM EMP;
-- ex4. 이름, 입사일 SAL, COMM, 이때까지 받은 연봉(SAL*12+COMM)
SELECT ENAME, HIREDATE, SAL, COMM,
    SAL*TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE))+NVL(COMM,0)*TRUNC((SYSDATE-HIREDATE)/365)
    FROM EMP;

-- (4) 형변환함수
-- TO_CHAR(날짜, 패턴) ; 날짜값를 패턴에 맞게 문자형로 변환
    -- YY(년도) MM(월) MON(월이름) DD(일) DY(요일)
    -- HH24(0~23시) AM(오전/오후) HH(0~11시) MI(분) SS(초)
SELECT ENAME, TO_CHAR(HIREDATE, 'YYYY"년"MM"월"DD"일"DY"요일"') FROM EMP;
SELECT TO_CHAR(SYSDATE, 'YY"년"MON DD"일" AM HH"시"MI"분"SS"초"')
    FROM DUAL;

-- TO_CHAR(숫자, 패턴) ; 숫자값을 패턴에 맞게 문자형로 변환
    -- 패턴내 0 ; 자릿수. 자릿수가 맞지 않으면 0으로 채움
    -- 패턴내 9 ; 자릿수. 자릿수가 맞지 않으면 채우지 않음(자바에서는 #)
    -- 패턴내 $ ; 통화단위 $가 숫자앞에 붙음
    -- 패턴내 L ; 지역통화단위가 숫자앞에 붙음
SELECT ENAME, TO_CHAR(SAL, 'L999,999') SAL FROM EMP;
SELECT ENAME, TO_CHAR(SAL, '$999,999') SAL FROM EMP;
SELECT ENAME, TO_CHAR(SAL, '$000,000') SAL FROM EMP;

-- TO_DATE(문자, 패턴) ; '81/01/01'문자를 패턴에 맞게 날짜형으로 변환
-- 81/5/1 ~ 83/5/1 사이에 입사한 직원 출력
SELECT * FROM EMP
    WHERE HIREDATE BETWEEN '81/05/01' AND '83/05/01';
SELECT * FROM EMP
    WHERE HIREDATE BETWEEN TO_DATE('19810501','YYYYMMDD')
                    AND TO_DATE('19830501','YYYYMMDD');
-- 2020년11월30일부터 현재까지 날짜수를 출력(시스템의 날짜형 포맷을 모른다)
SELECT SYSDATE-TO_DATE('20201130','YYYYMMDD') FROM DUAL;
SELECT CEIL(SYSDATE-TO_DATE('20201130','YYYYMMDD')) FROM DUAL;--29
SELECT TRUNC(SYSDATE-TO_DATE('20201130','YYYYMMDD')) FROM DUAL;--28

-- TO_NUMBER(문자, 패턴);문자를 패턴에 맞게 숫자형으로 변환
SELECT TO_NUMBER('1,000', '9,999') FROM DUAL;
SELECT TO_NUMBER('1,000','9,999')*1.1 FROM DUAL;

-- (5) NULL관련함수 ; NVL(널일 수도 있는 데이터, 널이면대신할 값)
                     -- 매개변수 2개는 타입일치
-- 사원이름, 직속상사의 이름(직속상사가 없으면 CEO로 출력)
SELECT W.ENAME, NVL(M.ENAME, 'CEO')
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO(+);
-- 사원이름, 직속상사의 사번(직속상사가 없으면 CEO로 출력)
SELECT ENAME, NVL(TO_CHAR(MGR),'CEO') MRG FROM EMP;

-- (6) DECODE(데이터, 값1, 결과1, 값2, 결과2, ..., 값N, 결과N, 그외결과)
-- 이름, 부서번호, 부서이름
SELECT ENAME, D.DEPTNO, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO;
SELECT ENAME, DEPTNO,
    DECODE(DEPTNO, 10, 'ACCOUNTING', 20,'RESEARCH', 30, 'SALES',
                   40, 'OPERATIONS', 'ETC') AS "DNAME"
    FROM EMP;
SELECT ENAME, DEPTNO,
    CASE WHEN DEPTNO=10 THEN 'ACCOUNTIN'
         WHEN DEPTNO=20 THEN 'RESEARCH'
         WHEN DEPTNO=30 THEN 'SALES'
         WHEN DEPTNO=40 THEN 'OPERATIONS'
         ELSE 'ETC'
    END AS "DNAME"
    FROM EMP;
SELECT ENAME, DEPTNO,
    CASE DEPTNO WHEN 10 THEN 'ACCOUNTIN'
                WHEN 20 THEN 'RESEARCH'
                WHEN 30 THEN 'SALES'
                WHEN 40 THEN 'OPERATIONS'
         ELSE 'ETC'
    END AS "DNAME"
    FROM EMP;
-- 이름, 급여, 인상예정급여
    -- JOB에 따라 'ANALYST' 10%인상, 'MANAGER'면 20%인상
            -- 'PRESIDENT'면 30%인상 'SALESMAN'면 40%인상
            -- 'CLERK'은 인상제외
SELECT ENAME, SAL 현급여, 
    DECODE(JOB, 'ANALYST', SAL*1.1, 'MANAGER', SAL*1.2,
        'PRESIDENT', SAL*1.3, 'SALESMAN', SAL*1.4, SAL) 인상급여
    FROM EMP;
SELECT ENAME, SAL 현급여,
    CASE WHEN JOB='ANALYST' THEN SAL*1.1
         WHEN JOB='MANAGER' THEN SAL*1.2
         WHEN JOB='PRESIDENT' THEN SAL*1.3
         WHEN JOB='SALESMAN' THEN SAL*1.4
        ELSE SAL
    END 인상급여
    FROM EMP;
SELECT ENAME, SAL 현급여,
    CASE JOB WHEN 'ANALYST' THEN SAL*1.1
         WHEN 'MANAGER' THEN SAL*1.2
         WHEN 'PRESIDENT' THEN SAL*1.3
         WHEN 'SALESMAN' THEN SAL*1.4
        ELSE SAL
    END 인상급여
    FROM EMP;
-- (7) 그외 EXTRACT, 레벨별 출력
SELECT EXTRACT(YEAR FROM HIREDATE) YEAR FROM EMP;
SELECT TO_CHAR(HIREDATE, 'YYYY') YEAR FROM EMP;
SELECT EXTRACT(MONTH FROM HIREDATE) MONTH FROM EMP;
SELECT TO_CHAR(HIREDATE, 'MM') MONTH FROM EMP;
-- LEVEL, START WITH(최상위레벨의조건), CONNECT BY PRIOR(레벨들 연결조건)
SELECT LEVEL, LPAD(' ', LEVEL*2)||ENAME, MGR FROM EMP
    START WITH MGR IS NULL
    CONNECT BY PRIOR EMPNO=MGR;
-- <총 연습문제>
-- 1. 현재 날짜를 출력하고 TITLE에 “Current Date”로 출력하는 SELECT 문장을 기술하시오.
SELECT SYSDATE "Current Date" FROM DUAL;
-- 2. EMP 테이블에서 현재 급여에 15%가 증가된 급여를 계산하여,
-- 사원번호,이름,업무,급여,증가된 급여(New Salary),증가액(Increase)를 출력하는 SELECT 문장
SELECT EMPNO, ENAME, JOB, SAL, SAL*1.15 "New Salary", (SAL*1.15-SAL) "Increase" FROM EMP;
--3. 이름, 입사일, 입사일로부터 6개월 후 돌아오는 월요일 구하여 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, HIREDATE, NEXT_DAY(ADD_MONTHS(HIREDATE,6),'월') "6개월 후 월요일" FROM EMP;
--4. 이름, 입사일, 입사일로부터 현재까지의 개월수, 급여, 입사일부터 현재까지의 받은 급여의 총계를 출력
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE,HIREDATE)), 
       SAL, ROUND(SAL*MONTHS_BETWEEN(SYSDATE,HIREDATE),2) FROM EMP;
--5. 모든 사원의 이름과 급여(15자리로 출력 좌측의 빈 곳은 “*”로 대치)를 출력
SELECT ENAME, LPAD(SAL,15,'*') FROM EMP;
--6. 모든 사원의 정보를 이름,업무,입사일,입사한 요일을 출력하는 SELECT 문장을 기술하시오
SELECT ENAME, JOB, HIREDATE, TO_CHAR(HIREDATE, 'DY"요일') FROM EMP;
--7. 이름의 길이가 6자 이상인 사원의 정보를 이름,이름의 글자수,업무를 출력
SELECT ENAME, LENGTH(ENAME), JOB FROM EMP WHERE LENGTH(ENAME)>=6;
--8. 모든 사원의 정보를 이름, 업무, 급여, 보너스, 급여+보너스를 출력
SELECT ENAME, JOB, SAL 급여, NVL(COMM,0) 보너스, SAL+NVL(COMM,0) "급여+보너스" FROM EMP;
-- 9.사원 테이블의 사원명에서 2번째 문자부터 3개의 문자를 추출하시오. 
SELECT SUBSTR(ENAME,2,3) FROM EMP;
--10. 사원 테이블에서 입사일이 12월인 사원의 사번, 사원명, 입사일을 검색하시오. 
--  시스템에 따라 DATEFORMAT 다를 수 있으므로 아래의 방법도 알아보자
SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE TO_CHAR(HIREDATE,'MM')='12';
--11. 다음과 같은 결과를 검색할 수 있는 SQL 문장을 작성하시오
--EMPNO		ENAME		급여
--7369		       SMITH		*******800
--7499		       ALLEN		******1600
--7521		       WARD		******1250
--……. 
SELECT EMPNO, ENAME, LPAD(SAL,10,'*') FROM EMP;
-- 12. 다음과 같은 결과를 검색할 수 있는 SQL 문장을 작성하시오
-- EMPNO	 ENAME 	입사일
-- 7369	  SMITH		1980-12-17
-- ….
SELECT EMPNO, ENAME, TO_CHAR(HIREDATE,'YYYY-MM-DD') FROM EMP;
--13. 사원 테이블에서 부서 번호가 20인 사원의 사번, 이름, 직무, 급여를 출력하시오.
    --(급여는 앞에 $를 삽입하고3자리마다 ,를 출력한다)
SELECT EMPNO, ENAME, JOB, TO_CHAR(SAL, '$999,999') 급여 FROM EMP;
-- 14. 사원 테이블에서 급여에 따라 사번, 이름, 급여, 등급을 검색하는 SQL 문장을 작성 하시 오.
-- 급여가 0~1000 E / 1001~2000 D / 2001~3000 C / 3001~4000 B / 4001~5000 A
SELECT EMPNO, ENAME, SAL, CASE WHEN SAL BETWEEN    0 AND 1000 THEN 'E'
                               WHEN SAL BETWEEN 1001 AND 2000 THEN 'D'
                               WHEN SAL BETWEEN 2001 AND 3000 THEN 'C'
                               WHEN SAL BETWEEN 3001 AND 4000 THEN 'B'
                               WHEN SAL BETWEEN 4001 AND 5000 THEN 'A'
                          END  등급 
                          FROM EMP;



