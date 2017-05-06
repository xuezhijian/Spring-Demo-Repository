/*
 Navicat Premium Data Transfer

 Source Server         : myConnection
 Source Server Type    : MySQL
 Source Server Version : 50714
 Source Host           : localhost
 Source Database       : ZJboot_auxiliary_db

 Target Server Type    : MySQL
 Target Server Version : 50714
 File Encoding         : utf-8

 Date: 04/21/2017 21:19:29 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `student`
-- ----------------------------
BEGIN;
INSERT INTO `student` VALUES ('1', '学生1'), ('2', '学生2'), ('3', '学生3');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
