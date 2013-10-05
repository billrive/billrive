CREATE DATABASE  IF NOT EXISTS `billrivedb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `billrivedb`;
-- MySQL dump 10.13  Distrib 5.6.12, for Win64 (x86_64)
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
  PRIMARY KEY (`id`)
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
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_bill_groups1_idx` (`groupId`),
  KEY `fk_bill_user1_idx` (`billPayerId`),
  CONSTRAINT `fk_bill_billsimpleentry` FOREIGN KEY (`id`) REFERENCES `billsimpleentry` (`billId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_bill_groups` FOREIGN KEY (`groupId`) REFERENCES `groups` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_bill_user` FOREIGN KEY (`billPayerId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` VALUES (2,'Walmart',6,NULL,3,6,'2013-07-19 16:12:56',50.00),(4,'Costco',6,'Costo bill',3,6,'2013-08-14 02:09:54',35.70);
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
  CONSTRAINT `fk_billitementry_bill` FOREIGN KEY (`billId`) REFERENCES `bill` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billitementry`
--

LOCK TABLES `billitementry` WRITE;
/*!40000 ALTER TABLE `billitementry` DISABLE KEYS */;
INSERT INTO `billitementry` VALUES ('alchohol','beer',2,1),('fruits','watermelon',2,2),('cereals','honey oats',4,3),('icecream','vannila',4,4);
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
  `billId` bigint(20) NOT NULL,
  PRIMARY KEY (`billId`),
  KEY `fk_bill_idx` (`billId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billsimpleentry`
--

LOCK TABLES `billsimpleentry` WRITE;
/*!40000 ALTER TABLE `billsimpleentry` DISABLE KEYS */;
INSERT INTO `billsimpleentry` VALUES ('simple',NULL,2),('simpe',NULL,4);
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groups`
--

LOCK TABLES `groups` WRITE;
/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
INSERT INTO `groups` VALUES (3,'SLC',NULL,6,0);
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
  CONSTRAINT `fk_simpleuseridandliablecost_user` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `simpleuseridandliablecost`
--

LOCK TABLES `simpleuseridandliablecost` WRITE;
/*!40000 ALTER TABLE `simpleuseridandliablecost` DISABLE KEYS */;
INSERT INTO `simpleuseridandliablecost` VALUES (10,6,1.00,2,0),(11,7,1.00,2,0),(12,8,1.00,2,0);
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
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (6,'Prashanth','Batchu',NULL,NULL,'me@prashu.net'),(7,'Jayanth','Kondaveti',NULL,NULL,'jayanthk4u@gmail.com'),(8,'Karthik','Kathari',NULL,NULL,'kkathari@gmail.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usergroupmap`
--

LOCK TABLES `usergroupmap` WRITE;
/*!40000 ALTER TABLE `usergroupmap` DISABLE KEYS */;
INSERT INTO `usergroupmap` VALUES (3,6,1),(3,7,2),(3,8,3);
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
  CONSTRAINT `fk_useridandliablecost_billitementry` FOREIGN KEY (`billItemEntryId`) REFERENCES `billitementry` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_useridandliablecost_userId` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `useridandliablecost`
--

LOCK TABLES `useridandliablecost` WRITE;
/*!40000 ALTER TABLE `useridandliablecost` DISABLE KEYS */;
INSERT INTO `useridandliablecost` VALUES (6,2.00,1,1),(7,2.00,1,2),(8,2.00,1,3),(6,3.00,2,4),(7,3.00,2,5),(8,3.00,2,6),(6,4.00,3,7),(7,4.00,3,8),(8,4.00,3,9);
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

-- Dump completed on 2013-09-22 20:40:08
