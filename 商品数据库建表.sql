-- USE miaosha;
-- Create TABLE `goods`(
-- 	`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
--     `goods_name` varchar(16) DEFAULT NULL COMMENT '商品名称',
--     `goods_title` varchar(64) DEFAULT NULL COMMENT '商品标题',
--     `goods_img` varchar(64) DEFAULT NULL COMMENT '商品图片链接',
--     `goods_detail` longtext COMMENT '商品详情介绍',
--     `goods_price` decimal(10,2) DEFAULT '0.00' COMMENT '商品单价',
--     `goods_stock` int(11) DEFAULT '0' COMMENT '商品库存，-1表示没有限制',
-- 	PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
-- INSERT INTO `goods` VALUES(1, 'iphoneX', 'Apple iPhone X(A1865) 64GB 银色 移动联通电信5G手机','/img/iphonex.png','Apple iPhone X(A1865) 64GB 银色 移动联通电信5G手机',3212.00, -1)；
-- INSERT INTO `goods` VALUES(2, '华为P30', '华为P30 64GB 银色 移动联通电信5G手机','/img/iphonex.png','华为P30 64GB 银色 移动联通电信5G手机',8888.00, -1);
-- Create TABLE `miaosha_goods`(
-- 	`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '秒杀的商品表',
--     `goods_id` bigint(20) DEFAULT NULL COMMENT '商品id',
--     `miaosha_price` decimal(10,2) DEFAULT '0.00' COMMENT '秒杀价',
--     `stock_count` int(11) DEFAULT NULL COMMENT '库存数量',
--     `start_date` datetime DEFAULT NULL COMMENT '秒杀开始时间',
--     `end_date` datetime DEFAULT NULL COMMENT '秒杀结束时间',
-- 	PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
-- INSERT INTO `miaosha_goods` VALUES(1,1,0.01,4,'2020-05-17 15:00:00','2020-05-27 15:00:00');
-- INSERT INTO `miaosha_goods` VALUES(2,2,0.01,9,'2020-05-17 18:00:00','2020-05-27 18:00:00');
-- create table `order_info`(
-- 	`id` bigint(20) NOT NULL AUTO_INCREMENT,
--     `user_id` bigint(20) NOT NULL COMMENT '用户ID',
--     `goods_id` bigint(20) NOT NULL COMMENT '商品ID',
--     `delivery_addr_id` bigint(20) NOT NULL COMMENT '收货地址ID',
--     `goods_name` varchar(16) DEFAULT NULL COMMENT '商品名称',
--     `goods_count` int(11) DEFAULT '0' COMMENT '商品数量',
--     `goods_price` decimal(10,2) DEFAULT '0.00' COMMENT '商品单价',
--     `order_channel` tinyint(4) DEFAULT '0' COMMENT '1pc, 2android, 3ios',
--     `status` tinyint(4) DEFAULT '0' COMMENT '订单状态，0新建未支付，1已支付，2已发货，3已收货，4已退款，5已完成',
--     `create_date` datetime DEFAULT NULL COMMENT '订单创建时间',
--     `pay_date` datetime DEFAULT NULL COMMENT '支付时间',
--     PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

-- create table `miaosha_order`(
-- 	`id` bigint(20) NOT NULL AUTO_INCREMENT,
--     `user_id` bigint(20) NOT NULL COMMENT '用户ID',
--     `order_id` bigint(20) NOT NULL COMMENT '订单ID',
--     `goods_id` bigint(20) NOT NULL COMMENT '商品ID',
--     PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;















