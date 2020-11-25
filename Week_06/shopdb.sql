CREATE DATABASE shopdb;

USE shopdb;

-- 用户
CREATE TABLE IF NOT EXISTS `t_user` (
  `user_id` char(64) NOT NULL COMMENT '用户主键',
  `user_name` varchar(100) NOT NULL COMMENT '用户名',
  `user_phone` varchar(40) DEFAULT '' COMMENT '电话',
  `user_password` varchar(64) NOT NULL COMMENT '用户密码',
  `user_nickname` varchar(100) DEFAULT '新用户' COMMENT '用户昵称',
  `user_email` varchar(40) DEFAULT '' COMMENT '邮箱',
  `user_img` varchar(300) DEFAULT '' COMMENT '头像路径',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 用户地址
CREATE TABLE IF NOT EXISTS `t_user_address` (
  `user_address_id` char(64) NOT NULL COMMENT '用户地址主键',
  `user_id` char(64) NOT NULL COMMENT '用户主键',
  `is_default` int(12) DEFAULT 0 COMMENT '是否为默认地址,目前有(0: 非默认,1: 默认地址)',
  `receive_user_name` varchar(40) NOT NULL DEFAULT '' COMMENT '接收人姓名',
  `receive_user_phone` varchar(40) NOT NULL DEFAULT '' COMMENT '接收人联系方式',
  `receive_province` varchar(50) DEFAULT '' COMMENT '省',
  `receive_city` varchar(50) DEFAULT '' COMMENT '市',
  `receive_district` varchar(50) DEFAULT '' COMMENT '区',
  `receive_description` varchar(100) DEFAULT '' COMMENT '地址详细描述',
  PRIMARY KEY (`user_address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 商品
CREATE TABLE IF NOT EXISTS `t_product` (
  `product_id` char(64) NOT NULL COMMENT '商品主键',
  `product_name` varchar(100) DEFAULT NULL COMMENT '商品名',
  `product_price` double DEFAULT 0 COMMENT '商品价格',
  `product_type` varchar(50) DEFAULT '' COMMENT '商品类型',
  `product_img` varchar(300) DEFAULT '' COMMENT '商品封面图',
  `product_num` int(12) DEFAULT 0 COMMENT '商品数量',
  `product_description` varchar(500) DEFAULT  '' COMMENT '商品描述',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 购物车
CREATE TABLE IF NOT EXISTS `t_cart` (
  `cart_id` char(64) NOT NULL COMMENT '购物车主键',
  `user_id` varchar(64) DEFAULT NULL COMMENT '用户主键',
  `product_id` varchar(64) DEFAULT NULL COMMENT '商品主键',
  `product_img` varchar(300) DEFAULT NULL COMMENT '商品封面',
  `product_name` varchar(100) DEFAULT NULL COMMENT '商品名称',
  `product_price` double DEFAULT 0 COMMENT '商品价格',
  `num` int(12) DEFAULT 0 COMMENT '商品数量',
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 订单
CREATE TABLE IF NOT EXISTS `t_order` (
  `order_id` char(64) NOT NULL COMMENT '订单主键',
  `user_id` char(64) NOT NULL COMMENT '用户主键',
  `user_address_id` char(64) NOT NULL COMMENT '用户地址主键',
  `order_money` double DEFAULT 0 COMMENT '订单总额',
  `order_paystate` int(12) DEFAULT 0 COMMENT '支付状态，目前有(0: 待支付,1: 支付中,2: 已支付)',
  `order_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
  `order_modify_time` timestamp COMMENT '订单最后修改时间',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 订单商品条目
CREATE TABLE IF NOT EXISTS `t_order_item` (
  `order_item_id` char(64) NOT NULL COMMENT '订单条目主键',
  `order_id` char(64) DEFAULT NULL COMMENT '订单主键',
  `product_id` char(64) DEFAULT NULL COMMENT '商品主键',
  `num` int(12) DEFAULT 0 COMMENT '商品数量',
  `product_img` varchar(300) DEFAULT NULL COMMENT '商品封面',
  `product_name` varchar(100) DEFAULT NULL COMMENT '商品名称',
  `product_price` double DEFAULT 0 COMMENT '商品价格',
  PRIMARY KEY (`order_item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
