select mod(5,3) from dual;
--2�� 10��
select power(2,10) from dual; 
--��¥ ��ȸ
select sysdate from dual;
--��¥ ���� ����
alter session set NLS_DATE_FORMAT='YYYY-MM-DD HH24:MI:SS';
alter session set NLS_DATE_FORMAT='YY/MM/DD';

select round(sysdate), trunc(sysdate) from dual;

select abs(MONTHS_BETWEEN(SYSDATE,'20/12/31')) from dual;
select MONTHS_BETWEEN('20/12/31',sysdate) from dual;

--��� ��
select add_months(sysdate,2) from dual;

select NEXT_DAY(SYSDATE, '��') from dual;
select NEXT_DAY(SYSDATE, 'ȭ') from dual;

select LAST_DAY(SYSDATE+3) from dual;
select sysdate + 3 from dual;

select 2+2, 2 + '2' from dual;
select 10 + to_number('120'), 10 + '120' from dual;
select to_char(235235) || '����' from dual;
select 235235 || '����' from dual;
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
select name, position, decode(position,'����','�ǰ���� �����') from employee;
select name, position, decode(position,'����','�ǰ���� �����','���ƴ�')
from employee;

select name, position, 
decode(position,'����','�ǰ���� �����','����','���������', '���ƴ�')
from employee;

select name, position, 
decode(position,'����','�ǰ���� �����','����','���������','����','���������', '���ƴ�') as �λ��������
from employee;

select position, sum(salary) as �������� from employee
group by position;

select position, round(AVG(salary),0) as ������� from employee
group by position;

select position, to_char(AVG(salary),'9999') as ������� from employee
group by position;

select department, count(*) from employee
where position like '���'
group by department ;

select department, max(salary) from employee
group by department;

select department, min(salary) from employee
group by department;
--ǥ������
select department, STDDEV(salary) from employee
group by department;

--�л�
select department, variance(salary) from employee
group by department HAVING count(*) >= 4;

--��� ���̺��� ������ �븮, ����� �������
--�� ������ �ִ밪�� �ּҰ��� ��ȸ�ϴ� ������ �ۼ�
select position, max(salary), min(salary) from employee
where position like '�븮' or position like '���' 
GROUP BY position;

select position, max(salary), min(salary) from employee
GROUP BY position 
having position like '�븮' or position like '���' ;

select * from employee where position in('����','����');

select department, avg(salary) from employee
GROUP BY department HAVING avg(salary) >= 3000;

--������ �ο���
select substr(name,1,1), count(*) from employee
GROUP BY substr(name,1,1);





