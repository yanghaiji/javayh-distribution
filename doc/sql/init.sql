/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50624
 Source Host           : localhost:3306
 Source Schema         : db1

 Target Server Type    : MySQL
 Target Server Version : 50624
 File Encoding         : 65001

 Date: 30/10/2019 15:35:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `p_id` int(11) NULL DEFAULT NULL COMMENT '父id',
  `menu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限url',
  `create_date` date NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` date NULL DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 10, '用户管理界面', '用户管理界面', '/alluser_admin', NULL, NULL);
INSERT INTO `sys_menu` VALUES (2, 10, '权限赋予界面', '权限赋予界面', '/tosetpermission_admin', NULL, NULL);
INSERT INTO `sys_menu` VALUES (3, 10, '资源路径设置', '资源路径设置', '/tosetresource_admin', NULL, NULL);
INSERT INTO `sys_menu` VALUES (4, 11, '个人信息查询', '个人信息查询', '/user?username=', NULL, NULL);
INSERT INTO `sys_menu` VALUES (5, 11, '个人信息修改', '个人信息修改', '/toUpdatepage?username=', NULL, NULL);
INSERT INTO `sys_menu` VALUES (7, 12, '其他信息', '其他信息', '/otherinfo_other', NULL, NULL);
INSERT INTO `sys_menu` VALUES (8, 12, '留言板', '留言', '/toLeaveMessage_other', NULL, NULL);
INSERT INTO `sys_menu` VALUES (9, 12, '浏览数据统计', '浏览数据统计', '/scandata_other', NULL, NULL);
INSERT INTO `sys_menu` VALUES (10, 0, '角色信息', NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (11, 0, '用户信息', NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (12, 0, '其他', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '住建',
  `role_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名',
  `create_date` date NULL DEFAULT NULL COMMENT '创建人',
  `update_date` date NULL DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`role_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'ROLE_ADMIN', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role` VALUES (2, 'ROLE_USER', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role` VALUES (3, 'ROLE_NOUSER', NULL, NULL, NULL, NULL);
INSERT INTO `sys_role` VALUES (4, 'ROLE_OTHER', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `menu_id` int(11) NOT NULL COMMENT '菜单id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (1, 1, 1);
INSERT INTO `sys_role_menu` VALUES (2, 1, 10);

-- ----------------------------
-- Table structure for sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sys_user_id` int(11) NOT NULL,
  `sys_role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role_user
-- ----------------------------
INSERT INTO `sys_role_user` VALUES (4, 2, 2);
INSERT INTO `sys_role_user` VALUES (6, 4, 2);
INSERT INTO `sys_role_user` VALUES (10, 1, 1);
INSERT INTO `sys_role_user` VALUES (11, 1, 3);
INSERT INTO `sys_role_user` VALUES (12, 1, 4);
INSERT INTO `sys_role_user` VALUES (13, 1, 2);
INSERT INTO `sys_role_user` VALUES (14, 5, 1);
INSERT INTO `sys_role_user` VALUES (33, 27, 1);
INSERT INTO `sys_role_user` VALUES (34, 27, 2);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `pass_word` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `active` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活跃状态',
  `email` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `create_date` date NULL DEFAULT NULL COMMENT '创建时间',
  `update_date` date NULL DEFAULT NULL COMMENT '更新时间',
  `status` int(1) NULL DEFAULT 0 COMMENT '0,正常用户；1账户锁定',
  `try_count` int(1) NULL DEFAULT 0 COMMENT '尝试次数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', 'b2b29d633e77413dfb6ad5b398920007', '活跃', '1215618342@qq.com', NULL, '2018-07-24', NULL, 0, 0);
INSERT INTO `sys_user` VALUES (2, 'aaa', '5565263eb3bff5c6b47c930ae1982e65', '离线', '1215618342@qq.com', NULL, '2018-07-17', NULL, 0, 0);
INSERT INTO `sys_user` VALUES (4, 'ccc', '4b5cb2b601b469fa7b7863f691f3c50d', '离线', '34354@qq.com', NULL, '2018-07-09', NULL, 0, 0);
INSERT INTO `sys_user` VALUES (27, 'wangsr', '1f8e04685f5b081b8f432961a7553200', '活跃', '1215618342@qq.com', NULL, '2018-08-11', NULL, 0, 0);
INSERT INTO `sys_user` VALUES (28, 'helloA', '1860fef5c7a3dd91c3433df75bd8aebc', '活跃', '1215618342@qq.com', NULL, '2018-08-11', NULL, 0, 0);

SET FOREIGN_KEY_CHECKS = 1;
