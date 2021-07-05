--- 新建数据库名为coursedb
--- 建立两张表模拟分表
CREATE TABLE course_1(
    cid BIGINT(20) PRIMARY key,
    cname VARCHAR(50) NOT NULL,
    user_id BIGINT(20) NOT NULL,
    cstatus varchar(10) NOT NULL
);


CREATE TABLE course_2(
     cid BIGINT(20) PRIMARY key,
     cname VARCHAR(50) NOT NULL,
     user_id BIGINT(20) NOT NULL,
     cstatus varchar(10) NOT NULL
);
--- 先插入一条数据试试
insert into course_1(cname,user_id,cstatus) values("xiaoming",100,1);






















