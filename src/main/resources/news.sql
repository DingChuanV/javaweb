/*
 Navicat Premium Data Transfer

 Source Server         : mysql5.7
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : localhost:3306
 Source Schema         : news

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 08/12/2021 14:09:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for news_category
-- ----------------------------
DROP TABLE IF EXISTS `news_category`;
CREATE TABLE `news_category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createdate` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of news_category
-- ----------------------------
INSERT INTO `news_category` VALUES (1, '国内', '2021-09-16 00:00:00');
INSERT INTO `news_category` VALUES (2, '国际', '2021-09-16 00:00:00');
INSERT INTO `news_category` VALUES (3, '娱乐', '2021-09-16 00:00:00');
INSERT INTO `news_category` VALUES (4, '军事', '2021-09-16 00:00:00');
INSERT INTO `news_category` VALUES (5, '财经', '2021-09-16 00:00:00');
INSERT INTO `news_category` VALUES (6, '天气', '2021-09-16 00:00:00');
INSERT INTO `news_category` VALUES (15, '水电费广东省', '2021-11-27 12:33:20');

-- ----------------------------
-- Table structure for news_comment
-- ----------------------------
DROP TABLE IF EXISTS `news_comment`;
CREATE TABLE `news_comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `newsId` int(10) NOT NULL,
  `content` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `author` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ip` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `createdate` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for news_detail
-- ----------------------------
DROP TABLE IF EXISTS `news_detail`;
CREATE TABLE `news_detail`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryId` int(11) NOT NULL,
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `summary` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `content` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `picpath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `author` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `createdate` datetime(0) DEFAULT NULL,
  `modifydate` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of news_detail
-- ----------------------------
INSERT INTO `news_detail` VALUES (1, 1, '孟晚舟顺利回到祖国？', '阿斯顿发送到', '阿斯蒂芬阿斯蒂', '2021年10月14日201857(2021-10-14-08-50-41).jpg', 'author', '2021-10-14 20:50:41', NULL);
INSERT INTO `news_detail` VALUES (3, 1, '按时发达撒打发斯蒂芬', '打发斯蒂芬', '阿斯顿发', '1138878(2021-10-14-09-22-42).jpg', 'author', '2021-10-14 21:22:42', NULL);
INSERT INTO `news_detail` VALUES (4, 1, '是大法官是地方改水电费1', '是大法官是电饭锅1', '<p>是地方改水电费1</p>\r\n', NULL, 'author222', '2021-10-16 21:15:47', NULL);
INSERT INTO `news_detail` VALUES (5, 1, 'as1234', 'asdfas', '<p>asdfasdf</p>\r\n', '3-1r1(2021-10-21-22-10-06).png', 'author', '2021-10-21 22:10:06', NULL);
INSERT INTO `news_detail` VALUES (6, 1, '阿斯', 'asdas', '<p>asdasdas</p>\r\n', '3-1r2(2021-10-21-22-10-23).png', 'author', '2021-10-21 22:10:23', NULL);
INSERT INTO `news_detail` VALUES (7, 1, 'as4567456', 'asdasrqwrqwrqw', '<p>阿斯蒂如果发生都搞啥</p>\r\n', 'boxplot(2021-10-21-22-10-51).png', 'author', '2021-10-21 22:10:51', NULL);
INSERT INTO `news_detail` VALUES (8, 1, 'as是大法官是地方改水电费', '是大法官是电饭锅', '是地方改水电费', 'wallhaven-x86lwv_1(2021-10-16-09-15-47).png', 'author', '2021-10-21 22:15:47', NULL);
INSERT INTO `news_detail` VALUES (9, 1, '孟晚舟顺利回到祖国2', '在党和人民亲切关怀和坚定支持下孟晚舟乘坐中国政府包机抵达深圳宝安国际机场顺利回到祖国。', '当地时间9月24日孟晚舟在不认罪不支付罚金的情况下离开加拿大踏上返回祖国的征程。', NULL, '新华网', '2021-10-22 22:16:59', NULL);
INSERT INTO `news_detail` VALUES (10, 2, '孟晚舟顺利回到祖国3', '阿斯顿发送到', '阿斯蒂芬阿斯蒂', '2021年10月14日201857(2021-10-14-08-50-41).jpg', 'author', '2021-10-14 20:50:41', NULL);
INSERT INTO `news_detail` VALUES (11, 2, '孟晚舟顺利回到祖国4', '阿斯顿发送到', '阿斯蒂芬阿斯蒂', '2021年10月14日201857(2021-10-14-08-50-41).jpg', 'author', '2021-10-14 20:50:41', NULL);
INSERT INTO `news_detail` VALUES (12, 2, '孟晚舟顺利回到祖国5', '阿斯顿发送到', '阿斯蒂芬阿斯蒂', '2021年10月14日201857(2021-10-14-08-50-41).jpg', 'author', '2021-10-14 20:50:41', NULL);
INSERT INTO `news_detail` VALUES (13, 2, 'as867876', '阿斯顿发送到', '阿斯蒂芬阿斯蒂', '2021年10月14日201857(2021-10-14-08-50-41).jpg', 'author', '2021-10-14 20:50:41', NULL);
INSERT INTO `news_detail` VALUES (14, 2, 'as9634534543', '阿斯顿发送到', '阿斯蒂芬阿斯蒂', '2021年10月14日201857(2021-10-14-08-50-41).jpg', 'author', '2021-10-14 20:50:41', NULL);
INSERT INTO `news_detail` VALUES (15, 2, 'as地方改水电费个', '阿斯顿发送到', '阿斯蒂芬阿斯蒂', '2021年10月14日201857(2021-10-14-08-50-41).jpg', 'author', '2021-10-14 20:50:41', NULL);
INSERT INTO `news_detail` VALUES (16, 1, 'qweqeqw', 'qwew', '<p>qwe</p>\r\n', NULL, 'author', '2021-11-11 15:31:55', NULL);
INSERT INTO `news_detail` VALUES (17, 1, 'zxc123', 'qweqw', '<p>qwe</p>\r\n', 'chrome(2021-11-11-15-33-31).exe', 'author', '2021-11-11 15:33:31', NULL);
INSERT INTO `news_detail` VALUES (18, 1, 'asd12312312', '', '', NULL, 'author', '2021-11-14 17:24:33', NULL);
INSERT INTO `news_detail` VALUES (19, 1, 'qwe6756', '', '', NULL, 'author', '2021-11-14 17:25:07', NULL);
INSERT INTO `news_detail` VALUES (20, 1, 'zxc123', '', '', NULL, 'author', '2021-11-14 17:26:32', NULL);
INSERT INTO `news_detail` VALUES (21, 1, 'jkghjgh', '', '', NULL, 'author', '2021-11-14 17:27:56', NULL);
INSERT INTO `news_detail` VALUES (25, 1, 'erger', '', '', NULL, '', '2021-11-27 11:51:30', NULL);
INSERT INTO `news_detail` VALUES (26, 1, 'erger', '', '', NULL, '', '2021-11-27 11:51:30', NULL);
INSERT INTO `news_detail` VALUES (27, 1, '1111', 'sdvsd', '<p>vzxcv</p>\r\n', NULL, 'ggh', '2021-11-27 11:52:56', NULL);
INSERT INTO `news_detail` VALUES (28, 1, '而和任何', '的双方各', '<p>二个人</p>\r\n', NULL, '电饭锅', '2021-11-27 12:00:42', NULL);

-- ----------------------------
-- Table structure for news_user
-- ----------------------------
DROP TABLE IF EXISTS `news_user`;
CREATE TABLE `news_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `usertype` tinyint(8) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of news_user
-- ----------------------------
INSERT INTO `news_user` VALUES (1, 'admin', 'admin', 'admin@bdqn.cn', 0);
INSERT INTO `news_user` VALUES (2, 'user', 'user', 'user@bdqn.cn', 1);
INSERT INTO `news_user` VALUES (3, 'user2', 'test2', 'test2@bdqn.cn', 0);
INSERT INTO `news_user` VALUES (18, 'user2', '1', 'qqwewq', 0);

SET FOREIGN_KEY_CHECKS = 1;
