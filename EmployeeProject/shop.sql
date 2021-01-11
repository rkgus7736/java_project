
CREATE TABLE customer (
    customer_no    VARCHAR2(4 BYTE) NOT NULL,
    customer_name  VARCHAR2(30 BYTE) NOT NULL,
    point          NUMBER(9) default 0,
    tel            VARCHAR2(11 BYTE) NOT NULL,
    grade          NUMBER(1) default 0
);


ALTER TABLE customer ADD CONSTRAINT customer_pk PRIMARY KEY ( customer_no );

CREATE TABLE product (
    product_no       VARCHAR2(12 BYTE) NOT NULL,
    product_name     VARCHAR2(60 BYTE) NOT NULL,
    price            NUMBER(10) NOT NULL,
    ea               NUMBER(4) default 0,
    maker            VARCHAR2(60 BYTE) NOT NULL,
    expiration_date  DATE,
    kind             NUMBER(1) default 2,
    constraint kind_check check(kind in(1,2))
);

ALTER TABLE product ADD CONSTRAINT product_pk PRIMARY KEY ( product_no );

CREATE TABLE sell (
    sell_no      NUMBER(5) NOT NULL,
    ea           NUMBER(3) NOT NULL,
    sell_date    DATE default sysdate,
    customer_no  VARCHAR2(4 BYTE) NOT NULL,
    product_no   VARCHAR2(12 BYTE) NOT NULL
);

ALTER TABLE sell
    ADD CONSTRAINT sell_customer_fk FOREIGN KEY ( customer_no )
        REFERENCES customer ( customer_no );

ALTER TABLE sell
    ADD CONSTRAINT sell_product_fk FOREIGN KEY ( product_no )
        REFERENCES product ( product_no );

