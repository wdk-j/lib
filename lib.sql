/*
 Navicat Premium Data Transfer

 Source Server         : mypc
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : lib

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 07/07/2020 08:49:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `bid` int(10) NOT NULL AUTO_INCREMENT COMMENT '图书编号',
  `bname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书名称',
  `baddress` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出版社',
  `bauthor` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作者',
  `bdate` date NULL DEFAULT NULL COMMENT '出版日期',
  `bprice` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `bindate` date NULL DEFAULT NULL COMMENT '入库日期',
  `binnumber` int(10) NULL DEFAULT NULL COMMENT '入库数量',
  `bnumber` int(10) NULL DEFAULT NULL COMMENT '现存数量',
  PRIMARY KEY (`bid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 190140 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (190102, '标准日本语（初级上）', '人民教育出版社', '光村图书出版株式会社', '2007-08-01', 28.90, '2019-12-01', 100, 100);
INSERT INTO `book` VALUES (190103, '标准日本语（初级下）', '人民教育出版社', '光村图书出版株式会社', '2007-08-01', 28.80, '2019-12-01', 100, 100);
INSERT INTO `book` VALUES (190104, '代谢增长论', '北京大学出版社', '陈平', '2019-01-01', 100.00, '2019-12-01', 100, 100);
INSERT INTO `book` VALUES (190105, '货币金融学', '中国人民大学出版社', '弗雷德里克·S·米什金', '2016-12-01', 64.00, '2019-12-01', 100, 100);
INSERT INTO `book` VALUES (190106, '微观经济学', '上海人民出版社', '哈尔·R.范里安', '2015-01-01', 65.00, '2019-12-01', 100, 100);
INSERT INTO `book` VALUES (190107, '进击的局座：悄悄话3', '长江文艺出版社', '张召忠', '2018-12-01', 42.00, '2019-12-01', 100, 100);
INSERT INTO `book` VALUES (190108, '进击的局座：悄悄话2', '长江文艺出版社', '张召忠', '2017-08-01', 42.00, '2019-12-01', 100, 100);
INSERT INTO `book` VALUES (190109, '进击的局座', '长江文艺出版社', '张召忠', '2016-11-01', 42.00, '2019-12-01', 100, 99);
INSERT INTO `book` VALUES (190110, '失踪的孩子', '人民文学出版社', '[意] 埃莱娜·费兰特', '2018-06-01', 62.00, '2019-12-01', 100, 100);
INSERT INTO `book` VALUES (190111, '论自由', '广西师范大学出版社', '[英] 约翰·穆勒', '2011-09-01', 32.00, '2019-12-01', 100, 100);
INSERT INTO `book` VALUES (190112, '经济学的思维方式', '四川人民出版社', '[美]托马斯索维尔', '2018-08-01', 79.10, '2019-12-01', 100, 100);
INSERT INTO `book` VALUES (190113, '经济学原理', '南海出版社', '阿尔佛雷德·马歇尔', '2010-07-01', 49.80, '2019-12-01', 100, 100);
INSERT INTO `book` VALUES (190141, '新华字典', '出版社', '出版社', '2014-07-06', 100.00, '2020-07-06', 10, 10);

-- ----------------------------
-- Table structure for book_borrowing
-- ----------------------------
DROP TABLE IF EXISTS `book_borrowing`;
CREATE TABLE `book_borrowing`  (
  `number` int(10) NOT NULL AUTO_INCREMENT COMMENT '任务序号',
  `bid` int(10) NULL DEFAULT NULL COMMENT '借阅书号',
  `bname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '借阅书名',
  `uid` int(10) NULL DEFAULT NULL COMMENT '借阅人编号',
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '读者账号',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '读者姓名',
  `startdate` date NULL DEFAULT NULL COMMENT '借阅日期',
  `enddate` date NULL DEFAULT NULL COMMENT '应还日期',
  PRIMARY KEY (`number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 94 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_borrowing
-- ----------------------------
INSERT INTO `book_borrowing` VALUES (95, 190109, '进击的局座', 2, 'admin', '王大可', '2020-07-06', '2020-08-06');

-- ----------------------------
-- Table structure for book_history
-- ----------------------------
DROP TABLE IF EXISTS `book_history`;
CREATE TABLE `book_history`  (
  `number` int(10) NOT NULL AUTO_INCREMENT COMMENT '任务序号',
  `bid` int(10) NULL DEFAULT NULL COMMENT '借阅书号',
  `bname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '书名',
  `uid` int(10) NULL DEFAULT NULL COMMENT '借阅人编号',
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '读者账号',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '读者姓名',
  `startdate` date NULL DEFAULT NULL COMMENT '借阅日期',
  `enddate` date NULL DEFAULT NULL COMMENT '应还日期',
  `truedate` date NULL DEFAULT NULL COMMENT '实际还书日期',
  `fine` decimal(10, 0) NULL DEFAULT NULL COMMENT '罚款金额',
  PRIMARY KEY (`number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 91 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_history
-- ----------------------------
INSERT INTO `book_history` VALUES (1, 190103, '标准日本语（初级下）', 2, 'admin', '王大可', '2020-07-04', '2020-08-04', '2020-07-06', 0);
INSERT INTO `book_history` VALUES (2, 190111, '论自由', 2, 'admin', '王大可', '2020-07-04', '2020-08-04', '2020-07-06', 50);
INSERT INTO `book_history` VALUES (3, 190111, '论自由', 2, 'admin', '王大可', '2020-07-05', '2020-08-05', '2020-07-07', 0);
INSERT INTO `book_history` VALUES (4, 190102, '标准日本语（初级上）', 17, '202077', '测试用例', '2020-07-06', '2020-08-06', '2020-07-07', 50);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '读者姓名',
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '性别',
  `telephone` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话',
  `state` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态：已启用/已停用',
  `power` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户权限：读者/管理员',
  PRIMARY KEY (`uid`, `username`) USING BTREE,
  INDEX `username`(`username`, `name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '20175347', '20175347', '读者测试', '男', '18026314365', '已启用', '读者');
INSERT INTO `user` VALUES (2, 'admin', 'admin', '管理员测试', '男', '18026314365', '已启用', '管理员');
INSERT INTO `user` VALUES (16, '20170000', '20170000', '测试人员', '男', '123456789', '已启用', '读者');
INSERT INTO `user` VALUES (17, '202077', '123456', '测试用例', '男', '20200707', '已启用', '读者');
INSERT INTO `user` VALUES (18, 'admin2', '1234', '管理员2', '男', '1234', '已启用', '管理员');

-- ----------------------------
-- Triggers structure for table book_borrowing
-- ----------------------------
DROP TRIGGER IF EXISTS `借阅图书数量-1`;
delimiter ;;
CREATE TRIGGER `借阅图书数量-1` AFTER INSERT ON `book_borrowing` FOR EACH ROW update book
set bnumber=bnumber-1
where bid=new.bid
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table book_borrowing
-- ----------------------------
DROP TRIGGER IF EXISTS ` 归还图书数量+1`;
delimiter ;;
CREATE TRIGGER ` 归还图书数量+1` AFTER DELETE ON `book_borrowing` FOR EACH ROW update book
set bnumber=bnumber+1
where bid=old.bid
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
