/*建立订单表*/
USE product;
DROP TABLE IF EXISTS `ORDER`;
CREATE TABLE IF NOT EXISTS `ORDER`(
  `ID` BIGINT(10) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `ORDER_CODE` VARCHAR(20) NOT NULL COMMENT '订单编号',
  `CREATE_DATE` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
  `LAST_UPDATE_DATE` DATETIME NOT NULL COMMENT '更新时间',
  `BEGIN_DATE` DATETIME DEFAULT NULL COMMENT '预计开始配送时间',
  `END_DATE` DATETIME DEFAULT NULL COMMENT '预计结束配送时间',
  `CREATOR` VARCHAR(20) DEFAULT NULL COMMENT '创建者账号',
  `CREATED_BY` VARCHAR(20) DEFAULT NULL COMMENT '创建者姓名',
  `LAST_UPDATED_BY` VARCHAR(20) DEFAULT NULL COMMENT '最后更新者姓名',
  `LAST_UPDATER` VARCHAR(20) DEFAULT NULL COMMENT '最后更新者账号',
    PRIMARY KEY (`ID`)
)ENGINE=InnoDB DEFAULT CHARSET = utf8 comment = '订单表';
DROP TRIGGER IF EXISTS `update_example_trigger`;
DELIMITER //
CREATE TRIGGER `update_example_trigger` BEFORE UPDATE ON `ORDER`
 FOR EACH ROW SET NEW.`LAST_UPDATE_DATE` = current_timestamp
//
DELIMITER ;
select version();

/*建立详情表*/
DROP TABLE IF EXISTS `DETAIL`;
CREATE TABLE IF NOT EXISTS `DETAIL`(
  `ID` BIGINT(10) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `ORDER_ID` VARCHAR(20) NOT NULL COMMENT '订单id',
  `DETAIL_CODE` VARCHAR(20) NOT NULL COMMENT '订单详情编号',
  `LAST_UPDATE_DATE` DATETIME NOT NULL COMMENT '更新时间',
  `PRODUCT_NAME` VARCHAR(100) NOT NULL COMMENT '商品名称',
  `PRODUCT_PRICE` VARCHAR(50) NOT NULL COMMENT '商品价格',
  `CREATOR` VARCHAR(20) DEFAULT NULL COMMENT '创建者账号',
  `CREATED_BY` VARCHAR(20) DEFAULT NULL COMMENT '创建者姓名',
  `LAST_UPDATED_BY` VARCHAR(20) DEFAULT NULL COMMENT '最后更新者姓名',
  `LAST_UPDATER` VARCHAR(20) DEFAULT NULL COMMENT '最后更新者账号',
    PRIMARY KEY (`ID`)
)ENGINE=InnoDB DEFAULT CHARSET = utf8 comment = '订单表';
DROP TRIGGER IF EXISTS `update_detail_trigger`;
DELIMITER //
CREATE TRIGGER `update_detail_trigger` BEFORE UPDATE ON `DETAIL`
 FOR EACH ROW SET NEW.`LAST_UPDATE_DATE` = current_timestamp
//
DELIMITER ;


//

/*说明
1.ID等字段是用反引号,不是单引号
2.创建时间与更新时间一般从两方面来进行保障,如果数据库像上面创建最好,如果不是,就在sql语句中写now()
3.id与code都是必有的,且都唯一,但是id是自增的,而code是人为设定的
  code两个作用,前台展示与作为模糊查询的条件
  关联表中会有自己的id,父表id,自己的code.注意是父表的id而非父表的code.
  id也需要返回给前台,因为查询详情时需要用id来查询
4.detail表中对应的是订单的code而不是id,因为如果是id那么就需要单独保存订单表,返回一个id再单独保存detail表,但是如果是
  code,那么就可以手动设置,然后一次保存两张表
5.如果要建立外键,那么需要两句,第一句是建表时就声明,第二句是建表后就声明
*/


