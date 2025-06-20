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
INSERT INTO `ABILITA` VALUES (1,'Palla di Fuoco','Mago','Evoca una sfera di fiamme che infligge danni in area.'),(2,'Fendente Poderoso','Guerriero','Un potente colpo che può stordire il nemico.'),(3,'Colpo alle Spalle','Ladro','Attacco a sorpresa che infligge danni critici.'),(4,'Bacio sulla bua','Chierico','Ripristina i punti vita di un alleato.'),(5,'Strizza gli occhi','Ranger','Attacco a distanza con maggiore precisione.'),(6,'Mignolo Sbattuto','Guerriero','Aumenta forza e resistenza per un breve periodo.'),(7,'AirVigorsol','Mago','Evoca una tempesta che rallenta e danneggia i nemici.'),(8,'Scudo Divino','Paladino','Protegge dagli attacchi per un breve periodo.'),(9,'Melodia Rinvigorente','Bardo','Migliora le statistiche degli alleati.'),(10,'Colpo Primaverile','Ranger','Scaglia fiori sui nemici.'),(11,'Invisibilità','Ladro','Rende invisibili per un breve periodo.'),(12,'Confessione','Mago','Fa riflettere lavversario.'),(13,'Provocazione esagerata','Guerriero','Attira l\'attenzione dei nemici su di sé.'),(14,'Resurrezione','Chierico','Riporta in vita un alleato caduto dopo 3 giorni.'),(15,'Starnuto','Mago','Stordisce i nemici in un\'area.');
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
INSERT INTO `APPRENDE` VALUES (1,1),(7,1),(2,2),(6,2),(3,3),(4,4),(5,5),(2,6),(6,6),(1,7),(7,7),(5,10),(3,11),(1,12),(7,12),(2,13),(6,13),(4,14),(1,15),(7,15);
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
INSERT INTO `ARMA` VALUES (101,8,NULL),(102,10,NULL),(103,6,'Veleno'),(104,7,NULL),(105,9,'Sacro'),(106,6,'Arcano'),(107,5,NULL),(108,8,NULL),(109,9,NULL),(110,7,'Contundente');
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
INSERT INTO `ARMATURA` VALUES (201,3,'Leggera'),(202,5,'Media'),(203,2,'Leggera'),(204,8,'Pesante'),(205,10,'Pesante'),(206,1,'Leggera'),(207,3,'Leggera'),(208,4,'Media'),(209,1,'Leggera'),(210,2,'Leggera');
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
INSERT INTO `INTRAPRENDE` VALUES (3,1),(4,2),(5,3),(6,4),(3,5),(2,6),(1,7);
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
INSERT INTO `INVENTARIO` VALUES (1,106,1),(1,203,1),(2,102,1),(2,204,1),(3,103,1),(3,201,1),(3,210,1),(4,105,1),(4,207,1),(5,104,1),(5,201,1),(6,110,1),(6,202,1),(6,208,1),(7,106,0),(7,203,1);
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
INSERT INTO `OGGETTO` VALUES (101,'Spada Lunga di Acciaio',50),(102,'Ascia da Battaglia Nanica',75),(103,'Pugnale dell\'Ombra',60),(104,'Arco Lungo Elfico',85),(105,'Martello da Operaio',90),(106,'Bastone',120),(107,'Spada troppo Corta',40),(108,'Patata al Forno',95),(109,'Lancia da Lanciare',65),(110,'Mazza Chiodata',55),(201,'Armatura di Cuoio',45),(202,'Cotta di Maglia',85),(203,'Travestimento da Cameriere',110),(204,'Armatura di Piastre',150),(205,'Costume da Bagno',210),(206,'Mantello dell\'Invisibilità',180),(207,'Tunica Sacerdotale',70),(208,'Cappello di paglia',40),(209,'Guanti Rinforzati',30),(210,'Stivali troppo Grandi',55);
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
INSERT INTO `PERSONAGGIO` VALUES (1,'Gandalf il Bianco',10,14,18,65,450,'Mago',7),(2,'Franco il panettiere',19,12,8,95,320,'Guerriero',8),(3,'Lyra Shadowstep',12,19,15,75,570,'Ladro',9),(4,'Il papa',14,10,16,85,410,'Chierico',7),(5,'Pietro Guardaboschi',11,17,14,70,290,'Ranger',6),(6,'Francesco il Forte',18,8,10,100,180,'Guerriero',5),(7,'Eleara Stellargento',8,14,19,60,630,'Mago',10),(8,'Ktamur il Masticapietre',16,13,9,90,340,'Guerriero',7);
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
INSERT INTO `QUEST` VALUES (1,203,'La Gemma Perduta','Non iniziata','Ritrova la caramella scomparsa della figlia di Ktamur',200,500,5),(2,NULL,'La Minaccia Oscura','In corso','Sconfiggi il Negromante Malbruk che minaccia il villaggio di Rosendale.',350,800,7),(3,105,'Il Martello Sacro','Non iniziata','Recupera il Martello da Guerra Sacro dal Tempio Abbandonato.',250,600,6),(4,NULL,'Il Panettiere Sbadato','Completata','Recupera la farina del Panettiere.',150,400,4),(5,104,'L\'invidia','In corso','Intrufolati la matrimonio di Francesco e crea un putiferio.',300,700,8),(6,NULL,'Vendetta del Clan','Non iniziata','Aiuta Kazador a vendicare il suo clan contro i predoni orcheschi.',280,650,7),(7,205,'L\'Armatura del Drago','In corso','Compra della crema solare.',500,1200,10);
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

-- Dump completed on 2025-06-19 15:51:33
