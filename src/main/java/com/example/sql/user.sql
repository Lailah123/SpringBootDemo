/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50644
 Source Host           : 60.205.184.214:3306
 Source Schema         : redis

 Target Server Type    : MySQL
 Target Server Version : 50644
 File Encoding         : 65001

 Date: 29/02/2020 13:57:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (23, 'hahaha123123', 'hahaha1212');
INSERT INTO `user` VALUES (24, 'hahaha222', 'hahaha333');
INSERT INTO `user` VALUES (26, '123', '666');
INSERT INTO `user` VALUES (27, '123', '444');
INSERT INTO `user` VALUES (28, '123123', '123123');
INSERT INTO `user` VALUES (29, '123123', '123123');
INSERT INTO `user` VALUES (30, '123', '123');
INSERT INTO `user` VALUES (35, '阿萨德', 'asd');
INSERT INTO `user` VALUES (36, '阿萨德', 'asd123');
INSERT INTO `user` VALUES (38, '123', '123');
INSERT INTO `user` VALUES (39, '123', '123');
INSERT INTO `user` VALUES (40, '123', '123');
INSERT INTO `user` VALUES (41, '234', '234');
INSERT INTO `user` VALUES (43, '234', '23412');
INSERT INTO `user` VALUES (47, '123', '123');
INSERT INTO `user` VALUES (49, '123', '123');
INSERT INTO `user` VALUES (50, '123', '123');
INSERT INTO `user` VALUES (52, '123', '123');
INSERT INTO `user` VALUES (53, '123', '123');
INSERT INTO `user` VALUES (56, '123', '123');
INSERT INTO `user` VALUES (57, '123', '123');
INSERT INTO `user` VALUES (60, '英吹思婷', '123123');
INSERT INTO `user` VALUES (61, '789', '789');
INSERT INTO `user` VALUES (62, '789', '789');
INSERT INTO `user` VALUES (63, '132', ' 请问678');
INSERT INTO `user` VALUES (64, '123', '123678678678');
INSERT INTO `user` VALUES (65, '123', '123123');
INSERT INTO `user` VALUES (66, '123', '123');
INSERT INTO `user` VALUES (67, '123', '123');
INSERT INTO `user` VALUES (68, '123', '123123');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
