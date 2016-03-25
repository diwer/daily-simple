/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : daily_db

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2016-03-25 18:02:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `dy_daily`
-- ----------------------------
DROP TABLE IF EXISTS `dy_daily`;
CREATE TABLE `dy_daily` (
  `id` varchar(128) NOT NULL,
  `content` text,
  `isdelete` tinyint(4) NOT NULL COMMENT '1为删除，0为正常',
  `createdate` date DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL COMMENT '标题（预留）',
  `deletedate` date DEFAULT NULL,
  `userid` varchar(128) NOT NULL,
  `videourl` varchar(300) DEFAULT NULL,
  `audiourl` varchar(300) DEFAULT NULL,
  `likecount` int(11) DEFAULT '0',
  `Location` varchar(20) NOT NULL,
  `weather` varchar(40) NOT NULL,
  `tag` varchar(200) DEFAULT NULL COMMENT '(预留)',
  `dailystatus` tinyint(4) NOT NULL COMMENT '日记状态',
  `reportcount` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日记表';

-- ----------------------------
-- Records of dy_daily
-- ----------------------------
INSERT INTO `dy_daily` VALUES ('0af98964-9e98-4cef-8705-ad1fe4d99674', '这是一个内容', '0', '2016-03-21', null, null, 'b35916ff-e3f4-4f15-9a52-3f05255ee839', null, null, '0', '北京', '晴', null, '1', '0');
INSERT INTO `dy_daily` VALUES ('16267860-d8a6-487c-9012-c1ecd61c7acc', '这是一个内容', '0', '2016-03-18', null, null, 'b35916ff-e3f4-4f15-9a52-3f05255ee839', null, null, '0', '北京', '晴', null, '1', '0');
INSERT INTO `dy_daily` VALUES ('2e1b9e15-7483-4cbd-9458-0f15ef57dada', '123', '0', '2015-12-29', null, null, '123', null, null, '0', '', '', null, '0', '0');
INSERT INTO `dy_daily` VALUES ('58d4b19d-025b-4115-b1c0-ebb11c6546ab', '123', '0', '2016-01-05', null, null, '123', null, null, '0', '', '', null, '0', '0');
INSERT INTO `dy_daily` VALUES ('69f46028-dd1a-4e68-b542-161167373909', '这是一个内容', '0', '2016-03-18', null, null, 'b35916ff-e3f4-4f15-9a52-3f05255ee839', null, null, '0', '北京', '晴', null, '1', '0');
INSERT INTO `dy_daily` VALUES ('803e193a-8832-4c0e-9a2d-d5ffb0a669ca', '123', '0', '2015-12-29', null, null, '123', null, null, '0', '', '', null, '0', '0');
INSERT INTO `dy_daily` VALUES ('88ea977e-9d31-4ce5-ac57-ab9516debe75', '123', '0', '2016-01-05', null, null, '123', null, null, '0', '', '', null, '0', '0');
INSERT INTO `dy_daily` VALUES ('8b696f0a-c1ca-44b3-b7b2-6ef37e8fa17b', '123', '0', '2016-01-05', null, null, '123', null, null, '0', '', '', null, '0', '0');
INSERT INTO `dy_daily` VALUES ('bad8131c-7793-477b-909a-bea7d01024de', '这是一个内容', '0', '2016-03-18', null, null, 'b35916ff-e3f4-4f15-9a52-3f05255ee839', null, null, '0', '北京', '晴', null, '1', '0');
INSERT INTO `dy_daily` VALUES ('d0a22e79-f34b-4b27-8031-cdff54e4e57d', '我修改了内容', '0', '2016-03-18', null, null, 'b35916ff-e3f4-4f15-9a52-3f05255ee839', null, null, '0', '北京', '晴', null, '1', '0');
INSERT INTO `dy_daily` VALUES ('d80ed60c-75df-4d15-b7ae-5971bd763509', '这是一个内容', '0', '2016-03-21', null, null, 'b35916ff-e3f4-4f15-9a52-3f05255ee839', null, null, '0', '北京', '晴', null, '1', '0');
INSERT INTO `dy_daily` VALUES ('dc6d4fef-83c5-4322-bffc-29abcb26e906', '123', '0', '2015-12-29', null, null, '123', null, null, '0', '', '', null, '0', '0');

-- ----------------------------
-- Table structure for `dy_image`
-- ----------------------------
DROP TABLE IF EXISTS `dy_image`;
CREATE TABLE `dy_image` (
  `id` varchar(128) NOT NULL,
  `filename` varchar(255) DEFAULT NULL,
  `filepath` varchar(255) DEFAULT NULL,
  `orderno` int(11) DEFAULT NULL,
  `url` varchar(300) DEFAULT NULL,
  `isdelete` tinyint(4) DEFAULT NULL,
  `type` int(11) NOT NULL,
  `flagdesc` varchar(255) DEFAULT NULL,
  `usedId` varchar(128) DEFAULT NULL,
  `createtdate` datetime DEFAULT NULL,
  `createrid` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='图片表';

-- ----------------------------
-- Records of dy_image
-- ----------------------------
INSERT INTO `dy_image` VALUES ('ed57e89d-4aaa-48dc-a392-62a37958c8e7', '123', '123', '1', null, '0', '0', 'miaosu', '123', '2016-01-05 16:48:54', 'user');
INSERT INTO `dy_image` VALUES ('bd85bcaf-acea-4118-83c8-8533ae72c10d', '123', '123', '1', null, '0', '0', 'miaosu', '123', '2016-01-05 16:50:16', 'user');
INSERT INTO `dy_image` VALUES ('b4e2ce05-ad18-4cb6-829c-f06a28271a7f', '123', '123', '1', null, '0', '0', 'miaosu', '123', '2016-01-05 16:50:49', 'user');
INSERT INTO `dy_image` VALUES ('8e03bd7d-bfae-474b-b83f-f2be89140223', '123', '123', '1', null, '0', '0', 'miaosu', '123', '2016-01-05 16:51:35', 'user');
INSERT INTO `dy_image` VALUES ('d837955c-bb3b-4bd9-8bc6-05766a72accc', '123', '123', '1', null, '0', '0', 'miaosu', '123', '2016-01-05 16:51:43', 'user');
INSERT INTO `dy_image` VALUES ('9912ed24-3e55-4b5c-a3bc-faf95fad93d6', '123', '123', '1', null, '0', '0', 'miaosu', '123', '2016-01-05 16:52:21', 'user');
INSERT INTO `dy_image` VALUES ('dfa01cd2-ef80-4b20-b9bc-3e9dca6b92b1', '321', '123', '1', null, '0', '0', 'miaosu', '123', '2016-01-05 16:52:40', '0');

-- ----------------------------
-- Table structure for `dy_user`
-- ----------------------------
DROP TABLE IF EXISTS `dy_user`;
CREATE TABLE `dy_user` (
  `id` varchar(128) NOT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `email` varchar(32) NOT NULL,
  `password` varchar(128) NOT NULL,
  `createtime` date DEFAULT NULL,
  `lastlogintime` date DEFAULT NULL,
  `nickname` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of dy_user
-- ----------------------------
INSERT INTO `dy_user` VALUES ('019f57f7-b4bf-4ea0-81a7-8f73f4cd201c', null, 'test', 'test', '2016-01-05', '2016-01-05', null);
INSERT INTO `dy_user` VALUES ('0edd500f-f052-428a-91fc-2c4885af1154', null, 'test', 'test', '2016-01-05', '2016-01-05', null);
INSERT INTO `dy_user` VALUES ('2880c1b5-17f2-4d6d-ba86-c732f9cd5244', null, 'test', '123', '2016-01-05', '2016-01-05', null);
INSERT INTO `dy_user` VALUES ('321ad7b9-e971-434c-ae78-7acc07bab328', null, 'test', 'test', '2016-01-05', '2016-01-05', null);
INSERT INTO `dy_user` VALUES ('78e28641-be64-4d97-a0da-e9f218dc5185', null, 'test', '123', '2016-01-05', '2016-01-05', null);
INSERT INTO `dy_user` VALUES ('abd9dd1c-84ad-4768-89bd-483e6fe7b004', null, 'test', '123', '2016-01-05', '2016-01-05', null);
INSERT INTO `dy_user` VALUES ('b35916ff-e3f4-4f15-9a52-3f05255ee839', '13041110273', 'diwers@163.com', 'AE005CEB7E9A217CCED2F8AA354187C7', '2016-03-18', '2016-03-18', 'diwer');
