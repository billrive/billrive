CREATE DATABASE  IF NOT EXISTS `billrivedbtest` 	
USE `billrivedbtest`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: billrivedbtest
-- ------------------------------------------------------
-- Server version	5.6.16

	
	
	
	
	
	
	
	
	
	

--
-- Table structure for table `balance`
--

DROP TABLE IF EXISTS `balance`;
	
	
CREATE TABLE `balance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId_gets` bigint(20) DEFAULT NULL,
  `userId_gives` bigint(20) DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
	

--
-- Dumping data for table `balance`
--

LOCK TABLES `balance` WRITE;
	
INSERT INTO `balance` VALUES (1,6,7,1090.90),(2,6,8,12.90),(3,7,8,9.80);
	
UNLOCK TABLES;

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
	
	
CREATE TABLE `bill` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `billPayerId` bigint(20) NOT NULL,
  `notes` varchar(100) DEFAULT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `billCreaterId` bigint(20) NOT NULL,
  `billDate` timestamp NULL DEFAULT NULL,
  `billTotal` decimal(10,2) DEFAULT NULL,
  `billSimpleEntryId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `billSimpleEntryId_UNIQUE` (`billSimpleEntryId`),
  KEY `fk_bill_groups1_idx` (`groupId`),
  KEY `fk_bill_user1_idx` (`billPayerId`),
  CONSTRAINT `FK_bill_billsimpleentry` FOREIGN KEY (`billSimpleEntryId`) REFERENCES `billsimpleentry` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_bill_user` FOREIGN KEY (`billPayerId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_bill_groups` FOREIGN KEY (`groupId`) REFERENCES `groups` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=latin1;
	

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
	
INSERT INTO `bill` VALUES (5,'Travel',6,NULL,4,6,'2013-08-14 02:09:54',50.00,5),(30,'Rent',6,NULL,3,6,'2013-10-02 06:00:00',900.00,23),(35,'Sprouts Farmers market',6,'Return Organic milk bottle',3,6,'2013-12-30 07:00:00',30.00,28),(36,'Movies',7,NULL,3,6,'2014-01-01 07:00:00',30.00,29),(45,'TestAddBill',7,NULL,4,6,'2014-03-17 21:08:44',560.00,49);
	
UNLOCK TABLES;

--
-- Table structure for table `billitementry`
--

DROP TABLE IF EXISTS `billitementry`;
	
	
CREATE TABLE `billitementry` (
  `itemTitle` varchar(200) DEFAULT NULL,
  `itemDescription` text,
  `billId` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_billitementry_bill1_idx` (`billId`),
  CONSTRAINT `fk_billitementry_bill` FOREIGN KEY (`billId`) REFERENCES `bill` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
	

--
-- Dumping data for table `billitementry`
--

LOCK TABLES `billitementry` WRITE;
	
	
UNLOCK TABLES;

--
-- Table structure for table `billsimpleentry`
--

DROP TABLE IF EXISTS `billsimpleentry`;
	
	
CREATE TABLE `billsimpleentry` (
  `itemTitle` varchar(200) DEFAULT NULL,
  `itemDescription` text,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `fk_bill_idx` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=latin1;
	

--
-- Dumping data for table `billsimpleentry`
--

LOCK TABLES `billsimpleentry` WRITE;
	
INSERT INTO `billsimpleentry` VALUES ('simple',NULL,2),('simpe',NULL,4),('simple',NULL,5),(NULL,NULL,11),(NULL,NULL,12),(NULL,NULL,13),(NULL,NULL,14),(NULL,NULL,15),(NULL,NULL,16),(NULL,NULL,17),(NULL,NULL,18),(NULL,NULL,19),(NULL,NULL,20),(NULL,NULL,21),(NULL,NULL,22),(NULL,NULL,23),(NULL,NULL,24),(NULL,NULL,25),(NULL,NULL,26),(NULL,NULL,27),(NULL,NULL,28),(NULL,NULL,29),(NULL,NULL,30),(NULL,NULL,36),(NULL,'SimpleTestAddBill',49);
	
UNLOCK TABLES;

--
-- Table structure for table `groups`
--

DROP TABLE IF EXISTS `groups`;
	
	
CREATE TABLE `groups` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `description` text,
  `ownerId` bigint(20) DEFAULT NULL,
  `isActive` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
	

--
-- Dumping data for table `groups`
--

LOCK TABLES `groups` WRITE;
	
INSERT INTO `groups` VALUES (3,'SLC',NULL,6,1),(4,'Office-IHC',NULL,6,1),(5,'Friends',NULL,6,1),(6,'Shiny New Group','no description for this pool ol',NULL,1);
	
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
	
	
CREATE TABLE `payment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `payerId` bigint(20) NOT NULL,
  `receiverId` bigint(20) NOT NULL,
  `paydate` timestamp NULL DEFAULT NULL,
  `paidAmount` bigint(20) NOT NULL,
  `notes` text,
  `groupId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_payerId_idx` (`payerId`),
  KEY `fk_receiverId_idx` (`receiverId`),
  KEY `FK_l0jsfq5aivo6fbr8kip7emfew` (`groupId`),
  CONSTRAINT `FK_l0jsfq5aivo6fbr8kip7emfew` FOREIGN KEY (`groupId`) REFERENCES `groups` (`id`),
  CONSTRAINT `fk_payerId` FOREIGN KEY (`payerId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_receiverId` FOREIGN KEY (`receiverId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
	

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
	
INSERT INTO `payment` VALUES (1,6,7,NULL,50,NULL,3),(2,7,8,NULL,25,NULL,3),(3,7,8,NULL,15,NULL,3);
	
UNLOCK TABLES;

--
-- Table structure for table `simpleuseridandliablecost`
--

DROP TABLE IF EXISTS `simpleuseridandliablecost`;
	
	
CREATE TABLE `simpleuseridandliablecost` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL,
  `liableCost` decimal(10,2) DEFAULT NULL,
  `billSimpleEntryId` bigint(20) DEFAULT NULL,
  `isActive` tinyint(1) DEFAULT NULL,
  `liableCostDiff` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_simpleuseridandliablecost_user1_idx` (`userId`),
  KEY `FK_sagu1ixi3u2i0v64mapu4lj5a` (`billSimpleEntryId`),
  CONSTRAINT `FK_simpleuseridandliablecost_billsimpleentry` FOREIGN KEY (`billSimpleEntryId`) REFERENCES `billsimpleentry` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_simpleuseridandliablecost_user` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=latin1;
	

--
-- Dumping data for table `simpleuseridandliablecost`
--

LOCK TABLES `simpleuseridandliablecost` WRITE;
	
INSERT INTO `simpleuseridandliablecost` VALUES (10,6,20.00,2,1,NULL),(11,7,20.00,2,1,NULL),(12,8,10.00,2,1,NULL),(13,6,15.70,4,1,NULL),(14,7,20.00,4,1,NULL),(15,6,1.00,2,1,NULL),(16,7,1.00,2,1,NULL),(17,8,1.00,2,1,NULL),(18,6,5.00,NULL,1,NULL),(19,7,5.00,NULL,1,NULL),(20,8,5.00,NULL,1,NULL),(21,6,44.00,NULL,1,NULL),(22,7,45.00,NULL,1,NULL),(23,8,545.00,NULL,1,NULL),(24,6,20.00,NULL,1,NULL),(25,7,20.00,NULL,1,NULL),(26,8,20.00,NULL,1,NULL),(27,6,500.00,NULL,1,NULL),(28,7,500.00,NULL,1,NULL),(29,8,0.00,NULL,0,NULL),(30,6,20.00,NULL,1,NULL),(31,7,20.00,NULL,1,NULL),(32,8,20.00,NULL,1,NULL),(33,6,20.00,11,1,NULL),(34,7,20.00,11,1,NULL),(35,8,20.00,11,1,NULL),(36,6,5.00,12,1,NULL),(37,7,5.00,12,1,NULL),(38,8,5.00,12,1,NULL),(39,6,20.00,13,1,NULL),(40,7,20.00,13,1,NULL),(41,8,20.00,13,1,NULL),(42,6,20.00,14,1,NULL),(43,7,20.00,14,1,NULL),(44,8,20.00,14,1,NULL),(45,6,20.00,15,1,NULL),(46,7,20.00,15,1,NULL),(47,8,20.00,15,1,NULL),(48,6,20.00,16,1,NULL),(49,7,20.00,16,1,NULL),(50,8,20.00,16,1,NULL),(51,6,20.00,17,1,NULL),(52,7,20.00,17,1,NULL),(53,8,20.00,17,1,NULL),(54,6,5.00,18,1,NULL),(55,7,5.00,18,1,NULL),(56,8,5.00,18,1,NULL),(57,6,2.00,19,1,NULL),(58,7,2.00,19,1,NULL),(59,8,2.00,19,1,NULL),(60,6,33.33,20,1,NULL),(61,7,33.33,20,1,NULL),(62,8,33.38,20,1,NULL),(63,6,20.00,21,1,NULL),(64,7,20.00,21,1,NULL),(65,8,20.00,21,1,NULL),(66,6,20.00,22,1,NULL),(67,7,20.00,22,1,NULL),(68,8,20.00,22,1,NULL),(69,6,300.00,23,1,NULL),(70,7,300.00,23,1,NULL),(71,8,300.00,23,1,NULL),(72,6,25.00,24,1,NULL),(73,7,30.00,24,1,NULL),(74,8,20.00,24,1,NULL),(75,6,300.00,25,1,NULL),(76,7,300.00,25,1,NULL),(77,8,300.00,25,1,NULL),(78,6,25.00,26,1,NULL),(79,7,25.00,26,1,NULL),(80,8,0.00,26,0,NULL),(81,6,10.00,27,1,NULL),(82,7,10.00,27,1,NULL),(83,8,10.00,27,1,NULL),(84,6,10.00,28,1,NULL),(85,7,10.00,28,1,NULL),(86,8,10.00,28,1,NULL),(87,6,10.00,29,1,NULL),(88,7,10.00,29,1,NULL),(89,8,10.00,29,1,NULL),(90,6,300.00,30,1,NULL),(91,7,300.00,30,1,NULL),(92,8,300.00,30,1,NULL),(108,6,3.00,36,1,NULL),(109,7,3.00,36,1,NULL),(110,8,3.00,36,1,NULL),(119,6,25.00,5,1,NULL),(120,7,25.00,5,1,NULL),(131,6,280.00,49,1,5.00),(132,7,280.00,49,1,5.00);
	
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
	
	
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fName` varchar(100) DEFAULT NULL,
  `lName` varchar(100) DEFAULT NULL,
  `mName` varchar(100) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
	

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
	
INSERT INTO `user` VALUES (6,'Bruce','Wayne',NULL,NULL,'me@prashu.net',NULL,1),(7,'Peter','Parker',NULL,NULL,'jayanthk4u@gmail.com',NULL,1),(8,'Clark','Kent',NULL,NULL,'kkathari@gmail.com',NULL,1);
	
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
	
	
CREATE TABLE `user_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_user_role` (`userId`),
  KEY `fk_user_role_idx` (`userId`),
  CONSTRAINT `fk_userId` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
	

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
	
	
UNLOCK TABLES;

--
-- Table structure for table `userfriendmap`
--

DROP TABLE IF EXISTS `userfriendmap`;
	
	
CREATE TABLE `userfriendmap` (
  `user_id` bigint(20) NOT NULL,
  `friend_id` bigint(20) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_user_has_user_user2_idx` (`friend_id`),
  KEY `fk_user_has_user_user1_idx` (`user_id`),
  CONSTRAINT `fk_user_has_user_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_user_user2` FOREIGN KEY (`friend_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
	

--
-- Dumping data for table `userfriendmap`
--

LOCK TABLES `userfriendmap` WRITE;
	
INSERT INTO `userfriendmap` VALUES (6,7,1),(6,8,2),(7,8,3);
	
UNLOCK TABLES;

--
-- Table structure for table `usergroupmap`
--

DROP TABLE IF EXISTS `usergroupmap`;
	
	
CREATE TABLE `usergroupmap` (
  `groups_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_groups_has_user_user1_idx` (`user_id`),
  KEY `fk_groups_has_user_groups1_idx` (`groups_id`),
  CONSTRAINT `fk_groups_has_user_groups1` FOREIGN KEY (`groups_id`) REFERENCES `groups` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_groups_has_user_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
	

--
-- Dumping data for table `usergroupmap`
--

LOCK TABLES `usergroupmap` WRITE;
	
INSERT INTO `usergroupmap` VALUES (3,6,1),(3,7,2),(3,8,3),(4,6,4),(4,7,5),(5,6,6),(5,8,7);
	
UNLOCK TABLES;

--
-- Table structure for table `useridandliablecost`
--

DROP TABLE IF EXISTS `useridandliablecost`;
	
	
CREATE TABLE `useridandliablecost` (
  `userId` bigint(20) DEFAULT NULL,
  `liableCost` decimal(10,2) DEFAULT NULL,
  `billItemEntryId` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_useridandliablecost_billitementry1_idx` (`billItemEntryId`),
  KEY `fk_useridandliablecost_userId_idx` (`userId`),
  CONSTRAINT `fk_useridandliablecost_billitementry` FOREIGN KEY (`billItemEntryId`) REFERENCES `billitementry` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_useridandliablecost_userId` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
	

--
-- Dumping data for table `useridandliablecost`
--

LOCK TABLES `useridandliablecost` WRITE;
	
	
UNLOCK TABLES;
	

	
	
	
	
	
	
	

-- Dump completed on 2014-03-17 16:31:39
CREATE DATABASE  IF NOT EXISTS `billrivedb` 	
USE `billrivedb`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: billrivedb
-- ------------------------------------------------------
-- Server version	5.6.16

	
	
	
	
	
	
	
	
	
	

--
-- Table structure for table `balance`
--

DROP TABLE IF EXISTS `balance`;
	
	
CREATE TABLE `balance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId_gets` bigint(20) DEFAULT NULL,
  `userId_gives` bigint(20) DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
	

--
-- Dumping data for table `balance`
--

LOCK TABLES `balance` WRITE;
	
INSERT INTO `balance` VALUES (1,6,7,10.50),(2,6,8,12.90),(3,7,8,9.80);
	
UNLOCK TABLES;

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
	
	
CREATE TABLE `bill` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `billPayerId` bigint(20) NOT NULL,
  `notes` varchar(100) DEFAULT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `billCreaterId` bigint(20) NOT NULL,
  `billDate` timestamp NULL DEFAULT NULL,
  `billTotal` decimal(10,2) DEFAULT NULL,
  `billSimpleEntryId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `billSimpleEntryId_UNIQUE` (`billSimpleEntryId`),
  KEY `fk_bill_groups1_idx` (`groupId`),
  KEY `fk_bill_user1_idx` (`billPayerId`),
  KEY `FK_4e6dfgs9volhxbvrfxdbnrc83` (`billSimpleEntryId`),
  CONSTRAINT `FK_bill_billsimpleentry` FOREIGN KEY (`billSimpleEntryId`) REFERENCES `billsimpleentry` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_bill_user` FOREIGN KEY (`billPayerId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_bill_groups` FOREIGN KEY (`groupId`) REFERENCES `groups` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;
	

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
	
INSERT INTO `bill` VALUES (5,'Travel',6,NULL,4,6,'2013-08-14 02:09:54',50.00,5),(30,'Rent',6,NULL,3,6,'2013-10-02 06:00:00',900.00,23),(35,'Sprouts Farmers market',6,'Return Organic milk bottle',3,6,'2013-12-30 07:00:00',30.00,28),(36,'Movies',7,NULL,3,6,'2014-01-01 07:00:00',30.00,29),(37,'Movies',6,NULL,3,6,'2014-02-01 07:00:00',90.00,37),(38,'Groceries',6,NULL,3,6,'2014-02-02 07:00:00',60.00,38),(39,'Laundry',6,NULL,3,6,'2014-02-01 07:00:00',9.00,39);
	
UNLOCK TABLES;

--
-- Table structure for table `billitementry`
--

DROP TABLE IF EXISTS `billitementry`;
	
	
CREATE TABLE `billitementry` (
  `itemTitle` varchar(200) DEFAULT NULL,
  `itemDescription` text,
  `billId` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_billitementry_bill1_idx` (`billId`),
  CONSTRAINT `fk_billitementry_bill` FOREIGN KEY (`billId`) REFERENCES `bill` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
	

--
-- Dumping data for table `billitementry`
--

LOCK TABLES `billitementry` WRITE;
	
	
UNLOCK TABLES;

--
-- Table structure for table `billsimpleentry`
--

DROP TABLE IF EXISTS `billsimpleentry`;
	
	
CREATE TABLE `billsimpleentry` (
  `itemTitle` varchar(200) DEFAULT NULL,
  `itemDescription` text,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `fk_bill_idx` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;
	

--
-- Dumping data for table `billsimpleentry`
--

LOCK TABLES `billsimpleentry` WRITE;
	
INSERT INTO `billsimpleentry` VALUES ('simple',NULL,2),('simpe',NULL,4),('simple',NULL,5),(NULL,NULL,6),(NULL,NULL,7),(NULL,NULL,8),(NULL,NULL,9),(NULL,NULL,10),(NULL,NULL,11),(NULL,NULL,12),(NULL,NULL,13),(NULL,NULL,14),(NULL,NULL,15),(NULL,NULL,16),(NULL,NULL,17),(NULL,NULL,18),(NULL,NULL,19),(NULL,NULL,20),(NULL,NULL,21),(NULL,NULL,22),(NULL,NULL,23),(NULL,NULL,24),(NULL,NULL,25),(NULL,NULL,26),(NULL,NULL,27),(NULL,NULL,28),(NULL,NULL,29),(NULL,NULL,30),(NULL,NULL,36),(NULL,NULL,37),(NULL,NULL,38),(NULL,NULL,39);
	
UNLOCK TABLES;

--
-- Table structure for table `groups`
--

DROP TABLE IF EXISTS `groups`;
	
	
CREATE TABLE `groups` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `description` text,
  `ownerId` bigint(20) DEFAULT NULL,
  `isActive` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
	

--
-- Dumping data for table `groups`
--

LOCK TABLES `groups` WRITE;
	
INSERT INTO `groups` VALUES (3,'SLC',NULL,6,1),(4,'Office-IHC',NULL,6,1),(5,'Friends',NULL,6,1),(6,'Shiny New Group','no description for this pool ol',NULL,1);
	
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
	
	
CREATE TABLE `payment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `payerId` bigint(20) NOT NULL,
  `receiverId` bigint(20) NOT NULL,
  `paydate` timestamp NULL DEFAULT NULL,
  `paidAmount` bigint(20) NOT NULL,
  `notes` text,
  `groupId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_payerId_idx` (`payerId`),
  KEY `fk_receiverId_idx` (`receiverId`),
  KEY `FK_l0jsfq5aivo6fbr8kip7emfew` (`groupId`),
  CONSTRAINT `FK_l0jsfq5aivo6fbr8kip7emfew` FOREIGN KEY (`groupId`) REFERENCES `groups` (`id`),
  CONSTRAINT `fk_payerId` FOREIGN KEY (`payerId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_receiverId` FOREIGN KEY (`receiverId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
	

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
	
INSERT INTO `payment` VALUES (1,6,7,NULL,50,NULL,3),(2,7,8,NULL,25,NULL,3),(3,7,8,NULL,15,NULL,3);
	
UNLOCK TABLES;

--
-- Table structure for table `simpleuseridandliablecost`
--

DROP TABLE IF EXISTS `simpleuseridandliablecost`;
	
	
CREATE TABLE `simpleuseridandliablecost` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL,
  `liableCost` decimal(10,2) DEFAULT NULL,
  `billSimpleEntryId` bigint(20) DEFAULT NULL,
  `isActive` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_simpleuseridandliablecost_user1_idx` (`userId`),
  KEY `FK_sagu1ixi3u2i0v64mapu4lj5a` (`billSimpleEntryId`),
  CONSTRAINT `FK_sagu1ixi3u2i0v64mapu4lj5a` FOREIGN KEY (`billSimpleEntryId`) REFERENCES `billsimpleentry` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_simpleuseridandliablecost_user` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=latin1;
	

--
-- Dumping data for table `simpleuseridandliablecost`
--

LOCK TABLES `simpleuseridandliablecost` WRITE;
	
INSERT INTO `simpleuseridandliablecost` VALUES (10,6,20.00,2,1),(11,7,20.00,2,1),(12,8,10.00,2,1),(13,6,15.70,4,1),(14,7,20.00,4,1),(15,6,1.00,2,1),(16,7,1.00,2,1),(17,8,1.00,2,1),(18,6,5.00,NULL,1),(19,7,5.00,NULL,1),(20,8,5.00,NULL,1),(21,6,44.00,NULL,1),(22,7,45.00,NULL,1),(23,8,545.00,NULL,1),(24,6,20.00,NULL,1),(25,7,20.00,NULL,1),(26,8,20.00,NULL,1),(27,6,500.00,NULL,1),(28,7,500.00,NULL,1),(29,8,0.00,NULL,0),(30,6,20.00,NULL,1),(31,7,20.00,NULL,1),(32,8,20.00,NULL,1),(33,6,20.00,11,1),(34,7,20.00,11,1),(35,8,20.00,11,1),(36,6,5.00,12,1),(37,7,5.00,12,1),(38,8,5.00,12,1),(39,6,20.00,13,1),(40,7,20.00,13,1),(41,8,20.00,13,1),(42,6,20.00,14,1),(43,7,20.00,14,1),(44,8,20.00,14,1),(45,6,20.00,15,1),(46,7,20.00,15,1),(47,8,20.00,15,1),(48,6,20.00,16,1),(49,7,20.00,16,1),(50,8,20.00,16,1),(51,6,20.00,17,1),(52,7,20.00,17,1),(53,8,20.00,17,1),(54,6,5.00,18,1),(55,7,5.00,18,1),(56,8,5.00,18,1),(57,6,2.00,19,1),(58,7,2.00,19,1),(59,8,2.00,19,1),(60,6,33.33,20,1),(61,7,33.33,20,1),(62,8,33.38,20,1),(63,6,20.00,21,1),(64,7,20.00,21,1),(65,8,20.00,21,1),(66,6,20.00,22,1),(67,7,20.00,22,1),(68,8,20.00,22,1),(69,6,300.00,23,1),(70,7,300.00,23,1),(71,8,300.00,23,1),(72,6,25.00,24,1),(73,7,30.00,24,1),(74,8,20.00,24,1),(75,6,300.00,25,1),(76,7,300.00,25,1),(77,8,300.00,25,1),(78,6,25.00,26,1),(79,7,25.00,26,1),(80,8,0.00,26,0),(81,6,10.00,27,1),(82,7,10.00,27,1),(83,8,10.00,27,1),(84,6,10.00,28,1),(85,7,10.00,28,1),(86,8,10.00,28,1),(87,6,10.00,29,1),(88,7,10.00,29,1),(89,8,10.00,29,1),(90,6,300.00,30,1),(91,7,300.00,30,1),(92,8,300.00,30,1),(108,6,3.00,36,1),(109,7,3.00,36,1),(110,8,3.00,36,1),(111,6,30.00,37,1),(112,7,30.00,37,1),(113,8,30.00,37,1),(114,6,20.00,38,1),(115,7,20.00,38,1),(116,8,20.00,38,1),(117,6,9.00,39,1),(118,7,0.00,39,0),(119,8,0.00,39,0);
	
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
	
	
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fName` varchar(100) DEFAULT NULL,
  `lName` varchar(100) DEFAULT NULL,
  `mName` varchar(100) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
	

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
	
INSERT INTO `user` VALUES (6,'Bruce','Wayne',NULL,NULL,'john@doe.com','password',1),(7,'Peter','Parker',NULL,NULL,'jayanthk4u@gmail.com','password',1),(8,'Clark','Kent',NULL,NULL,'kkathari@gmail.com','password',1);
	
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
	
	
CREATE TABLE `user_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_user_role` (`userId`),
  KEY `fk_user_role_idx` (`userId`),
  CONSTRAINT `fk_userId` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
	

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
	
INSERT INTO `user_role` VALUES (1,6,'ROLE_USER'),(2,7,'ROLE_USER'),(3,8,'ROLE_USER');
	
UNLOCK TABLES;

--
-- Table structure for table `userfriendmap`
--

DROP TABLE IF EXISTS `userfriendmap`;
	
	
CREATE TABLE `userfriendmap` (
  `user_id` bigint(20) NOT NULL,
  `friend_id` bigint(20) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_user_has_user_user2_idx` (`friend_id`),
  KEY `fk_user_has_user_user1_idx` (`user_id`),
  CONSTRAINT `fk_user_has_user_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_user_user2` FOREIGN KEY (`friend_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
	

--
-- Dumping data for table `userfriendmap`
--

LOCK TABLES `userfriendmap` WRITE;
	
INSERT INTO `userfriendmap` VALUES (6,7,1),(6,8,2),(7,8,3);
	
UNLOCK TABLES;

--
-- Table structure for table `usergroupmap`
--

DROP TABLE IF EXISTS `usergroupmap`;
	
	
CREATE TABLE `usergroupmap` (
  `groups_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_groups_has_user_user1_idx` (`user_id`),
  KEY `fk_groups_has_user_groups1_idx` (`groups_id`),
  CONSTRAINT `fk_groups_has_user_groups1` FOREIGN KEY (`groups_id`) REFERENCES `groups` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_groups_has_user_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
	

--
-- Dumping data for table `usergroupmap`
--

LOCK TABLES `usergroupmap` WRITE;
	
INSERT INTO `usergroupmap` VALUES (3,6,1),(3,7,2),(3,8,3),(4,6,4),(4,7,5),(5,6,6),(5,8,7);
	
UNLOCK TABLES;

--
-- Table structure for table `useridandliablecost`
--

DROP TABLE IF EXISTS `useridandliablecost`;
	
	
CREATE TABLE `useridandliablecost` (
  `userId` bigint(20) DEFAULT NULL,
  `liableCost` decimal(10,2) DEFAULT NULL,
  `billItemEntryId` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_useridandliablecost_billitementry1_idx` (`billItemEntryId`),
  KEY `fk_useridandliablecost_userId_idx` (`userId`),
  CONSTRAINT `fk_useridandliablecost_billitementry` FOREIGN KEY (`billItemEntryId`) REFERENCES `billitementry` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_useridandliablecost_userId` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
	

--
-- Dumping data for table `useridandliablecost`
--

LOCK TABLES `useridandliablecost` WRITE;
	
	
UNLOCK TABLES;
	

	
	
	
	
	
	
	

-- Dump completed on 2014-03-17 16:31:39
