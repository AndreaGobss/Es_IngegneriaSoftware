CREATE DATABASE  IF NOT EXISTS `GiocoRPGdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `GiocoRPGdb`;
-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: GiocoRPGdb
-- ------------------------------------------------------
-- Server version	8.0.42-0ubuntu0.24.04.1

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
-- Table structure for table `ABILITA`
--

DROP TABLE IF EXISTS `ABILITA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ABILITA` (
  `ID_Abilita` int NOT NULL,
  `Nome_A` varchar(50) NOT NULL,
  `Classe_A` varchar(30) NOT NULL,
  `Descrizione_A` text,
  PRIMARY KEY (`ID_Abilita`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ABILITA`
--

LOCK TABLES `ABILITA` WRITE;
/*!40000 ALTER TABLE `ABILITA` DISABLE KEYS */;
/*!40000 ALTER TABLE `ABILITA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `APPRENDE`
--

DROP TABLE IF EXISTS `APPRENDE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `APPRENDE` (
  `ID_Personaggio` int NOT NULL,
  `ID_Abilita` int NOT NULL,
  PRIMARY KEY (`ID_Personaggio`,`ID_Abilita`),
  KEY `APPRENDE_ibfk_2` (`ID_Abilita`),
  CONSTRAINT `APPRENDE_ibfk_1` FOREIGN KEY (`ID_Personaggio`) REFERENCES `PERSONAGGIO` (`ID_Personaggio`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `APPRENDE_ibfk_2` FOREIGN KEY (`ID_Abilita`) REFERENCES `ABILITA` (`ID_Abilita`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `APPRENDE`
--

LOCK TABLES `APPRENDE` WRITE;
/*!40000 ALTER TABLE `APPRENDE` DISABLE KEYS */;
/*!40000 ALTER TABLE `APPRENDE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ARMA`
--

DROP TABLE IF EXISTS `ARMA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ARMA` (
  `ID_Oggetto` int NOT NULL,
  `Danno` int NOT NULL,
  `Elemento` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`ID_Oggetto`),
  CONSTRAINT `ARMA_ibfk_1` FOREIGN KEY (`ID_Oggetto`) REFERENCES `OGGETTO` (`ID_OGGETTO`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ARMA_chk_1` CHECK ((`Danno` >= 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ARMA`
--

LOCK TABLES `ARMA` WRITE;
/*!40000 ALTER TABLE `ARMA` DISABLE KEYS */;
/*!40000 ALTER TABLE `ARMA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ARMATURA`
--

DROP TABLE IF EXISTS `ARMATURA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ARMATURA` (
  `ID_Oggetto` int NOT NULL,
  `Protezione` int NOT NULL,
  `Tipo` varchar(30) NOT NULL,
  PRIMARY KEY (`ID_Oggetto`),
  CONSTRAINT `ARMATURA_ibfk_1` FOREIGN KEY (`ID_Oggetto`) REFERENCES `OGGETTO` (`ID_OGGETTO`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ARMATURA_chk_1` CHECK ((`Protezione` >= 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ARMATURA`
--

LOCK TABLES `ARMATURA` WRITE;
/*!40000 ALTER TABLE `ARMATURA` DISABLE KEYS */;
/*!40000 ALTER TABLE `ARMATURA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `INTRAPRENDE`
--

DROP TABLE IF EXISTS `INTRAPRENDE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `INTRAPRENDE` (
  `ID_Personaggio` int NOT NULL,
  `ID_Quest` int NOT NULL,
  PRIMARY KEY (`ID_Personaggio`,`ID_Quest`),
  KEY `INTRAPRENDE_ibfk_2` (`ID_Quest`),
  CONSTRAINT `INTRAPRENDE_ibfk_1` FOREIGN KEY (`ID_Personaggio`) REFERENCES `PERSONAGGIO` (`ID_Personaggio`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `INTRAPRENDE_ibfk_2` FOREIGN KEY (`ID_Quest`) REFERENCES `QUEST` (`ID_Quest`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `INTRAPRENDE`
--

LOCK TABLES `INTRAPRENDE` WRITE;
/*!40000 ALTER TABLE `INTRAPRENDE` DISABLE KEYS */;
/*!40000 ALTER TABLE `INTRAPRENDE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `INVENTARIO`
--

DROP TABLE IF EXISTS `INVENTARIO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `INVENTARIO` (
  `ID_Personaggio` int NOT NULL,
  `ID_Oggetto` int NOT NULL,
  `Equipaggiato` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`ID_Personaggio`,`ID_Oggetto`),
  KEY `INVENTARIO_ibfk_2` (`ID_Oggetto`),
  CONSTRAINT `INVENTARIO_ibfk_1` FOREIGN KEY (`ID_Personaggio`) REFERENCES `PERSONAGGIO` (`ID_Personaggio`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `INVENTARIO_ibfk_2` FOREIGN KEY (`ID_Oggetto`) REFERENCES `OGGETTO` (`ID_OGGETTO`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `INVENTARIO`
--

LOCK TABLES `INVENTARIO` WRITE;
/*!40000 ALTER TABLE `INVENTARIO` DISABLE KEYS */;
/*!40000 ALTER TABLE `INVENTARIO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `OGGETTO`
--

DROP TABLE IF EXISTS `OGGETTO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `OGGETTO` (
  `ID_OGGETTO` int NOT NULL,
  `NOME_O` varchar(50) NOT NULL,
  `VALORE` int DEFAULT NULL,
  PRIMARY KEY (`ID_OGGETTO`),
  CONSTRAINT `OGGETTO_chk_1` CHECK ((`VALORE` >= 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `OGGETTO`
--

LOCK TABLES `OGGETTO` WRITE;
/*!40000 ALTER TABLE `OGGETTO` DISABLE KEYS */;
/*!40000 ALTER TABLE `OGGETTO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PERSONAGGIO`
--

DROP TABLE IF EXISTS `PERSONAGGIO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PERSONAGGIO` (
  `ID_Personaggio` int NOT NULL,
  `Nome_P` varchar(50) NOT NULL,
  `Forza` int NOT NULL,
  `Destrezza` int NOT NULL,
  `Intelligenza` int NOT NULL,
  `Punti_vita` int NOT NULL,
  `Oro_P` int DEFAULT '0',
  `Classe_P` varchar(30) NOT NULL,
  `Livello` int NOT NULL,
  PRIMARY KEY (`ID_Personaggio`),
  CONSTRAINT `PERSONAGGIO_chk_1` CHECK ((`FORZA` >= 0)),
  CONSTRAINT `PERSONAGGIO_chk_2` CHECK ((`DESTREZZA` >= 0)),
  CONSTRAINT `PERSONAGGIO_chk_3` CHECK ((`INTELLIGENZA` >= 0)),
  CONSTRAINT `PERSONAGGIO_chk_4` CHECK ((`PUNTI_VITA` >= 0)),
  CONSTRAINT `PERSONAGGIO_chk_5` CHECK ((`ORO_P` >= 0)),
  CONSTRAINT `PERSONAGGIO_chk_6` CHECK ((`LIVELLO` >= 1))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PERSONAGGIO`
--

LOCK TABLES `PERSONAGGIO` WRITE;
/*!40000 ALTER TABLE `PERSONAGGIO` DISABLE KEYS */;
/*!40000 ALTER TABLE `PERSONAGGIO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QUEST`
--

DROP TABLE IF EXISTS `QUEST`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `QUEST` (
  `ID_Quest` int NOT NULL,
  `Oggetto_Ric` int DEFAULT NULL,
  `Nome_Q` varchar(50) NOT NULL,
  `Stato` enum('Non iniziata','In corso','Completata') DEFAULT NULL,
  `Descrizione_Q` text,
  `Oro_Q` int DEFAULT '0',
  `Esperienza_Q` int DEFAULT '0',
  `Livello_minimo` int NOT NULL,
  PRIMARY KEY (`ID_Quest`),
  KEY `QUEST_ibfk_1` (`Oggetto_Ric`),
  CONSTRAINT `QUEST_ibfk_1` FOREIGN KEY (`Oggetto_Ric`) REFERENCES `OGGETTO` (`ID_OGGETTO`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `QUEST_chk_1` CHECK ((`ORO_Q` >= 0)),
  CONSTRAINT `QUEST_chk_2` CHECK ((`ESPERIENZA_Q` >= 0)),
  CONSTRAINT `QUEST_chk_3` CHECK ((`LIVELLO_MINIMO` >= 1))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QUEST`
--

LOCK TABLES `QUEST` WRITE;
/*!40000 ALTER TABLE `QUEST` DISABLE KEYS */;
/*!40000 ALTER TABLE `QUEST` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-19 14:50:14
