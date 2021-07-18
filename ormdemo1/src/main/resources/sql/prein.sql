---
CREATE TABLE `sys_role` (
                            `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
                            `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
                            `remark` varchar(100) DEFAULT NULL COMMENT '备注',
                            `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
                            `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                            PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='角色'

---
INSERT INTO sys_role (role_id, role_name, remark, dept_id, create_time) VALUES (1, '超级管理员', '最高权限', 34, '2018-07-31 19:27:42');
INSERT INTO sys_role (role_id, role_name, remark, dept_id, create_time) VALUES (2, '管理员', '权限比较少', 9, '2018-07-31 19:28:58');
INSERT INTO sys_role (role_id, role_name, remark, dept_id, create_time) VALUES (3, 'IT经理', 'IT用户使用', 34, '2018-12-30 22:42:15');
