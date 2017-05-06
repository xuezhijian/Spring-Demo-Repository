/*
 Navicat Premium Data Transfer

 Source Server         : myConnection
 Source Server Type    : MySQL
 Source Server Version : 50714
 Source Host           : localhost
 Source Database       : ZJboot_primary_db

 Target Server Type    : MySQL
 Target Server Version : 50714
 File Encoding         : utf-8

 Date: 04/21/2017 21:19:15 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `city`
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='市级信息';

-- ----------------------------
--  Records of `city`
-- ----------------------------
BEGIN;
INSERT INTO `city` VALUES ('1', '石家庄', '河北'), ('2', '邯郸', '河北');
COMMIT;

-- ----------------------------
--  Table structure for `country`
-- ----------------------------
DROP TABLE IF EXISTS `country`;
CREATE TABLE `country` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `countryname` varchar(255) DEFAULT NULL COMMENT '名称',
  `countrycode` varchar(255) DEFAULT NULL COMMENT '代码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=187 DEFAULT CHARSET=utf8 COMMENT='国家信息';

-- ----------------------------
--  Records of `country`
-- ----------------------------
BEGIN;
INSERT INTO `country` VALUES ('1', 'Angola', 'AO'), ('2', 'Afghanistan', 'AF'), ('3', 'Albania', 'AL'), ('4', 'Algeria', 'DZ'), ('5', 'Andorra', 'AD'), ('6', 'Anguilla', 'AI'), ('7', 'Antigua and Barbuda', 'AG'), ('8', 'Argentina', 'AR'), ('9', 'Armenia', 'AM'), ('10', 'Australia', 'AU'), ('11', 'Austria', 'AT'), ('12', 'Azerbaijan', 'AZ'), ('13', 'Bahamas', 'BS'), ('14', 'Bahrain', 'BH'), ('15', 'Bangladesh', 'BD'), ('16', 'Barbados', 'BB'), ('17', 'Belarus', 'BY'), ('18', 'Belgium', 'BE'), ('19', 'Belize', 'BZ'), ('20', 'Benin', 'BJ'), ('21', 'Bermuda Is.', 'BM'), ('22', 'Bolivia', 'BO'), ('23', 'Botswana', 'BW'), ('24', 'Brazil', 'BR'), ('25', 'Brunei', 'BN'), ('26', 'Bulgaria', 'BG'), ('27', 'Burkina-faso', 'BF'), ('28', 'Burma', 'MM'), ('29', 'Burundi', 'BI'), ('30', 'Cameroon', 'CM'), ('31', 'Canada', 'CA'), ('32', 'Central African Republic', 'CF'), ('33', 'Chad', 'TD'), ('34', 'Chile', 'CL'), ('35', 'China', 'CN'), ('36', 'Colombia', 'CO'), ('37', 'Congo', 'CG'), ('38', 'Cook Is.', 'CK'), ('39', 'Costa Rica', 'CR'), ('40', 'Cuba', 'CU'), ('41', 'Cyprus', 'CY'), ('42', 'Czech Republic', 'CZ'), ('43', 'Denmark', 'DK'), ('44', 'Djibouti', 'DJ'), ('45', 'Dominica Rep.', 'DO'), ('46', 'Ecuador', 'EC'), ('47', 'Egypt', 'EG'), ('48', 'EI Salvador', 'SV'), ('49', 'Estonia', 'EE'), ('50', 'Ethiopia', 'ET'), ('51', 'Fiji', 'FJ'), ('52', 'Finland', 'FI'), ('53', 'France', 'FR'), ('54', 'French Guiana', 'GF'), ('55', 'Gabon', 'GA'), ('56', 'Gambia', 'GM'), ('57', 'Georgia', 'GE'), ('58', 'Germany', 'DE'), ('59', 'Ghana', 'GH'), ('60', 'Gibraltar', 'GI'), ('61', 'Greece', 'GR'), ('62', 'Grenada', 'GD'), ('63', 'Guam', 'GU'), ('64', 'Guatemala', 'GT'), ('65', 'Guinea', 'GN'), ('66', 'Guyana', 'GY'), ('67', 'Haiti', 'HT'), ('68', 'Honduras', 'HN'), ('69', 'Hongkong', 'HK'), ('70', 'Hungary', 'HU'), ('71', 'Iceland', 'IS'), ('72', 'India', 'IN'), ('73', 'Indonesia', 'ID'), ('74', 'Iran', 'IR'), ('75', 'Iraq', 'IQ'), ('76', 'Ireland', 'IE'), ('77', 'Israel', 'IL'), ('78', 'Italy', 'IT'), ('79', 'Jamaica', 'JM'), ('80', 'Japan', 'JP'), ('81', 'Jordan', 'JO'), ('82', 'Kampuchea (Cambodia )', 'KH'), ('83', 'Kazakstan', 'KZ'), ('84', 'Kenya', 'KE'), ('85', 'Korea', 'KR'), ('86', 'Kuwait', 'KW'), ('87', 'Kyrgyzstan', 'KG'), ('88', 'Laos', 'LA'), ('89', 'Latvia', 'LV'), ('90', 'Lebanon', 'LB'), ('91', 'Lesotho', 'LS'), ('92', 'Liberia', 'LR'), ('93', 'Libya', 'LY'), ('94', 'Liechtenstein', 'LI'), ('95', 'Lithuania', 'LT'), ('96', 'Luxembourg', 'LU'), ('97', 'Macao', 'MO'), ('98', 'Madagascar', 'MG'), ('99', 'Malawi', 'MW'), ('100', 'Malaysia', 'MY'), ('101', 'Maldives', 'MV'), ('102', 'Mali', 'ML'), ('103', 'Malta', 'MT'), ('104', 'Mauritius', 'MU'), ('105', 'Mexico', 'MX'), ('106', 'Moldova, Republic of', 'MD'), ('107', 'Monaco', 'MC'), ('108', 'Mongolia', 'MN'), ('109', 'Montserrat Is', 'MS'), ('110', 'Morocco', 'MA'), ('111', 'Mozambique', 'MZ'), ('112', 'Namibia', 'NA'), ('113', 'Nauru', 'NR'), ('114', 'Nepal', 'NP'), ('115', 'Netherlands', 'NL'), ('116', 'New Zealand', 'NZ'), ('117', 'Nicaragua', 'NI'), ('118', 'Niger', 'NE'), ('119', 'Nigeria', 'NG'), ('120', 'North Korea', 'KP'), ('121', 'Norway', 'NO'), ('122', 'Oman', 'OM'), ('123', 'Pakistan', 'PK'), ('124', 'Panama', 'PA'), ('125', 'Papua New Cuinea', 'PG'), ('126', 'Paraguay', 'PY'), ('127', 'Peru', 'PE'), ('128', 'Philippines', 'PH'), ('129', 'Poland', 'PL'), ('130', 'French Polynesia', 'PF'), ('131', 'Portugal', 'PT'), ('132', 'Puerto Rico', 'PR'), ('133', 'Qatar', 'QA'), ('134', 'Romania', 'RO'), ('135', 'Russia', 'RU'), ('136', 'Saint Lueia', 'LC'), ('137', 'Saint Vincent', 'VC'), ('138', 'San Marino', 'SM'), ('139', 'Sao Tome and Principe', 'ST'), ('140', 'Saudi Arabia', 'SA'), ('141', 'Senegal', 'SN'), ('142', 'Seychelles', 'SC'), ('143', 'Sierra Leone', 'SL'), ('144', 'Singapore', 'SG'), ('145', 'Slovakia', 'SK'), ('146', 'Slovenia', 'SI'), ('147', 'Solomon Is', 'SB'), ('148', 'Somali', 'SO'), ('149', 'South Africa', 'ZA'), ('150', 'Spain', 'ES'), ('151', 'Sri Lanka', 'LK'), ('152', 'St.Lucia', 'LC'), ('153', 'St.Vincent', 'VC'), ('154', 'Sudan', 'SD'), ('155', 'Suriname', 'SR'), ('156', 'Swaziland', 'SZ'), ('157', 'Sweden', 'SE'), ('158', 'Switzerland', 'CH'), ('159', 'Syria', 'SY'), ('160', 'Taiwan', 'TW'), ('161', 'Tajikstan', 'TJ'), ('162', 'Tanzania', 'TZ'), ('163', 'Thailand', 'TH'), ('164', 'Togo', 'TG'), ('165', 'Tonga', 'TO'), ('166', 'Trinidad and Tobago', 'TT'), ('167', 'Tunisia', 'TN'), ('168', 'Turkey', 'TR'), ('169', 'Turkmenistan', 'TM'), ('170', 'Uganda', 'UG'), ('171', 'Ukraine', 'UA'), ('172', 'United Arab Emirates', 'AE'), ('173', 'United Kiongdom', 'GB'), ('174', 'United States of America', 'US'), ('175', 'Uruguay', 'UY'), ('176', 'Uzbekistan', 'UZ'), ('177', 'Venezuela', 'VE'), ('178', 'Vietnam', 'VN'), ('179', 'Yemen', 'YE'), ('180', 'Yugoslavia', 'YU'), ('181', 'Zimbabwe', 'ZW'), ('182', 'Zaire', 'ZR'), ('186', 'Zambia', 'ZM');
COMMIT;

-- ----------------------------
--  Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `usertype` varchar(2) DEFAULT NULL COMMENT '用户类型',
  `enabled` int(2) DEFAULT NULL COMMENT '是否可用',
  `realname` varchar(32) DEFAULT NULL COMMENT '真实姓名',
  `qq` varchar(14) DEFAULT NULL COMMENT 'QQ',
  `email` varchar(100) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL COMMENT '联系电话',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
--  Records of `user_info`
-- ----------------------------
BEGIN;
INSERT INTO `user_info` VALUES ('1', 'test1', '12345678', '1', null, null, null, null, null), ('2', 'test2', 'aaaa', '2', null, null, null, null, null), ('3', 'test3', 'bbbb', '1', null, null, null, null, null), ('4', 'test4', 'cccc', '2', null, null, null, null, null), ('5', 'test5', 'dddd', '1', null, null, null, null, null);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
