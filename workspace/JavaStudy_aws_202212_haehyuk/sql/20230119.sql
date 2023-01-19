-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_study2_explain
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `db_study2_explain`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `db_study2_explain` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `db_study2_explain`;

--
-- Table structure for table `course_mst`
--

DROP TABLE IF EXISTS `course_mst`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_mst` (
  `course_id` int NOT NULL,
  `student_id` int NOT NULL,
  `lecture_id` int NOT NULL,
  `instructor_id` int NOT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_mst`
--

LOCK TABLES `course_mst` WRITE;
/*!40000 ALTER TABLE `course_mst` DISABLE KEYS */;
INSERT INTO `course_mst` VALUES (1,1,1,1),(2,2,1,1),(3,3,2,2),(4,4,3,3);
/*!40000 ALTER TABLE `course_mst` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instructor_mst`
--

DROP TABLE IF EXISTS `instructor_mst`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `instructor_mst` (
  `instructor_id` int NOT NULL,
  `instructor_name` varchar(45) DEFAULT NULL,
  `university_id` int DEFAULT NULL,
  PRIMARY KEY (`instructor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructor_mst`
--

LOCK TABLES `instructor_mst` WRITE;
/*!40000 ALTER TABLE `instructor_mst` DISABLE KEYS */;
INSERT INTO `instructor_mst` VALUES (1,'세종대왕',1),(2,'왕건',2),(3,'이성계',3);
/*!40000 ALTER TABLE `instructor_mst` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lecture_mst`
--

DROP TABLE IF EXISTS `lecture_mst`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lecture_mst` (
  `lecture_id` int NOT NULL,
  `lecture_name` varchar(45) NOT NULL,
  `lecture_price` int NOT NULL,
  PRIMARY KEY (`lecture_id`,`lecture_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lecture_mst`
--

LOCK TABLES `lecture_mst` WRITE;
/*!40000 ALTER TABLE `lecture_mst` DISABLE KEYS */;
INSERT INTO `lecture_mst` VALUES (1,'java',100000),(2,'python',80000),(3,'c',90000);
/*!40000 ALTER TABLE `lecture_mst` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mentor_mst`
--

DROP TABLE IF EXISTS `mentor_mst`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mentor_mst` (
  `mentor_id` int NOT NULL,
  `mentor_name` varchar(45) NOT NULL,
  PRIMARY KEY (`mentor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mentor_mst`
--

LOCK TABLES `mentor_mst` WRITE;
/*!40000 ALTER TABLE `mentor_mst` DISABLE KEYS */;
INSERT INTO `mentor_mst` VALUES (1,'신사임당'),(2,'율곡이이'),(3,'퇴계이황');
/*!40000 ALTER TABLE `mentor_mst` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_mst`
--

DROP TABLE IF EXISTS `student_mst`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_mst` (
  `student_id` int NOT NULL,
  `student_name` varchar(45) NOT NULL,
  `mentor_id` int NOT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_mst`
--

LOCK TABLES `student_mst` WRITE;
/*!40000 ALTER TABLE `student_mst` DISABLE KEYS */;
INSERT INTO `student_mst` VALUES (1,'홍길동',1),(2,'김유신',2),(3,'이순신',3),(4,'문익점',1);
/*!40000 ALTER TABLE `student_mst` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `university_mst`
--

DROP TABLE IF EXISTS `university_mst`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `university_mst` (
  `university_id` int NOT NULL,
  `university_name` varchar(45) NOT NULL,
  PRIMARY KEY (`university_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `university_mst`
--

LOCK TABLES `university_mst` WRITE;
/*!40000 ALTER TABLE `university_mst` DISABLE KEYS */;
INSERT INTO `university_mst` VALUES (1,'서울대'),(2,'고려대'),(3,'연세대');
/*!40000 ALTER TABLE `university_mst` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'db_study2_explain'
--

--
-- Dumping routines for database 'db_study2_explain'
--

--
-- Current Database: `db_study`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `db_study` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `db_study`;

--
-- Table structure for table `customer_mst`
--

DROP TABLE IF EXISTS `customer_mst`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_mst` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(45) NOT NULL,
  `customer_address` varchar(45) NOT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_mst`
--

LOCK TABLES `customer_mst` WRITE;
/*!40000 ALTER TABLE `customer_mst` DISABLE KEYS */;
INSERT INTO `customer_mst` VALUES (1,'홍길동','부산 해운대구 센텀시티'),(2,'김유신','경상북도 경주시 신라읍'),(3,'이순신','부산 부산진구 부암동');
/*!40000 ALTER TABLE `customer_mst` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `순번` int NOT NULL AUTO_INCREMENT,
  `주문번호` int DEFAULT NULL,
  `상품명` varchar(45) DEFAULT NULL,
  `가격` int DEFAULT NULL,
  `주문자명` varchar(45) DEFAULT NULL,
  `주문자주소` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`순번`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (1,1,'apple',1000,'홍길동','부산 해운대구 센텀시티'),(2,1,'banana',2000,'홍길동','부산 해운대구 센텀시티'),(3,2,'apple',1000,'김유신','경상북도 경주시 신라읍'),(4,3,'apple',1000,'이순신','부산 부산진구 부암동');
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_dtl`
--

DROP TABLE IF EXISTS `order_dtl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_dtl` (
  `order_dtl_id` int NOT NULL AUTO_INCREMENT,
  `order_id` int NOT NULL,
  `product_id` int NOT NULL,
  PRIMARY KEY (`order_dtl_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_dtl`
--

LOCK TABLES `order_dtl` WRITE;
/*!40000 ALTER TABLE `order_dtl` DISABLE KEYS */;
INSERT INTO `order_dtl` VALUES (1,1,1),(2,1,2),(3,2,1),(4,3,3);
/*!40000 ALTER TABLE `order_dtl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_mst`
--

DROP TABLE IF EXISTS `order_mst`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_mst` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `order_code` int NOT NULL,
  `customer_id` int NOT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_mst`
--

LOCK TABLES `order_mst` WRITE;
/*!40000 ALTER TABLE `order_mst` DISABLE KEYS */;
INSERT INTO `order_mst` VALUES (1,23011901,1),(2,23011902,2),(3,23011903,3),(4,23011904,1);
/*!40000 ALTER TABLE `order_mst` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_mst`
--

DROP TABLE IF EXISTS `product_mst`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_mst` (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(45) DEFAULT NULL,
  `product_price` int DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_mst`
--

LOCK TABLES `product_mst` WRITE;
/*!40000 ALTER TABLE `product_mst` DISABLE KEYS */;
INSERT INTO `product_mst` VALUES (1,'apple',1000),(2,'banana',2000),(3,'pineapple',3000);
/*!40000 ALTER TABLE `product_mst` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'db_study'
--

--
-- Dumping routines for database 'db_study'
--

--
-- Current Database: `db_study2`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `db_study2` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `db_study2`;

--
-- Table structure for table `course_mst`
--

DROP TABLE IF EXISTS `course_mst`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_mst` (
  `course_id` int NOT NULL,
  `student_id` int NOT NULL,
  `lecture_id` int NOT NULL,
  `instructor_id` int NOT NULL,
  `mentor_id` int NOT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_mst`
--

LOCK TABLES `course_mst` WRITE;
/*!40000 ALTER TABLE `course_mst` DISABLE KEYS */;
INSERT INTO `course_mst` VALUES (1,1,1,1,0),(2,2,1,1,0),(3,3,2,2,0),(4,4,3,3,0);
/*!40000 ALTER TABLE `course_mst` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instructor_mst`
--

DROP TABLE IF EXISTS `instructor_mst`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `instructor_mst` (
  `instructor_id` int NOT NULL,
  `instructor_name` varchar(45) NOT NULL,
  `univercity_id` int NOT NULL,
  PRIMARY KEY (`instructor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructor_mst`
--

LOCK TABLES `instructor_mst` WRITE;
/*!40000 ALTER TABLE `instructor_mst` DISABLE KEYS */;
INSERT INTO `instructor_mst` VALUES (1,'세종대왕',1),(2,'왕건',2),(3,'이성계',3);
/*!40000 ALTER TABLE `instructor_mst` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lecture_mst`
--

DROP TABLE IF EXISTS `lecture_mst`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lecture_mst` (
  `lecture_id` int NOT NULL,
  `lecture_name` varchar(45) NOT NULL,
  `letcutre_price` int NOT NULL,
  PRIMARY KEY (`lecture_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lecture_mst`
--

LOCK TABLES `lecture_mst` WRITE;
/*!40000 ALTER TABLE `lecture_mst` DISABLE KEYS */;
INSERT INTO `lecture_mst` VALUES (1,'java',10000),(2,'python',15000),(3,'C',20000);
/*!40000 ALTER TABLE `lecture_mst` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mentor_mst`
--

DROP TABLE IF EXISTS `mentor_mst`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mentor_mst` (
  `mentor_id` int NOT NULL,
  `mentor_name` varchar(45) NOT NULL,
  PRIMARY KEY (`mentor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mentor_mst`
--

LOCK TABLES `mentor_mst` WRITE;
/*!40000 ALTER TABLE `mentor_mst` DISABLE KEYS */;
INSERT INTO `mentor_mst` VALUES (1,'율곡이이'),(2,'퇴계이황'),(3,'신사임당');
/*!40000 ALTER TABLE `mentor_mst` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_mst`
--

DROP TABLE IF EXISTS `student_mst`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_mst` (
  `student_id` int NOT NULL,
  `student_name` varchar(45) NOT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_mst`
--

LOCK TABLES `student_mst` WRITE;
/*!40000 ALTER TABLE `student_mst` DISABLE KEYS */;
INSERT INTO `student_mst` VALUES (1,'홍길동'),(2,'김유신'),(3,'이순신'),(4,'문익점');
/*!40000 ALTER TABLE `student_mst` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `univercity_mst`
--

DROP TABLE IF EXISTS `univercity_mst`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `univercity_mst` (
  `univercity_id` int NOT NULL,
  `univercity_name` varchar(45) NOT NULL,
  PRIMARY KEY (`univercity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `univercity_mst`
--

LOCK TABLES `univercity_mst` WRITE;
/*!40000 ALTER TABLE `univercity_mst` DISABLE KEYS */;
INSERT INTO `univercity_mst` VALUES (1,'서울대'),(2,'고려대'),(3,'연세대');
/*!40000 ALTER TABLE `univercity_mst` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'db_study2'
--

--
-- Dumping routines for database 'db_study2'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-19 17:38:05
