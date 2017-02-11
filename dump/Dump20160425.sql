-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: justaskprojdb
-- ------------------------------------------------------
-- Server version	5.7.11-log

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
-- Table structure for table `addresstable`
--

DROP TABLE IF EXISTS `addresstable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `addresstable` (
  `addressId` int(11) NOT NULL,
  `addrCategory` varchar(255) DEFAULT NULL,
  `addrLine1` varchar(255) NOT NULL,
  `addrLine2` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `zipcode` int(11) NOT NULL,
  PRIMARY KEY (`addressId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addresstable`
--

LOCK TABLES `addresstable` WRITE;
/*!40000 ALTER TABLE `addresstable` DISABLE KEYS */;
INSERT INTO `addresstable` VALUES (2,'R','75 Saint Alphonsus Street','apt#1415','Boston','USA','MA',2120),(3,'R','124 Saint diago','Add2','Boston','USA','MA',2120),(7,'R','addLine1','addLine2','Boston','USA','MA',1104),(9,'H','145 Tylet','Address2','Buffalo','USA','MA',2120),(11,'R','addLine1','addLine2','Boston','USA','MA',1104),(17,NULL,'AddressLine1','Add2','Boston','USA','MA',2),(19,'P','Longwood','addr2','Boston','United States','MA',2201),(21,'R','Stephen strret','Street2','Boston','USA','MA',2130),(26,NULL,'75 Saint Alphonsus Street','Add2','Boston','USA','MA',2120),(28,'P','175 Parker Street','Addr2','Boston','United States','MA',2120),(31,'R','125 Stephan Street1','Street2','Boston','USA','MA',2120),(33,'R','a1','a2','Boston','United States','MA',2120),(35,'R','AddressLine1','Add2','Boston','USA','MA',2120),(37,'R','AddressLine1','Add2','Indore','India','MP',452009),(39,'R','AddressLine1','Add2','Boston','USA','MA',452009),(41,'R','AddressLine1','Add2','Boston','USA','MA',452009),(43,'R','283 Longwood Ave','EsT','Boston','USA','MA',2120),(45,'R','746 Huntington Ave','Near NEU','Boston','USA','MA',2120),(47,'R','15 Francis S','NEU','Boston','USA','MA',2120),(49,'NA','748 Huntington Ave','ADd2','Boston','USA','MA',2120),(51,'NA','126 Brookline Ave','Add1','Boston','USA','MA',2466),(53,'NA',' 201 Brookline Ave','(617) 247-0174','Boston','USA','MA',2120),(55,'NA',' 201 Brookline Ave','(617) 247-0174','Boston','USA','MA',2120),(57,'NA',' 201 Brookline Ave','(617) 247-0174','Boston','USA','MA',2120),(59,'R','AddressLine1','Add2','Boston','USA','MA',452009),(80,'H','dv','dvcd','asf','sac','as',123),(88,NULL,'addfdf','sdsd','sdf','sdf','sdf',23423);
/*!40000 ALTER TABLE `addresstable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `advertisementtable`
--

DROP TABLE IF EXISTS `advertisementtable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `advertisementtable` (
  `advertiseId` bigint(20) NOT NULL,
  `feeOfAd` int(11) NOT NULL,
  `packageOfAd` varchar(255) DEFAULT NULL,
  `ownerOfAd_personId` bigint(20) DEFAULT NULL,
  `venueOfAd_venueId` int(11) DEFAULT NULL,
  PRIMARY KEY (`advertiseId`),
  KEY `FK6algq7dr1oo8orf4kqynutj78` (`ownerOfAd_personId`),
  KEY `FKf923ip7xv4sh6qwaim6jqyfog` (`venueOfAd_venueId`),
  CONSTRAINT `FK6algq7dr1oo8orf4kqynutj78` FOREIGN KEY (`ownerOfAd_personId`) REFERENCES `usertable` (`personId`),
  CONSTRAINT `FKf923ip7xv4sh6qwaim6jqyfog` FOREIGN KEY (`venueOfAd_venueId`) REFERENCES `venue` (`venueId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `advertisementtable`
--

