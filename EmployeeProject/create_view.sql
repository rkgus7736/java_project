CREATE UNIQUE INDEX PRODUCT_IDX ON PRODUCT(PNAME);

ALTER INDEX PRODUCT_IDX REBUILD;

CREATE VIEW NON_BONUS_EMPLOYEE AS
select a.emp_no, a.name, a.position, a.department, a.salary from employee a, emp_bonus b
where b.emp_no(+) = a.emp_no and b.bonus is null order by emp_no;

DROP VIEW NON_BONUS_EMPLOYEE;

CREATE SEQUENCE BOARD_NO
INCREMENT BY 1
START WITH 1
MINVALUE 1
MAXVALUE 10 | NOMAXVALUE
NOCYCLE;

SELECT BOARD_NO.NEXTVAL FROM DUAL;

DROP SEQUENCE BOARD_NO;

select board_no.nextVAL from dual;
select board_no.CURRVAL from dual;
select rowid, name from employee;