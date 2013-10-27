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
  `amount` decimal(19,2) DEFAULT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `userId_gets` bigint(20) DEFAULT NULL,
  `userId_gives` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_mycwknj9hkg9bht1bu1lrd7gn` (`groupId`),
  CONSTRAINT `FK_mycwknj9hkg9bht1bu1lrd7gn` FOREIGN KEY (`groupId`) REFERENCES `groups` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `balance`
--

LOCK TABLES `balance` WRITE;
/*!40000 ALTER TABLE `balance` DISABLE KEYS */;
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
  `billCreaterId` bigint(20) DEFAULT NULL,
  `billDate` datetime DEFAULT NULL,
  `billPayerId` bigint(20) DEFAULT NULL,
  `billTotal` decimal(19,2) DEFAULT NULL,
  `groupId` bigint(20) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_3g3k244b6ru1luwg0wk4hp3im` (`groupId`),
  CONSTRAINT `FK_3g3k244b6ru1luwg0wk4hp3im` FOREIGN KEY (`groupId`) REFERENCES `groups` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `billitementry`
--

DROP TABLE IF EXISTS `billitementry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `billitementry` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `billId` bigint(20) DEFAULT NULL,
  `itemDescription` text,
  PRIMARY KEY (`id`),
  KEY `FK_h2itopru86fo2jv1gyc99qokx` (`billId`),
  CONSTRAINT `FK_h2itopru86fo2jv1gyc99qokx` FOREIGN KEY (`billId`) REFERENCES `bill` (`id`)
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
  `billId` bigint(20) NOT NULL AUTO_INCREMENT,
  `itemDescription` text,
  PRIMARY KEY (`billId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billsimpleentry`
--

LOCK TABLES `billsimpleentry` WRITE;
/*!40000 ALTER TABLE `billsimpleentry` DISABLE KEYS */;
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
  `description` text,
  `isActive` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `ownerId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groups`
--

LOCK TABLES `groups` WRITE;
/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
INSERT INTO `groups` VALUES (3,'SLC',NULL,'6',1),(4,'Office-IHC',NULL,'6',1),(5,'Friends',NULL,'6',1);
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
  `groupId` bigint(20) NOT NULL,
  `notes` text,
  `paidAmount` bigint(20) NOT NULL,
  `payDate` datetime DEFAULT NULL,
  `payerId` bigint(20) NOT NULL,
  `receiverId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_l0jsfq5aivo6fbr8kip7emfew` (`groupId`),
  CONSTRAINT `FK_l0jsfq5aivo6fbr8kip7emfew` FOREIGN KEY (`groupId`) REFERENCES `groups` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
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
  `billSimpleEntryId` bigint(20) DEFAULT NULL,
  `isActive` bit(1) DEFAULT NULL,
  `liableCost` decimal(19,2) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_os9lbogxinfjh5v937yroqkk4` (`userId`),
  KEY `FK_sagu1ixi3u2i0v64mapu4lj5a` (`billSimpleEntryId`),
  CONSTRAINT `FK_sagu1ixi3u2i0v64mapu4lj5a` FOREIGN KEY (`billSimpleEntryId`) REFERENCES `billsimpleentry` (`billId`),
  CONSTRAINT `FK_os9lbogxinfjh5v937yroqkk4` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `simpleuseridandliablecost`
--

LOCK TABLES `simpleuseridandliablecost` WRITE;
/*!40000 ALTER TABLE `simpleuseridandliablecost` DISABLE KEYS */;
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
  `email` varchar(255) DEFAULT NULL,
  `fName` varchar(255) DEFAULT NULL,
  `lName` varchar(255) DEFAULT NULL,
  `mName` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
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
-- Table structure for table `usergroupmap`
--

DROP TABLE IF EXISTS `usergroupmap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usergroupmap` (
  `user_id` bigint(20) NOT NULL,
  `groups_id` bigint(20) NOT NULL,
  KEY `FK_ep1fl2nbwsu472y8odwjs6fwc` (`groups_id`),
  KEY `FK_ph2isnw49j4bwqykkk6cbj7pm` (`user_id`),
  CONSTRAINT `FK_ph2isnw49j4bwqykkk6cbj7pm` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_ep1fl2nbwsu472y8odwjs6fwc` FOREIGN KEY (`groups_id`) REFERENCES `groups` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usergroupmap`
--

LOCK TABLES `usergroupmap` WRITE;
/*!40000 ALTER TABLE `usergroupmap` DISABLE KEYS */;
INSERT INTO `usergroupmap` VALUES (6,3),(7,3),(8,3),(6,4),(7,4),(6,5),(8,5);
/*!40000 ALTER TABLE `usergroupmap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `useridandliablecost`
--

DROP TABLE IF EXISTS `useridandliablecost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `useridandliablecost` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `billItemEntryId` bigint(20) DEFAULT NULL,
  `liableCost` decimal(19,2) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_tjd8axt767n6vhl8k43wmbi89` (`billItemEntryId`),
  CONSTRAINT `FK_tjd8axt767n6vhl8k43wmbi89` FOREIGN KEY (`billItemEntryId`) REFERENCES `billitementry` (`id`)
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

-- Dump completed on 2013-10-26 18:24:28
