/*
 Navicat Premium Data Transfer

 Source Server         : [01] 127.0.0.1 localhost 8.0 root
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : ry_vue

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 17/03/2023 15:29:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for diy_user
-- ----------------------------
DROP TABLE IF EXISTS `diy_user`;
CREATE TABLE `diy_user`  (
  `user_id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户ID（主键）',
  `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `user_area_id` bigint NULL DEFAULT NULL COMMENT '用户区域表外键',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '自定义Demo用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of diy_user
-- ----------------------------
INSERT INTO `diy_user` VALUES (1, 'lemon', 1, 'Nicolas·Lemon', '2023-03-17 13:54:09', 'Nicolas·Lemon', '2023-03-17 13:54:09', NULL);
INSERT INTO `diy_user` VALUES (2, 'tom', 5, 'Nicolas·Lemon', '2023-03-17 13:54:09', 'Nicolas·Lemon', '2023-03-17 13:54:09', NULL);
INSERT INTO `diy_user` VALUES (3, 'uncle·mo', 3, 'Nicolas·Lemon', '2023-03-17 13:54:09', 'Nicolas·Lemon', '2023-03-17 13:54:09', NULL);
INSERT INTO `diy_user` VALUES (4, 'old·mo', 4, 'Nicolas·Lemon', '2023-03-17 14:02:40', 'Nicolas·Lemon', '2023-03-17 14:02:40', NULL);
INSERT INTO `diy_user` VALUES (5, 'qi·qiang', 2, 'Nicolas·Lemon', '2023-03-17 14:03:38', 'Nicolas·Lemon', '2023-03-17 14:03:38', NULL);

-- ----------------------------
-- Table structure for diy_user_area
-- ----------------------------
DROP TABLE IF EXISTS `diy_user_area`;
CREATE TABLE `diy_user_area`  (
  `area_id` bigint NOT NULL AUTO_INCREMENT COMMENT '区域ID（主键）',
  `area_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区域名称',
  PRIMARY KEY (`area_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '自定义Demo用户区域表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of diy_user_area
-- ----------------------------
INSERT INTO `diy_user_area` VALUES (1, '湖北');
INSERT INTO `diy_user_area` VALUES (2, '湖南');
INSERT INTO `diy_user_area` VALUES (3, '海南');
INSERT INTO `diy_user_area` VALUES (4, '深圳');
INSERT INTO `diy_user_area` VALUES (5, '广州');

SET FOREIGN_KEY_CHECKS = 1;
