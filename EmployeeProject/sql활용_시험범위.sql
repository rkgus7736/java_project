--DDL : CREATE ALTER DROP
--TABLE
create table AAAA(
    no number primary key,
    content varchar2(30 byte),
    gender number(1),
    constraint check_gender check(gender in(0,1))
);
create table BBB(
    no number,
    txt varchar2(100 byte)
);
drop table AAAA CASCADE CONSTRAINTS;
alter table BBB add constraint FK_NO foreign key(no)
references AAAA(no);

--���� ������ ������ ���̺� ���
select * from user_tables;
--���� ������ ������ ���� ���� ���
select * from user_constraints;
--������ ����
select * from dba_tables;
--INDEX : ���̺� ������ �˻��Ҷ� ���� ȿ�������� �˻�
create index BBB_IDX_1 on BBB(no, txt);--�÷� ���� �ߺ� ����
create unique index BBB_IDX_1 on BBB(no);--�÷� ���� �ߺ� �Ұ���
drop index BBB_IDX_1;
--VIEW
create view BBB_VIEW
as select * from BBB where no < 10;
drop view BBB_VIEW;
--SEQUENCE
create sequence seq_no 
start with 1 increment by 1 
minvalue 1 maxvalue 10 cycle nocache;
--�ִ밪�� ���� ������
create sequence seq_no start with 1 minvalue 1 nomaxvalue;
drop sequence seq_no;

--DML : SELECT INSERT UPDATE DELETE
select no, txt from BBB;
select no, txt from BBB where no <= 10 and no >= 5;
select no, txt from BBB where txt like 'A';--���� A
select no, txt from BBB where txt like '%A%';--A����
--join : ��������, �ڿ�����, ��������, �ܺ�����
select * from AAA a, BBB b where a.no = b.no;--��������
select * from AAA a natural join BBB b; --�ڿ�����
select * from AAA a cross join BBB b; -- ��������
select * from AAA a, BBB b where a.no = b.no(+);--�ܺ�����
--�������� : single column single row ; single column mulit row 
--         multi column multi row
select * from AAA where no in(select no from BBB);
select * from AAAA where (NO, CONTENT) 
in(select NO, TXT from BBB WHERE NO <= 10);

--INSERT
INSERT INTO AAAA VALUES(1,'AAA',1);
INSERT INTO AAAA(NO,CONTENT,GENDER) VALUES(1,'AAA',1);
--UPDATE
UPDATE AAAA SET NO = NO + 10 WHERE NO = 1; 
--DELETE
DELETE FROM AAAA WHERE NO = 1;

--DCL : ROLLBACK, SAVEPOINT, COMMIT
SAVEPOINT FIN_01; -- �߰� ��������
ROLLBACK TO FIN_01; -- FIN_01 �߰� ���� �������� �ѹ�
ROLLBACK;--�۾������� �ѹ�
COMMIT; -- �۾����� ����





