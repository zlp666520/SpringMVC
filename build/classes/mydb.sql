/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : mydb

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 26/05/2023 22:45:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role` int(255) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('aa', '123', 0);
INSERT INTO `admin` VALUES ('bb', '123', 1);
INSERT INTO `admin` VALUES ('z', 'z', 1);
INSERT INTO `admin` VALUES ('dsa', 'dsa', 1);
INSERT INTO `admin` VALUES ('6', '6', 1);
INSERT INTO `admin` VALUES ('7', '7', 0);
INSERT INTO `admin` VALUES ('8', '8', 1);
INSERT INTO `admin` VALUES ('9', '9', 0);

-- ----------------------------
-- Table structure for health
-- ----------------------------
DROP TABLE IF EXISTS `health`;
CREATE TABLE `health`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `info_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'info表no字段',
  `body_info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身体情况',
  `date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '体检日期',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '体检情况表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of health
-- ----------------------------
INSERT INTO `health` VALUES (1, '1', '健康', '2023-04-25');
INSERT INTO `health` VALUES (2, '4', '患有高血压', '2023-04-24');
INSERT INTO `health` VALUES (3, '3', '发育不良', '2023-04-23');
INSERT INTO `health` VALUES (5, '5', '小脑发育不良', '2023-04-23');
INSERT INTO `health` VALUES (6, '6', '轻微症状身体不适', '2023-04-24');

-- ----------------------------
-- Table structure for info
-- ----------------------------
DROP TABLE IF EXISTS `info`;
CREATE TABLE `info`  (
  `no` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of info
-- ----------------------------
INSERT INTO `info` VALUES ('1', '2023-04-22', '李娜', '女', '39');
INSERT INTO `info` VALUES ('3', '2023-04-22', '张三', '男', '45');
INSERT INTO `info` VALUES ('4', '2023-04-21', 'dsadsa', '女', '23');
INSERT INTO `info` VALUES ('5', '2023-04-21', '王五', '男', '24');
INSERT INTO `info` VALUES ('6', '2023-04-20', '李四', '男', '43');

SET FOREIGN_KEY_CHECKS = 1;
