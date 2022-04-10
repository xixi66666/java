/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50558
Source Host           : localhost:3306
Source Database       : blog_database

Target Server Type    : MYSQL
Target Server Version : 50558
File Encoding         : 65001

Date: 2022-03-18 15:05:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `agree_history`
-- ----------------------------
DROP TABLE IF EXISTS `agree_history`;
CREATE TABLE `agree_history` (
  `user` bigint(20) NOT NULL,
  `blog` bigint(20) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`user`),
  KEY `blog_idx` (`blog`),
  CONSTRAINT `blog` FOREIGN KEY (`blog`) REFERENCES `blog_info` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of agree_history
-- ----------------------------

-- ----------------------------
-- Table structure for `blog_info`
-- ----------------------------
DROP TABLE IF EXISTS `blog_info`;
CREATE TABLE `blog_info` (
  `ID` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `tag` varchar(100) DEFAULT NULL,
  `title` varchar(64) NOT NULL,
  `content` varchar(800) NOT NULL,
  `comment_num` bigint(20) NOT NULL,
  `date` datetime NOT NULL,
  `views` bigint(20) NOT NULL,
  `agree_num` bigint(20) NOT NULL,
  `picture` longblob,
  `up` int(11) NOT NULL,
  `keyword` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `user_id_idx` (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`User_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_info
-- ----------------------------

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `user1` bigint(20) NOT NULL,
  `blog_id` bigint(20) NOT NULL,
  `agree_num` bigint(20) NOT NULL,
  `date` datetime NOT NULL,
  `content` varchar(800) NOT NULL,
  `baba_id` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `blog_id_idx` (`blog_id`),
  KEY `baba_id_idx` (`baba_id`),
  KEY `user1_idx` (`user1`),
  CONSTRAINT `baba_id` FOREIGN KEY (`baba_id`) REFERENCES `comment` (`ID`),
  CONSTRAINT `blog_id` FOREIGN KEY (`blog_id`) REFERENCES `blog_info` (`ID`),
  CONSTRAINT `user1` FOREIGN KEY (`user1`) REFERENCES `user_info` (`User_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for `draft`
-- ----------------------------
DROP TABLE IF EXISTS `draft`;
CREATE TABLE `draft` (
  `ID` bigint(20) NOT NULL,
  `user` bigint(20) NOT NULL,
  `title` varchar(64) NOT NULL,
  `content` varchar(800) NOT NULL,
  `picture` longblob,
  `date` datetime NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of draft
-- ----------------------------

-- ----------------------------
-- Table structure for `fans`
-- ----------------------------
DROP TABLE IF EXISTS `fans`;
CREATE TABLE `fans` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `fan` bigint(20) NOT NULL,
  `user` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fan_idx` (`fan`),
  CONSTRAINT `fan` FOREIGN KEY (`fan`) REFERENCES `user_info` (`User_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fans
-- ----------------------------

-- ----------------------------
-- Table structure for `friends`
-- ----------------------------
DROP TABLE IF EXISTS `friends`;
CREATE TABLE `friends` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `friend_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `friend_status` varchar(24) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `friend_id_idx` (`friend_id`),
  CONSTRAINT `friend_id` FOREIGN KEY (`friend_id`) REFERENCES `user_info` (`User_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of friends
-- ----------------------------

-- ----------------------------
-- Table structure for `message`
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `sender` bigint(20) NOT NULL,
  `receiver` bigint(20) NOT NULL,
  `content` varchar(800) NOT NULL,
  `picture` longblob,
  `time` datetime NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `sender_idx` (`sender`),
  KEY `receiver_idx` (`receiver`),
  CONSTRAINT `receiver` FOREIGN KEY (`receiver`) REFERENCES `user_info` (`User_ID`),
  CONSTRAINT `sender` FOREIGN KEY (`sender`) REFERENCES `user_info` (`User_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------

-- ----------------------------
-- Table structure for `sort`
-- ----------------------------
DROP TABLE IF EXISTS `sort`;
CREATE TABLE `sort` (
  `ID` bigint(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(200) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sort
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_info`
-- ----------------------------
DROP TABLE IF EXISTS `sys_info`;
CREATE TABLE `sys_info` (
  `sys_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `receiver` bigint(20) DEFAULT NULL,
  `all_users` int(11) NOT NULL,
  `content` varchar(800) NOT NULL,
  PRIMARY KEY (`sys_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_info
-- ----------------------------

-- ----------------------------
-- Table structure for `tag`
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `description` varchar(200) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tag
-- ----------------------------

-- ----------------------------
-- Table structure for `user_attention`
-- ----------------------------
DROP TABLE IF EXISTS `user_attention`;
CREATE TABLE `user_attention` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `attention_id` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `attention_id_idx` (`attention_id`),
  CONSTRAINT `attention_id` FOREIGN KEY (`attention_id`) REFERENCES `user_info` (`User_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_attention
-- ----------------------------

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `User_ID` bigint(20) NOT NULL,
  `User_name` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `sex` int(11) NOT NULL,
  `email` varchar(64) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `firstname` varchar(4) NOT NULL,
  `lastname` varchar(8) NOT NULL,
  `head` longblob NOT NULL,
  `is_admin` int(11) NOT NULL,
  `last_login` datetime DEFAULT NULL,
  `register_me` longblob,
  `level` int(11) DEFAULT NULL,
  `experience` int(11) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `freeze_id` int(11) NOT NULL,
  `status` varchar(24) DEFAULT NULL,
  `freeze_comment` int(11) NOT NULL,
  `freeze_friend` int(11) NOT NULL,
  PRIMARY KEY (`User_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