LOCK TABLES `advertisementtable` WRITE;
/*!40000 ALTER TABLE `advertisementtable` DISABLE KEYS */;
/*!40000 ALTER TABLE `advertisementtable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (91),(91),(91),(91),(91);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personsampletable`
--

DROP TABLE IF EXISTS `personsampletable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personsampletable` (
  `personID` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `firstName` varchar(255) NOT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `address_addressId` int(11) DEFAULT NULL,
  PRIMARY KEY (`personID`),
  KEY `FK8jd9ck2nbuo3u1w1ahsqddqle` (`address_addressId`),
  CONSTRAINT `FK8jd9ck2nbuo3u1w1ahsqddqle` FOREIGN KEY (`address_addressId`) REFERENCES `addresstable` (`addressId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personsampletable`
--

LOCK TABLES `personsampletable` WRITE;
/*!40000 ALTER TABLE `personsampletable` DISABLE KEYS */;
INSERT INTO `personsampletable` VALUES (1,'ilanigam17@gmail.com','Ila','Nigam',2),(6,'ilanigam17@gmail.com','aman','ila',7),(8,'sami.arif24@gmail.com','Parul','Nigam',9),(25,'samis@gmail.com','Arif','Sami',26),(87,'ilanigam17@gmail.com','ilanigam','nigam',88);
/*!40000 ALTER TABLE `personsampletable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `review` (
  `reviewId` int(11) NOT NULL,
  `costEff` double DEFAULT NULL,
  `dateOfReview` datetime DEFAULT NULL,
  `reviewDesc` varchar(255) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `venueId` int(11) NOT NULL,
  `venueType` varchar(255) DEFAULT NULL,
  `user_personId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`reviewId`),
  KEY `FK5ua8cxwparsu1tvexhbso80h` (`user_personId`),
  CONSTRAINT `FK5ua8cxwparsu1tvexhbso80h` FOREIGN KEY (`user_personId`) REFERENCES `usertable` (`personId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (12,1000,'2016-04-18 19:27:51','Nice restaurant',5,10,'R',8),(13,2000,'2010-04-18 19:27:51','Amazing Dining restaurant!! Went twice!',5,10,'R',8),(24,3000.2,'2016-04-25 10:57:47','Best Chinese cuisine ever!',1,18,NULL,1),(29,1300,'2016-04-24 20:56:59','It was good but bit expensive!',4,3,NULL,1),(65,25,'2016-04-25 20:43:51','Really in your budget. if you are a student! Loved It!',5,38,NULL,25),(67,876.5,'2016-04-25 20:45:42','Awesome and great',5,44,NULL,25),(68,120,'2016-04-25 16:11:57','Please go and try it out!',4,42,NULL,25),(69,23,'2016-04-25 16:16:12','Cutlet Center is must go!! great taste in everything!',1,16,NULL,25),(70,122,'2016-04-25 16:22:54','Majestic glorious bread pudding like manna from heaven.',3,3,NULL,25),(71,346,'2016-04-25 16:26:33','A nice outdoor patio for people watching and enjoying the summer weather',4,58,NULL,25),(72,243,'2016-04-25 16:34:44','Rurry center is the best for food',4,10,NULL,25),(73,234,'2016-04-25 16:37:26','They serve great quality food and the waitress is very nice.',4,16,NULL,25),(74,3423,'2016-04-25 16:39:16','And the panzanella salad.',4,10,NULL,25),(75,123,'2016-04-25 16:40:37','And the panzanella salad.',4,16,NULL,25),(76,122,'2016-04-25 16:47:13','Very nice restaurant',4,30,NULL,25),(77,345,'2016-04-25 16:50:47','And the panzanella salad.',4,30,NULL,25),(78,233,'2016-04-25 16:53:20','Reviewed',2,30,NULL,25),(89,123,'2016-04-25 20:04:56','And the panzanella salad.',1,3,NULL,25),(90,123,'2016-04-25 20:12:35','Awesome place',3,10,NULL,25);
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_fav_venue`
--

DROP TABLE IF EXISTS `user_fav_venue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_fav_venue` (
  `personId` bigint(20) NOT NULL,
  `venueId` int(11) NOT NULL,
  PRIMARY KEY (`personId`,`venueId`),
  KEY `FKkxgn73cc5g0aghqa82ihr6jm6` (`venueId`),
  CONSTRAINT `FKkxgn73cc5g0aghqa82ihr6jm6` FOREIGN KEY (`venueId`) REFERENCES `venue` (`venueId`),
  CONSTRAINT `FKmmiga424jt6moflu2n7b4u7o2` FOREIGN KEY (`personId`) REFERENCES `usertable` (`personId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_fav_venue`
--

LOCK TABLES `user_fav_venue` WRITE;
/*!40000 ALTER TABLE `user_fav_venue` DISABLE KEYS */;
INSERT INTO `user_fav_venue` VALUES (1,3),(1,10),(8,10),(25,10),(25,16),(25,46);
/*!40000 ALTER TABLE `user_fav_venue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_visited_venue`
--

DROP TABLE IF EXISTS `user_visited_venue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_visited_venue` (
  `personId` bigint(20) NOT NULL,
  `venueId` int(11) NOT NULL,
  PRIMARY KEY (`personId`,`venueId`),
  KEY `FKsordxt65y957bkbqddy101ia3` (`venueId`),
  CONSTRAINT `FKfit7bmnchnu2b7e7x94o4ryrc` FOREIGN KEY (`personId`) REFERENCES `usertable` (`personId`),
  CONSTRAINT `FKsordxt65y957bkbqddy101ia3` FOREIGN KEY (`venueId`) REFERENCES `venue` (`venueId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_visited_venue`
--

LOCK TABLES `user_visited_venue` WRITE;
/*!40000 ALTER TABLE `user_visited_venue` DISABLE KEYS */;
INSERT INTO `user_visited_venue` VALUES (1,3),(25,3),(1,10),(8,10),(1,20);
/*!40000 ALTER TABLE `user_visited_venue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usertable`
--

DROP TABLE IF EXISTS `usertable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usertable` (
  `password` varchar(8) NOT NULL,
  `userType` varchar(255) DEFAULT NULL,
  `username` varchar(40) NOT NULL,
  `personId` bigint(20) NOT NULL,
  `blacklist` bit(1) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  PRIMARY KEY (`personId`),
  CONSTRAINT `FKn2rlctxgcoo23ifvpwpy8nvhk` FOREIGN KEY (`personId`) REFERENCES `personsampletable` (`personID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertable`
--

LOCK TABLES `usertable` WRITE;
/*!40000 ALTER TABLE `usertable` DISABLE KEYS */;
INSERT INTO `usertable` VALUES ('fishy','User','fish',1,'','2016-02-24 02:56:35'),('nigam','Admin','amani',6,'\0','2015-04-22 02:56:35'),('qwerty','User','arifsami',8,'\0','2011-01-24 02:56:35'),('nigam','User','aman',25,'\0','2016-04-24 02:56:35'),('qwerty','User','arif',87,'','2016-04-25 18:49:23');
/*!40000 ALTER TABLE `usertable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venue`
--

DROP TABLE IF EXISTS `venue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venue` (
  `venueId` int(11) NOT NULL,
  `venueDesc` varchar(255) DEFAULT NULL,
  `venueImgLocation` varchar(255) DEFAULT NULL,
  `venueName` varchar(255) DEFAULT NULL,
  `venueRange` varchar(255) DEFAULT NULL,
  `venueType` varchar(255) DEFAULT NULL,
  `venueAddress_addressId` int(11) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `introVenueReview` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`venueId`),
  KEY `FKjb4eadfq0php2ts36s0mtacqd` (`venueAddress_addressId`),
  CONSTRAINT `FKjb4eadfq0php2ts36s0mtacqd` FOREIGN KEY (`venueAddress_addressId`) REFERENCES `addresstable` (`addressId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venue`
--

LOCK TABLES `venue` WRITE;
/*!40000 ALTER TABLE `venue` DISABLE KEYS */;
INSERT INTO `venue` VALUES (3,'LongWood','r1.jpg','curry Center','1010','R',3,'2006-04-24 09:42:13','Small center specially good for Students!'),(10,'LongWood','r1.jpg','rurry Center','1010','R',11,'2014-05-24 09:42:13','Cheap and Inexpensive!'),(16,'New Restaurant with great dining ambience and rates!','r1.jpg','Cutlet Center','120','R',17,'2014-04-24 09:42:13','Great taste.'),(18,'Nice small chinese restaurant!','r1.jpg','Albatross Center','350','P',19,'2016-04-22 09:42:13','Total loved the ambiance!'),(20,'New Pizza center with 300plus variety!!\r\nAmazing!','b1.jpg','Pizza Corner Center','20','R',21,'2015-04-24 09:42:13','Perfect for Couples ;)'),(27,'Clud night for awesome people','r1.jpg','Parker club','1200','P',28,'2016-04-24 09:42:13','Simply Awesome!!'),(30,'The Taj Mahal Hotel is a 5-star luxury hotel in Delhi, India','b1.jpg','Hotel Taj','1000','R',31,'2016-04-24 21:49:41','Amazing Dining '),(32,'Indian,It sis the second 5-star luxury hotel in Delhi','b1.jpg','Hotel Veer','10','R',33,'2016-04-24 23:47:30','Simply Awesome!!'),(34,'Very nice restaurant The Tahl Hotel is a 5-star luxuxious','b1.jpg','Hotel Kiran','122','R',35,'2016-04-24 23:48:29','Total loved the ambiance!'),(36,'Indian Restaurant,Nisha is India Restaurant with all kinds of India.','b1.jpg','Hotel Alby','123','R',37,'2016-04-24 23:49:24','Fine dining with excellent view!'),(38,'Italian Hotel,We\'ve good quick service,We\'ve good quick service','b1.jpg','Neha resorts ','455','R',39,'2016-04-24 23:51:02','A nice outdoor patio for people watching '),(40,'Nisha is India Restaurant with all kinds of India.','b1.jpg','Nisha Restaurant ','455','R',41,'2016-04-24 23:54:39','Fine dining with excellent view!'),(42,'Eco-minded counter-service chain offering made-to-order burritos.','b1.jpg','Boloco','126','R',43,'2016-04-25 00:11:49','Total loved the ambiance!'),(44,'Small counter providing an island-dining experience with its goats.','b1.jpg','Flames Restaurant ','1221','R',45,'2016-04-25 00:14:14','Fine dining with excellent view!'),(46,'We\'ve good quick service','b1.jpg','Pat\'s Place','452','R',47,'2016-04-25 00:15:27','Amazing Dining restaurant!! Went twice!'),(48,'A mix of regional Mexican dishes served in a basic setting','b1.jpg','Montecristo Grill','23','R',49,'2016-04-25 00:16:45','A nice outdoor patio for people watch'),(50,'High-end sports-bar chain with a huge menu of New American fare & an extensive list of draft beers.','b1.jpg','Yard House','1233','R',51,'2016-04-25 00:17:49','Amazing Dining restaurant!!'),(52,'Counter-serve bakery/cafe chain serving sandwiches, salads & more, known for its bread & free WiFi.\r\n','b1.jpg','Panera Bread','201','H',53,'2016-04-25 00:19:00','Fine dining with excellent view!'),(54,'Counter-serve bakery/cafe chain serving sandwiches, salads & more, known for its bread & free WiFi.\r\n','b1.jpg','Panera Breakfast','201','H',55,'2016-04-25 00:23:07','Total loved the ambiance!'),(56,'Counter-serve bakery/cafe chain serving sandwiches, salads & more, known for its bread & free WiFi.\r\n','b1.jpg','Panera Brew','201','H',57,'2016-04-25 00:24:31','Cheap and Inexpensive!'),(58,'Sophisticated, modern French fixed-price menus served in 4 luxe, romantic dining rooms.','b1.jpg','L\'Espalier','60','H',59,'2016-04-25 00:55:22','A nice outdoor patio for people watching'),(79,'High-end sports-bar chain with a huge menu of New American fare & an extensive list of draft beers.','b1.jpg','Great Mahal','122','H',80,'2016-04-25 17:10:41','Amazing Dining restaurant!! ');
/*!40000 ALTER TABLE `venue` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-25 22:38:12
