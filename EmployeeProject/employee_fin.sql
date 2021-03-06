--------------------------------------------------------
--  ������ ������ - �ݿ���-10��-30-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table EMPLOYEE
--------------------------------------------------------

  CREATE TABLE "SCOTT"."EMPLOYEE" 
   (	"EMP_NO" NUMBER, 
	"NAME" VARCHAR2(20 BYTE), 
	"POSITION" VARCHAR2(30 BYTE), 
	"DEPARTMENT" VARCHAR2(50 BYTE), 
	"SALARY" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into SCOTT.EMPLOYEE
SET DEFINE OFF;
Insert into SCOTT.EMPLOYEE (EMP_NO,NAME,POSITION,DEPARTMENT,SALARY) values (1,'������','����','�λ���',4800);
Insert into SCOTT.EMPLOYEE (EMP_NO,NAME,POSITION,DEPARTMENT,SALARY) values (2,'�赿��','�븮','�λ���',2700);
Insert into SCOTT.EMPLOYEE (EMP_NO,NAME,POSITION,DEPARTMENT,SALARY) values (3,'��ÿ�','����','�ѹ���',4500);
Insert into SCOTT.EMPLOYEE (EMP_NO,NAME,POSITION,DEPARTMENT,SALARY) values (4,'���ط�','�븮','�λ���',3200);
Insert into SCOTT.EMPLOYEE (EMP_NO,NAME,POSITION,DEPARTMENT,SALARY) values (5,'�ڼͿ�','�븮','�ѹ���',3400);
Insert into SCOTT.EMPLOYEE (EMP_NO,NAME,POSITION,DEPARTMENT,SALARY) values (6,'�ں���','����','�ѹ���',6400);
Insert into SCOTT.EMPLOYEE (EMP_NO,NAME,POSITION,DEPARTMENT,SALARY) values (7,'������','����','�濵������',4400);
Insert into SCOTT.EMPLOYEE (EMP_NO,NAME,POSITION,DEPARTMENT,SALARY) values (8,'���ο�','����','�濵������',5100);
Insert into SCOTT.EMPLOYEE (EMP_NO,NAME,POSITION,DEPARTMENT,SALARY) values (9,'�̵���','�븮','������',2800);
Insert into SCOTT.EMPLOYEE (EMP_NO,NAME,POSITION,DEPARTMENT,SALARY) values (10,'�̿���','����','������',3200);
Insert into SCOTT.EMPLOYEE (EMP_NO,NAME,POSITION,DEPARTMENT,SALARY) values (11,'������','����','������',2400);
Insert into SCOTT.EMPLOYEE (EMP_NO,NAME,POSITION,DEPARTMENT,SALARY) values (12,'�����','����','������',4500);
Insert into SCOTT.EMPLOYEE (EMP_NO,NAME,POSITION,DEPARTMENT,SALARY) values (13,'������','���','������',2400);
Insert into SCOTT.EMPLOYEE (EMP_NO,NAME,POSITION,DEPARTMENT,SALARY) values (14,'������','���','�濵������',2200);
Insert into SCOTT.EMPLOYEE (EMP_NO,NAME,POSITION,DEPARTMENT,SALARY) values (15,'�ֽ¼�','����','������',2600);
Insert into SCOTT.EMPLOYEE (EMP_NO,NAME,POSITION,DEPARTMENT,SALARY) values (16,'�ѻ��','����','������',4300);
Insert into SCOTT.EMPLOYEE (EMP_NO,NAME,POSITION,DEPARTMENT,SALARY) values (17,'������','���','������',2000);
Insert into SCOTT.EMPLOYEE (EMP_NO,NAME,POSITION,DEPARTMENT,SALARY) values (18,'����','����','������',2300);
Insert into SCOTT.EMPLOYEE (EMP_NO,NAME,POSITION,DEPARTMENT,SALARY) values (19,'�����','���','�λ���',2200);
Insert into SCOTT.EMPLOYEE (EMP_NO,NAME,POSITION,DEPARTMENT,SALARY) values (20,'������','����','�λ���',2500);
Insert into SCOTT.EMPLOYEE (EMP_NO,NAME,POSITION,DEPARTMENT,SALARY) values (21,'������','����','������',3600);
Insert into SCOTT.EMPLOYEE (EMP_NO,NAME,POSITION,DEPARTMENT,SALARY) values (22,'�弼��','���','�濵������',2600);
Insert into SCOTT.EMPLOYEE (EMP_NO,NAME,POSITION,DEPARTMENT,SALARY) values (23,'������','����','������',2300);
Insert into SCOTT.EMPLOYEE (EMP_NO,NAME,POSITION,DEPARTMENT,SALARY) values (24,'������','���','������',2000);
Insert into SCOTT.EMPLOYEE (EMP_NO,NAME,POSITION,DEPARTMENT,SALARY) values (25,'������','����','������',2300);
Insert into SCOTT.EMPLOYEE (EMP_NO,NAME,POSITION,DEPARTMENT,SALARY) values (26,'������','���','������',2200);
Insert into SCOTT.EMPLOYEE (EMP_NO,NAME,POSITION,DEPARTMENT,SALARY) values (27,'������','����','�λ���',2500);
Insert into SCOTT.EMPLOYEE (EMP_NO,NAME,POSITION,DEPARTMENT,SALARY) values (33,'ȫ�浿','����','�λ���',5000);
Insert into SCOTT.EMPLOYEE (EMP_NO,NAME,POSITION,DEPARTMENT,SALARY) values (45,'�载��','�븮','�ѹ���',3200);
--------------------------------------------------------
--  DDL for Index SYS_C007042
--------------------------------------------------------

  CREATE UNIQUE INDEX "SCOTT"."SYS_C007042" ON "SCOTT"."EMPLOYEE" ("EMP_NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table EMPLOYEE
--------------------------------------------------------

  ALTER TABLE "SCOTT"."EMPLOYEE" ADD PRIMARY KEY ("EMP_NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
