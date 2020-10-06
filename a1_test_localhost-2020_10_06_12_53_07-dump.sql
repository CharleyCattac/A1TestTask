-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: 
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!50606 SET @OLD_INNODB_STATS_AUTO_RECALC=@@INNODB_STATS_AUTO_RECALC */;
/*!50606 SET GLOBAL INNODB_STATS_AUTO_RECALC=OFF */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `a1_test`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `a1_test` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `a1_test`;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `id` bigint NOT NULL,
  `account_name` varchar(255) DEFAULT NULL,
  `is_active` bit(1) NOT NULL,
  `application_codename` varchar(255) DEFAULT NULL,
  `department_name` varchar(255) DEFAULT NULL,
  `job_title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqwoa9avn8kwac5lo3paj0vdwj` (`application_codename`),
  KEY `FK5onn2b3m12cwbiqphorawypei` (`department_name`),
  KEY `FKc51fngmx4qhs5jkbcklo449mt` (`job_title`),
  CONSTRAINT `FK5onn2b3m12cwbiqphorawypei` FOREIGN KEY (`department_name`) REFERENCES `department` (`name`),
  CONSTRAINT `FKc51fngmx4qhs5jkbcklo449mt` FOREIGN KEY (`job_title`) REFERENCES `job` (`title`),
  CONSTRAINT `FKqwoa9avn8kwac5lo3paj0vdwj` FOREIGN KEY (`application_codename`) REFERENCES `application` (`codename`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'BORODZUTPNI',_binary '','SAP','Группа складского хозяйства','Комплектовщик товаров'),(2,'GUROPIMCHIN',_binary '','SAP','Группа складского хозяйства','Комплектовщик товаров'),(3,'GRUZD',_binary '','SAP','Группа складского хозяйства','Техник по складскому учету'),(4,'YUFIMUNNO',_binary '','SAP','Группа складского хозяйства','Заведующий складом'),(5,'ZHULUNGOVPNI',_binary '','SAP','Группа складского хозяйства','Техник по складскому учету'),(6,'NONOPH',_binary '','SAP','Группа складского хозяйства','Техник по складскому учету'),(7,'NONDYBO',_binary '','SAP','Группа складского хозяйства','Техник по складскому учету'),(8,'NOROBCHUN',_binary '\0','SAP','Группа складского хозяйства','Техник по складскому учету'),(9,'NURLOVICH_O',_binary '','SAP','Группа складского хозяйства','Техник по складскому учету'),(10,'MONNO',_binary '','SAP','Группа складского хозяйства','Комплектовщик товаров'),(11,'MULNINOV',_binary '','SAP','Группа складского хозяйства','Комплектовщик товаров'),(12,'MOTORIN',_binary '\0','SAP','Группа складского хозяйства','Техник по складскому учету'),(13,'POVLIPHIN',_binary '','SAP','Группа складского хозяйства','Техник по складскому учету'),(14,'POVICH',_binary '','SAP','Группа складского хозяйства','Техник по складскому учету'),(15,'PVIDOV',_binary '','SAP','Группа складского хозяйства','Техник по складскому учету'),(16,'PHOBOVICH',_binary '\0','SAP','Группа складского хозяйства','Заведующий складом'),(17,'NLIMONOV',_binary '\0',NULL,NULL,NULL),(32,'PONOLOVPNOY_',_binary '\0',NULL,NULL,NULL),(35,'PTOPHUNUVICH',_binary '\0',NULL,NULL,NULL);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `application`
--

