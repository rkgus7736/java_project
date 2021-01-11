select mod(5,3) from dual;
--2의 10승
select power(2,10) from dual; 
--날짜 조회
select sysdate from dual;
--날짜 포멧 변경
alter session set NLS_DATE_FORMAT='YYYY-MM-DD HH24:MI:SS';
alter session set NLS_DATE_FORMAT='YY/MM/DD';

select round(sysdate), trunc(sysdate) from dual;

select abs(MONTHS_BETWEEN(SYSDATE,'20/12/31')) from dual;
select MONTHS_BETWEEN('20/12/31',sysdate) from dual;

--몇개월 뒤
select add_months(sysdate,2) from dual;

select NEXT_DAY(SYSDATE, '월') from dual;
select NEXT_DAY(SYSDATE, '화') from dual;

select LAST_DAY(SYSDATE+3) from dual;
select sysdate + 3 from dual;

select 2+2, 2 + '2' from dual;
select 10 + to_number('120'), 10 + '120' from dual;
select to_char(235235) || '숫자' from dual;
select 235235 || '숫자' from dual;
select to_char(sysdate,'YYYY') from dual;
select to_char(sysdate,'RRRR') from dual;
select to_char(sysdate,'MM') from dual;
select to_char(sysdate,'DD') from dual;
select to_char(sysdate,'YYYY_MM_DD_HH24_MI_SS') from dual;
select to_char(sysdate,'MON MONTH DD DDT DAY') from dual;

select to_char(1432500,'999999999'), length(to_char(1432500,'999999999')) from dual;
select to_char(1432500), length(to_char(1432500)) from dual;
select to_char(1432500,'0999999999') from dual;
select to_char(5000000,'$99999999') from dual;
select to_char(5000000,'$0000000') from dual;
select to_char(5000000,'$0,000,000') from dual;
select trim(to_char(5000,'$999,999,999999,999,999,999,999,999')) from dual;
select length(trim(to_char(5000,'$999,999,999999,999,999,999,999,999'))) from dual;
select to_char(123.123456789,'999999.9999') from dual;
select to_char(123,'999999.9999') from dual;
select to_date('20/10/30') from dual;
select add_months(to_date('20/10/30'),2) from dual;
select TO_DATE('20/10/30 19:56:33','YY/MM/DD HH24:MI:SS') from dual;
select nvl(NULL, 100),nvl('test', 100) from dual;
select nvl2(NULL, 100,200),nvl2('test', 100,200) from dual;
select name, position, decode(position,'부장','권고사직 대상자') from employee;
select name, position, decode(position,'부장','권고사직 대상자','대상아님')
from employee;

select name, position, 
decode(position,'부장','권고사직 대상자','차장','승진대상자', '대상아님')
from employee;

select name, position, 
decode(position,'부장','권고사직 대상자','차장','승진대상자','과장','감봉대상자', '대상아님') as 인사공고대상자
from employee;

select position, sum(salary) as 연봉총합 from employee
group by position;

select position, round(AVG(salary),0) as 연봉평균 from employee
group by position;

select position, to_char(AVG(salary),'9999') as 연봉평균 from employee
group by position;

select department, count(*) from employee
where position like '사원'
group by department ;

select department, max(salary) from employee
group by department;

select department, min(salary) from employee
group by department;
--표준편차
select department, STDDEV(salary) from employee
group by department;

--분산
select department, variance(salary) from employee
group by department HAVING count(*) >= 4;

--사원 테이블에서 직급이 대리, 사원을 대상으로
--각 연봉의 최대값과 최소값을 조회하는 쿼리를 작성
select position, max(salary), min(salary) from employee
where position like '대리' or position like '사원' 
GROUP BY position;

select position, max(salary), min(salary) from employee
GROUP BY position 
having position like '대리' or position like '사원' ;

select * from employee where position in('부장','차장');

select department, avg(salary) from employee
GROUP BY department HAVING avg(salary) >= 3000;

--성씨별 인원수
select substr(name,1,1), count(*) from employee
GROUP BY substr(name,1,1);





