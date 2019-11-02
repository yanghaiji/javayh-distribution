/*
Navicat MySQL Data Transfer

Source Server         : DB-Mysql
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : db1

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-11-03 00:20:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_logistics
-- ----------------------------
DROP TABLE IF EXISTS `sys_logistics`;
CREATE TABLE `sys_logistics` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addressee_name` varchar(64) NOT NULL COMMENT ''收件人'',
  `addressee` varchar(256) NOT NULL COMMENT ''收件人地址'',
  `addressee_phone` int(11) NOT NULL,
  `sender_name` varchar(64) NOT NULL COMMENT ''寄件人'',
  `sender_add` varchar(256) NOT NULL COMMENT ''寄件人地址'',
  `ems_status` int(1) NOT NULL DEFAULT ''0'' COMMENT ''0,已接单，1,已发货，2，已签收'',
  `retreat_status` int(1) DEFAULT ''0'' COMMENT ''0,为退货，1，退货中，2，已退货'',
  `retreat_info` varchar(256) DEFAULT NULL COMMENT ''退货原因'',
  `create_date` date NOT NULL COMMENT ''创建时间'',
  `update_date` date DEFAULT NULL,
  `create_by` varchar(64) NOT NULL COMMENT ''操作人'',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_logistics
-- ----------------------------
INSERT INTO `sys_logistics` VALUES (''1'', ''yanghai'', ''北京'', ''1234565432'', ''dylan'', ''北京'', ''0'', ''0'', null, ''2019-11-02'', null, ''admin'');
INSERT INTO `sys_logistics` VALUES (''2'', ''yanghai'', ''北京'', ''1234565432'', ''dylan'', ''北京'', ''0'', ''0'', null, ''2019-11-02'', null, ''admin'');
INSERT INTO `sys_logistics` VALUES (''3'', ''yanghai'', ''北京'', ''1234565432'', ''dylan'', ''北京'', ''0'', ''0'', null, ''2019-11-02'', null, ''admin'');
INSERT INTO `sys_logistics` VALUES (''4'', ''yanghai'', ''北京'', ''1234565432'', ''dylan'', ''北京'', ''0'', ''0'', null, ''2019-11-02'', null, ''admin'');
INSERT INTO `sys_logistics` VALUES (''5'', ''yanghai'', ''北京'', ''1234565432'', ''dylan'', ''北京'', ''0'', ''0'', null, ''2019-11-02'', null, ''admin'');
INSERT INTO `sys_logistics` VALUES (''6'', ''yanghai'', ''北京'', ''1234565432'', ''dylan'', ''北京'', ''0'', ''0'', null, ''2019-11-02'', null, ''admin'');
INSERT INTO `sys_logistics` VALUES (''7'', ''yanghai'', ''北京'', ''1234565432'', ''dylan'', ''北京'', ''0'', ''0'', null, ''2019-11-02'', null, ''admin'');
INSERT INTO `sys_logistics` VALUES (''8'', ''yanghai'', ''北京'', ''1234565432'', ''dylan'', ''北京'', ''0'', ''0'', null, ''2019-11-02'', null, ''admin'');
INSERT INTO `sys_logistics` VALUES (''9'', ''yanghai'', ''北京'', ''1234565432'', ''dylan'', ''北京'', ''0'', ''0'', null, ''2019-11-02'', null, ''admin'');
INSERT INTO `sys_logistics` VALUES (''10'', ''yanghai'', ''北京'', ''1234565432'', ''dylan'', ''北京'', ''0'', ''0'', null, ''2019-11-02'', null, ''admin'');
INSERT INTO `sys_logistics` VALUES (''11'', ''yanghai'', ''北京'', ''1234565432'', ''dylan'', ''北京'', ''0'', ''0'', null, ''2019-11-02'', null, ''admin'');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `p_id` int(11) DEFAULT NULL COMMENT ''父id'',
  `menu_name` varchar(255) DEFAULT NULL COMMENT ''菜单名'',
  `description` varchar(255) DEFAULT NULL COMMENT ''描述'',
  `url` varchar(255) DEFAULT NULL COMMENT ''权限url'',
  `create_date` date DEFAULT NULL COMMENT ''创建时间'',
  `create_by` date DEFAULT NULL COMMENT ''创建人'',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (''1'', ''10'', ''用户管理界面'', ''用户管理界面'', ''/alluser_admin'', null, null);
INSERT INTO `sys_menu` VALUES (''2'', ''10'', ''权限赋予界面'', ''权限赋予界面'', ''/tosetpermission_admin'', null, null);
INSERT INTO `sys_menu` VALUES (''3'', ''10'', ''资源路径设置'', ''资源路径设置'', ''/tosetresource_admin'', null, null);
INSERT INTO `sys_menu` VALUES (''4'', ''11'', ''个人信息查询'', ''个人信息查询'', ''/user?username='', null, null);
INSERT INTO `sys_menu` VALUES (''5'', ''11'', ''个人信息修改'', ''个人信息修改'', ''/toUpdatepage?username='', null, null);
INSERT INTO `sys_menu` VALUES (''7'', ''12'', ''其他信息'', ''其他信息'', ''/otherinfo_other'', null, null);
INSERT INTO `sys_menu` VALUES (''8'', ''12'', ''留言板'', ''留言'', ''/toLeaveMessage_other'', null, null);
INSERT INTO `sys_menu` VALUES (''9'', ''12'', ''浏览数据统计'', ''浏览数据统计'', ''/scandata_other'', null, null);
INSERT INTO `sys_menu` VALUES (''10'', ''0'', ''角色信息'', ''角色信息'', null, null, null);
INSERT INTO `sys_menu` VALUES (''11'', ''0'', ''用户信息'', ''用户信息'', null, null, null);
INSERT INTO `sys_menu` VALUES (''12'', ''0'', ''其他'', ''其他'', null, null, null);
INSERT INTO `sys_menu` VALUES (''13'', ''0'', ''物流统计'', ''物流统计'', '''', null, null);
INSERT INTO `sys_menu` VALUES (''14'', ''0'', ''热点数据'', ''热点数据'', '''', null, null);
INSERT INTO `sys_menu` VALUES (''15'', ''13'', ''物流信息'', ''物流信息'', ''/logistics_info'', null, null);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT ''住建'',
  `role_name` varchar(40) NOT NULL COMMENT ''角色名'',
  `create_date` date DEFAULT NULL COMMENT ''创建人'',
  `update_date` date DEFAULT NULL COMMENT ''修改时间'',
  `create_by` varchar(64) DEFAULT NULL COMMENT ''创建人'',
  `update_by` varchar(64) DEFAULT NULL COMMENT ''修改人'',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `name` (`role_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (''1'', ''ROLE_ADMIN'', null, null, null, null);
INSERT INTO `sys_role` VALUES (''2'', ''ROLE_USER'', null, null, null, null);
INSERT INTO `sys_role` VALUES (''3'', ''ROLE_NOUSER'', null, null, null, null);
INSERT INTO `sys_role` VALUES (''4'', ''ROLE_OTHER'', null, null, null, null);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL COMMENT ''角色id'',
  `menu_id` int(11) NOT NULL COMMENT ''菜单id'',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (''1'', ''1'', ''1'');
INSERT INTO `sys_role_menu` VALUES (''2'', ''1'', ''10'');
INSERT INTO `sys_role_menu` VALUES (''3'', ''1'', ''2'');
INSERT INTO `sys_role_menu` VALUES (''4'', ''1'', ''3'');
INSERT INTO `sys_role_menu` VALUES (''5'', ''1'', ''4'');
INSERT INTO `sys_role_menu` VALUES (''6'', ''1'', ''5'');
INSERT INTO `sys_role_menu` VALUES (''7'', ''1'', ''6'');
INSERT INTO `sys_role_menu` VALUES (''8'', ''1'', ''7'');
INSERT INTO `sys_role_menu` VALUES (''9'', ''1'', ''8'');
INSERT INTO `sys_role_menu` VALUES (''10'', ''1'', ''9'');
INSERT INTO `sys_role_menu` VALUES (''11'', ''1'', ''11'');
INSERT INTO `sys_role_menu` VALUES (''12'', ''1'', ''12'');
INSERT INTO `sys_role_menu` VALUES (''13'', ''1'', ''13'');
INSERT INTO `sys_role_menu` VALUES (''14'', ''1'', ''14'');
INSERT INTO `sys_role_menu` VALUES (''15'', ''1'', ''15'');

-- ----------------------------
-- Table structure for sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sys_user_id` int(11) NOT NULL,
  `sys_role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of sys_role_user
-- ----------------------------
INSERT INTO `sys_role_user` VALUES (''4'', ''2'', ''2'');
INSERT INTO `sys_role_user` VALUES (''6'', ''4'', ''2'');
INSERT INTO `sys_role_user` VALUES (''10'', ''1'', ''1'');
INSERT INTO `sys_role_user` VALUES (''11'', ''1'', ''3'');
INSERT INTO `sys_role_user` VALUES (''12'', ''1'', ''4'');
INSERT INTO `sys_role_user` VALUES (''13'', ''1'', ''2'');
INSERT INTO `sys_role_user` VALUES (''14'', ''5'', ''1'');
INSERT INTO `sys_role_user` VALUES (''33'', ''27'', ''1'');
INSERT INTO `sys_role_user` VALUES (''34'', ''27'', ''2'');
INSERT INTO `sys_role_user` VALUES (''35'', ''36'', ''1'');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT ''主键'',
  `user_name` varchar(255) DEFAULT NULL COMMENT ''用户名'',
  `pass_word` varchar(255) DEFAULT NULL COMMENT ''密码'',
  `active` varchar(255) DEFAULT NULL COMMENT ''活跃状态'',
  `email` varchar(32) DEFAULT NULL COMMENT ''邮箱'',
  `phone` varchar(11) DEFAULT NULL COMMENT ''手机号'',
  `create_date` date DEFAULT NULL COMMENT ''创建时间'',
  `update_date` date DEFAULT NULL COMMENT ''更新时间'',
  `status` int(1) DEFAULT ''0'' COMMENT ''0,正常用户；1账户锁定'',
  `try_count` int(1) DEFAULT ''0'' COMMENT ''尝试次数'',
  `del_flag` int(1) DEFAULT ''0'' COMMENT ''0 未删除 1 已删除'',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (''1'', ''admin'', ''3fa3886a9be344ce7cf66ba200955795'', ''活跃'', ''1215618321@qq.com'', ''11111111111'', ''2018-07-24'', ''2019-11-02'', ''0'', ''0'', ''0'');
INSERT INTO `sys_user` VALUES (''36'', ''yanghj'', ''51f47f80d6928a650f2ce6ec474bb500'', ''活跃'', ''1111@qq.com'', ''11111111111'', ''2019-11-02'', ''2019-11-02'', ''0'', ''0'', ''0'');