DROP TABLE IF EXISTS `application`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `application` (
  `codename` varchar(255) NOT NULL,
  PRIMARY KEY (`codename`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `application`
--

LOCK TABLES `application` WRITE;
/*!40000 ALTER TABLE `application` DISABLE KEYS */;
INSERT INTO `application` VALUES ('SAP');
/*!40000 ALTER TABLE `application` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bun`
--

DROP TABLE IF EXISTS `bun`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bun` (
  `codename` varchar(255) NOT NULL,
  PRIMARY KEY (`codename`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bun`
--

LOCK TABLES `bun` WRITE;
/*!40000 ALTER TABLE `bun` DISABLE KEYS */;
INSERT INTO `bun` VALUES ('pc');
/*!40000 ALTER TABLE `bun` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `currency`
--

DROP TABLE IF EXISTS `currency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `currency` (
  `codename` varchar(255) NOT NULL,
  PRIMARY KEY (`codename`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `currency`
--

LOCK TABLES `currency` WRITE;
/*!40000 ALTER TABLE `currency` DISABLE KEYS */;
INSERT INTO `currency` VALUES ('BYN');
/*!40000 ALTER TABLE `currency` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES ('Группа складского хозяйства');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (51),(51);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `job` (
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`title`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
INSERT INTO `job` VALUES ('Заведующий складом'),('Комплектовщик товаров'),('Техник по складскому учету');
/*!40000 ALTER TABLE `job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `material` (
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`description`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
INSERT INTO `material` VALUES ('A1 Alpha 64GB Black'),('A1 Alpha 64GB green'),('Apple iPhone 7 32GB black'),('Cover BoraSCO (Honor 8A) clear'),('Data cable Prime Line USB-microUSB1,2м b'),('Headphones JBL C100SIU BLK black'),('Headphones JBL T110BT WHT white'),('Honor 8A (JAT-LX1) Black'),('USIM 64К Trio Privet in wrapping CallsA1'),('USIM Trio Privet in wrapping Internet A1'),('Wireless JBL CHARGE4 BLK'),('Xiaomi Redmi 7A 2GB/32GB Black'),('Xiaomi Redmi 7A 2GB/32GB Blue'),('Xiaomi Redmi 8 3GB/32GB Red');
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posting`
--

DROP TABLE IF EXISTS `posting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `posting` (
  `id` bigint NOT NULL,
  `amountlc` float NOT NULL,
  `doc_timestamp` bigint DEFAULT NULL,
  `authorised` bit(1) NOT NULL,
  `item_index` int NOT NULL,
  `posting_index` bigint DEFAULT NULL,
  `posting_timestamp` bigint DEFAULT NULL,
  `quantity` int NOT NULL,
  `account_id` bigint DEFAULT NULL,
  `b_un_codename` varchar(255) DEFAULT NULL,
  `currency_codename` varchar(255) DEFAULT NULL,
  `material_description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKraq6q5etxuokbkmb4y02d2hn7` (`account_id`),
  KEY `FKaxpb38utr99j9db38s5993ltc` (`b_un_codename`),
  KEY `FKsj4j2bby7k1yfaeub476lyot1` (`currency_codename`),
  KEY `FK1bwra4joosf5prkvhu7lcugwk` (`material_description`),
  CONSTRAINT `FK1bwra4joosf5prkvhu7lcugwk` FOREIGN KEY (`material_description`) REFERENCES `material` (`description`),
  CONSTRAINT `FKaxpb38utr99j9db38s5993ltc` FOREIGN KEY (`b_un_codename`) REFERENCES `bun` (`codename`),
  CONSTRAINT `FKraq6q5etxuokbkmb4y02d2hn7` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  CONSTRAINT `FKsj4j2bby7k1yfaeub476lyot1` FOREIGN KEY (`currency_codename`) REFERENCES `currency` (`codename`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posting`
--

LOCK TABLES `posting` WRITE;
/*!40000 ALTER TABLE `posting` DISABLE KEYS */;
INSERT INTO `posting` VALUES (18,38.1,1595624400000,_binary '\0',2,6777727662,1595624400000,3,17,'pc','BYN','Headphones JBL C100SIU BLK black'),(23,75,1595624400000,_binary '\0',1,6777727662,1595624400000,2,17,'pc','BYN','Headphones JBL T110BT WHT white'),(24,921.44,1595624400000,_binary '\0',3,6777727662,1595624400000,4,17,'pc','BYN','Wireless JBL CHARGE4 BLK'),(25,450.08,1595624400000,_binary '\0',1,6777727661,1595624400000,2,17,'pc','BYN','A1 Alpha 64GB green'),(26,450.08,1595624400000,_binary '\0',2,6777727661,1595624400000,2,17,'pc','BYN','A1 Alpha 64GB Black'),(27,0,1595278800000,_binary '\0',1,4977637124,1595278800000,-5,17,'pc','BYN','USIM Trio Privet in wrapping Internet A1'),(28,0,1595278800000,_binary '\0',3,4977637124,1595278800000,-3,17,'pc','BYN','USIM 64К Trio Privet in wrapping CallsA1'),(29,0,1595278800000,_binary '\0',1,4977637123,1595278800000,-3,17,'pc','BYN','Xiaomi Redmi 7A 2GB/32GB Black'),(30,0,1595278800000,_binary '\0',3,4977637123,1595278800000,-4,17,'pc','BYN','Xiaomi Redmi 7A 2GB/32GB Blue'),(31,0,1595278800000,_binary '\0',5,4977637123,1595278800000,-2,17,'pc','BYN','Xiaomi Redmi 8 3GB/32GB Red'),(33,-719.11,1594933200000,_binary '\0',1,4977637119,1595278800000,-3,32,'pc','BYN','Honor 8A (JAT-LX1) Black'),(34,-9.6,1594933200000,_binary '\0',3,4977637119,1595278800000,-4,32,'pc','BYN','Cover BoraSCO (Honor 8A) clear'),(36,0,1598216400000,_binary '\0',2,4977637126,1598216400000,1,35,'pc','BYN','Data cable Prime Line USB-microUSB1,2м b'),(37,0,1598216400000,_binary '\0',1,4977637126,1598216400000,-1,35,'pc','BYN','Data cable Prime Line USB-microUSB1,2м b'),(38,0,1597957200000,_binary '\0',2,4977637122,1597957200000,1,35,'pc','BYN','Data cable Prime Line USB-microUSB1,2м b'),(39,0,1597957200000,_binary '\0',1,4977637122,1597957200000,-1,35,'pc','BYN','Data cable Prime Line USB-microUSB1,2м b'),(40,-2.3,1597870800000,_binary '\0',1,4977637111,1597870800000,-1,35,'pc','BYN','Data cable Prime Line USB-microUSB1,2м b'),(41,-2.3,1597870800000,_binary '\0',1,4977637117,1597870800000,-1,35,'pc','BYN','Data cable Prime Line USB-microUSB1,2м b'),(42,-2.3,1597870800000,_binary '\0',1,4977637179,1597870800000,-1,35,'pc','BYN','Data cable Prime Line USB-microUSB1,2м b'),(43,-2.3,1596574800000,_binary '\0',1,4977637796,1596574800000,-1,35,'pc','BYN','Data cable Prime Line USB-microUSB1,2м b'),(44,0,1596488400000,_binary '\0',3,4977629376,1596488400000,-11,32,'pc','BYN','Data cable Prime Line USB-microUSB1,2м b'),(45,-2.3,1596488400000,_binary '\0',1,4977629374,1596488400000,-1,35,'pc','BYN','Data cable Prime Line USB-microUSB1,2м b'),(46,0,1597870800000,_binary '\0',1,4977637178,1597870800000,-1,32,'pc','BYN','Apple iPhone 7 32GB black'),(47,0,1596488400000,_binary '\0',1,4977629376,1596488400000,-3,32,'pc','BYN','Apple iPhone 7 32GB black'),(48,0,1596488400000,_binary '\0',1,4977629373,1596488400000,-2,32,'pc','BYN','Apple iPhone 7 32GB black'),(49,0,1596488400000,_binary '',1,5000223349,1600894800000,-3,4,'pc','BYN','Apple iPhone 7 32GB black'),(50,0,1596488400000,_binary '',2,5000223349,1600894800000,-2,4,'pc','BYN','Apple iPhone 7 32GB black');
/*!40000 ALTER TABLE `posting` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
/*!50606 SET GLOBAL INNODB_STATS_AUTO_RECALC=@OLD_INNODB_STATS_AUTO_RECALC */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-06 12:53:07
