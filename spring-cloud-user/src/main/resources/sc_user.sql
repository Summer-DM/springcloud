/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : springclouddemo

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 20/08/2021 15:29:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sc_user
-- ----------------------------
DROP TABLE IF EXISTS `sc_user`;
CREATE TABLE `sc_user`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键id',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `birthday` date NULL DEFAULT NULL COMMENT '用户出生年月',
  `sex` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户性别',
  `age` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户年龄',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户家庭住址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sc_user
-- ----------------------------
INSERT INTO `sc_user` VALUES ('1427158549582163969', '夏呆毛', 'e10adc3949ba59abbe56e057f20f883e', NULL, NULL, NULL, NULL);
INSERT INTO `sc_user` VALUES ('1427455944907853825', '陈星宇', 'e10adc3949ba59abbe56e057f20f883e', NULL, NULL, NULL, NULL);
INSERT INTO `sc_user` VALUES ('1427465220464439298', '牛魔王', 'e10adc3949ba59abbe56e057f20f883e', NULL, NULL, NULL, NULL);
INSERT INTO `sc_user` VALUES ('1427507723565568001', '鲁班大师', 'e10adc3949ba59abbe56e057f20f883e', '1997-02-12', '男', '25', '北京市昌平区回龙观');
INSERT INTO `sc_user` VALUES ('1427800575717732353', '鲁班', 'e10adc3949ba59abbe56e057f20f883e', '1996-04-12', '男', '25', '北京市昌平区回龙观');
INSERT INTO `sc_user` VALUES ('1427800805896941570', '澜', 'e10adc3949ba59abbe56e057f20f883e', '1996-04-12', '男', '25', '北京市昌平区回龙观');
INSERT INTO `sc_user` VALUES ('1427800856702545921', '吕布', 'e10adc3949ba59abbe56e057f20f883e', '1996-04-12', '男', '25', '北京市昌平区回龙观');
INSERT INTO `sc_user` VALUES ('1427800928618082305', '貂蝉', 'e10adc3949ba59abbe56e057f20f883e', '1996-04-12', '女', '25', '北京市昌平区回龙观');
INSERT INTO `sc_user` VALUES ('1427801016354533377', '瑶', 'fcea920f7412b5da7be0cf42b8c93759', '1996-04-12', '女', '25', '北京市昌平区回龙观');
INSERT INTO `sc_user` VALUES ('1427801060759629826', '王昭君', 'fcea920f7412b5da7be0cf42b8c93759', '1996-04-12', '女', '21', '北京市昌平区回龙观');
INSERT INTO `sc_user` VALUES ('1427801119303725058', '娜可露露', 'fcea920f7412b5da7be0cf42b8c93759', '1999-04-12', '女', '21', '北京市昌平区回龙观');
INSERT INTO `sc_user` VALUES ('1427801249486532609', '钟无艳', 'fcea920f7412b5da7be0cf42b8c93759', '1999-04-12', '女', '21', '北京市昌平区回龙观');

SET FOREIGN_KEY_CHECKS = 1;
