create table A(
    no number,
    txt varchar2(3));
create table B(
    no number,
    txt varchar2(3));
    
create table C(
    no number,
    txt varchar2(3));
    
insert into A values(1,'A');
insert into A values(2,'B');
insert into A values(3,'C');

insert into B values(1,'D');
insert into B values(2,'E');
insert into B values(3,'F');

insert into C values(1,'G');
insert into C values(2,'H');
insert into C values(3,'I');

SELECT a.no, b.txt
FROM A a,B b
where a.no = b.no;


CREATE TABLE EMP_BONUS(
    EMP_NO NUMBER,
    MONEY NUMBER);

--외부 조인
SELECT a.EMP_NO, a.NAME, b.MONEY FROM EMPLOYEE a, EMP_BONUS b  WHERE b.EMP_NO(+) = a.EMP_NO;
SELECT a.EMP_NO, a.NAME, b.MONEY FROM EMPLOYEE a, EMP_BONUS b  WHERE b.EMP_NO = a.EMP_NO(+);

--동일 조인
SELECT a.EMP_NO, a.NAME, b.MONEY FROM EMPLOYEE a, EMP_BONUS b  WHERE b.EMP_NO = a.EMP_NO;
SELECT a.EMP_NO, a.NAME, b.MONEY FROM EMPLOYEE a INNER JOIN EMP_BONUS b ON  b.EMP_NO = a.EMP_NO;

--자연 조인
SELECT * FROM EMPLOYEE a NATURAL JOIN EMP_BONUS b ;
--교차 조인
SELECT * FROM EMPLOYEE a CROSS JOIN EMP_BONUS b ;

