CREATE DATABASE testdb;

CREATE TABLE IF NOT EXISTS `t_order_0` (
    `order_id` bigint(20) NOT NULL COMMENT '订单主键',
    `user_id` bigint(20) NOT NULL COMMENT '用户主键',
    `user_address_id` bigint(20) NOT NULL COMMENT '用户地址主键',
    `order_money` double DEFAULT 0 COMMENT '订单总额',
    `order_paystate` int(12) DEFAULT 0 COMMENT '支付状态，目前有(0: 待支付,1: 支付中,2: 已支付)',
    `order_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
    `order_modify_time` timestamp COMMENT '订单最后修改时间',
    PRIMARY KEY (`order_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `t_order_1` (
    `order_id` bigint(20) NOT NULL COMMENT '订单主键',
    `user_id` bigint(20) NOT NULL COMMENT '用户主键',
    `user_address_id` bigint(20) NOT NULL COMMENT '用户地址主键',
    `order_money` double DEFAULT 0 COMMENT '订单总额',
    `order_paystate` int(12) DEFAULT 0 COMMENT '支付状态，目前有(0: 待支付,1: 支付中,2: 已支付)',
    `order_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
    `order_modify_time` timestamp COMMENT '订单最后修改时间',
    PRIMARY KEY (`order_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `t_order_2` (
    `order_id` bigint(20) NOT NULL COMMENT '订单主键',
    `user_id` bigint(20) NOT NULL COMMENT '用户主键',
    `user_address_id` bigint(20) NOT NULL COMMENT '用户地址主键',
    `order_money` double DEFAULT 0 COMMENT '订单总额',
    `order_paystate` int(12) DEFAULT 0 COMMENT '支付状态，目前有(0: 待支付,1: 支付中,2: 已支付)',
    `order_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
    `order_modify_time` timestamp COMMENT '订单最后修改时间',
    PRIMARY KEY (`order_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `t_order_3` (
    `order_id` bigint(20) NOT NULL COMMENT '订单主键',
    `user_id` bigint(20) NOT NULL COMMENT '用户主键',
    `user_address_id` bigint(20) NOT NULL COMMENT '用户地址主键',
    `order_money` double DEFAULT 0 COMMENT '订单总额',
    `order_paystate` int(12) DEFAULT 0 COMMENT '支付状态，目前有(0: 待支付,1: 支付中,2: 已支付)',
    `order_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
    `order_modify_time` timestamp COMMENT '订单最后修改时间',
    PRIMARY KEY (`order_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `t_order_4` (
    `order_id` bigint(20) NOT NULL COMMENT '订单主键',
    `user_id` bigint(20) NOT NULL COMMENT '用户主键',
    `user_address_id` bigint(20) NOT NULL COMMENT '用户地址主键',
    `order_money` double DEFAULT 0 COMMENT '订单总额',
    `order_paystate` int(12) DEFAULT 0 COMMENT '支付状态，目前有(0: 待支付,1: 支付中,2: 已支付)',
    `order_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
    `order_modify_time` timestamp COMMENT '订单最后修改时间',
    PRIMARY KEY (`order_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `t_order_5` (
    `order_id` bigint(20) NOT NULL COMMENT '订单主键',
    `user_id` bigint(20) NOT NULL COMMENT '用户主键',
    `user_address_id` bigint(20) NOT NULL COMMENT '用户地址主键',
    `order_money` double DEFAULT 0 COMMENT '订单总额',
    `order_paystate` int(12) DEFAULT 0 COMMENT '支付状态，目前有(0: 待支付,1: 支付中,2: 已支付)',
    `order_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
    `order_modify_time` timestamp COMMENT '订单最后修改时间',
    PRIMARY KEY (`order_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `t_order_6` (
    `order_id` bigint(20) NOT NULL COMMENT '订单主键',
    `user_id` bigint(20) NOT NULL COMMENT '用户主键',
    `user_address_id` bigint(20) NOT NULL COMMENT '用户地址主键',
    `order_money` double DEFAULT 0 COMMENT '订单总额',
    `order_paystate` int(12) DEFAULT 0 COMMENT '支付状态，目前有(0: 待支付,1: 支付中,2: 已支付)',
    `order_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
    `order_modify_time` timestamp COMMENT '订单最后修改时间',
    PRIMARY KEY (`order_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `t_order_7` (
    `order_id` bigint(20) NOT NULL COMMENT '订单主键',
    `user_id` bigint(20) NOT NULL COMMENT '用户主键',
    `user_address_id` bigint(20) NOT NULL COMMENT '用户地址主键',
    `order_money` double DEFAULT 0 COMMENT '订单总额',
    `order_paystate` int(12) DEFAULT 0 COMMENT '支付状态，目前有(0: 待支付,1: 支付中,2: 已支付)',
    `order_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
    `order_modify_time` timestamp COMMENT '订单最后修改时间',
    PRIMARY KEY (`order_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `t_order_8` (
    `order_id` bigint(20) NOT NULL COMMENT '订单主键',
    `user_id` bigint(20) NOT NULL COMMENT '用户主键',
    `user_address_id` bigint(20) NOT NULL COMMENT '用户地址主键',
    `order_money` double DEFAULT 0 COMMENT '订单总额',
    `order_paystate` int(12) DEFAULT 0 COMMENT '支付状态，目前有(0: 待支付,1: 支付中,2: 已支付)',
    `order_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
    `order_modify_time` timestamp COMMENT '订单最后修改时间',
    PRIMARY KEY (`order_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `t_order_9` (
    `order_id` bigint(20) NOT NULL COMMENT '订单主键',
    `user_id` bigint(20) NOT NULL COMMENT '用户主键',
    `user_address_id` bigint(20) NOT NULL COMMENT '用户地址主键',
    `order_money` double DEFAULT 0 COMMENT '订单总额',
    `order_paystate` int(12) DEFAULT 0 COMMENT '支付状态，目前有(0: 待支付,1: 支付中,2: 已支付)',
    `order_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
    `order_modify_time` timestamp COMMENT '订单最后修改时间',
    PRIMARY KEY (`order_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `t_order_10` (
    `order_id` bigint(20) NOT NULL COMMENT '订单主键',
    `user_id` bigint(20) NOT NULL COMMENT '用户主键',
    `user_address_id` bigint(20) NOT NULL COMMENT '用户地址主键',
    `order_money` double DEFAULT 0 COMMENT '订单总额',
    `order_paystate` int(12) DEFAULT 0 COMMENT '支付状态，目前有(0: 待支付,1: 支付中,2: 已支付)',
    `order_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
    `order_modify_time` timestamp COMMENT '订单最后修改时间',
    PRIMARY KEY (`order_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `t_order_11` (
    `order_id` bigint(20) NOT NULL COMMENT '订单主键',
    `user_id` bigint(20) NOT NULL COMMENT '用户主键',
    `user_address_id` bigint(20) NOT NULL COMMENT '用户地址主键',
    `order_money` double DEFAULT 0 COMMENT '订单总额',
    `order_paystate` int(12) DEFAULT 0 COMMENT '支付状态，目前有(0: 待支付,1: 支付中,2: 已支付)',
    `order_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
    `order_modify_time` timestamp COMMENT '订单最后修改时间',
    PRIMARY KEY (`order_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `t_order_12` (
    `order_id` bigint(20) NOT NULL COMMENT '订单主键',
    `user_id` bigint(20) NOT NULL COMMENT '用户主键',
    `user_address_id` bigint(20) NOT NULL COMMENT '用户地址主键',
    `order_money` double DEFAULT 0 COMMENT '订单总额',
    `order_paystate` int(12) DEFAULT 0 COMMENT '支付状态，目前有(0: 待支付,1: 支付中,2: 已支付)',
    `order_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
    `order_modify_time` timestamp COMMENT '订单最后修改时间',
    PRIMARY KEY (`order_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `t_order_13` (
    `order_id` bigint(20) NOT NULL COMMENT '订单主键',
    `user_id` bigint(20) NOT NULL COMMENT '用户主键',
    `user_address_id` bigint(20) NOT NULL COMMENT '用户地址主键',
    `order_money` double DEFAULT 0 COMMENT '订单总额',
    `order_paystate` int(12) DEFAULT 0 COMMENT '支付状态，目前有(0: 待支付,1: 支付中,2: 已支付)',
    `order_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
    `order_modify_time` timestamp COMMENT '订单最后修改时间',
    PRIMARY KEY (`order_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `t_order_14` (
    `order_id` bigint(20) NOT NULL COMMENT '订单主键',
    `user_id` bigint(20) NOT NULL COMMENT '用户主键',
    `user_address_id` bigint(20) NOT NULL COMMENT '用户地址主键',
    `order_money` double DEFAULT 0 COMMENT '订单总额',
    `order_paystate` int(12) DEFAULT 0 COMMENT '支付状态，目前有(0: 待支付,1: 支付中,2: 已支付)',
    `order_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
    `order_modify_time` timestamp COMMENT '订单最后修改时间',
    PRIMARY KEY (`order_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `t_order_15` (
    `order_id` bigint(20) NOT NULL COMMENT '订单主键',
    `user_id` bigint(20) NOT NULL COMMENT '用户主键',
    `user_address_id` bigint(20) NOT NULL COMMENT '用户地址主键',
    `order_money` double DEFAULT 0 COMMENT '订单总额',
    `order_paystate` int(12) DEFAULT 0 COMMENT '支付状态，目前有(0: 待支付,1: 支付中,2: 已支付)',
    `order_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
    `order_modify_time` timestamp COMMENT '订单最后修改时间',
    PRIMARY KEY (`order_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;