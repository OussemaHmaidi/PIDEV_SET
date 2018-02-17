-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: all4kids
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) DEFAULT NULL,
  `mp` varchar(45) DEFAULT NULL,
  `nom` varchar(45) DEFAULT NULL,
  `prenom` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `annonce`
--

DROP TABLE IF EXISTS `annonce`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `annonce` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `description` text,
  `prix` float DEFAULT NULL,
  `produit` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `produit_fk_idx` (`produit`),
  KEY `bonPlan_fk_idx` (`produit`),
  CONSTRAINT `produit_fk` FOREIGN KEY (`produit`) REFERENCES `produit` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `annonce`
--

LOCK TABLES `annonce` WRITE;
/*!40000 ALTER TABLE `annonce` DISABLE KEYS */;
/*!40000 ALTER TABLE `annonce` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(45) DEFAULT NULL,
  `categorie` varchar(45) DEFAULT NULL,
  `contenu` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `babysitter`
--

DROP TABLE IF EXISTS `babysitter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `babysitter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `prenom` varchar(45) DEFAULT NULL,
  `date_naissance` date DEFAULT NULL,
  `login` varchar(45) DEFAULT NULL,
  `mp` varchar(45) DEFAULT NULL,
  `cin` varchar(45) DEFAULT NULL,
  `tel` varchar(45) DEFAULT NULL,
  `salaire` float DEFAULT NULL,
  `adresse` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `babysitter`
--

LOCK TABLES `babysitter` WRITE;
/*!40000 ALTER TABLE `babysitter` DISABLE KEYS */;
INSERT INTO `babysitter` VALUES (2,'pp','nfghj','2000-11-03','cccccccc','ddddddd','aaaaasssssss','fffffffff',10000.5,NULL),(3,'mmlll','bbbbbb','0069-11-03','cccccccc','ddddddd','aaaaasssssss','hayayaa',10000.5,NULL),(4,'aaaaa','bbbbbb','1969-12-31','cccccccc','ddddddd','aaaaasssssss','fffffffff',10000.5,NULL),(5,'aaaaa','bbbbbb','1969-12-11','cccccccc','ddddddd','eeeeeeee','fffffffff',10000.5,NULL),(6,'aaaaa','bbbbbb','0069-11-03','cccccccc','ddddddd','hjsgdgsdk','fffffffff',10000.5,NULL),(7,'aaaaa','bbbbbb','1969-12-31','cccccccc','ddddddd','eeeeeeee','fffffffff',10000.5,NULL),(8,'hhhh','hhhhh','2018-01-30','hhhh','hhhh','hhhh','hhhh',444,NULL),(9,'jj','jj','2018-02-06','jj','jj','jj','jj',11,NULL),(10,'nn','zz','0118-01-04','aa','77','zz','77',5454,NULL),(11,'baby','sitter','2018-01-29','bs1','0000','15546555','85554456',500,NULL);
/*!40000 ALTER TABLE `babysitter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bon_plan`
--

DROP TABLE IF EXISTS `bon_plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bon_plan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(45) DEFAULT NULL,
  `description` text,
  `proprietaire` varchar(45) DEFAULT NULL,
  `date_debut` date DEFAULT NULL,
  `date_fin` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bon_plan`
--

LOCK TABLES `bon_plan` WRITE;
/*!40000 ALTER TABLE `bon_plan` DISABLE KEYS */;
/*!40000 ALTER TABLE `bon_plan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cours`
--

DROP TABLE IF EXISTS `cours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cours` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(45) DEFAULT NULL,
  `classe` varchar(45) DEFAULT NULL,
  `categorie` varchar(45) DEFAULT NULL,
  `pdf` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cours`
--

LOCK TABLES `cours` WRITE;
/*!40000 ALTER TABLE `cours` DISABLE KEYS */;
/*!40000 ALTER TABLE `cours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dessin_anime`
--

DROP TABLE IF EXISTS `dessin_anime`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dessin_anime` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `chaine` varchar(45) DEFAULT NULL,
  `url` text,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dessin_anime`
--

LOCK TABLES `dessin_anime` WRITE;
/*!40000 ALTER TABLE `dessin_anime` DISABLE KEYS */;
/*!40000 ALTER TABLE `dessin_anime` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enfant`
--

DROP TABLE IF EXISTS `enfant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enfant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `prenom` varchar(45) DEFAULT NULL,
  `date_naissance` date DEFAULT NULL,
  `sexe` varchar(45) DEFAULT NULL,
  `classe` varchar(45) DEFAULT NULL,
  `parent` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `parent_fk_idx` (`parent`),
  CONSTRAINT `parent_fk` FOREIGN KEY (`parent`) REFERENCES `parent` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enfant`
--

LOCK TABLES `enfant` WRITE;
/*!40000 ALTER TABLE `enfant` DISABLE KEYS */;
/*!40000 ALTER TABLE `enfant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enfant_vaccin`
--

DROP TABLE IF EXISTS `enfant_vaccin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enfant_vaccin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `enfant` int(11) DEFAULT NULL,
  `vaccin` int(11) DEFAULT NULL,
  `statut` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `vaccin_fk_idx` (`vaccin`),
  KEY `enfant_fk_idx` (`enfant`),
  CONSTRAINT `enfant_fk` FOREIGN KEY (`enfant`) REFERENCES `enfant` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `vaccin_fk` FOREIGN KEY (`vaccin`) REFERENCES `vaccin` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enfant_vaccin`
--

LOCK TABLES `enfant_vaccin` WRITE;
/*!40000 ALTER TABLE `enfant_vaccin` DISABLE KEYS */;
/*!40000 ALTER TABLE `enfant_vaccin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evenement`
--

DROP TABLE IF EXISTS `evenement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evenement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `description` text,
  `prix` float DEFAULT NULL,
  `adresse` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evenement`
--

LOCK TABLES `evenement` WRITE;
/*!40000 ALTER TABLE `evenement` DISABLE KEYS */;
/*!40000 ALTER TABLE `evenement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `garderie`
--

DROP TABLE IF EXISTS `garderie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `garderie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `description` text,
  `adresse` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `garderie`
--

LOCK TABLES `garderie` WRITE;
/*!40000 ALTER TABLE `garderie` DISABLE KEYS */;
/*!40000 ALTER TABLE `garderie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jeu`
--

DROP TABLE IF EXISTS `jeu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jeu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `url` text,
  `type` varchar(45) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jeu`
--

LOCK TABLES `jeu` WRITE;
/*!40000 ALTER TABLE `jeu` DISABLE KEYS */;
/*!40000 ALTER TABLE `jeu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parc`
--

DROP TABLE IF EXISTS `parc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `decription` text,
  `adresse` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parc`
--

LOCK TABLES `parc` WRITE;
/*!40000 ALTER TABLE `parc` DISABLE KEYS */;
/*!40000 ALTER TABLE `parc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parent`
--

DROP TABLE IF EXISTS `parent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `prenom` varchar(45) DEFAULT NULL,
  `login` varchar(45) DEFAULT NULL,
  `mp` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `date_naissance` date DEFAULT NULL,
  `cin` varchar(45) DEFAULT NULL,
  `tel` varchar(45) DEFAULT NULL,
  `adresse` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parent`
--

LOCK TABLES `parent` WRITE;
/*!40000 ALTER TABLE `parent` DISABLE KEYS */;
INSERT INTO `parent` VALUES (1,NULL,NULL,NULL,NULL,'asasasa',NULL,'asasasa',NULL,NULL);
/*!40000 ALTER TABLE `parent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pharmacie`
--

DROP TABLE IF EXISTS `pharmacie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pharmacie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `adresse` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pharmacie`
--

LOCK TABLES `pharmacie` WRITE;
/*!40000 ALTER TABLE `pharmacie` DISABLE KEYS */;
/*!40000 ALTER TABLE `pharmacie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plannification`
--

DROP TABLE IF EXISTS `plannification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plannification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `babysitter` int(11) DEFAULT NULL,
  `parent` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `babysitter_plannification_fk_idx` (`babysitter`),
  KEY `parent_plannification_fk_idx` (`parent`),
  CONSTRAINT `babysitter_plannification_fk` FOREIGN KEY (`babysitter`) REFERENCES `babysitter` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `parent_plannification_fk` FOREIGN KEY (`parent`) REFERENCES `parent` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plannification`
--

LOCK TABLES `plannification` WRITE;
/*!40000 ALTER TABLE `plannification` DISABLE KEYS */;
/*!40000 ALTER TABLE `plannification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produit`
--

DROP TABLE IF EXISTS `produit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `description` text,
  `categorie` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produit`
--

LOCK TABLES `produit` WRITE;
/*!40000 ALTER TABLE `produit` DISABLE KEYS */;
/*!40000 ALTER TABLE `produit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publication`
--

DROP TABLE IF EXISTS `publication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `publication` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(45) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `contenu` text,
  `parent` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `parent_publication_fk_idx` (`parent`),
  CONSTRAINT `parent_publication_fk` FOREIGN KEY (`parent`) REFERENCES `parent` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publication`
--

LOCK TABLES `publication` WRITE;
/*!40000 ALTER TABLE `publication` DISABLE KEYS */;
/*!40000 ALTER TABLE `publication` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vaccin`
--

DROP TABLE IF EXISTS `vaccin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vaccin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `description` text,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vaccin`
--

LOCK TABLES `vaccin` WRITE;
/*!40000 ALTER TABLE `vaccin` DISABLE KEYS */;
/*!40000 ALTER TABLE `vaccin` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-16 20:14:17
