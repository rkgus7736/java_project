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

--현재 유저가 생성한 테이블 목록
select * from user_tables;
--현재 유저가 생성한 제약 조건 목록
select * from user_constraints;
--관리자 입장
select * from dba_tables;
--INDEX : 테이블 내용을 검색할때 보다 효율적으로 검색
create index BBB_IDX_1 on BBB(no, txt);--컬럼 값이 중복 가능
create unique index BBB_IDX_1 on BBB(no);--컬럼 값이 중복 불가능
drop index BBB_IDX_1;
--VIEW
create view BBB_VIEW
as select * from BBB where no < 10;
drop view BBB_VIEW;
--SEQUENCE
create sequence seq_no 
start with 1 increment by 1 
minvalue 1 maxvalue 10 cycle nocache;
--최대값이 없는 시퀸스
create sequence seq_no start with 1 minvalue 1 nomaxvalue;
drop sequence seq_no;

--DML : SELECT INSERT UPDATE DELETE
select no, txt from BBB;
select no, txt from BBB where no <= 10 and no >= 5;
select no, txt from BBB where txt like 'A';--값이 A
select no, txt from BBB where txt like '%A%';--A포함
--join : 동등조인, 자연조인, 교차조인, 외부조인
select * from AAA a, BBB b where a.no = b.no;--동등조인
select * from AAA a natural join BBB b; --자연조인
select * from AAA a cross join BBB b; -- 교차조인
select * from AAA a, BBB b where a.no = b.no(+);--외부조인
--서브쿼리 : single column single row ; single column mulit row 
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
SAVEPOINT FIN_01; -- 중간 저장지점
ROLLBACK TO FIN_01; -- FIN_01 중간 저장 지점으로 롤백
ROLLBACK;--작업전으로 롤백
COMMIT; -- 작업내용 적용





