/*
 Navicat Premium Data Transfer

 Source Server         : docker-mysql56
 Source Server Type    : MySQL
 Source Server Version : 50644
 Source Host           : localhost:3306
 Source Schema         : ticket

 Target Server Type    : MySQL
 Target Server Version : 50644
 File Encoding         : 65001

 Date: 27/05/2019 18:22:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ticket_admin
-- ----------------------------
DROP TABLE IF EXISTS `ticket_admin`;
CREATE TABLE `ticket_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ticket_admin
-- ----------------------------
BEGIN;
INSERT INTO `ticket_admin` VALUES (1, 'admin', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', 'https://avatars0.githubusercontent.com/u/13061300?s=400', 'Admin 备注信息1', NULL, NULL, 0);
INSERT INTO `ticket_admin` VALUES (2, 'test1', '$2a$10$nzSNrbTeL0hRhtcnOX1eO.ciyS3MrAjvHPtTnyp6KkveIebns6pqO', NULL, 'test1 备注信息', NULL, NULL, 0);
INSERT INTO `ticket_admin` VALUES (3, 'test2', '$2a$10$Taf3xdFbhLhgndKTq.MX.eRGphcfQm1A59yawQ17emNwl8AZpqWFu', NULL, 'test2 备注信息 备注信息修改', NULL, NULL, 1);
INSERT INTO `ticket_admin` VALUES (4, 'test3', '$2a$10$VrAKmEa9uXg3PHqMO0thruso6o4f5zMs.iC7k8cIr91TAAGkq5Gc2', NULL, 'test3', '2019-05-17 06:27:52', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for ticket_admin_log
-- ----------------------------
DROP TABLE IF EXISTS `ticket_admin_log`;
CREATE TABLE `ticket_admin_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin` varchar(20) DEFAULT NULL COMMENT '管理员',
  `path` varchar(255) DEFAULT NULL COMMENT '请求地址',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `action` varchar(50) DEFAULT NULL COMMENT '动作',
  `type` tinyint(1) DEFAULT NULL COMMENT '日志类型',
  `result` varchar(200) DEFAULT NULL COMMENT '结果',
  `ip` varchar(30) DEFAULT NULL COMMENT 'IP地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ticket_admin_log
-- ----------------------------
BEGIN;
INSERT INTO `ticket_admin_log` VALUES (1, 'admin', 'http://localhost:8081', '2019-05-17 07:51:06', '登出', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (2, 'admin', 'http://localhost:8081', '2019-05-17 07:51:09', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (3, 'admin', '/auth/logout', '2019-05-17 08:33:04', '登出', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (4, 'admin', '/auth/login', '2019-05-20 07:52:36', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (5, 'admin', '/auth/login', '2019-05-20 07:56:30', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (6, 'admin', '/auth/login', '2019-05-20 07:57:23', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (7, 'admin', '/auth/login', '2019-05-20 08:07:18', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (8, 'admin', '/auth/login', '2019-05-20 08:43:22', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (9, 'admin', '/auth/login', '2019-05-21 07:07:33', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (10, 'admin', '/auth/logout', '2019-05-21 07:31:45', '登出', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (11, 'test3', '/auth/login', '2019-05-21 07:31:48', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (12, 'test3', '/auth/login', '2019-05-21 07:32:40', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (13, 'test3', '/auth/login', '2019-05-21 07:32:50', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (14, 'test3', '/auth/login', '2019-05-21 07:33:50', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (15, 'test3', '/auth/login', '2019-05-21 07:34:37', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (16, 'test3', '/auth/login', '2019-05-21 07:37:19', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (17, 'test3', '/auth/login', '2019-05-21 07:37:21', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (18, 'test3', '/auth/login', '2019-05-21 07:39:19', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (19, 'test3', '/auth/login', '2019-05-21 07:41:12', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (20, 'test3', '/auth/login', '2019-05-21 08:02:17', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (21, 'test3', '/auth/login', '2019-05-21 08:04:09', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (22, 'admin', '/auth/login', '2019-05-21 08:06:23', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (23, 'admin', '/auth/logout', '2019-05-21 08:06:27', '登出', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (24, 'test3', '/auth/login', '2019-05-21 08:06:42', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (25, 'test3', '/auth/login', '2019-05-21 08:07:21', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (26, 'test3', '/auth/login', '2019-05-21 08:07:22', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (27, 'test3', '/auth/login', '2019-05-21 08:07:23', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (28, 'test3', '/auth/login', '2019-05-21 08:07:23', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (29, 'test3', '/auth/login', '2019-05-21 08:07:24', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (30, 'test3', '/auth/login', '2019-05-21 08:07:24', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (31, 'test3', '/auth/login', '2019-05-21 08:07:24', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (32, 'test3', '/auth/login', '2019-05-21 08:07:25', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (33, 'test3', '/auth/login', '2019-05-21 08:07:25', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (34, 'admin', '/auth/login', '2019-05-21 08:07:47', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (35, 'admin', '/auth/logout', '2019-05-21 08:07:51', '登出', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (36, 'admin', '/auth/login', '2019-05-21 08:07:53', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (37, 'admin', '/auth/logout', '2019-05-21 09:13:33', '登出', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (38, 'test3', '/auth/login', '2019-05-21 09:13:39', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (39, 'test1', '/auth/login', '2019-05-21 09:14:05', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (40, 'test1', '/auth/login', '2019-05-21 09:16:00', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (41, 'test1', '/auth/login', '2019-05-21 09:16:04', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (42, 'test1', '/auth/login', '2019-05-21 09:17:12', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (43, 'admin', '/auth/login', '2019-05-22 02:22:52', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (44, 'admin', '/auth/login', '2019-05-22 02:23:16', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (45, 'admin', '/auth/login', '2019-05-22 02:23:40', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (46, 'admin', '/auth/login', '2019-05-22 02:24:00', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (47, 'admin', '/auth/login', '2019-05-22 02:24:26', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (48, 'admin', '/auth/login', '2019-05-22 02:24:30', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (49, 'admin', '/auth/login', '2019-05-22 02:27:46', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (50, 'admin', '/auth/login', '2019-05-22 02:28:03', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (51, 'admin', '/auth/login', '2019-05-22 02:28:30', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (52, 'admin', '/auth/login', '2019-05-22 02:28:51', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (53, 'admin', '/auth/login', '2019-05-22 02:29:20', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (54, 'admin', '/auth/login', '2019-05-22 02:29:25', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (55, 'admin', '/auth/login', '2019-05-22 02:36:10', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (56, 'admin', '/auth/login', '2019-05-22 02:40:30', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (57, 'admin', '/auth/login', '2019-05-22 02:40:54', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (58, 'admin', '/auth/login', '2019-05-22 02:41:18', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (59, 'admin', '/auth/login', '2019-05-22 02:42:12', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (60, 'admin', '/auth/login', '2019-05-22 02:42:52', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (61, 'admin', '/auth/login', '2019-05-22 02:43:49', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (62, 'test1', '/auth/logout', '2019-05-22 02:56:37', '登出', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (63, 'admin', '/auth/login', '2019-05-22 02:56:39', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (64, 'admin', '/auth/logout', '2019-05-22 04:09:38', '登出', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (65, 'test1', '/auth/login', '2019-05-22 04:09:41', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (66, 'test1', '/auth/logout', '2019-05-22 04:09:56', '登出', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (67, 'admin', '/auth/login', '2019-05-24 05:25:28', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (68, 'admin', '/auth/login', '2019-05-24 05:47:35', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (69, 'admin', '/admin/auth/login', '2019-05-24 05:54:01', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (70, 'admin', '/admin/auth/login', '2019-05-24 05:54:12', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (71, 'admin', '/admin/auth/login', '2019-05-24 05:55:04', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
INSERT INTO `ticket_admin_log` VALUES (72, 'admin', '/admin/auth/login', '2019-05-25 07:53:41', '登陆', 1, '成功', '0:0:0:0:0:0:0:1');
COMMIT;

-- ----------------------------
-- Table structure for ticket_admin_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `ticket_admin_role_relation`;
CREATE TABLE `ticket_admin_role_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ticket_admin_role_relation
-- ----------------------------
BEGIN;
INSERT INTO `ticket_admin_role_relation` VALUES (1, 1, 1);
INSERT INTO `ticket_admin_role_relation` VALUES (2, 2, 2);
INSERT INTO `ticket_admin_role_relation` VALUES (3, 3, 2);
INSERT INTO `ticket_admin_role_relation` VALUES (4, 3, 3);
INSERT INTO `ticket_admin_role_relation` VALUES (5, 4, 3);
COMMIT;

-- ----------------------------
-- Table structure for ticket_permission
-- ----------------------------
DROP TABLE IF EXISTS `ticket_permission`;
CREATE TABLE `ticket_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `type` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ticket_permission
-- ----------------------------
BEGIN;
INSERT INTO `ticket_permission` VALUES (1, '所有权限', '*', 0, 0);
INSERT INTO `ticket_permission` VALUES (2, '系统管理', 'sys', 0, 1);
INSERT INTO `ticket_permission` VALUES (3, '管理员', 'sys:admin', 2, 1);
INSERT INTO `ticket_permission` VALUES (4, '管理员列表', 'sys:admin:list', 3, 2);
INSERT INTO `ticket_permission` VALUES (5, '查看管理员信息', 'sys:admin:read', 3, 2);
INSERT INTO `ticket_permission` VALUES (6, '创建管理员', 'sys:admin:create', 3, 2);
INSERT INTO `ticket_permission` VALUES (7, '修改管理员', 'sys:admin:update', 3, 2);
INSERT INTO `ticket_permission` VALUES (8, '删除管理员', 'sys:admin:delete', 3, 2);
INSERT INTO `ticket_permission` VALUES (9, '日志', 'sys:log', 2, 1);
INSERT INTO `ticket_permission` VALUES (10, '日志列表', 'sys:log:list', 9, 2);
INSERT INTO `ticket_permission` VALUES (11, 'Example', 'example', 0, 1);
INSERT INTO `ticket_permission` VALUES (12, 'Table', 'example:table', 11, 1);
INSERT INTO `ticket_permission` VALUES (13, 'Table列表', 'example:table:list', 12, 2);
INSERT INTO `ticket_permission` VALUES (14, 'Tree', 'example:tree', 11, 1);
INSERT INTO `ticket_permission` VALUES (15, 'Tree列表', 'example:tree:list', 14, 2);
INSERT INTO `ticket_permission` VALUES (16, 'Menu', 'menu', 0, 1);
INSERT INTO `ticket_permission` VALUES (17, 'Menu1', 'menu:menu1', 16, 1);
INSERT INTO `ticket_permission` VALUES (18, 'Menu1-1', 'menu:menu1:1', 17, 1);
INSERT INTO `ticket_permission` VALUES (19, 'Menu1-2', 'menu:menu1:2', 17, 1);
INSERT INTO `ticket_permission` VALUES (20, 'Menu1-2-1', 'menu:menu1:2:1', 19, 1);
INSERT INTO `ticket_permission` VALUES (21, 'Menu1-2-2', 'menu:menu1:2:2', 19, 1);
INSERT INTO `ticket_permission` VALUES (22, 'Menu1-3', 'menu:menu1:3', 17, 1);
INSERT INTO `ticket_permission` VALUES (23, 'Menu2', 'menu:menu2', 16, 1);
COMMIT;

-- ----------------------------
-- Table structure for ticket_product
-- ----------------------------
DROP TABLE IF EXISTS `ticket_product`;
CREATE TABLE `ticket_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `sub_title` varchar(255) DEFAULT NULL COMMENT '商品副标题',
  `description` varchar(255) DEFAULT NULL COMMENT '商品介绍',
  `sn` varchar(255) DEFAULT NULL COMMENT '商品货号',
  `price` decimal(10,2) DEFAULT NULL COMMENT '商品售价',
  `original_price` decimal(10,2) DEFAULT NULL COMMENT '市场价',
  `stock` int(10) DEFAULT NULL COMMENT '库存',
  `unit` varchar(255) DEFAULT NULL COMMENT '单位',
  `sort` int(10) DEFAULT NULL COMMENT '排序',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `deleted` tinyint(4) DEFAULT NULL COMMENT '逻辑删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ticket_product
-- ----------------------------
BEGIN;
INSERT INTO `ticket_product` VALUES (1, '商品1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `ticket_product` VALUES (2, '商品2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `ticket_product` VALUES (3, '商品3', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for ticket_product_category
-- ----------------------------
DROP TABLE IF EXISTS `ticket_product_category`;
CREATE TABLE `ticket_product_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL COMMENT '上级',
  `name` varchar(255) DEFAULT NULL COMMENT '分类名称',
  `product_count` int(11) DEFAULT NULL COMMENT '商品数量',
  `product_unit` varchar(10) DEFAULT NULL COMMENT '商品规格',
  `sort` tinyint(4) DEFAULT NULL COMMENT '排序',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `show_status` tinyint(4) DEFAULT NULL COMMENT '显示状态',
  `nav_status` tinyint(4) DEFAULT NULL COMMENT '导航显示状态',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `deleted` tinyint(4) DEFAULT NULL COMMENT '逻辑删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ticket_product_category
-- ----------------------------
BEGIN;
INSERT INTO `ticket_product_category` VALUES (1, 0, '分类1', 12, '张', 1, NULL, NULL, NULL, '描述信息', NULL, '2019-05-24 09:54:19', 0);
INSERT INTO `ticket_product_category` VALUES (2, 0, '分类2', 19, '张', 2, NULL, NULL, NULL, '描述信息2', NULL, NULL, 0);
INSERT INTO `ticket_product_category` VALUES (3, 2, '分类2-1', 11, '张', 3, NULL, NULL, NULL, '描述信息2-1', NULL, NULL, 0);
INSERT INTO `ticket_product_category` VALUES (4, 2, '分类2-2', 2, '张', 4, NULL, NULL, NULL, '描述信息2-2', NULL, NULL, 0);
INSERT INTO `ticket_product_category` VALUES (5, 0, 'fffff', 0, '桶', 12, '', 0, 1, '描述信息 update', '2019-05-24 09:56:16', '2019-05-24 09:56:54', 0);
COMMIT;

-- ----------------------------
-- Table structure for ticket_role
-- ----------------------------
DROP TABLE IF EXISTS `ticket_role`;
CREATE TABLE `ticket_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `deleted` tinyint(4) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ticket_role
-- ----------------------------
BEGIN;
INSERT INTO `ticket_role` VALUES (1, '系统管理员', '系统管理员，具有系统全部权限', '1900-01-01 00:00:00', 0, NULL);
INSERT INTO `ticket_role` VALUES (2, '角色2', '具有系统部分权限', '1900-01-01 00:00:00', 0, NULL);
INSERT INTO `ticket_role` VALUES (3, '角色3', '具有系统部分权限', '1900-01-01 00:00:00', 0, NULL);
INSERT INTO `ticket_role` VALUES (4, 'role test1', 'role test1 description 11', '2019-05-21 02:57:10', 0, '2019-05-21 03:18:46');
INSERT INTO `ticket_role` VALUES (5, 'role test2', '', '2019-05-21 02:58:39', 1, NULL);
COMMIT;

-- ----------------------------
-- Table structure for ticket_role_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `ticket_role_permission_relation`;
CREATE TABLE `ticket_role_permission_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ticket_role_permission_relation
-- ----------------------------
BEGIN;
INSERT INTO `ticket_role_permission_relation` VALUES (1, 1, 1);
INSERT INTO `ticket_role_permission_relation` VALUES (8, NULL, NULL);
INSERT INTO `ticket_role_permission_relation` VALUES (14, 2, 2);
INSERT INTO `ticket_role_permission_relation` VALUES (15, 2, 3);
INSERT INTO `ticket_role_permission_relation` VALUES (16, 2, 4);
INSERT INTO `ticket_role_permission_relation` VALUES (17, 2, 7);
INSERT INTO `ticket_role_permission_relation` VALUES (18, 2, 9);
INSERT INTO `ticket_role_permission_relation` VALUES (19, 2, 10);
COMMIT;

-- ----------------------------
-- Table structure for ticket_scenic
-- ----------------------------
DROP TABLE IF EXISTS `ticket_scenic`;
CREATE TABLE `ticket_scenic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) DEFAULT NULL COMMENT '分类Id',
  `name` varchar(255) DEFAULT NULL COMMENT '景点名',
  `short_name` varchar(255) DEFAULT NULL COMMENT '景点简称',
  `sell_point` varchar(255) DEFAULT NULL COMMENT '景点卖点',
  `open_time` varchar(100) DEFAULT NULL COMMENT '开放时间',
  `address` varchar(255) DEFAULT NULL COMMENT '景点地址',
  `address_lng` varchar(20) DEFAULT NULL COMMENT '地址经度',
  `address_lat` varchar(20) DEFAULT NULL COMMENT '地址纬度',
  `notice` text COMMENT '景点须知',
  `description` text COMMENT '景点介绍',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `deleted` tinyint(4) DEFAULT NULL COMMENT '逻辑删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ticket_scenic
-- ----------------------------
BEGIN;
INSERT INTO `ticket_scenic` VALUES (1, 8, '大连森林动物园（4A）', '高品质的野生动物园', NULL, '08:30开园', '辽宁省大连市西岗区滨海路79号森林动物园', NULL, NULL, '<h2>门票优惠</h2>\n<p>儿童xxxxxx</p>\n<p>老人xxxx</p>\n<h2>开放时间</h2>\n<p>开放时间xxxxxxx</p>', '<p>高品质野生动物园</p>\n<p>大连森林动物园熊猫馆建于xxxxxxx</p>\n<p>在非洲食草动物区xxxxx</p>\n<p>大连森林动物园热带雨林xxxxxx</p>', '2019-05-27 09:55:40', NULL, 0);
INSERT INTO `ticket_scenic` VALUES (2, 8, '大连森林动物园（4A）', '高品质的野生动物园', NULL, '08:30开园', '辽宁省大连市西岗区滨海路79号森林动物园', NULL, NULL, '<h2>门票优惠</h2>\n<p>儿童xxxxxx</p>\n<p>老人xxxx</p>\n<h2>开放时间</h2>\n<p>开放时间xxxxxxx</p>', '<p>高品质野生动物园</p>\n<p>大连森林动物园熊猫馆建于xxxxxxx</p>\n<p>在非洲食草动物区xxxxx</p>\n<p>大连森林动物园热带雨林xxxxxx</p>', '2019-05-27 09:56:24', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for ticket_scenic_category
-- ----------------------------
DROP TABLE IF EXISTS `ticket_scenic_category`;
CREATE TABLE `ticket_scenic_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL COMMENT '父id',
  `name` varchar(255) DEFAULT NULL COMMENT '景点分类名',
  `description` varchar(255) DEFAULT NULL COMMENT '描述信息',
  `scenic_count` int(11) DEFAULT NULL COMMENT '景点数量',
  `sort` tinyint(4) DEFAULT NULL COMMENT '排序',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `show_status` tinyint(4) DEFAULT NULL COMMENT '显示状态',
  `nav_status` tinyint(4) DEFAULT NULL COMMENT '导航显示',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `deleted` tinyint(4) DEFAULT NULL COMMENT '逻辑删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ticket_scenic_category
-- ----------------------------
BEGIN;
INSERT INTO `ticket_scenic_category` VALUES (1, 0, '景点', NULL, 11, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `ticket_scenic_category` VALUES (2, 1, '自然风光', NULL, 12, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `ticket_scenic_category` VALUES (3, 1, '名胜古迹', NULL, 13, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `ticket_scenic_category` VALUES (4, 1, '观光街区', NULL, 14, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `ticket_scenic_category` VALUES (5, 1, '公园游乐场', NULL, 15, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `ticket_scenic_category` VALUES (6, 1, '其他景点', NULL, 16, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `ticket_scenic_category` VALUES (7, 0, '动植物园', NULL, 17, 0, NULL, 0, 0, NULL, NULL, 0);
INSERT INTO `ticket_scenic_category` VALUES (8, 7, '动物园', NULL, 18, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `ticket_scenic_category` VALUES (9, 7, '植物园', NULL, 119, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `ticket_scenic_category` VALUES (10, 7, '海洋馆', NULL, 22, NULL, NULL, NULL, NULL, NULL, NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for ticket_scenic_photo
-- ----------------------------
DROP TABLE IF EXISTS `ticket_scenic_photo`;
CREATE TABLE `ticket_scenic_photo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `scenic_id` int(11) DEFAULT NULL COMMENT '景点id',
  `path` varchar(255) DEFAULT NULL COMMENT '图片路径',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `deleted` tinyint(4) DEFAULT NULL COMMENT '逻辑删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of ticket_scenic_photo
-- ----------------------------
BEGIN;
INSERT INTO `ticket_scenic_photo` VALUES (1, 1, 'http://localhost:8081/static/ZQeKJsSIBtEZ7Svhv9oR.jpeg', '2019-05-27 09:55:40', NULL, 0);
INSERT INTO `ticket_scenic_photo` VALUES (2, 1, 'http://localhost:8081/static/udmfgsrBTE753QOwQly8.jpeg', '2019-05-27 09:55:40', NULL, 0);
INSERT INTO `ticket_scenic_photo` VALUES (3, 1, 'http://localhost:8081/static/Ts23Gt9n8mcnE6Ra2EHn.jpeg', '2019-05-27 09:55:40', NULL, 0);
INSERT INTO `ticket_scenic_photo` VALUES (4, 1, 'http://localhost:8081/static/hmJOXy74LXuf0l7WnwQC.jpeg', '2019-05-27 09:55:40', NULL, 0);
INSERT INTO `ticket_scenic_photo` VALUES (5, 1, 'http://localhost:8081/static/y80t8iHBUjlTmHA9Bg90.jpeg', '2019-05-27 09:55:40', NULL, 0);
INSERT INTO `ticket_scenic_photo` VALUES (6, 2, 'http://localhost:8081/static/ZQeKJsSIBtEZ7Svhv9oR.jpeg', '2019-05-27 09:56:24', NULL, 0);
INSERT INTO `ticket_scenic_photo` VALUES (7, 2, 'http://localhost:8081/static/udmfgsrBTE753QOwQly8.jpeg', '2019-05-27 09:56:24', NULL, 0);
INSERT INTO `ticket_scenic_photo` VALUES (8, 2, 'http://localhost:8081/static/Ts23Gt9n8mcnE6Ra2EHn.jpeg', '2019-05-27 09:56:24', NULL, 0);
INSERT INTO `ticket_scenic_photo` VALUES (9, 2, 'http://localhost:8081/static/hmJOXy74LXuf0l7WnwQC.jpeg', '2019-05-27 09:56:24', NULL, 0);
INSERT INTO `ticket_scenic_photo` VALUES (10, 2, 'http://localhost:8081/static/y80t8iHBUjlTmHA9Bg90.jpeg', '2019-05-27 09:56:24', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for ticket_storage
-- ----------------------------
DROP TABLE IF EXISTS `ticket_storage`;
CREATE TABLE `ticket_storage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `key` varchar(63) NOT NULL COMMENT '文件的唯一索引',
  `name` varchar(255) NOT NULL COMMENT '文件名',
  `type` varchar(20) NOT NULL COMMENT '文件类型',
  `size` int(11) NOT NULL COMMENT '文件大小',
  `url` varchar(255) DEFAULT NULL COMMENT '文件访问链接',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COMMENT='文件存储表';

-- ----------------------------
-- Records of ticket_storage
-- ----------------------------
BEGIN;
INSERT INTO `ticket_storage` VALUES (1, '7fPSwq3NXD6q0jS4F0qC.jpg', '802758360cd659c01c5a0a9af85668b5_middle.jpg', 'image/jpeg', 6559, 'http://localhost:8080/wx/storage/fetch/7fPSwq3NXD6q0jS4F0qC.jpg', NULL, NULL, NULL);
INSERT INTO `ticket_storage` VALUES (2, 'DdhG6jqgIOF7qQO2dX8J.jpg', '802758360cd659c01c5a0a9af85668b5_middle.jpg', 'image/jpeg', 6559, 'http://localhost:8080/wx/storage/fetch/DdhG6jqgIOF7qQO2dX8J.jpg', NULL, NULL, NULL);
INSERT INTO `ticket_storage` VALUES (3, 'fitlhP6PkPoMjgsmsOnq.jpg', '802758360cd659c01c5a0a9af85668b5_middle.jpg', 'image/jpeg', 6559, 'http://localhost:8081/admin/storage/fetch/fitlhP6PkPoMjgsmsOnq.jpg', NULL, NULL, NULL);
INSERT INTO `ticket_storage` VALUES (4, 'UA91lUqmyxS0x31PaTW1.jpg', '802758360cd659c01c5a0a9af85668b5_middle.jpg', 'image/jpeg', 6559, 'http://localhost:8081/static/UA91lUqmyxS0x31PaTW1.jpg', NULL, NULL, NULL);
INSERT INTO `ticket_storage` VALUES (5, 'pJhcNA8Lkg1qCKfMFcE0.jpg', '802758360cd659c01c5a0a9af85668b5_middle.jpg', 'image/jpeg', 6559, 'http://localhost:8081/static/pJhcNA8Lkg1qCKfMFcE0.jpg', NULL, NULL, NULL);
INSERT INTO `ticket_storage` VALUES (6, 'Cxd5OKAquPzwBXHi8uE4.jpg', '802758360cd659c01c5a0a9af85668b5_middle.jpg', 'image/jpeg', 6559, 'http://localhost:8081/static/Cxd5OKAquPzwBXHi8uE4.jpg', NULL, NULL, NULL);
INSERT INTO `ticket_storage` VALUES (7, '8E5XVpyEBeBs4bZo2eIS.jpg', '802758360cd659c01c5a0a9af85668b5_middle.jpg', 'image/jpeg', 6559, 'http://localhost:8081/static/8E5XVpyEBeBs4bZo2eIS.jpg', NULL, NULL, NULL);
INSERT INTO `ticket_storage` VALUES (8, 'mWf3EbVhdYYkTCAuSc11.jpg', '802758360cd659c01c5a0a9af85668b5_middle.jpg', 'image/jpeg', 6559, 'http://localhost:8081/static/mWf3EbVhdYYkTCAuSc11.jpg', NULL, NULL, NULL);
INSERT INTO `ticket_storage` VALUES (9, 'UdBmPv1g92BMHWi1viQG.jpg', '802758360cd659c01c5a0a9af85668b5_middle.jpg', 'image/jpeg', 6559, 'http://localhost:8081/static/UdBmPv1g92BMHWi1viQG.jpg', NULL, NULL, NULL);
INSERT INTO `ticket_storage` VALUES (10, 'NpVzrWC9OrKmHms8VbMr.jpg', '802758360cd659c01c5a0a9af85668b5_middle.jpg', 'image/jpeg', 6559, 'http://localhost:8081/static/NpVzrWC9OrKmHms8VbMr.jpg', NULL, NULL, NULL);
INSERT INTO `ticket_storage` VALUES (11, 'puk3BZH0F07Vt4hCgrsT.jpg', '802758360cd659c01c5a0a9af85668b5_middle.jpg', 'image/jpeg', 6559, 'http://localhost:8081/static/puk3BZH0F07Vt4hCgrsT.jpg', NULL, NULL, NULL);
INSERT INTO `ticket_storage` VALUES (12, 'nSutfZP81xLrUE8zIBpT.jpg', '802758360cd659c01c5a0a9af85668b5_middle.jpg', 'image/jpeg', 6559, 'http://localhost:8081/static/nSutfZP81xLrUE8zIBpT.jpg', NULL, NULL, NULL);
INSERT INTO `ticket_storage` VALUES (13, 'vhtAFtqCjvyXICQeG98i.jpg', '802758360cd659c01c5a0a9af85668b5_middle.jpg', 'image/jpeg', 6559, 'http://localhost:8081/static/vhtAFtqCjvyXICQeG98i.jpg', NULL, NULL, NULL);
INSERT INTO `ticket_storage` VALUES (14, '97AYKVzqdjqROgoa2v0X.jpg', '802758360cd659c01c5a0a9af85668b5_middle.jpg', 'image/jpeg', 6559, 'http://localhost:8081/static/97AYKVzqdjqROgoa2v0X.jpg', NULL, NULL, NULL);
INSERT INTO `ticket_storage` VALUES (15, '9HlqCTkcwf7nX3Y911Xh.jpg', '802758360cd659c01c5a0a9af85668b5_middle.jpg', 'image/jpeg', 6559, 'http://localhost:8081/static/9HlqCTkcwf7nX3Y911Xh.jpg', NULL, NULL, NULL);
INSERT INTO `ticket_storage` VALUES (16, 'i6cuI1VPfWv92JbF068V.jpg', '802758360cd659c01c5a0a9af85668b5_middle.jpg', 'image/jpeg', 6559, 'http://localhost:8081/static/i6cuI1VPfWv92JbF068V.jpg', NULL, NULL, NULL);
INSERT INTO `ticket_storage` VALUES (17, 'iy0hYcHq4UZEfDkBs7rD.jpg', '802758360cd659c01c5a0a9af85668b5_middle.jpg', 'image/jpeg', 6559, 'http://localhost:8081/static/iy0hYcHq4UZEfDkBs7rD.jpg', NULL, NULL, NULL);
INSERT INTO `ticket_storage` VALUES (18, 'dRQue19MC3YGFMvlq0Jc.jpg', '802758360cd659c01c5a0a9af85668b5_middle.jpg', 'image/jpeg', 6559, 'http://localhost:8081/static/dRQue19MC3YGFMvlq0Jc.jpg', NULL, NULL, NULL);
INSERT INTO `ticket_storage` VALUES (19, 'gUKgzlwdcKiniVP5C42C.jpg', '802758360cd659c01c5a0a9af85668b5_middle.jpg', 'image/jpeg', 6559, 'http://localhost:8081/static/gUKgzlwdcKiniVP5C42C.jpg', NULL, NULL, NULL);
INSERT INTO `ticket_storage` VALUES (20, 'HUdFG2Zay7ixscRwfXcI.jpg', '802758360cd659c01c5a0a9af85668b5_middle.jpg', 'image/jpeg', 6559, 'http://localhost:8081/static/HUdFG2Zay7ixscRwfXcI.jpg', NULL, NULL, NULL);
INSERT INTO `ticket_storage` VALUES (21, 'EkiUHKH7xUCH6amWMKfH.jpg', '802758360cd659c01c5a0a9af85668b5_middle.jpg', 'image/jpeg', 6559, 'http://localhost:8081/static/EkiUHKH7xUCH6amWMKfH.jpg', NULL, NULL, NULL);
INSERT INTO `ticket_storage` VALUES (22, '33V1ufdFlsLY7gJJC0fO.jpg', '802758360cd659c01c5a0a9af85668b5_middle.jpg', 'image/jpeg', 6559, 'http://localhost:8081/static/33V1ufdFlsLY7gJJC0fO.jpg', NULL, NULL, NULL);
INSERT INTO `ticket_storage` VALUES (23, 'cy7yZxfWxHcra0L1Qq0q.jpg', '802758360cd659c01c5a0a9af85668b5_middle.jpg', 'image/jpeg', 6559, 'http://localhost:8081/static/cy7yZxfWxHcra0L1Qq0q.jpg', NULL, NULL, NULL);
INSERT INTO `ticket_storage` VALUES (24, 'Nyu4iEbK6yJ1qOSa5exA.jpg', '802758360cd659c01c5a0a9af85668b5_middle.jpg', 'image/jpeg', 6559, 'http://localhost:8081/static/Nyu4iEbK6yJ1qOSa5exA.jpg', NULL, NULL, NULL);
INSERT INTO `ticket_storage` VALUES (25, 'rCGkSlvGIQdMLk67SOeT.jpg', '802758360cd659c01c5a0a9af85668b5_middle.jpg', 'image/jpeg', 6559, 'http://localhost:8081/static/rCGkSlvGIQdMLk67SOeT.jpg', NULL, NULL, NULL);
INSERT INTO `ticket_storage` VALUES (26, 'Dw37i2sWFAMss9GqQzbD.jpg', '802758360cd659c01c5a0a9af85668b5_middle.jpg', 'image/jpeg', 6559, 'http://localhost:8081/static/Dw37i2sWFAMss9GqQzbD.jpg', NULL, NULL, NULL);
INSERT INTO `ticket_storage` VALUES (27, 'SCJ5pzsXxGGCs7iUY9zY.jpg', '802758360cd659c01c5a0a9af85668b5_middle.jpg', 'image/jpeg', 6559, 'http://localhost:8081/static/SCJ5pzsXxGGCs7iUY9zY.jpg', NULL, NULL, NULL);
INSERT INTO `ticket_storage` VALUES (28, '15AVZ7rpD6eS1xIh4wgC.jpg', '802758360cd659c01c5a0a9af85668b5_middle.jpg', 'image/jpeg', 6559, 'http://localhost:8081/static/15AVZ7rpD6eS1xIh4wgC.jpg', NULL, NULL, NULL);
INSERT INTO `ticket_storage` VALUES (29, 's55Kv2ccijcWTLNG9TXi.jpg', '802758360cd659c01c5a0a9af85668b5_middle.jpg', 'image/jpeg', 6559, 'http://localhost:8081/static/s55Kv2ccijcWTLNG9TXi.jpg', NULL, NULL, NULL);
INSERT INTO `ticket_storage` VALUES (30, 'e6UoDurjwLcN9mtmOiv4.jpeg', 'WechatIMG1.jpeg', 'image/jpeg', 39777, 'http://localhost:8081/static/e6UoDurjwLcN9mtmOiv4.jpeg', NULL, NULL, NULL);
INSERT INTO `ticket_storage` VALUES (31, 'ZQeKJsSIBtEZ7Svhv9oR.jpeg', 'WechatIMG2.jpeg', 'image/jpeg', 78247, 'http://localhost:8081/static/ZQeKJsSIBtEZ7Svhv9oR.jpeg', NULL, NULL, NULL);
INSERT INTO `ticket_storage` VALUES (32, 'udmfgsrBTE753QOwQly8.jpeg', 'WechatIMG3.jpeg', 'image/jpeg', 53812, 'http://localhost:8081/static/udmfgsrBTE753QOwQly8.jpeg', NULL, NULL, NULL);
INSERT INTO `ticket_storage` VALUES (33, 'Ts23Gt9n8mcnE6Ra2EHn.jpeg', 'WechatIMG4.jpeg', 'image/jpeg', 57727, 'http://localhost:8081/static/Ts23Gt9n8mcnE6Ra2EHn.jpeg', NULL, NULL, NULL);
INSERT INTO `ticket_storage` VALUES (34, 'hmJOXy74LXuf0l7WnwQC.jpeg', 'WechatIMG5.jpeg', 'image/jpeg', 26624, 'http://localhost:8081/static/hmJOXy74LXuf0l7WnwQC.jpeg', NULL, NULL, NULL);
INSERT INTO `ticket_storage` VALUES (35, 'y80t8iHBUjlTmHA9Bg90.jpeg', 'WechatIMG6.jpeg', 'image/jpeg', 39069, 'http://localhost:8081/static/y80t8iHBUjlTmHA9Bg90.jpeg', NULL, NULL, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
