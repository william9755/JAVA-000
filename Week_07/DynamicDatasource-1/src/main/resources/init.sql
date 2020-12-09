CREATE DATABASE testdb;

CREATE TABLE IF NOT EXISTS `t_user` (
    `id` bigint(20) NOT NULL COMMENT '用户主键',
    `username` char(50) NOT NULL COMMENT '用户名',
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;