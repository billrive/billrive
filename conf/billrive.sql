CREATE DATABASE  IF NOT EXISTS `billrivedbtest` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `billrivedbtest`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: billrivedbtest
-- ------------------------------------------------------
-- Server version	5.6.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `balance`
--

DROP TABLE IF EXISTS `balance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `balance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `groupId` bigint(20) DEFAULT NULL,
  `userId_gets` bigint(20) DEFAULT NULL,
  `userId_gives` bigint(20) DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_mycwknj9hkg9bht1bu1lrd7gn` (`groupId`),
  CONSTRAINT `FK_mycwknj9hkg9bht1bu1lrd7gn` FOREIGN KEY (`groupId`) REFERENCES `groups` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `balance`
--

LOCK TABLES `balance` WRITE;
/*!40000 ALTER TABLE `balance` DISABLE KEYS */;
INSERT INTO `balance` VALUES (1,3,6,7,10.50),(2,3,6,8,12.90),(3,3,7,8,9.80);
/*!40000 ALTER TABLE `balance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bill` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `billPayerId` bigint(20) DEFAULT NULL,
  `notes` varchar(100) DEFAULT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `billCreaterId` bigint(20) DEFAULT NULL,
  `billDate` timestamp NULL DEFAULT NULL,
  `billTotal` decimal(10,2) DEFAULT NULL,
  `billSimpleEntryId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_bill_groups1_idx` (`groupId`),
  KEY `fk_bill_user1_idx` (`billPayerId`),
  KEY `FK_4e6dfgs9volhxbvrfxdbnrc83` (`billSimpleEntryId`),
  CONSTRAINT `FK_4e6dfgs9volhxbvrfxdbnrc83` FOREIGN KEY (`billSimpleEntryId`) REFERENCES `billsimpleentry` (`id`),
  CONSTRAINT `fk_bill_groups` FOREIGN KEY (`groupId`) REFERENCES `groups` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_bill_user` FOREIGN KEY (`billPayerId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` VALUES (5,'Travel',6,NULL,4,6,'2013-08-14 02:09:54',50.00,5),(22,'',NULL,NULL,NULL,NULL,'2013-10-01 06:00:00',NULL,NULL),(27,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(30,'Rent',6,NULL,3,NULL,'2013-10-02 06:00:00',900.00,23),(33,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(35,'Sprouts Farmers market',6,'Return Organic milk bottle',3,NULL,'2013-12-30 07:00:00',30.00,28),(36,'Movies',7,NULL,3,NULL,'2014-01-01 07:00:00',30.00,29);
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `billitementry`
--

DROP TABLE IF EXISTS `billitementry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billitementry`
--

LOCK TABLES `billitementry` WRITE;
/*!40000 ALTER TABLE `billitementry` DISABLE KEYS */;
/*!40000 ALTER TABLE `billitementry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `billsimpleentry`
--

DROP TABLE IF EXISTS `billsimpleentry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `billsimpleentry` (
  `itemTitle` varchar(200) DEFAULT NULL,
  `itemDescription` text,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `fk_bill_idx` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billsimpleentry`
--

LOCK TABLES `billsimpleentry` WRITE;
/*!40000 ALTER TABLE `billsimpleentry` DISABLE KEYS */;
INSERT INTO `billsimpleentry` VALUES ('simple',NULL,2),('simpe',NULL,4),('simple',NULL,5),(NULL,NULL,6),(NULL,NULL,7),(NULL,NULL,8),(NULL,NULL,9),(NULL,NULL,10),(NULL,NULL,11),(NULL,NULL,12),(NULL,NULL,13),(NULL,NULL,14),(NULL,NULL,15),(NULL,NULL,16),(NULL,NULL,17),(NULL,NULL,18),(NULL,NULL,19),(NULL,NULL,20),(NULL,NULL,21),(NULL,NULL,22),(NULL,NULL,23),(NULL,NULL,24),(NULL,NULL,25),(NULL,NULL,26),(NULL,NULL,27),(NULL,NULL,28),(NULL,NULL,29),(NULL,NULL,30),(NULL,NULL,36);
/*!40000 ALTER TABLE `billsimpleentry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groups`
--

DROP TABLE IF EXISTS `groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `groups` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `description` text,
  `ownerId` bigint(20) DEFAULT NULL,
  `isActive` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groups`
--

LOCK TABLES `groups` WRITE;
/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
INSERT INTO `groups` VALUES (3,'SLC',NULL,6,1),(4,'Office-IHC',NULL,6,1),(5,'Friends',NULL,6,1),(6,'Shiny New Group','no description for this pool ol',NULL,1);
/*!40000 ALTER TABLE `groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,6,7,NULL,50,NULL,3),(2,7,8,NULL,25,NULL,3),(3,7,8,NULL,15,NULL,3);
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `simpleuseridandliablecost`
--

DROP TABLE IF EXISTS `simpleuseridandliablecost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
  CONSTRAINT `FK_sagu1ixi3u2i0v64mapu4lj5a` FOREIGN KEY (`billSimpleEntryId`) REFERENCES `billsimpleentry` (`id`),
  CONSTRAINT `fk_simpleuseridandliablecost_user` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `simpleuseridandliablecost`
--

LOCK TABLES `simpleuseridandliablecost` WRITE;
/*!40000 ALTER TABLE `simpleuseridandliablecost` DISABLE KEYS */;
INSERT INTO `simpleuseridandliablecost` VALUES (10,6,20.00,2,1),(11,7,20.00,2,1),(12,8,10.00,2,1),(13,6,15.70,4,1),(14,7,20.00,4,1),(15,6,1.00,2,1),(16,7,1.00,2,1),(17,8,1.00,2,1),(18,6,5.00,NULL,1),(19,7,5.00,NULL,1),(20,8,5.00,NULL,1),(21,6,44.00,NULL,1),(22,7,45.00,NULL,1),(23,8,545.00,NULL,1),(24,6,20.00,NULL,1),(25,7,20.00,NULL,1),(26,8,20.00,NULL,1),(27,6,500.00,NULL,1),(28,7,500.00,NULL,1),(29,8,0.00,NULL,0),(30,6,20.00,NULL,1),(31,7,20.00,NULL,1),(32,8,20.00,NULL,1),(33,6,20.00,11,1),(34,7,20.00,11,1),(35,8,20.00,11,1),(36,6,5.00,12,1),(37,7,5.00,12,1),(38,8,5.00,12,1),(39,6,20.00,13,1),(40,7,20.00,13,1),(41,8,20.00,13,1),(42,6,20.00,14,1),(43,7,20.00,14,1),(44,8,20.00,14,1),(45,6,20.00,15,1),(46,7,20.00,15,1),(47,8,20.00,15,1),(48,6,20.00,16,1),(49,7,20.00,16,1),(50,8,20.00,16,1),(51,6,20.00,17,1),(52,7,20.00,17,1),(53,8,20.00,17,1),(54,6,5.00,18,1),(55,7,5.00,18,1),(56,8,5.00,18,1),(57,6,2.00,19,1),(58,7,2.00,19,1),(59,8,2.00,19,1),(60,6,33.33,20,1),(61,7,33.33,20,1),(62,8,33.38,20,1),(63,6,20.00,21,1),(64,7,20.00,21,1),(65,8,20.00,21,1),(66,6,20.00,22,1),(67,7,20.00,22,1),(68,8,20.00,22,1),(69,6,300.00,23,1),(70,7,300.00,23,1),(71,8,300.00,23,1),(72,6,25.00,24,1),(73,7,30.00,24,1),(74,8,20.00,24,1),(75,6,300.00,25,1),(76,7,300.00,25,1),(77,8,300.00,25,1),(78,6,25.00,26,1),(79,7,25.00,26,1),(80,8,0.00,26,0),(81,6,10.00,27,1),(82,7,10.00,27,1),(83,8,10.00,27,1),(84,6,10.00,28,1),(85,7,10.00,28,1),(86,8,10.00,28,1),(87,6,10.00,29,1),(88,7,10.00,29,1),(89,8,10.00,29,1),(90,6,300.00,30,1),(91,7,300.00,30,1),(92,8,300.00,30,1),(108,6,3.00,36,1),(109,7,3.00,36,1),(110,8,3.00,36,1);
/*!40000 ALTER TABLE `simpleuseridandliablecost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (6,'Bruce','Wayne',NULL,NULL,'me@prashu.net',NULL,1),(7,'Peter','Parker',NULL,NULL,'jayanthk4u@gmail.com',NULL,1),(8,'Clark','Kent',NULL,NULL,'kkathari@gmail.com',NULL,1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_user_role` (`userId`),
  KEY `fk_user_role_idx` (`userId`),
  CONSTRAINT `fk_userId` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userfriendmap`
--

DROP TABLE IF EXISTS `userfriendmap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userfriendmap`
--

LOCK TABLES `userfriendmap` WRITE;
/*!40000 ALTER TABLE `userfriendmap` DISABLE KEYS */;
INSERT INTO `userfriendmap` VALUES (6,7,1),(6,8,2),(7,8,3);
/*!40000 ALTER TABLE `userfriendmap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usergroupmap`
--

DROP TABLE IF EXISTS `usergroupmap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usergroupmap`
--

LOCK TABLES `usergroupmap` WRITE;
/*!40000 ALTER TABLE `usergroupmap` DISABLE KEYS */;
INSERT INTO `usergroupmap` VALUES (3,6,1),(3,7,2),(3,8,3),(4,6,4),(4,7,5),(5,6,6),(5,8,7);
/*!40000 ALTER TABLE `usergroupmap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `useridandliablecost`
--

DROP TABLE IF EXISTS `useridandliablecost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `useridandliablecost`
--

LOCK TABLES `useridandliablecost` WRITE;
/*!40000 ALTER TABLE `useridandliablecost` DISABLE KEYS */;
/*!40000 ALTER TABLE `useridandliablecost` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-02-27 23:00:49
CREATE DATABASE  IF NOT EXISTS `billrivedb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `billrivedb`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: billrivedb
-- ------------------------------------------------------
-- Server version	5.6.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `balance`
--

DROP TABLE IF EXISTS `balance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `balance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `groupId` bigint(20) DEFAULT NULL,
  `userId_gets` bigint(20) DEFAULT NULL,
  `userId_gives` bigint(20) DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_mycwknj9hkg9bht1bu1lrd7gn` (`groupId`),
  CONSTRAINT `FK_mycwknj9hkg9bht1bu1lrd7gn` FOREIGN KEY (`groupId`) REFERENCES `groups` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `balance`
--

LOCK TABLES `balance` WRITE;
/*!40000 ALTER TABLE `balance` DISABLE KEYS */;
INSERT INTO `balance` VALUES (1,3,6,7,10.50),(2,3,6,8,12.90),(3,3,7,8,9.80);
/*!40000 ALTER TABLE `balance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bill` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `billPayerId` bigint(20) DEFAULT NULL,
  `notes` varchar(100) DEFAULT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `billCreaterId` bigint(20) DEFAULT NULL,
  `billDate` timestamp NULL DEFAULT NULL,
  `billTotal` decimal(10,2) DEFAULT NULL,
  `billSimpleEntryId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_bill_groups1_idx` (`groupId`),
  KEY `fk_bill_user1_idx` (`billPayerId`),
  KEY `FK_4e6dfgs9volhxbvrfxdbnrc83` (`billSimpleEntryId`),
  CONSTRAINT `FK_4e6dfgs9volhxbvrfxdbnrc83` FOREIGN KEY (`billSimpleEntryId`) REFERENCES `billsimpleentry` (`id`),
  CONSTRAINT `fk_bill_groups` FOREIGN KEY (`groupId`) REFERENCES `groups` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_bill_user` FOREIGN KEY (`billPayerId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` VALUES (5,'Travel',6,NULL,4,6,'2013-08-14 02:09:54',50.00,5),(22,'',NULL,NULL,NULL,NULL,'2013-10-01 06:00:00',NULL,NULL),(27,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(30,'Rent',6,NULL,3,NULL,'2013-10-02 06:00:00',900.00,23),(33,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(35,'Sprouts Farmers market',6,'Return Organic milk bottle',3,NULL,'2013-12-30 07:00:00',30.00,28),(36,'Movies',7,NULL,3,NULL,'2014-01-01 07:00:00',30.00,29),(37,'Movies',6,NULL,3,NULL,'2014-02-01 07:00:00',90.00,37),(38,'Groceries',6,NULL,3,NULL,'2014-02-02 07:00:00',60.00,38),(39,'Laundry',6,NULL,3,NULL,'2014-02-01 07:00:00',9.00,39);
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `billitementry`
--

DROP TABLE IF EXISTS `billitementry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billitementry`
--

LOCK TABLES `billitementry` WRITE;
/*!40000 ALTER TABLE `billitementry` DISABLE KEYS */;
/*!40000 ALTER TABLE `billitementry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `billsimpleentry`
--

DROP TABLE IF EXISTS `billsimpleentry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `billsimpleentry` (
  `itemTitle` varchar(200) DEFAULT NULL,
  `itemDescription` text,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `fk_bill_idx` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billsimpleentry`
--

LOCK TABLES `billsimpleentry` WRITE;
/*!40000 ALTER TABLE `billsimpleentry` DISABLE KEYS */;
INSERT INTO `billsimpleentry` VALUES ('simple',NULL,2),('simpe',NULL,4),('simple',NULL,5),(NULL,NULL,6),(NULL,NULL,7),(NULL,NULL,8),(NULL,NULL,9),(NULL,NULL,10),(NULL,NULL,11),(NULL,NULL,12),(NULL,NULL,13),(NULL,NULL,14),(NULL,NULL,15),(NULL,NULL,16),(NULL,NULL,17),(NULL,NULL,18),(NULL,NULL,19),(NULL,NULL,20),(NULL,NULL,21),(NULL,NULL,22),(NULL,NULL,23),(NULL,NULL,24),(NULL,NULL,25),(NULL,NULL,26),(NULL,NULL,27),(NULL,NULL,28),(NULL,NULL,29),(NULL,NULL,30),(NULL,NULL,36),(NULL,NULL,37),(NULL,NULL,38),(NULL,NULL,39);
/*!40000 ALTER TABLE `billsimpleentry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groups`
--

DROP TABLE IF EXISTS `groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `groups` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `description` text,
  `ownerId` bigint(20) DEFAULT NULL,
  `isActive` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groups`
--

LOCK TABLES `groups` WRITE;
/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
INSERT INTO `groups` VALUES (3,'SLC',NULL,6,1),(4,'Office-IHC',NULL,6,1),(5,'Friends',NULL,6,1),(6,'Shiny New Group','no description for this pool ol',NULL,1);
/*!40000 ALTER TABLE `groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,6,7,NULL,50,NULL,3),(2,7,8,NULL,25,NULL,3),(3,7,8,NULL,15,NULL,3);
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `simpleuseridandliablecost`
--

DROP TABLE IF EXISTS `simpleuseridandliablecost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
  CONSTRAINT `FK_sagu1ixi3u2i0v64mapu4lj5a` FOREIGN KEY (`billSimpleEntryId`) REFERENCES `billsimpleentry` (`id`),
  CONSTRAINT `fk_simpleuseridandliablecost_user` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `simpleuseridandliablecost`
--

LOCK TABLES `simpleuseridandliablecost` WRITE;
/*!40000 ALTER TABLE `simpleuseridandliablecost` DISABLE KEYS */;
INSERT INTO `simpleuseridandliablecost` VALUES (10,6,20.00,2,1),(11,7,20.00,2,1),(12,8,10.00,2,1),(13,6,15.70,4,1),(14,7,20.00,4,1),(15,6,1.00,2,1),(16,7,1.00,2,1),(17,8,1.00,2,1),(18,6,5.00,NULL,1),(19,7,5.00,NULL,1),(20,8,5.00,NULL,1),(21,6,44.00,NULL,1),(22,7,45.00,NULL,1),(23,8,545.00,NULL,1),(24,6,20.00,NULL,1),(25,7,20.00,NULL,1),(26,8,20.00,NULL,1),(27,6,500.00,NULL,1),(28,7,500.00,NULL,1),(29,8,0.00,NULL,0),(30,6,20.00,NULL,1),(31,7,20.00,NULL,1),(32,8,20.00,NULL,1),(33,6,20.00,11,1),(34,7,20.00,11,1),(35,8,20.00,11,1),(36,6,5.00,12,1),(37,7,5.00,12,1),(38,8,5.00,12,1),(39,6,20.00,13,1),(40,7,20.00,13,1),(41,8,20.00,13,1),(42,6,20.00,14,1),(43,7,20.00,14,1),(44,8,20.00,14,1),(45,6,20.00,15,1),(46,7,20.00,15,1),(47,8,20.00,15,1),(48,6,20.00,16,1),(49,7,20.00,16,1),(50,8,20.00,16,1),(51,6,20.00,17,1),(52,7,20.00,17,1),(53,8,20.00,17,1),(54,6,5.00,18,1),(55,7,5.00,18,1),(56,8,5.00,18,1),(57,6,2.00,19,1),(58,7,2.00,19,1),(59,8,2.00,19,1),(60,6,33.33,20,1),(61,7,33.33,20,1),(62,8,33.38,20,1),(63,6,20.00,21,1),(64,7,20.00,21,1),(65,8,20.00,21,1),(66,6,20.00,22,1),(67,7,20.00,22,1),(68,8,20.00,22,1),(69,6,300.00,23,1),(70,7,300.00,23,1),(71,8,300.00,23,1),(72,6,25.00,24,1),(73,7,30.00,24,1),(74,8,20.00,24,1),(75,6,300.00,25,1),(76,7,300.00,25,1),(77,8,300.00,25,1),(78,6,25.00,26,1),(79,7,25.00,26,1),(80,8,0.00,26,0),(81,6,10.00,27,1),(82,7,10.00,27,1),(83,8,10.00,27,1),(84,6,10.00,28,1),(85,7,10.00,28,1),(86,8,10.00,28,1),(87,6,10.00,29,1),(88,7,10.00,29,1),(89,8,10.00,29,1),(90,6,300.00,30,1),(91,7,300.00,30,1),(92,8,300.00,30,1),(108,6,3.00,36,1),(109,7,3.00,36,1),(110,8,3.00,36,1),(111,6,30.00,37,1),(112,7,30.00,37,1),(113,8,30.00,37,1),(114,6,20.00,38,1),(115,7,20.00,38,1),(116,8,20.00,38,1),(117,6,9.00,39,1),(118,7,0.00,39,0),(119,8,0.00,39,0);
/*!40000 ALTER TABLE `simpleuseridandliablecost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (6,'Bruce','Wayne',NULL,NULL,'me@prashu.net','password',1),(7,'Peter','Parker',NULL,NULL,'jayanthk4u@gmail.com','password',1),(8,'Clark','Kent',NULL,NULL,'kkathari@gmail.com','password',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_user_role` (`userId`),
  KEY `fk_user_role_idx` (`userId`),
  CONSTRAINT `fk_userId` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,6,'ROLE_USER'),(2,7,'ROLE_USER'),(3,8,'ROLE_USER');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userfriendmap`
--

DROP TABLE IF EXISTS `userfriendmap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userfriendmap`
--

LOCK TABLES `userfriendmap` WRITE;
/*!40000 ALTER TABLE `userfriendmap` DISABLE KEYS */;
INSERT INTO `userfriendmap` VALUES (6,7,1),(6,8,2),(7,8,3);
/*!40000 ALTER TABLE `userfriendmap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usergroupmap`
--

DROP TABLE IF EXISTS `usergroupmap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usergroupmap`
--

LOCK TABLES `usergroupmap` WRITE;
/*!40000 ALTER TABLE `usergroupmap` DISABLE KEYS */;
INSERT INTO `usergroupmap` VALUES (3,6,1),(3,7,2),(3,8,3),(4,6,4),(4,7,5),(5,6,6),(5,8,7);
/*!40000 ALTER TABLE `usergroupmap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `useridandliablecost`
--

DROP TABLE IF EXISTS `useridandliablecost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `useridandliablecost`
--

LOCK TABLES `useridandliablecost` WRITE;
/*!40000 ALTER TABLE `useridandliablecost` DISABLE KEYS */;
/*!40000 ALTER TABLE `useridandliablecost` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-02-27 23:00:50
