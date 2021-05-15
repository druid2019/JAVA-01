DROP TABLE IF EXISTS `orders_copy1`;
CREATE TABLE `orders_copy1` (
  `order_id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL COMMENT '用户编号',
  `account` float DEFAULT NULL COMMENT '支付金额',
  `order_state` smallint DEFAULT NULL COMMENT '订单状态 1.未支付 2.已支付 3.未发货 4.已发货 5.交易成功 6.交易关闭',
  `pay_type` smallint DEFAULT NULL COMMENT '支付类型：1.在线支付 2.货到付款',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`order_id`) USING BTREE
)
DROP TABLE IF EXISTS `orders_copy2`;
CREATE TABLE `orders_copy2` (
  `order_id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL COMMENT '用户编号',
  `account` float DEFAULT NULL COMMENT '支付金额',
  `order_state` smallint DEFAULT NULL COMMENT '订单状态 1.未支付 2.已支付 3.未发货 4.已发货 5.交易成功 6.交易关闭',
  `pay_type` smallint DEFAULT NULL COMMENT '支付类型：1.在线支付 2.货到付款',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`order_id`) USING BTREE
)
DROP TABLE IF EXISTS `orders_copy3`;
CREATE TABLE `orders_copy3` (
  `order_id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL COMMENT '用户编号',
  `account` float DEFAULT NULL COMMENT '支付金额',
  `order_state` smallint DEFAULT NULL COMMENT '订单状态 1.未支付 2.已支付 3.未发货 4.已发货 5.交易成功 6.交易关闭',
  `pay_type` smallint DEFAULT NULL COMMENT '支付类型：1.在线支付 2.货到付款',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`order_id`) USING BTREE
)
DROP TABLE IF EXISTS `orders_copy4`;
CREATE TABLE `orders_copy4` (
  `order_id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL COMMENT '用户编号',
  `account` float DEFAULT NULL COMMENT '支付金额',
  `order_state` smallint DEFAULT NULL COMMENT '订单状态 1.未支付 2.已支付 3.未发货 4.已发货 5.交易成功 6.交易关闭',
  `pay_type` smallint DEFAULT NULL COMMENT '支付类型：1.在线支付 2.货到付款',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`order_id`) USING BTREE
)
DROP TABLE IF EXISTS `orders_copy5`;
CREATE TABLE `orders_copy5` (
  `order_id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL COMMENT '用户编号',
  `account` float DEFAULT NULL COMMENT '支付金额',
  `order_state` smallint DEFAULT NULL COMMENT '订单状态 1.未支付 2.已支付 3.未发货 4.已发货 5.交易成功 6.交易关闭',
  `pay_type` smallint DEFAULT NULL COMMENT '支付类型：1.在线支付 2.货到付款',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`order_id`) USING BTREE
)
DROP TABLE IF EXISTS `orders_copy6`;
CREATE TABLE `orders_copy6` (
  `order_id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL COMMENT '用户编号',
  `account` float DEFAULT NULL COMMENT '支付金额',
  `order_state` smallint DEFAULT NULL COMMENT '订单状态 1.未支付 2.已支付 3.未发货 4.已发货 5.交易成功 6.交易关闭',
  `pay_type` smallint DEFAULT NULL COMMENT '支付类型：1.在线支付 2.货到付款',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`order_id`) USING BTREE
)
DROP TABLE IF EXISTS `orders_copy7`;
CREATE TABLE `orders_copy7` (
  `order_id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL COMMENT '用户编号',
  `account` float DEFAULT NULL COMMENT '支付金额',
  `order_state` smallint DEFAULT NULL COMMENT '订单状态 1.未支付 2.已支付 3.未发货 4.已发货 5.交易成功 6.交易关闭',
  `pay_type` smallint DEFAULT NULL COMMENT '支付类型：1.在线支付 2.货到付款',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`order_id`) USING BTREE
)
DROP TABLE IF EXISTS `orders_copy8`;
CREATE TABLE `orders_copy8` (
  `order_id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL COMMENT '用户编号',
  `account` float DEFAULT NULL COMMENT '支付金额',
  `order_state` smallint DEFAULT NULL COMMENT '订单状态 1.未支付 2.已支付 3.未发货 4.已发货 5.交易成功 6.交易关闭',
  `pay_type` smallint DEFAULT NULL COMMENT '支付类型：1.在线支付 2.货到付款',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`order_id`) USING BTREE
)
DROP TABLE IF EXISTS `orders_copy9`;
CREATE TABLE `orders_copy9` (
  `order_id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL COMMENT '用户编号',
  `account` float DEFAULT NULL COMMENT '支付金额',
  `order_state` smallint DEFAULT NULL COMMENT '订单状态 1.未支付 2.已支付 3.未发货 4.已发货 5.交易成功 6.交易关闭',
  `pay_type` smallint DEFAULT NULL COMMENT '支付类型：1.在线支付 2.货到付款',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`order_id`) USING BTREE
)
DROP TABLE IF EXISTS `orders_copy10`;
CREATE TABLE `orders_copy10` (
  `order_id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL COMMENT '用户编号',
  `account` float DEFAULT NULL COMMENT '支付金额',
  `order_state` smallint DEFAULT NULL COMMENT '订单状态 1.未支付 2.已支付 3.未发货 4.已发货 5.交易成功 6.交易关闭',
  `pay_type` smallint DEFAULT NULL COMMENT '支付类型：1.在线支付 2.货到付款',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`order_id`) USING BTREE
)
DROP TABLE IF EXISTS `orders_copy11`;
CREATE TABLE `orders_copy11` (
  `order_id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL COMMENT '用户编号',
  `account` float DEFAULT NULL COMMENT '支付金额',
  `order_state` smallint DEFAULT NULL COMMENT '订单状态 1.未支付 2.已支付 3.未发货 4.已发货 5.交易成功 6.交易关闭',
  `pay_type` smallint DEFAULT NULL COMMENT '支付类型：1.在线支付 2.货到付款',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`order_id`) USING BTREE
)
DROP TABLE IF EXISTS `orders_copy12`;
CREATE TABLE `orders_copy12` (
  `order_id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL COMMENT '用户编号',
  `account` float DEFAULT NULL COMMENT '支付金额',
  `order_state` smallint DEFAULT NULL COMMENT '订单状态 1.未支付 2.已支付 3.未发货 4.已发货 5.交易成功 6.交易关闭',
  `pay_type` smallint DEFAULT NULL COMMENT '支付类型：1.在线支付 2.货到付款',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`order_id`) USING BTREE
)
DROP TABLE IF EXISTS `orders_copy13`;
CREATE TABLE `orders_copy13` (
  `order_id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL COMMENT '用户编号',
  `account` float DEFAULT NULL COMMENT '支付金额',
  `order_state` smallint DEFAULT NULL COMMENT '订单状态 1.未支付 2.已支付 3.未发货 4.已发货 5.交易成功 6.交易关闭',
  `pay_type` smallint DEFAULT NULL COMMENT '支付类型：1.在线支付 2.货到付款',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`order_id`) USING BTREE
)
DROP TABLE IF EXISTS `orders_copy14`;
CREATE TABLE `orders_copy14` (
  `order_id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL COMMENT '用户编号',
  `account` float DEFAULT NULL COMMENT '支付金额',
  `order_state` smallint DEFAULT NULL COMMENT '订单状态 1.未支付 2.已支付 3.未发货 4.已发货 5.交易成功 6.交易关闭',
  `pay_type` smallint DEFAULT NULL COMMENT '支付类型：1.在线支付 2.货到付款',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`order_id`) USING BTREE
)
DROP TABLE IF EXISTS `orders_copy15`;
CREATE TABLE `orders_copy15` (
  `order_id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL COMMENT '用户编号',
  `account` float DEFAULT NULL COMMENT '支付金额',
  `order_state` smallint DEFAULT NULL COMMENT '订单状态 1.未支付 2.已支付 3.未发货 4.已发货 5.交易成功 6.交易关闭',
  `pay_type` smallint DEFAULT NULL COMMENT '支付类型：1.在线支付 2.货到付款',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`order_id`) USING BTREE
)
DROP TABLE IF EXISTS `orders_copy16`;
CREATE TABLE `orders_copy16` (
  `order_id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL COMMENT '用户编号',
  `account` float DEFAULT NULL COMMENT '支付金额',
  `order_state` smallint DEFAULT NULL COMMENT '订单状态 1.未支付 2.已支付 3.未发货 4.已发货 5.交易成功 6.交易关闭',
  `pay_type` smallint DEFAULT NULL COMMENT '支付类型：1.在线支付 2.货到付款',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`order_id`) USING BTREE
)