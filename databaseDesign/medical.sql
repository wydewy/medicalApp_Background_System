/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : medical

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2016-11-01 22:21:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for appointment
-- ----------------------------
DROP TABLE IF EXISTS `appointment`;
CREATE TABLE `appointment` (
  `id` char(36) NOT NULL,
  `doctorId` char(36) NOT NULL,
  `customerId` char(36) NOT NULL,
  `realseId` char(36) NOT NULL,
  `idCard` varchar(20) DEFAULT NULL,
  `type` tinyint(4) DEFAULT NULL,
  `sectionName` varchar(20) DEFAULT NULL,
  `outpatientName` varchar(20) DEFAULT NULL,
  `appointDate` datetime DEFAULT NULL,
  `cost` double(10,2) DEFAULT NULL,
  `telephone` varchar(11) DEFAULT NULL,
  `customerName` varchar(10) DEFAULT NULL,
  `doctorName` varchar(10) DEFAULT NULL,
  `sectionArea` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `a_doctor` (`doctorId`),
  KEY `a_customer` (`customerId`),
  KEY `FK_releaseId` (`realseId`),
  CONSTRAINT `FK_releaseId` FOREIGN KEY (`realseId`) REFERENCES `releasenum` (`realseId`) ON DELETE CASCADE,
  CONSTRAINT `a_customer` FOREIGN KEY (`customerId`) REFERENCES `customer` (`customerId`) ON DELETE CASCADE,
  CONSTRAINT `a_doctor` FOREIGN KEY (`doctorId`) REFERENCES `doctor` (`doctorId`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of appointment
-- ----------------------------

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customerId` char(36) NOT NULL,
  `picHead` varchar(20) DEFAULT NULL,
  `customerName` varchar(20) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `nickName` varchar(20) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `idCard` varchar(20) DEFAULT NULL,
  `phone` char(11) DEFAULT NULL,
  `customerAdrr` varchar(255) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `remarks` varchar(300) DEFAULT NULL,
  `isMarried` tinyint(4) DEFAULT NULL,
  `job` varchar(20) DEFAULT NULL,
  `nation` varchar(20) DEFAULT NULL,
  `birthPlace` varchar(50) DEFAULT NULL,
  `residence` varchar(50) DEFAULT NULL,
  `workplace` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`customerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('4f0e5020-2afb-4587-ad03-16cb1db6a137', null, 'csj', null, null, null, '23', '123', null, '123', null, null, null, null, null, null, null);
INSERT INTO `customer` VALUES ('8725de73-2e26-4db6-9a28-bb703d872375', '', 'qjk', '30', 'Roc-J', '1', '140564199002012218', '123', '北京邮电大学', '123456', '第一条数据', '0', '研究僧', '山西', '山西', '北京', '北京');
INSERT INTO `customer` VALUES ('a478311b-3efe-49d4-a999-b779316156c4', '', '秦君', '30', 'Roc-J', '1', '140564199002012218', '15652912457', '北京邮电大学', '123456', '第一条数据', '0', '研究僧', '山西', '山西', '北京', '北京');
INSERT INTO `customer` VALUES ('be23bfb2-9a73-48d2-a308-fe4655901725', '', '秦君', '30', 'Roc-J', '1', '140564199002012218', '15652912457', '北京邮电大学', '123456', '第一条数据', '0', '研究僧', '山西', '山西', '北京', '北京');

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor` (
  `doctorId` char(36) NOT NULL,
  `outpatientId` char(36) NOT NULL,
  `picHead` varchar(30) DEFAULT NULL,
  `doctorName` varchar(30) DEFAULT NULL,
  `position` varchar(20) DEFAULT NULL,
  `special` varchar(30) DEFAULT NULL,
  `section` varchar(30) DEFAULT NULL,
  `doctorIntro` varchar(300) DEFAULT NULL,
  `flag` tinyint(4) DEFAULT NULL,
  `sex` char(2) DEFAULT NULL,
  `graduInstitution` varchar(20) DEFAULT NULL,
  `tutorQualification` varchar(20) DEFAULT NULL,
  `degree` varchar(10) DEFAULT NULL,
  `marjor` varchar(10) DEFAULT NULL,
  `partTimeAcademic` varchar(255) DEFAULT NULL,
  `certificateHold` varchar(20) DEFAULT NULL,
  `isFamilyDoc` tinyint(4) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `relNubCount` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`doctorId`),
  KEY `FK_outpatient` (`outpatientId`),
  CONSTRAINT `FK_outpatient` FOREIGN KEY (`outpatientId`) REFERENCES `outpatient` (`outpatientId`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of doctor
-- ----------------------------
INSERT INTO `doctor` VALUES ('2f869097-31fc-44c8-ac92-ff516faa3bf3', '22222', '', '张平', '主治医生', '擅长外科手术', '外科', '医生简介', '2', '男', '医科大', '有从业导师资格证', '硕士', '外科', null, '国家一级证书', null, null, '100');
INSERT INTO `doctor` VALUES ('333', '22222', '23232', '张平', '2323', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `doctor` VALUES ('622160d1-4c9b-46ff-8072-2176c1e955e7', '22222', '', '张平', '主治医生', '擅长外科手术', '外科', '医生简介', '2', '男', '医科大', '有从业导师资格证', '硕士', '外科', null, '国家一级证书', null, null, '100');

-- ----------------------------
-- Table structure for hospital
-- ----------------------------
DROP TABLE IF EXISTS `hospital`;
CREATE TABLE `hospital` (
  `hosId` char(36) NOT NULL,
  `hosName` varchar(30) DEFAULT NULL,
  `hosGrade` varchar(30) DEFAULT NULL,
  `hosAddr` varchar(50) DEFAULT NULL,
  `hosTel` varchar(20) DEFAULT NULL,
  `hosIntro` varchar(300) DEFAULT NULL,
  `hosUrl` varchar(30) DEFAULT NULL,
  `dean` varchar(30) DEFAULT NULL,
  `deanIntro` varchar(300) DEFAULT NULL,
  `hosTraffic` varchar(255) DEFAULT NULL,
  `hosSpecial` varchar(50) DEFAULT NULL,
  `hosEstablished` date DEFAULT NULL,
  PRIMARY KEY (`hosId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hospital
-- ----------------------------
INSERT INTO `hospital` VALUES ('00000', '123', '123', '123', '123', '123', '123', '123', '123', '123', '123', '2016-10-18');
INSERT INTO `hospital` VALUES ('12a5d91d-bf85-4ef6-a27a-88db928a375d', '北京协和医院', '三甲医院', '东城区东单帅府园1号(东院)', '010-43545556', '北京协和医院的简介', 'www.xiehe.com', '王俊', '北京协和医院院长简介', '交通情况101,102,103,104,105', '特色科室有儿科，外科，等等.', null);
INSERT INTO `hospital` VALUES ('1a70694a-b425-42e3-8e09-451d66237363', '北京协和医院', '三甲医院', '东城区东单帅府园1号(东院)', '010-43545556', '北京协和医院的简介', 'www.xiehe.com', '王俊', '北京协和医院院长简介', '交通情况101,102,103,104,105', '***特色科室有儿科，外科，等等.', null);
INSERT INTO `hospital` VALUES ('25f9d793-4a16-4564-b6cb-98bdcba38261', '北京协和医院', '三甲医院', '东城区东单帅府园1号(东院)', '010-43545556', '北京协和医院的简介', 'www.xiehe.com', '王俊', '北京协和医院院长简介', '交通情况101,102,103,104,105', '特色科室有儿科，外科，等等.', null);
INSERT INTO `hospital` VALUES ('3a589127-c82a-4b9d-824b-63b02541af7d', '北京协和医院', '三甲医院', '东城区东单帅府园1号(东院)', '010-43545556', '北京协和医院的简介', 'www.xiehe.com', '王俊', '北京协和医院院长简介', '交通情况101,102,103,104,105', '特色科室有儿科，外科，等等.', null);
INSERT INTO `hospital` VALUES ('921ca47b-fee2-419e-8ac9-9ae7f1435d26', '北京海淀区社区医院', '三甲医院', '北京海淀区西土城路XX号', '010-4354555', '北京海淀区社区医院简介：北京市海淀区社区医院成立于1990年。', 'www.bjhdsqhospital.com', '康德俊凯', '北京海淀区社区医院-院长简介', '交通情况101,102,103,104,105', '特色科室有儿科，外科，等等.', '1990-01-01');
INSERT INTO `hospital` VALUES ('b3f26645-0d36-4b6e-8cdf-077352a7b25f', '北京协和医院', '三甲医院', '东城区东单帅府园1号(东院)', '010-43545556', '北京协和医院的简介', 'www.xiehe.com', '王俊', '北京协和医院院长简介', '交通情况101,102,103,104,105', '特色科室有儿科，外科，等等.', null);
INSERT INTO `hospital` VALUES ('de1cf5b7-bfe3-49e7-8a13-7b3889e3e328', '北京协和医院', '三甲医院', '东城区东单帅府园1号(东院)', '010-43545556', '北京协和医院的简介', 'www.xiehe.com', '王俊', '北京协和医院院长简介', '交通情况101,102,103,104,105', '特色科室有儿科，外科，等等.', null);
INSERT INTO `hospital` VALUES ('e47716fd-13dc-416a-820b-70a815bf0d2b', '北京协和医院', '三甲医院', '东城区东单帅府园1号(东院)', '010-43545556', '北京协和医院的简介', 'www.xiehe.com', '王俊', '北京协和医院院长简介', '交通情况101,102,103,104,105', '特色科室有儿科，外科，等等.', null);

-- ----------------------------
-- Table structure for interest
-- ----------------------------
DROP TABLE IF EXISTS `interest`;
CREATE TABLE `interest` (
  `id` char(36) NOT NULL,
  `customerId` char(36) DEFAULT NULL,
  `doctorId` char(36) DEFAULT NULL,
  `hosId` char(36) DEFAULT NULL,
  `idCard` varchar(20) DEFAULT NULL,
  `type` tinyint(4) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `1_customerId` (`customerId`),
  KEY `1_doctorId` (`doctorId`),
  KEY `1_hosId` (`hosId`),
  CONSTRAINT `1_customerId` FOREIGN KEY (`customerId`) REFERENCES `customer` (`customerId`) ON DELETE CASCADE,
  CONSTRAINT `1_doctorId` FOREIGN KEY (`doctorId`) REFERENCES `doctor` (`doctorId`) ON DELETE CASCADE,
  CONSTRAINT `1_hosId` FOREIGN KEY (`hosId`) REFERENCES `hospital` (`hosId`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of interest
-- ----------------------------

-- ----------------------------
-- Table structure for outpatient
-- ----------------------------
DROP TABLE IF EXISTS `outpatient`;
CREATE TABLE `outpatient` (
  `outpatientId` char(36) NOT NULL,
  `outpatientName` varchar(20) DEFAULT NULL,
  `sectionId` char(36) DEFAULT NULL,
  `sectionName` varchar(20) DEFAULT NULL,
  `doctorName` varchar(30) DEFAULT NULL,
  `outpatientLoc` varchar(30) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `telephone` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`outpatientId`),
  KEY `S_sectionId` (`sectionId`),
  CONSTRAINT `S_sectionId` FOREIGN KEY (`sectionId`) REFERENCES `section` (`sectionId`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of outpatient
-- ----------------------------
INSERT INTO `outpatient` VALUES ('22222', null, '11111', null, null, null, null, null);
INSERT INTO `outpatient` VALUES ('49fa063e-0c36-4591-9187-73f77c4a696a', '呼吸内科普通门诊', 'cbd3c4d3-db44-4f6c-b530-9db42f1f7c5c', '呼吸内科', null, '门诊部呼吸内科普通门诊三层', '100', '010-2244567');
INSERT INTO `outpatient` VALUES ('af6f5d91-2ef3-4063-8ff2-cacdd3ceb1df', '神经内科普通门诊', 'f64f2b1b-bc0f-4069-9101-e92ce53d7c73', '神经内科', null, '门诊部神经内科普通门诊二层', '100', '010-2344565');
INSERT INTO `outpatient` VALUES ('d0d485e7-9e77-4ba3-8043-a2a049c94d42', '呼吸内科专家坐诊门诊', 'cbd3c4d3-db44-4f6c-b530-9db42f1f7c5c', '呼吸内科', null, '门诊部呼吸内科专家坐诊门诊三层', '50', '010-2244566');
INSERT INTO `outpatient` VALUES ('f87fd060-e1eb-45c3-b863-8dbc8fba0765', '神经内科专家坐诊门诊', 'f64f2b1b-bc0f-4069-9101-e92ce53d7c73', '神经内科', null, '门诊部神经内科专家坐诊门诊三层', '50', '010-2344566');

-- ----------------------------
-- Table structure for releasenum
-- ----------------------------
DROP TABLE IF EXISTS `releasenum`;
CREATE TABLE `releasenum` (
  `realseId` varchar(36) NOT NULL,
  `doctorId` varchar(36) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `isSuccess` tinyint(4) DEFAULT NULL,
  `isFamilyNum` int(11) DEFAULT NULL,
  `week` varchar(10) DEFAULT NULL,
  `ampm` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`realseId`),
  KEY `r_doctorid` (`doctorId`),
  KEY `realseId` (`realseId`),
  CONSTRAINT `r_doctorid` FOREIGN KEY (`doctorId`) REFERENCES `doctor` (`doctorId`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of releasenum
-- ----------------------------

-- ----------------------------
-- Table structure for section
-- ----------------------------
DROP TABLE IF EXISTS `section`;
CREATE TABLE `section` (
  `sectionId` char(36) NOT NULL,
  `hosId` char(36) DEFAULT NULL,
  `sectionCode` varchar(20) DEFAULT NULL,
  `sectionName` varchar(30) DEFAULT NULL,
  `sectionIntro` varchar(200) DEFAULT NULL,
  `sectionPic` varchar(255) DEFAULT NULL,
  `sectionLoc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sectionId`),
  KEY `d_hosId` (`hosId`) USING BTREE,
  CONSTRAINT `d_hosId` FOREIGN KEY (`hosId`) REFERENCES `hospital` (`hosId`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of section
-- ----------------------------
INSERT INTO `section` VALUES ('11111', '00000', null, null, null, null, null);
INSERT INTO `section` VALUES ('48aa4fb8-9cbd-4b75-b312-427093953fd2', '921ca47b-fee2-419e-8ac9-9ae7f1435d26', '0000005', '肾内科', '科室介绍:关于北京市海淀区社区医院肾内科的简介。', null, '第一主楼八楼肾内科');
INSERT INTO `section` VALUES ('94fac27d-fbf0-461e-8d2c-707dafc3a08a', '921ca47b-fee2-419e-8ac9-9ae7f1435d26', '0000004', '心血管内科', '科室介绍:关于北京市海淀区社区医院心血管内科的简介。', null, '第二主楼八楼心血管内科');
INSERT INTO `section` VALUES ('9d9db5ad-d665-4be9-860e-30f4d4916651', '921ca47b-fee2-419e-8ac9-9ae7f1435d26', '0000002', '消化内科', '科室介绍:关于北京市海淀区社区医院消化内科的简介。', null, '第二主楼四楼消化内科');
INSERT INTO `section` VALUES ('cbd3c4d3-db44-4f6c-b530-9db42f1f7c5c', '921ca47b-fee2-419e-8ac9-9ae7f1435d26', '0000001', '呼吸内科', '科室介绍:关于北京市海淀区社区医院呼吸内科的简介。', null, '第二主楼三楼呼吸内科');
INSERT INTO `section` VALUES ('f64f2b1b-bc0f-4069-9101-e92ce53d7c73', '921ca47b-fee2-419e-8ac9-9ae7f1435d26', '0000003', '神经内科', '科室介绍:关于北京市海淀区社区医院神经内科的简介。', null, '第二主楼五楼神经内科');
